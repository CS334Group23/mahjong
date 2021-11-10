package server;

import utils.DealMsg;
import utils.DrawMsg;
import utils.DrawNoticeMsg;
import utils.Message;
import utils.Peer;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import client.Client;

public class Server implements Peer{
	public final static int INITIAL_HAND = 13;
	public final static int CLIENT_NUM = 4;
	public final static int TOTAL_TILES = 144;
	public final static int TOTAL_TILES_WITHOUT_FLOWERS = 136;
	
	private Deque<Integer> cardlist;
	private ArrayList<ArrayList<Integer>> client_hands;
	private ServerOperation op; //need to later add exception handling
	private ArrayList<Client> allClients;
	private int nextClient;
	private boolean gameStart = false;

	public Server() {
		cardlist = new LinkedList<>();
	}
	
	public void init() {
		gameStart = true;
		allClients = new ArrayList<Client>(CLIENT_NUM);
		cardlist = shuffle();
		for(int i = 0;i<CLIENT_NUM;i++) {
			allClients.add(new Client(i,this));
		}
		client_hands = deal();
		//send initial hands to the clients
		for(int i = 0;i<CLIENT_NUM;i++) {
			send(allClients.get(i),new DealMsg(client_hands.get(i)));
		}
	}
	
	public void startGame() {
		nextClient = 0;
		sendAll(new DrawNoticeMsg(nextClient), 0);
		sendNextDraw();
	}
	
	public Deque<Integer> shuffle() {
		Deque<Integer> deque = new LinkedList<>();
		ArrayList<Integer> IDs = new ArrayList<Integer>();
		for(int i=0;i<TOTAL_TILES_WITHOUT_FLOWERS;i++) {
			IDs.add(i);
		}
		Collections.shuffle(IDs);
		for(Integer id : IDs) {
			deque.offerLast(id);
		}
		return deque;	
	}
	
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
	
	public void sendAll(Message msg, int endClient) {
		for(int i = 0;i<CLIENT_NUM;i++) {
			int target = (endClient+i+1)%CLIENT_NUM;
			send(allClients.get(target),msg);
		}
	}
	
	public void setNextClient(int clientId) {
		this.nextClient = clientId;
	}
	
	public int getNextClient() {
		return nextClient;
	}
	
	public void sendNextDraw() {
		int sendTarget = nextClient; //use this to edit before send
		nextClient ++;
		nextClient %= CLIENT_NUM;
		if(!cardlist.isEmpty())
			send(allClients.get(sendTarget),new DrawMsg(cardlist.pollFirst()));
		else {
			setGameOver();
		}	
	}
	
	public void setGameOver() {
		System.out.println("Game Over!!!");
		gameStart = false;
	}
	
	@Override
	public void send(Peer target, Message msg) {
		target.onRecv(msg);
	}

	@Override
	public void onRecv(Message msg) {
		try {// this part may be extracted later
			Class c = Class.forName("server."+msg.getOperationName());
			Constructor constructor = c.getConstructor(); //this warning need to be solved later
			op = (ServerOperation)constructor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		op.operate(this, msg);
	}
	
}
