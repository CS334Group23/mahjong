package client;

import utils.BidMsg;
import utils.DiscardMsg;
import utils.DrawMsg;
import utils.Meld;
import utils.Message;
import utils.TerminalIOUtils;
import utils.Tile;
import java.util.*;

import sequence.FacadeChecker;
import sequence.KongChecker;
import sequence.Sequence;

public class DrawOperation implements ClientOperation{

	@Override
	public void operate(Client client, Message msg) {
		DrawMsg drawMsg = (DrawMsg)msg;
		System.out.printf("You are client%d\n", client.getId());
		TerminalIOUtils.printIndex(client.getLength());
		System.out.printf("Client%d has cards: %s\n", client.getId(),client.printWall());
		System.out.printf("Client%d draws card %s\n", client.getId(),Tile.idToChnName((drawMsg).getTileId()));
		Meld kong = KongChecker.checkKong(client.getWall(), new Tile(drawMsg.getTileId()));
		ArrayList<Sequence> possibleSequence = new ArrayList<>();
		FacadeChecker facadeChecker = new FacadeChecker(client.getWall(),client.getMeld(),new Tile(drawMsg.getTileId()));
		possibleSequence = facadeChecker.check_if_win();
		boolean isWin = possibleSequence.size()!=0;
		if(kong!=null || isWin) {
			if(kong == null) {
				handleWin(client, possibleSequence, msg);
			}
			else {
				if(!isWin) {
					handleKong(client, kong, msg);
				}
				else {
					handleWinAndKong(client, kong, possibleSequence, msg);
				}
			}
		}
		client.addTile(((DrawMsg)msg).getTileId());
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
		int discardId = client.getTile(tileIndex-1).getId();
        client.discardTile(tileIndex-1);
		client.send(client.getServer(),new DiscardMsg(discardId,client.getId()));
	}
	
	private void handleKong(Client client, Meld kong, Message msg) {
		TerminalIOUtils.printIndex(2);
		System.out.print("You have options:");
		System.out.printf("%s %s   /",kong.getChnName(),kong.printMeld());
		System.out.println("过");
		System.out.print("Please input the index of the operation: ");
		Scanner scan = new Scanner(System.in);
		int opIndex=0;
        if (scan.hasNext()) {
            opIndex = scan.nextInt()-1;
        }
        if(opIndex<2 && 0<=opIndex) {
        	if(opIndex == 0) {
        		client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.KONG, "KongResponser", ((DrawMsg)msg).getTileId(),kong));
				return;
        	}
        }
	}
	
	private void handleWin(Client client, ArrayList<Sequence> possibleSequence, Message msg) {
		TerminalIOUtils.printIndex(2);
		System.out.print("You have options:");
		System.out.println("胡   /过   ");
		System.out.print("Please input the index of the operation: ");
		Scanner scan = new Scanner(System.in);
		int opIndex=0;
        if (scan.hasNext()) {
            opIndex = scan.nextInt()-1;
        }
        if(opIndex<2 && 0<=opIndex) {
        	if(opIndex == 0) {
        		client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.WIN, "WinResponser", ((DrawMsg)msg).getTileId(),null));
				return;
        	}
        }
	}
	
	private void handleWinAndKong(Client client, Meld kong, ArrayList<Sequence> possibleSequence, Message msg) {
		TerminalIOUtils.printIndex(3);
		System.out.print("You have options:");
		System.out.printf("%s %s   /",kong.getChnName(),kong.printMeld());
		System.out.println("胡   /过   ");
		System.out.print("Please input the index of the operation: ");
		Scanner scan = new Scanner(System.in);
		int opIndex=0;
        if (scan.hasNext()) {
            opIndex = scan.nextInt()-1;
        }
        if(opIndex<3 && 0<=opIndex) {
        	if(opIndex == 0) {
        		client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.KONG, "KongResponser", ((DrawMsg)msg).getTileId(),kong));
				return;
        	}
        	if(opIndex == 1) {
        		client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.WIN, "WinResponser", ((DrawMsg)msg).getTileId(),null));
				return;
        	}
        }
	}

}
