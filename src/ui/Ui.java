package ui;

import java.util.ArrayList;

import utils.BidMsg;
import utils.DealMsg;
import utils.DiscardMsg;
import utils.DrawMsg;

public interface Ui {
	public void infoDeal(DealMsg dealMsg);
	public void infoDraw(DrawMsg drawMsg, ArrayList<BidMsg> possibleBid);
	public int getOpIndex();
	public int getDiscard();
	public void infoDiscard(DiscardMsg discardMsg, ArrayList<BidMsg> possibleBid);
	public void infoBid(BidMsg bidMsg);
	void infoWin(BidMsg bidMsg);
}
