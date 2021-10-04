package Server;

import utils.Message;
import utils.Peer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Server implements Peer{

	public Server() {
		
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
	
	@Override
	public void send(Peer target, Message msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRecv(Message msg) {
		// TODO Auto-generated method stub
		
	}
	
}
