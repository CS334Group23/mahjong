package server;

import utils.DealMsg;
import utils.DrawMsg;
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
	
	private Deque<Integer> cardlist;
	private ArrayList<ArrayList<Integer>> client_hands;
	private ServerOperation op; //need to later add exception handling
	private ArrayList<Client> allClients;

	public Server() {
		cardlist = new LinkedList<>();
	}
	
	public void init() {
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
		int currentClientId = 0;
		send(allClients.get(currentClientId),new DrawMsg(cardlist.pollFirst()));
	}
	
	public Deque<Integer> shuffle() {
		Deque<Integer> deque = new LinkedList<>();
		ArrayList<Integer> IDs = new ArrayList<Integer>();
		for(int i=0;i<144;i++) {
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
	
	public void sendAll(Message msg) {
		for(int i = 0;i<CLIENT_NUM;i++) {
			send(allClients.get(i),msg);
		}
	}
	
	@Override
	public void send(Peer target, Message msg) {
		target.onRecv(msg);
	}

	@Override
	public void onRecv(Message msg) {
		try {
			Class c = Class.forName(msg.getOperationName());
			Constructor constructor = c.getConstructor(); //this warning need to be solved later
			op = (ServerOperation)constructor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		op.operate(this, msg);
	}
	
}
