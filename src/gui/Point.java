package gui;

public class Point {
	public int x;
	public int y;
	public int row;
	
	public Point() {
		x = 0; y = 0; row = 0;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.row = 0;
	}
	
	public Point(int x, int y, int row) {
		this.x = x;
		this.y = y;
		this.row = row;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
}
