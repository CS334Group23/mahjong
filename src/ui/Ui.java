package ui;

import java.util.ArrayList;

import utils.BidMsg;
import utils.DiscardMsg;
import utils.DrawMsg;

public interface Ui {
	public void infoDraw(DrawMsg drawMsg, ArrayList<BidMsg> possibleBid);
	public int getOpIndex();
	public int getDraw();
	public void infoDiscard(DiscardMsg discardMsg, ArrayList<BidMsg> possibleBid);
	public void infoBid(BidMsg bidMsg);
}
