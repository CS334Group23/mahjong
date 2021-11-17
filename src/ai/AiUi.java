package ai;

import java.util.ArrayList;

import ui.ClientInterface;
import ui.Ui;
import utils.BidMsg;
import utils.DealMsg;
import utils.DiscardMsg;
import utils.DrawMsg;
import utils.DrawNoticeMsg;
import utils.FindTilePosition;
import utils.Tile;

public class AiUi implements Ui{
	private ClientInterface client;
	private AiRecommender aiRecommender;
	
	public AiUi(ClientInterface client) {
		this.client = client;
		this.aiRecommender = new AiRecommender();
	}

	@Override
	public void infoDeal(DealMsg dealMsg) {
		aiRecommender.uponCalled(dealMsg.getInitCards());
	}

	@Override
	public void infoDraw(DrawMsg drawMsg, ArrayList<BidMsg> possibleBid) {
		aiRecommender.uponCalled(client.getWall(), drawMsg.getTileId());
	}

	@Override
	public int getOpIndex() { //this need later check
		return 1;
	}

	@Override
	public int getDiscard() {
//		Tile tile = aiRecommender.recommend();
//		return FindTilePosition.FindPosition(client.getWall(), tile)+1;
		return 1;
	}

	@Override
	public void infoDiscard(DiscardMsg discardMsg, ArrayList<BidMsg> possibleBid) {
		aiRecommender.uponCalled(client.getWall(), discardMsg.getTileId());
	}

	@Override
	public void infoBid(BidMsg bidMsg) {
		aiRecommender.uponCalled(bidMsg.getMeld());
	}

	@Override
	public void infoWin(BidMsg bidMsg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void infoDrawNotice(DrawNoticeMsg drawNoticeMsg) {
		// TODO Auto-generated method stub
		
	}

}
