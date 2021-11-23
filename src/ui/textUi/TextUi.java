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

public class TextUi implements Ui{
	private ClientInterface client; //this client later need to try best to decouple out with input parameters
	private Scanner scan;
	
	public TextUi(ClientInterface client) { //this may later change to singleton
		this.client = client;
		scan = new Scanner(System.in);
	}

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


	@Override
	public int getOpIndex() {
		System.out.print("Please input the index of the operation: ");
		int opIndex=-1;
        if (scan.hasNext()) {
            opIndex = scan.nextInt()-1;
        }
        return opIndex;
	}

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

	@Override
	public void infoBid(BidMsg bidMsg) {
		System.out.printf("client%d plays the operation %s\n", bidMsg.getBidClient(), bidMsg.getOperationName());
		if(bidMsg.getBidType() == BidType.CHOW.getBidType() || bidMsg.getBidType() == BidType.PONG.getBidType()) {
			//here getBidType later need more unity to save to may conversion
			printIndex(client.getLength());
			System.out.printf("Client%d has cards: %s\n", client.getId(),Tile.tileListToString(client.getWall()));
		}
	}
	
	@Override
	public void infoDeal(DealMsg dealMsg) {//this need later change to send a tile list instead of index list, or use get wall interface
		//this may later need to change to extract with other info method with a print method
		System.out.printf("Client%d has cards: %s\n", client.getId(),Tile.tileListToString(client.getWall()));
	}
	
	@Override
	public void infoWin(WinMsg winMsg) {
		System.out.printf("client%d wins\n", winMsg.getWinClientId());
		for(ArrayList<Integer> hand : winMsg.getHandsList()) {
			System.out.printf("The hand of client %d is %s\n", winMsg.getHandsList().indexOf(hand),Tile.tileListToString(Tile.idToTileList(hand)));
		}
	}

	@Override
	public void infoDrawNotice(DrawNoticeMsg drawNoticeMsg) {
		System.out.printf("server will send a draw to client: %d\n", drawNoticeMsg.getClientId());
	}
	
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

	@Override
	public void init(ClientInterface client) {
		System.out.println("text ui init");
	}
	
}
