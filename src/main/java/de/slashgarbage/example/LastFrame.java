package de.slashgarbage.example;

public class LastFrame implements Frame {
	@Override
	public String toString() {
		return "  LastFrame " + firstBalls + "," + secondBalls + "," + thirdBalls + " -> " + score;
	}

	private int firstBalls;
	private int secondBalls;
	private int thirdBalls;
	private int score;

	LastFrame(int firstBalls, int secondBalls, int thirdBalls) {
		this.firstBalls = firstBalls;
		this.secondBalls = secondBalls;
		this.thirdBalls = thirdBalls;
	}

	@Override
	public void computeScore() {
		System.out.println("computeScore for LastFrame");
		int scoreFromPrevious = 0;
		if (previousFrame != null)
			scoreFromPrevious = previousFrame.getScore();
		this.score = scoreFromPrevious + firstBalls + secondBalls + thirdBalls;
	}

	private Frame previousFrame;

	@Override
	public void setPreviousFrame(Frame previousFrame) {
		this.previousFrame = previousFrame;
	}

	private Frame nextFrame = null;

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
