/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: AiUi.java </p> 
 * @author TeamCS3343 </a>
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class AiUi.
 */
public class AiUi implements Ui{
	
	/** The client. */
	private ClientInterface client;
	
	/** The ai recommender. */
	private AiRecommender aiRecommender;
	
	/**
	 * Instantiates a new ai ui.
	 *
	 * @param client the client
	 */
	public AiUi(ClientInterface client) {
		this.client = client;
//		this.aiRecommender = new AiRecommender();
	}

	/**
	 * Info deal.
	 *
	 * @param dealMsg the deal msg
	 */
	@Override
	public void infoDeal(DealMsg dealMsg) {
		aiRecommender.uponCalled(dealMsg.getInitCards());
	}

	/**
	 * Info draw.
	 *
	 * @param drawMsg the draw msg
	 * @param possibleBid the possible bid
	 */
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

	/**
	 * Gets the op index.
	 *
	 * @return the op index
	 */
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

	/**
	 * Gets the discard.
	 *
	 * @return the discard
	 */
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

	/**
	 * Info discard.
	 *
	 * @param discardMsg the discard msg
	 * @param possibleBid the possible bid
	 */
	@Override
	public void infoDiscard(DiscardMsg discardMsg, ArrayList<BidMsg> possibleBid) {
		aiRecommender.uponCalled(client.getWall(), discardMsg.getTileId());
	}

	/**
	 * Info bid.
	 *
	 * @param bidMsg the bid msg
	 */
	@Override
	public void infoBid(BidMsg bidMsg) {
		aiRecommender.uponCalled(client.getWall(), bidMsg.getMeld());
	}

	/**
	 * Info win.
	 *
	 * @param winMsg the win msg
	 */
	@Override
	public void infoWin(WinMsg winMsg) {
		// TODO Auto-generated method stub
		//here need other check or reset to init state for aiUi
	}

	/**
	 * Info draw notice.
	 *
	 * @param drawNoticeMsg the draw notice msg
	 */
	@Override
	public void infoDrawNotice(DrawNoticeMsg drawNoticeMsg) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Inits the.
	 *
	 * @param client the client
	 */
	@Override
	public void init(ClientInterface client) {
		// TODO Auto-generated method stub
		this.aiRecommender = new AiRecommender();
		System.out.println("AIUI init");
	}

}
