package org.oracle.assignment.impl;

import org.oracle.assignment.def.Frame;

public class SimpleFrame extends AbstractFrame {

	private int firstBalls;
	private int secondBalls;

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

	public int getFirstBalls() {
		return firstBalls;
	}

	public int getSecondBalls() {
		return secondBalls;
	}

	public Frame getPreviousFrame() {
		return previousFrame;
	}

	public int getBallsCount() {
		return firstBalls + secondBalls;
	}

}
