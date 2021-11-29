/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Point.java </p> 
 * @author TeamCS3343 </a>
 */
package ui.gui;

// TODO: Auto-generated Javadoc
/**
 * The Class Point.
 */
public class Point {
	
	/** The x. */
	public double x;
	
	/** The y. */
	public double y;
	
	/** The initial X. */
	private double initialX;
	
	/** The initial Y. */
	private double initialY;
	
	/** The last X. */
	private double lastX;
	
	/** The last Y. */
	private double lastY;
	
	/**
	 * Instantiates a new point.
	 */
	public Point() {
		x = 0; y = 0;
	}
	
	/**
	 * Instantiates a new point.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		this.initialX = x;
		this.initialY = y;
		this.lastX = x;
		this.lastY = y;
	}
	
	/**
	 * Instantiates a new point.
	 *
	 * @param x the x
	 * @param y the y
	 * @param row the row
	 */
	public Point(double x, double y, int row) {
		this.x = x;
		this.y = y;
		this.initialX = x;
		this.initialY = y;
		this.lastX = x;
		this.lastY = y;
	}
	
	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(double x) {
		this.lastX = this.x;
		this.x = x;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(double y) {
		this.lastY = this.y;
		this.y = y;
	}
	
	/**
	 * Reset coordinate.
	 */
	public void resetCoordinate() {
		x = initialX;
		y = initialY;
	}
	
	/**
	 * Reset coordinate.
	 *
	 * @param offsetX the offset X
	 * @param offsetY the offset Y
	 */
	public void resetCoordinate(int offsetX, int offsetY) {
		x = initialX + offsetX;
		y = initialY + offsetY;
	}
	
	/**
	 * Return to last position.
	 */
	public void returnToLastPosition() {
		x = lastX;
		y = lastY;
	}

	/**
	 * Gets the initial X.
	 *
	 * @return the initial X
	 */
	public double getInitialX() {
		return initialX;
	}

	/**
	 * Gets the initial Y.
	 *
	 * @return the initial Y
	 */
	public double getInitialY() {
		return initialY;
	}
	
	
}
