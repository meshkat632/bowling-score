package org.oracle.conject.assignment.impl;

public class LastFrame extends AbstractFrame {

	private int firstBalls;
	private int secondBalls;
	private int thirdBalls;
	
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
	
	public int getFirstTwoBallsCount() {
		return firstBalls + secondBalls;
	}

	public int getFirstBalls() {
		return firstBalls;
	}

}
