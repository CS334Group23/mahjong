package Server;

import utils.Message;
import utils.Peer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import Client.Client;

public class Server implements Peer{
	public final static int INITIAL_HAND = 13;
	public final static int CLIENT_NUM = 4;
	
	public Deque<Integer> cardlist;
	public ArrayList<ArrayList<Integer>> client_hands;

	public Server() {
		cardlist = new LinkedList<>();
	}
	
	public void init() {
		ArrayList<Client> allClients = new ArrayList<Client>(CLIENT_NUM);
		cardlist = shuffle();
		for(int i = 0;i<CLIENT_NUM;i++) {
			allClients.set(i, new Client());
		}
		client_hands = deal();
		//send initial hands to the clients
	}
	
	public Deque<Integer> shuffle() {
		Deque<Integer> deque = new LinkedList<>();
		ArrayList<Integer> IDs = new ArrayList<Integer>(144);
		for(int i=0;i<144;i++) {
			IDs.set(i,i);
		}
		Collections.shuffle(IDs);
		for(Integer id : IDs) {
			deque.offerLast(id);
		}
		return deque;	
	}
	
	private ArrayList<ArrayList<Integer>> deal(){
		ArrayList<ArrayList<Integer>> client_hands = new ArrayList<ArrayList<Integer>>(CLIENT_NUM);
		for(int i=0;i<INITIAL_HAND*CLIENT_NUM;i++) {
			int clientID = i%4;
			client_hands.get(clientID).add(cardlist.pollFirst());
		}
		for(int i=0;i<CLIENT_NUM;i++) {
			Collections.sort(client_hands.get(i));
		}

		return client_hands;
	}
	
	@Override
	public void send(Peer target, Message msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRecv(Message msg) {
		// TODO Auto-generated method stub
		
	}
	
}
