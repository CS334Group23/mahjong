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

/**
 * The Class AiUi.
 * The Class AiUi which implements the Ui interface and do ai recommendation.
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
	}

	/**
	 * Inform the ui about deal message and update internal state of ai recommender.
	 *
	 * @param dealMsg the deal message
	 */
	@Override
	public void infoDeal(DealMsg dealMsg) {
		aiRecommender.uponCalled(dealMsg.getInitCards());
	}

	/**
	 * Inform the ui about draw message and update internal state of ai recommender.
	 *
	 * @param drawMsg the draw message
	 * @param possibleBid the possible bid represented as BidMsg list
	 */
	@Override
	public void infoDraw(DrawMsg drawMsg, ArrayList<BidMsg> possibleBid) {
		aiRecommender.uponCalled(client.getWall(), drawMsg.getTileId());
	}

	/**
	 * Gets the operation index from the ai.
	 * As the operations are sorted according to the priority, so just return 1
	 *
	 * @return the operation index
	 */
	@Override
	public int getOpIndex() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 1;
	}

	/**
	 * Gets the discard tile index form the ai.
	 *
	 * @return the discard tile index
	 */
	@Override
	public int getDiscard() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Tile tile = aiRecommender.recommend();
		return FindTilePosition.FindPosition(client.getWall(), tile)+1;
	}

	/**
	 * Inform the ui about discard message and update internal state of ai recommender.
	 *
	 * @param discardMsg the discard msg
	 * @param possibleBid the possible bid represented as BidMsg list
	 */
	@Override
	public void infoDiscard(DiscardMsg discardMsg, ArrayList<BidMsg> possibleBid) {
		aiRecommender.uponCalled(client.getWall(), discardMsg.getTileId());
	}

	/**
	 * Inform the ui about bid message and update internal state of ai recommender.
	 *
	 * @param bidMsg the bid message
	 */
	@Override
	public void infoBid(BidMsg bidMsg) {
		aiRecommender.uponCalled(client.getWall(), bidMsg.getMeld());
	}

	/**
	 * Inform the ui about win message.
	 * No operation for AI
	 *
	 * @param winMsg the win message
	 */
	@Override
	public void infoWin(WinMsg winMsg) {
	}

	/**
	 * Inform the ui about draw notice message.
	 * No operation for AI
	 *
	 * @param drawNoticeMsg the draw notice message
	 */
	@Override
	public void infoDrawNotice(DrawNoticeMsg drawNoticeMsg) {
	}

	/**
	 * Inits the ai in a new round of game.
	 *
	 * @param client the client
	 */
	@Override
	public void init(ClientInterface client) {
		this.aiRecommender = new AiRecommender();
		System.out.println("AIUI init");
	}

}
