package org.oracle.assignment.impl;

public class SpareFrame extends AbstractFrame{

	private int firstBalls;
	private int secondBalls;
	
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
	
	public int getBallsCount() {
		return firstBalls + secondBalls;
	}

}
