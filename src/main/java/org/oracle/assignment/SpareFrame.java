package org.oracle.assignment;

public class SpareFrame implements Frame {

	private int firstBalls;
	private int secondBalls;
	private int score;
	private Frame previousFrame;
	private Frame nextFrame;

	SpareFrame(int firstBalls) {
		this.firstBalls = firstBalls;
		this.secondBalls = 10 - firstBalls;
	}

	@Override
	public void computeScore() {

		int scoreFromPrevious = 0;
		if (previousFrame != null)
			scoreFromPrevious = previousFrame.getScore();

		if (nextFrame instanceof SimpleFrame) {
			this.score = scoreFromPrevious + ((SimpleFrame) nextFrame).getFirstBalls() + 10;
		}
		if (nextFrame instanceof StrikeFrame) {
			this.score = scoreFromPrevious + 10 + 10;
		}
		if (nextFrame instanceof SpareFrame) {
			this.score = scoreFromPrevious + ((SpareFrame) nextFrame).getFirstBalls() + 10;
		}
		if (nextFrame instanceof LastFrame) {
			this.score = scoreFromPrevious + ((LastFrame) nextFrame).getFirstBalls() + 10;
		}

	}

	int getFirstBalls() {
		return firstBalls;
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
		return nextFrame;
	}

	public int getBallsCount() {
		return firstBalls + secondBalls;
	}

}
