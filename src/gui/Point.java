package gui;

public class Point {
	public double x;
	public double y;
	private double initialX;
	private double initialY;
	private double lastX;
	private double lastY;
	
	private int row;
	private int lastRow;
	
	public Point() {
		x = 0; y = 0; row = 0; lastRow = 0;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		this.initialX = x;
		this.initialY = y;
		this.lastX = x;
		this.lastY = y;
		this.row = 0;
		this.lastRow = 0;
	}
	
	public Point(double x, double y, int row) {
		this.x = x;
		this.y = y;
		this.initialX = x;
		this.initialY = y;
		this.lastX = x;
		this.lastY = y;
		this.row = row;
		this.lastRow = row;
	}
	
	public void setX(double x) {
		this.lastX = this.x;
		this.x = x;
	}
	
	public void setY(double y) {
		this.lastY = this.y;
		this.y = y;
	}
	
	public void setRow(int row) {
		this.lastRow = this.row;
		this.row = row;
	}
	
	public void resetCoordinate() {
		x = initialX;
		y = initialY;
	}
	
	public void resetCoordinate(int offsetX, int offsetY) {
		x = initialX + offsetX;
		y = initialY + offsetY;
	}
	
	public void returnToLastPosition() {
		x = lastX;
		y = lastY;
		row = lastRow;
	}

	public double getInitialX() {
		return initialX;
	}

	public double getInitialY() {
		return initialY;
	}
	
	
}
