package gui;

public class Point {
	public double x;
	public double y;
	private double initialX;
	private double initialY;
	
	public int row;
	
	public Point() {
		x = 0; y = 0; row = 0;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		this.initialX = x;
		this.initialY = y;
		this.row = 0;
	}
	
	public Point(double x, double y, int row) {
		this.x = x;
		this.y = y;
		this.initialX = x;
		this.initialY = y;
		this.row = row;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public void resetCoordinate() {
		x = initialX;
		y = initialY;
	}
}
