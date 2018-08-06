package org.oracle.assignment;

public class SimpleFrame implements Frame {

	private int firstBalls;
	private int secondBalls;
	private int score;
	private Frame previousFrame;
	private Frame nextFrame;

	SimpleFrame(int firstBalls, int secondBalls) {
		this.firstBalls = firstBalls;
		this.secondBalls = secondBalls;
	}

	@Override
	public void computeScore() {
		int scoreFromPrevious = 0;
		if (previousFrame != null)
			scoreFromPrevious = previousFrame.getScore();
		this.score = scoreFromPrevious + firstBalls + secondBalls;
	}

	@Override
	public void setPreviousFrame(Frame previousFrame) {
		this.previousFrame = previousFrame;

	}

	@Override
	public void setNextFrame(Frame nextFrame) {
		this.nextFrame = nextFrame;

	}

	public int getFirstBalls() {
		return firstBalls;
	}

	public int getSecondBalls() {
		return secondBalls;
	}

	public Frame getPreviousFrame() {
		return previousFrame;
	}	

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public Frame getNextFrame() {
		return nextFrame;
	}

	public int getBallsCount() {
		return firstBalls + secondBalls;
	}

}
