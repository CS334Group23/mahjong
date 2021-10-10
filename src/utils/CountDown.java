package utils;

import java.lang.Thread.State;

public class CountDown {
	private int time;
	private int count;
	private static final int SECOND = 1000;
	private Thread thread;
	private boolean pause;
	private boolean start;
	
	public CountDown(int maxTime) {
		this.pause = false;
		setTime(maxTime);
	}
	
	public void setTime(int maxTime) {
		if(this.start) {
			return;
		}
		this.time = maxTime;
		this.count = maxTime;
		this.thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while(count != 0) {
					try {
						if(!start) {
							count = 0;
							break;
						}
						if(!pause) {
							Thread.sleep(SECOND);
							count--;
						}
					}
					catch(InterruptedException ex) {
						pause = true;
					}
				}
				done();
			}
				
		});
		this.start = false;
	}
	
	protected void done() {
		System.out.println("Out of time");
	}
	
	public void pause() {
		if(start) {
			thread.interrupt();
		}
	}
	
	public boolean isStart() {
		return start;
	}
	
	public boolean isPause() {
		return pause;
	}
	
	public void stop() {
		if(start){
			start = false;
		}
	}
	
	public void start() {
		if(thread.getState().equals(State.NEW)) {
			start = true;
			thread.start();
		}
		else if(thread.getState().equals(State.TERMINATED)) {
			setTime(time);
			start = true;
			thread.start();
		}
	}
}
