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

// TODO: Auto-generated Javadoc
/**
 * The Class TextUi.
 */
public class TextUi implements Ui{
	
	/** The client. */
	private ClientInterface client; //this client later need to try best to decouple out with input parameters
	
	/** The scan. */
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
	 * Info draw.
	 *
	 * @param drawMsg the draw msg
	 * @param possibleBid the possible bid
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
	 * Gets the op index.
	 *
	 * @return the op index
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
	 * Gets the discard.
	 *
	 * @return the discard
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
	 * Info discard.
	 *
	 * @param discardMsg the discard msg
	 * @param possibleBid the possible bid
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
	 * Info bid.
	 *
	 * @param bidMsg the bid msg
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
	 * Info deal.
	 *
	 * @param dealMsg the deal msg
	 */
	@Override
	public void infoDeal(DealMsg dealMsg) {//this need later change to send a tile list instead of index list, or use get wall interface
		//this may later need to change to extract with other info method with a print method
		System.out.printf("Client%d has cards: %s\n", client.getId(),Tile.tileListToString(client.getWall()));
	}
	
	/**
	 * Info win.
	 *
	 * @param winMsg the win msg
	 */
	@Override
	public void infoWin(WinMsg winMsg) {
		System.out.printf("client%d wins\n", winMsg.getWinClientId());
		for(ArrayList<Integer> hand : winMsg.getHandsList()) {
			System.out.printf("The hand of client %d is %s\n", winMsg.getHandsList().indexOf(hand),Tile.tileListToString(Tile.idToTileList(hand)));
		}
	}

	/**
	 * Info draw notice.
	 *
	 * @param drawNoticeMsg the draw notice msg
	 */
	@Override
	public void infoDrawNotice(DrawNoticeMsg drawNoticeMsg) {
		System.out.printf("server will send a draw to client: %d\n", drawNoticeMsg.getClientId());
	}
	
	/**
	 * Prints the index.
	 *
	 * @param length the length
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
	 * Inits the.
	 *
	 * @param client the client
	 */
	@Override
	public void init(ClientInterface client) {
		System.out.println("text ui init");
	}
	
}
