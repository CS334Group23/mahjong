package client;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import utils.Message;
import utils.Peer;
import utils.Tile;

public class Client implements Peer{
	private ClientOperation op; //need to later add exception handling
	private ArrayList<Tile> wall;
	private int id;
	private Peer server;
	
	public Client(int aid, Peer server) {
		this.id = aid;
		this.wall = new ArrayList<>();
		this.server = server;
	}
	
	public int getId() {
		return id;
	}
	
	public Peer getServer() {
		return server;
	}
	
	@Override
	public void send(Peer target, Message msg) {
		target.onRecv(msg);
	}

	@Override
	public void onRecv(Message msg) {
		try {
			Class c = Class.forName("client."+msg.getOperationName()); //this hard code need to be solved later
			Constructor constructor = c.getConstructor(); //this warning need to be solved later
			op = (ClientOperation)constructor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		op.operate(this, msg);
	}
	
	public void initWall(ArrayList<Integer> initCards) {
		for(Integer id : initCards) {
			wall.add(new Tile(id));
		}
	}
	
	public String printWall() {
		String s = "";
		for(Tile t:wall) {
			s = s+(t.getName()+" ");
		}
		return s;
	}
	
	public Tile getTile(int index) {
		return wall.get(index);
	}
}
