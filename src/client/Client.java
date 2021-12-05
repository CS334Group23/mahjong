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
 * The Class Client is the class which stores the client related information and perform operations on the client side.
 */
public class Client implements Peer, ClientInterface{
	
	/** The Constant CLIENT_NUM is the total number of the clients in a game. */
	public final static int CLIENT_NUM = 4;
	
	/** The op is the client operation which is built with Java reflection mechanism. */
	private ClientOperation op; //need to later add exception handling
	
	/** The wall is an array list of tiles this client currently has. */
	private ArrayList<Tile> wall;
	
	/** The meld wall is a 2-dimensional array list storing the meld list of all four clients. */
	private ArrayList<ArrayList<Meld>> meldWall;
	
	/** The tile length is an array list storing how many tiles all four clients' currently have in hand . */
	private ArrayList<Integer> tileLength;
	
	/** The id is the unique identification of client. */
	private int id;
	
	/** The server is the server this client will communicate with in this round of game. */
	private Peer server;
	
	/** The ui is the user interface the client will invoke in this game. */
	private Ui ui;
	
	/** The scores is an array list storing the scores of all four clients. */
	private ArrayList<Integer> scores;
	
	/**
	 * Instantiates a new client.
	 *
	 * @param aid the unique client ID
	 * @param server the server this client will communicate with in this round of game
	 * @param ui the user interface the client will invoke in this game
	 */
	public Client(int aid, Peer server, String ui) {
		this.id = aid;
			
		this.server = server;
		this.scores = new ArrayList<Integer>(Arrays.asList(0,0,0,0));
		chooseUi(ui);
	}
	
	/**
	 * Choose the user interface this client will interact with.
	 *
	 * @param ui the user interface the client will invoke in this game.
	 */
	public void chooseUi(String ui) {
		if(id == 0) {
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
			setUi(new AiUi(this));
		}
	}
	
	/**
	 * Gets the client unique ID.
	 *
	 * @return the client ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets the server the client communicate with.
	 *
	 * @return the server the client communicate with
	 */
	public Peer getServer() {
		return server;
	}
	
	/**
	 * Sends the message.
	 *
	 * @param target the receiver of the message
	 * @param msg the message that is going to be sent
	 */
	@Override
	public void send(Peer target, Message msg) {
		target.onRecv(msg);
	}

	/**
	 * Deals with the received Message.
	 * Uses Java reflection mechanism to construct the corresponding operation class.
	 *
	 * @param msg the message the client receives
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
	 * Initiates the tile wall.
	 *
	 * @param initCards the array list of tiles the client receives at the beginning a game
	 */
	public void initWall(ArrayList<Integer> initCards) {
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
	 * Gets the tile according to the index.
	 *
	 * @param index the index of the locations of the tile
	 * @return the tile needed
	 */
	public Tile getTile(int index) {
		return wall.get(index);
	}
	
	/**
	 * Adds the tile to the client's tile wall.
	 *
	 * @param id the unique ID of the tile
	 */
	public void addTile(int id) {
		wall.add(new Tile(id));
	}
	
	/**
	 * Discard tile and remove the tile from the client's tile wall according to the index.
	 *
	 * @param index the index of the tile needed to be removed
	 */
	public void discardTile(int index) {
		wall.remove(index);
		reSort();
	}
	
	/**
	 * Sorts the tile wall according to the tile ID from small to big.
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
	 * Adds the meld to the meld wall.
	 *
	 * @param clientId the client ID the meld belongs to
	 * @param meld the meld that is going to be added
	 */
	public void addMeld(int clientId, Meld meld) {
		meldWall.get(clientId).add(meld);
		int num = tileLength.get(clientId);
		tileLength.set(clientId, num-3);
	}
	
	/**
	 * Remove the tile in the meld from the tile wall.
	 *
	 * @param meld the meld the client forms
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
	 * Gets the client's own tile wall.
	 *
	 * @return the client's own tile wall
	 */
	public ArrayList<Tile> getWall(){
		return wall;
	}
	
	/**
	 * Gets the client's own meld wall.
	 *
	 * @return the client's own meld wall
	 */
	public ArrayList<Meld> getMeld(){
		return meldWall.get(id);
	}
	
	/**
	 * Gets how many tiles the client has in hand currently.
	 *
	 * @return the number of tiles the client has in hand currently
	 */
	public int getLength() {
		return wall.size();
	}
	
	/**
	 * Gets the user interface this client will interact with.
	 *
	 * @return the user interface this client will interact with
	 */
	public Ui getUi() {
		return ui;
	}
	
	/**
	 * Gets other client's meld according to the client ID.
	 *
	 * @param clientId the other client's id
	 * @return the meld wall of the chosen client
	 */
	public ArrayList<Meld> getOtherMeld(int clientId){
		return meldWall.get(clientId);
	}
	
	/**
	 * Sets the user interface this client will interact with.
	 *
	 * @param ui the new user interface this client will interact with
	 */
	public void setUi(Ui ui) {//more for testing reasons
		this.ui = ui;
	}
	
	/**
	 * Renew scores of four clients after finishing a game.
	 *
	 * @param gameScore the game score of the single round of game
	 */
	@Override
	public void renewScore(ArrayList<Integer> gameScore) {
		for(int i=0;i<scores.size();i++) {
			scores.set(i, scores.get(i)+gameScore.get(i));
		}
	}
	
	/**
	 * Gets the score according to the client ID.
	 *
	 * @param clientId the client ID
	 * @return the score of the specified client
	 */
	@Override
	public int getScore(int clientId) {
		return scores.get(clientId);
	}
}
