package ui.aiUi;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import network.BidMsg;
import network.DealMsg;
import network.DiscardMsg;
import network.DrawMsg;
import network.DrawNoticeMsg;
import network.WinMsg;
import ui.ClientInterface;
import ui.Ui;
import utils.FindTilePosition;
import utils.Tile;

public class AiUi implements Ui{
	private ClientInterface client;
	private AiRecommender aiRecommender;
	
	public AiUi(ClientInterface client) {
		this.client = client;
//		this.aiRecommender = new AiRecommender();
	}

	@Override
	public void infoDeal(DealMsg dealMsg) {
		aiRecommender.uponCalled(dealMsg.getInitCards());
	}

	@Override
	public void infoDraw(DrawMsg drawMsg, ArrayList<BidMsg> possibleBid) {
//		try {
//			TimeUnit.SECONDS.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		aiRecommender.uponCalled(client.getWall(), drawMsg.getTileId());
	}

	@Override
	public int getOpIndex() { //this need later check
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int getDiscard() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Tile tile = aiRecommender.recommend();
		return FindTilePosition.FindPosition(client.getWall(), tile)+1;
//		return 1;
	}

	@Override
	public void infoDiscard(DiscardMsg discardMsg, ArrayList<BidMsg> possibleBid) {
		aiRecommender.uponCalled(client.getWall(), discardMsg.getTileId());
	}

	@Override
	public void infoBid(BidMsg bidMsg) {
		aiRecommender.uponCalled(client.getWall(), bidMsg.getMeld());
	}

	@Override
	public void infoWin(WinMsg winMsg) {
		// TODO Auto-generated method stub
		//here need other check or reset to init state for aiUi
	}

	@Override
	public void infoDrawNotice(DrawNoticeMsg drawNoticeMsg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(ClientInterface client) {
		// TODO Auto-generated method stub
		this.aiRecommender = new AiRecommender();
		System.out.println("AIUI init");
	}

}
