package ui;

import java.util.ArrayList;

import network.BidMsg;
import network.DealMsg;
import network.DiscardMsg;
import network.DrawMsg;
import network.DrawNoticeMsg;
import network.WinMsg;

public interface Ui {
	public void infoDeal(DealMsg dealMsg); 
	public void infoDraw(DrawMsg drawMsg, ArrayList<BidMsg> possibleBid);
	public int getOpIndex();
	public int getDiscard();
	public void infoDiscard(DiscardMsg discardMsg, ArrayList<BidMsg> possibleBid);
	public void infoBid(BidMsg bidMsg);
	public void infoWin(WinMsg winMsg);
	public void infoDrawNotice(DrawNoticeMsg drawNoticeMsg);
	public void init(ClientInterface client);
}
