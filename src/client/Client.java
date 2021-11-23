package client;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import ai.AiUi;
import gui.GameController;
import network.Message;
import network.Peer;
import ui.ClientInterface;
import ui.TextUi;
import ui.Ui;
import utils.Tile;
import utils.Meld;

public class Client implements Peer, ClientInterface{
	public final static int CLIENT_NUM = 4;
	
	private ClientOperation op; //need to later add exception handling
	private ArrayList<Tile> wall;
	private ArrayList<ArrayList<Meld>> meldWall;
	private ArrayList<Integer> tileLength;
	private int id;
	private Peer server;
	private Ui ui;
	private ArrayList<Integer> scores;
	
	public Client(int aid, Peer server, String ui) {
		this.id = aid;
//		this.wall = new ArrayList<>();
			
		this.server = server;
		this.scores = new ArrayList<Integer>(Arrays.asList(0,0,0,0));
		chooseUi(ui);
	}
	
	public void chooseUi(String ui) {
		if(id == 0) {
//			this.ui = GameController.getInstance();
//			setUi(GameController.getInstance());
//			GameController.getInstance().init(this); //should resolved later
			if(ui.equals("AI")) {
				setUi(new AiUi(this));
			}
			else if(ui.equals("TEXT")) {
				setUi(new TextUi(this));
			}
			else {
				setUi(GameController.getInstance());
			}
		}
		else {
//			this.ui = new TextUi(this); //this may later need to change other ui options
//			this.ui = new AiUi(this);
			setUi(new AiUi(this));
		}
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
//		for(Integer id : initCards) {
//			wall.add(new Tile(id));
//		}
		wall = Tile.idToTileList(initCards);
		this.meldWall = new ArrayList<ArrayList<Meld>>(CLIENT_NUM);
		for(int i=0; i<CLIENT_NUM; i++) {
			meldWall.add(new ArrayList<Meld>());
		}
		this.tileLength = new ArrayList<Integer>(CLIENT_NUM);
		for(int i=0;i<CLIENT_NUM;i++) {
			tileLength.add(13);
		}
		System.out.println(meldWall.get(0).size());
	}
	
//	public String printWall() {
//		String s = "";
//		for(Tile t:wall) {
//			s = s+(t.getChnName()+" /");
//		}
//		return s;
//	}

	public Tile getTile(int index) {
		return wall.get(index);
	}
	
	public void addTile(int id) {
		wall.add(new Tile(id));
	}
	
	public void discardTile(int index) {
		wall.remove(index);
		reSort();
	}
	
	public void reSort() {
		Collections.sort(wall,new Comparator<Tile>() {

			@Override
			public int compare(Tile o1, Tile o2) {
				return o1.getId()-o2.getId();
			}
		});
	}
	
	public void addMeld(int clientId, Meld meld) {
		meldWall.get(clientId).add(meld);
		int num = tileLength.get(clientId);
		tileLength.set(clientId, num-3);
	}
	
	public void updateWall(Meld meld) {
		wall.removeIf(m -> m.getId()==meld.getFirst().getId());
		wall.removeIf(m -> m.getId()==meld.getSecond().getId());
		wall.removeIf(m -> m.getId()==meld.getThird().getId());
		if(meld.getMeldLength()==4) {
			wall.removeIf(m -> m.getId()==meld.getForth().getId());
		}
		meldWall.get(id).add(meld);
		tileLength.set(id, wall.size());
		
	}
	

	
	public ArrayList<Tile> getWall(){
		return wall;
	}
	
	public ArrayList<Meld> getMeld(){
		return meldWall.get(id);
	}
	
	public int getLength() {
		return wall.size();
	}
	
	public Ui getUi() {
		return ui;
	}
	
	public ArrayList<Meld> getOtherMeld(int clientId){
		return meldWall.get(clientId);
	}
	
	public void setUi(Ui ui) {//more for testing reasons
		this.ui = ui;
	}
	
	@Override
	public void renewScore(ArrayList<Integer> gameScore) {
		for(int i=0;i<scores.size();i++) {
			scores.set(i, scores.get(i)+gameScore.get(i));
		}
	}
	
	@Override
	public int getScore(int clientId) {
		return scores.get(clientId);
	}
}
