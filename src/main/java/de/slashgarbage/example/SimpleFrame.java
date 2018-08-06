package de.slashgarbage.example;

public class SimpleFrame implements Frame {
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
	public String toString() {
		return "SimpleFrame " + firstBalls + "," + secondBalls + " -> "+score;
	}

	private int firstBalls;
    private int secondBalls;    
    private int score;

    SimpleFrame(int firstBalls,int secondBalls){
        this.firstBalls = firstBalls;
        this.secondBalls = secondBalls;        
    }

	@Override
	public void computeScore() {
		//System.out.println("computeScore for SimpleFrame");
		int scoreFromPrevious = 0;
		if (previousFrame != null)
			scoreFromPrevious = previousFrame.getScore();
		this.score = scoreFromPrevious + firstBalls + secondBalls;
		System.out.println("computeScore for SimpleFrame " + toString());
		 
	}

	private Frame previousFrame;
	@Override
	public void setPreviousFrame(Frame previousFrame) {
		this.previousFrame = previousFrame;
		
	}
	private Frame nextFrame;
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
		return firstBalls+secondBalls;
	}

}
