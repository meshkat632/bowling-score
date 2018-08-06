package org.oracle.assignment;

public class LastFrame implements Frame {

	private int firstBalls;
	private int secondBalls;
	private int thirdBalls;
	private int score;
	private Frame previousFrame;
	private Frame nextFrame = null;

	LastFrame(int firstBalls, int secondBalls, int thirdBalls) {
		this.firstBalls = firstBalls;
		this.secondBalls = secondBalls;
		this.thirdBalls = thirdBalls;
	}

	@Override
	public void computeScore() {
		int scoreFromPrevious = 0;
		if (previousFrame != null)
			scoreFromPrevious = previousFrame.getScore();
		this.score = scoreFromPrevious + firstBalls + secondBalls + thirdBalls;
	}

	@Override
	public void setPreviousFrame(Frame previousFrame) {
		this.previousFrame = previousFrame;
	}

	@Override
	public void setNextFrame(Frame nextFrame) {
		this.nextFrame = nextFrame;

	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public Frame getNextFrame() {
		return null;
	}

	public int getFirstTwoBallsCount() {
		return firstBalls + secondBalls;
	}

	public int getFirstBalls() {
		return firstBalls;
	}

}
