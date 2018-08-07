package org.oracle.conject.assignment.impl;

import org.oracle.conject.assignment.Constants;

public class SpareFrame extends AbstractFrame{

	private int firstBalls;
	private int secondBalls;
	
	SpareFrame(int firstBalls) {
		this.firstBalls = firstBalls;
		this.secondBalls = Constants.MAX_PIN - firstBalls;
	}

	@Override
	public void computeScore() {

		int scoreFromPrevious = 0;
		if (previousFrame != null)
			scoreFromPrevious = previousFrame.getScore();

		if (nextFrame instanceof SimpleFrame) {
			this.score = scoreFromPrevious + ((SimpleFrame) nextFrame).getFirstBalls() + Constants.MAX_PIN;
		}
		if (nextFrame instanceof StrikeFrame) {
			this.score = scoreFromPrevious + Constants.MAX_PIN + Constants.MAX_PIN;
		}
		if (nextFrame instanceof SpareFrame) {
			this.score = scoreFromPrevious + ((SpareFrame) nextFrame).getFirstBalls() + Constants.MAX_PIN;
		}
		if (nextFrame instanceof LastFrame) {
			this.score = scoreFromPrevious + ((LastFrame) nextFrame).getFirstBalls() + Constants.MAX_PIN;
		}

	}

	int getFirstBalls() {
		return firstBalls;
	}
	
	public int getBallsCount() {
		return firstBalls + secondBalls;
	}

}
