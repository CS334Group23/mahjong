/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Client.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import network.Message;
import network.Peer;
import ui.ClientInterface;
import ui.Ui;
import ui.aiUi.AiUi;
import ui.gui.GameController;
import ui.textUi.TextUi;
import utils.Tile;
import utils.Meld;

// TODO: Auto-generated Javadoc
/**
 * The Class Client.
 */
public class Client implements Peer, ClientInterface{
	
	/** The Constant CLIENT_NUM. */
	public final static int CLIENT_NUM = 4;
	
	/** The op. */
	private ClientOperation op; //need to later add exception handling
	
	/** The wall. */
	private ArrayList<Tile> wall;
	
	/** The meld wall. */
	private ArrayList<ArrayList<Meld>> meldWall;
	
	/** The tile length. */
	private ArrayList<Integer> tileLength;
	
	/** The id. */
	private int id;
	
	/** The server. */
	private Peer server;
	
	/** The ui. */
	private Ui ui;
	
	/** The scores. */
	private ArrayList<Integer> scores;
	
	/**
	 * Instantiates a new client.
	 *
	 * @param aid the aid
	 * @param server the server
	 * @param ui the ui
	 */
	public Client(int aid, Peer server, String ui) {
		this.id = aid;
//		this.wall = new ArrayList<>();
			
		this.server = server;
		this.scores = new ArrayList<Integer>(Arrays.asList(0,0,0,0));
		chooseUi(ui);
	}
	
	/**
	 * Choose ui.
	 *
	 * @param ui the ui
	 */
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
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets the server.
	 *
	 * @return the server
	 */
	public Peer getServer() {
		return server;
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
		try {
			Class<?> c = Class.forName("client."+msg.getOperationName());
			Constructor<?> constructor = c.getConstructor();
			op = (ClientOperation)constructor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		op.operate(this, msg);
	}
	
	/**
	 * Inits the wall.
	 *
	 * @param initCards the init cards
	 */
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
	}

	/**
 * Gets the tile.
 *
 * @param index the index
 * @return the tile
 */
public Tile getTile(int index) {
		return wall.get(index);
	}
	
	/**
	 * Adds the tile.
	 *
	 * @param id the id
	 */
	public void addTile(int id) {
		wall.add(new Tile(id));
	}
	
	/**
	 * Discard tile.
	 *
	 * @param index the index
	 */
	public void discardTile(int index) {
		wall.remove(index);
		reSort();
	}
	
	/**
	 * Re sort.
	 */
	public void reSort() {
		Collections.sort(wall,new Comparator<Tile>() {

			@Override
			public int compare(Tile o1, Tile o2) {
				return o1.getId()-o2.getId();
			}
		});
	}
	
	/**
	 * Adds the meld.
	 *
	 * @param clientId the client id
	 * @param meld the meld
	 */
	public void addMeld(int clientId, Meld meld) {
		meldWall.get(clientId).add(meld);
		int num = tileLength.get(clientId);
		tileLength.set(clientId, num-3);
	}
	
	/**
	 * Update wall.
	 *
	 * @param meld the meld
	 */
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
	

	
	/**
	 * Gets the wall.
	 *
	 * @return the wall
	 */
	public ArrayList<Tile> getWall(){
		return wall;
	}
	
	/**
	 * Gets the meld.
	 *
	 * @return the meld
	 */
	public ArrayList<Meld> getMeld(){
		return meldWall.get(id);
	}
	
	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public int getLength() {
		return wall.size();
	}
	
	/**
	 * Gets the ui.
	 *
	 * @return the ui
	 */
	public Ui getUi() {
		return ui;
	}
	
	/**
	 * Gets the other meld.
	 *
	 * @param clientId the client id
	 * @return the other meld
	 */
	public ArrayList<Meld> getOtherMeld(int clientId){
		return meldWall.get(clientId);
	}
	
	/**
	 * Sets the ui.
	 *
	 * @param ui the new ui
	 */
	public void setUi(Ui ui) {//more for testing reasons
		this.ui = ui;
	}
	
	/**
	 * Renew score.
	 *
	 * @param gameScore the game score
	 */
	@Override
	public void renewScore(ArrayList<Integer> gameScore) {
		for(int i=0;i<scores.size();i++) {
			scores.set(i, scores.get(i)+gameScore.get(i));
		}
	}
	
	/**
	 * Gets the score.
	 *
	 * @param clientId the client id
	 * @return the score
	 */
	@Override
	public int getScore(int clientId) {
		return scores.get(clientId);
	}
}
