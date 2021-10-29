package ui;

import java.util.ArrayList;
import java.util.Scanner;

import utils.BidMsg;
import utils.BidType;
import utils.DiscardMsg;
import utils.DrawMsg;
import utils.TerminalIOUtils;
import utils.Tile;

public class TextUi implements Ui{
	private ClientInterface client; //this client later need to try best to decouple out with input parameters

	@Override
	public void infoDraw(DrawMsg drawMsg, ArrayList<BidMsg> possibleBid) {
		System.out.printf("You are client%d\n", client.getId());
		TerminalIOUtils.printIndex(client.getLength());
		System.out.printf("Client%d has cards: %s\n", client.getId(),client.printWall());
		System.out.printf("Client%d draws card %s\n", client.getId(),Tile.idToChnName((drawMsg).getTileId()));
		if(possibleBid.size()>0) {
			TerminalIOUtils.printIndex(possibleBid.size());
			System.out.print("You have options:");
			BidMsg.printBid(possibleBid);
		}
	}

	@Override
	public int getOpIndex() {
		Scanner scan = new Scanner(System.in);
		int opIndex=0;
        if (scan.hasNext()) {
            opIndex = scan.nextInt()-1;
        }
        return opIndex;
	}

	@Override
	public int getDraw() {
		//this may add if to make two parts unity
		System.out.printf("Please Input the index of the card you want to play (If you want to discard the card you draw, type %d):",client.getLength());
		boolean validInput = false;
		int tileIndex=client.getLength();
		while(!validInput) {
			Scanner scan = new Scanner(System.in);
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
		if(possibleBid.size()>0) { //in the main logic part still need to check
			TerminalIOUtils.printIndex(possibleBid.size());
			System.out.print("You have options:");
			BidMsg.printBid(possibleBid);
			System.out.printf("Client%d has cards: %s\n", client.getId(),client.printWall());
		}
	}

	@Override
	public void infoBid(BidMsg bidMsg) {
		System.out.printf("client%d plays the operation %s\n", bidMsg.getBidClient(), bidMsg.getOperationName());
		if(bidMsg.getBidType() == BidType.CHOW.getBidType() || bidMsg.getBidType() == BidType.PONG.getBidType()) {
			//here getBidType later need more unity to save to may conversion
			TerminalIOUtils.printIndex(client.getLength());
			System.out.printf("Client%d has cards: %s\n", client.getId(),client.printWall());
		}
	}
	
	
	
}
