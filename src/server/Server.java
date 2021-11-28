/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Server.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import utils.BidType;
import utils.Tile;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import client.Client;

import network.BidMsg;
import network.DealMsg;
import network.DrawMsg;
import network.DrawNoticeMsg;
import network.InitMsg;
import network.Message;
import network.Peer;

// TODO: Auto-generated Javadoc
/**
 * The Class Server.
 */
public class Server implements Peer{
	
	/** The Constant INITIAL_HAND. */
	public final static int INITIAL_HAND = 13;
	
	/** The Constant CLIENT_NUM. */
	public final static int CLIENT_NUM = 4;
	
	/** The cardlist. */
	private Deque<Integer> cardlist;
	
	/** The client hands. */
	private ArrayList<ArrayList<Integer>> clientHands;
	
	/** The op. */
	private ServerOperation op; //need to later add exception handling
	
	/** The all clients. */
	private ArrayList<Peer> allClients;
	
	/** The next client. */
	private int nextClient;

	/**
	 * Instantiates a new server.
	 */
	public Server() {
		cardlist = new LinkedList<>();
	}
	
	/**
	 * Form room.
	 *
	 * @param ui the ui
	 */
	public void formRoom(String ui) {
		allClients = new ArrayList<Peer>(CLIENT_NUM);
		for(int i = 0;i<CLIENT_NUM;i++) {
			allClients.add(new Client(i,this, ui));
		}
	}
	
	/**
	 * Inits the.
	 */
	public void init() {
		cardlist = shuffle();
		clientHands = deal();
		//init the each ui
		sendAll(new InitMsg(), 0);
		//send initial hands to the clients
		for(int i = 0;i<CLIENT_NUM;i++) {
			send(allClients.get(i),new DealMsg(clientHands.get(i)));
		}
	}
	
	/**
	 * Start game.
	 */
	public void startGame() {
		nextClient = 0;
		sendAll(new DrawNoticeMsg(nextClient), 0);
		sendNextDraw();
	}
	
	/**
	 * Shuffle.
	 *
	 * @return the deque
	 */
	public Deque<Integer> shuffle() {
		Deque<Integer> deque = new LinkedList<>();
		ArrayList<Integer> IDs = new ArrayList<Integer>();
		for(int i=0;i<Tile.TOTAL_TILES_WITHOUT_FLOWERS;i++) {
			IDs.add(i);
		}
		Collections.shuffle(IDs);
		for(Integer id : IDs) {
			deque.offerLast(id);
		}
		return deque;	
	}
	
	/**
	 * Deal.
	 *
	 * @return the array list
	 */
	private ArrayList<ArrayList<Integer>> deal(){
		ArrayList<ArrayList<Integer>> client_hands = new ArrayList<ArrayList<Integer>>(CLIENT_NUM);
		for(int i=0; i<CLIENT_NUM; i++) {
			client_hands.add(new ArrayList<Integer>());
		}
		for(int i=0;i<INITIAL_HAND*CLIENT_NUM;i++) {
			int clientID = i%4;
			client_hands.get(clientID).add(cardlist.pollFirst());
		}
		for(int i=0;i<CLIENT_NUM;i++) {
			Collections.sort(client_hands.get(i));
		}

		return client_hands;
	}
	
	/**
	 * Send all.
	 *
	 * @param msg the msg
	 * @param endClient the end client
	 */
	public void sendAll(Message msg, int endClient) {
		for(int i = 0;i<CLIENT_NUM;i++) {
			int target = (endClient+i+1)%CLIENT_NUM;
			send(allClients.get(target),msg);
		}
	}
	
	/**
	 * Sets the next client.
	 *
	 * @param clientId the new next client
	 */
	public void setNextClient(int clientId) {
		this.nextClient = clientId;
	}
	
	/**
	 * Gets the next client.
	 *
	 * @return the next client
	 */
	public int getNextClient() {
		return nextClient;
	}
	
	/**
	 * Send next draw.
	 */
	public void sendNextDraw() {
		int sendTarget = nextClient;
		nextClient ++;
		nextClient %= CLIENT_NUM;
		if(!cardlist.isEmpty())
			send(allClients.get(sendTarget),new DrawMsg(cardlist.pollFirst()));
		else {
			sendAll(new BidMsg(-1,-1,BidType.WIN,"WinResponser",-1,null,null,false),0);
		}	
	}
	
	/**
	 * Sets the game over.
	 */
	public void setGameOver() {
		System.out.println("Game Over!!!");
	}
	
	
	/**
	 * Send.
	 *
	 * @param target the target
	 * @param msg the msg
	 */
	@Override
	public void send(Peer target, Message msg) {
		target.onRecv(msg);
	}

	/**
	 * On recv.
	 *
	 * @param msg the msg
	 */
	@Override
	public void onRecv(Message msg) {
		try {// this part may be extracted later
			Class<?> c = Class.forName("server."+msg.getOperationName());
			Constructor<?> constructor = c.getConstructor();
			op = (ServerOperation)constructor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		op.operate(this, msg);
	}
	
}
