package de.slashgarbage.example;

public class StrikeFrame implements Frame {

	@Override
	public String toString() {
		return "StrikeFrame 10  -> "+score;
	}
	
	private int score;
	private Frame previousFrame;
	StrikeFrame(){
		
	}
	@Override
	public void computeScore() {
		//System.out.println("computeScore StrikeFrame"+toString());
		int scoreFromPrevious = 0;
		if(previousFrame != null)
			scoreFromPrevious = previousFrame.getScore();		
		
		if(nextFrame instanceof SimpleFrame) {
			this.score = scoreFromPrevious+((SimpleFrame) nextFrame).getBallsCount() +10 ;
			//return;			
		}
		if(nextFrame instanceof SpareFrame) {
			this.score = scoreFromPrevious+((SpareFrame) nextFrame).getBallsCount() +10 ;
			//return;			
		}
		if(nextFrame instanceof StrikeFrame) {
			this.score = scoreFromPrevious + 10;
			if(nextFrame.getNextFrame() instanceof SpareFrame) {				
				this.score =this.score  + ((SpareFrame)nextFrame.getNextFrame()).getFirstBalls();
			}
			if(nextFrame.getNextFrame() instanceof StrikeFrame) {
				this.score =this.score  + 10;
			}
			if(nextFrame.getNextFrame() instanceof LastFrame) {
				this.score =this.score  + ((LastFrame)nextFrame.getNextFrame()).getFirstBalls();
			}
			this.score = this.score  + 10;
			//return;			
		}
		
		if(nextFrame instanceof LastFrame) {
			this.score = scoreFromPrevious + ((LastFrame)nextFrame).getFirstTwoBallsCount()+ 10;
			//return;
			
		}
		System.out.println("computeScore StrikeFrame "+toString());
	}
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
	 

}
