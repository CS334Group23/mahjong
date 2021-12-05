/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TextUi.java </p> 
 * @author TeamCS3343 </a>
 */
package ui.textUi;

import java.util.ArrayList;
import java.util.Scanner;

import network.BidMsg;
import network.DealMsg;
import network.DiscardMsg;
import network.DrawMsg;
import network.DrawNoticeMsg;
import network.WinMsg;
import ui.ClientInterface;
import ui.Ui;
import utils.BidType;
import utils.Tile;

/**
 * The Class TextUi.
 * The Class TextUi which implements the Ui interface and do terminal IO.
 */
public class TextUi implements Ui{
	
	/** The client. */
	private ClientInterface client;
	
	/** The scan to read terminal input. */
	private Scanner scan;
	
	/**
	 * Instantiates a new text ui.
	 *
	 * @param client the client
	 */
	public TextUi(ClientInterface client) { //this may later change to singleton
		this.client = client;
		scan = new Scanner(System.in);
	}

	/**
	 * Info the ui about draw message and print accordance information on the terminal.
	 *
	 * @param drawMsg the draw message
	 * @param possibleBid the possible bid represented as BidMsg list
	 */
	@Override
	public void infoDraw(DrawMsg drawMsg, ArrayList<BidMsg> possibleBid) {
		System.out.printf("You are client%d\n", client.getId());
		printIndex(client.getLength());
		System.out.printf("Client%d has cards: %s\n", client.getId(),Tile.tileListToString(client.getWall()));
		System.out.printf("Client%d draws card %s\n", client.getId(),Tile.idToChnName((drawMsg).getTileId()));
		if(possibleBid != null && possibleBid.size()>0) {
			printIndex(possibleBid.size());
			System.out.print("You have options:");
			BidMsg.printBid(possibleBid);
		}
	}


	/**
	 * Gets the operation index of the user from the terminal.
	 *
	 * @return the operation index
	 */
	@Override
	public int getOpIndex() {
		System.out.print("Please input the index of the operation: ");
		int opIndex=-1;
        if (scan.hasNext()) {
            opIndex = scan.nextInt()-1;
        }
        return opIndex;
	}

	/**
	 * Gets the discard index of the user from the terminal.
	 *
	 * @return the discard index
	 */
	@Override
	public int getDiscard() {
		//this may add if to make two parts unity
		System.out.printf("Please Input the index of the card you want to play (If you want to discard the card you draw, type %d):",client.getLength());
		boolean validInput = false;
		int tileIndex=client.getLength();
		while(!validInput) {
	        if (scan.hasNext()) {
	            tileIndex = scan.nextInt();
	        }
	        if(1<=tileIndex && tileIndex<= client.getLength()) {
	        	validInput=true;
	        }
	        else {
	        	System.out.print("Invalid input. Please input again: ");
	        }
	        
		}
		return tileIndex;
	}

	/**
	 * Info the ui about discard message and print accordance information on the terminal.
	 * 
	 * @param discardMsg the discard message
	 * @param possibleBid the possible bid represented as BidMsg list
	 */
	@Override
	public void infoDiscard(DiscardMsg discardMsg, ArrayList<BidMsg> possibleBid) {
		System.out.printf("You are client%d\n", client.getId());
		System.out.printf("Client%d discards %s\n", discardMsg.getSenderId(),Tile.idToChnName(discardMsg.getTileId()));
		if(possibleBid != null && possibleBid.size()>0) { //in the main logic part still need to check
			printIndex(possibleBid.size());
			System.out.print("You have options:");
			BidMsg.printBid(possibleBid);
			System.out.printf("Client%d has cards: %s\n", client.getId(),Tile.tileListToString(client.getWall()));
		}
	}

	/**
	 * Info the ui about bid message and print accordance information on the terminal.
	 *
	 * @param bidMsg the bid message
	 */
	@Override
	public void infoBid(BidMsg bidMsg) {
		System.out.printf("client%d plays the operation %s\n", bidMsg.getBidClient(), bidMsg.getChnName());
		if(bidMsg.getBidType() == BidType.CHOW.getBidType() || bidMsg.getBidType() == BidType.PONG.getBidType()) {
			//here getBidType later need more unity to save to may conversion
			printIndex(client.getLength());
			System.out.printf("Client%d has cards: %s\n", client.getId(),Tile.tileListToString(client.getWall()));
		}
	}
	
	/**
	 * Inform the ui about deal message and print accordance information on the terminal.
	 *
	 * @param dealMsg the deal message
	 */
	@Override
	public void infoDeal(DealMsg dealMsg) {//this need later change to send a tile list instead of index list, or use get wall interface
		//this may later need to change to extract with other info method with a print method
		System.out.printf("Client%d has cards: %s\n", client.getId(),Tile.tileListToString(client.getWall()));
	}
	
	/**
	 * Info the ui about win message and print accordance information on the terminal.
	 *
	 * @param winMsg the win message
	 */
	@Override
	public void infoWin(WinMsg winMsg) {
		System.out.printf("client%d wins\n", winMsg.getWinClientId());
		for(ArrayList<Integer> hand : winMsg.getHandsList()) {
			System.out.printf("The hand of client %d is %s\n", winMsg.getHandsList().indexOf(hand),Tile.tileListToString(Tile.idToTileList(hand)));
		}
	}

	/**
	 * Info the ui about draw notice message and print accordance information on the terminal.
	 *
	 * @param drawNoticeMsg the draw notice message
	 */
	@Override
	public void infoDrawNotice(DrawNoticeMsg drawNoticeMsg) {
		System.out.printf("server will send a draw to client: %d\n", drawNoticeMsg.getClientId());
	}
	
	/**
	 * Auxiliary function to prints the index of the Tile list for user convenience.
	 *
	 * @param length the length of the Tile list
	 */
	private static void printIndex(int length) {
		String str = "";
		for(int i=0;i<16;i++) {
			str += " ";
		}
		for(int i=0;i<length;i++) {
			str += "    ";
			str += Integer.toString(i+1);
		}
		System.out.println(str);
	}

	/**
	 * Inits the text ui and print accordance information on the terminal.
	 *
	 * @param client the client
	 */
	@Override
	public void init(ClientInterface client) {
		System.out.println("text ui init");
	}
	
}
