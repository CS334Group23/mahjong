package gui;

import javax.swing.JLabel;

public class TileLabel extends JLabel{
	private boolean isFirstClick;
	
	public TileLabel() {
		super();
		isFirstClick = true;
	}
	
	public boolean isFirstClick() {
		return isFirstClick;
	}
	
	public void setIsFirstClick(boolean bool) {
		isFirstClick = bool;
	}
}
