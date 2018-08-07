package org.oracle.conject.assignment.impl;

import org.oracle.conject.assignment.Constants;

public class StrikeFrame extends AbstractFrame {	
	
	@Override
	public void computeScore() {
	
		int scoreFromPrevious = 0;
		if(previousFrame != null)
			scoreFromPrevious = previousFrame.getScore();		
		
		if(nextFrame instanceof SimpleFrame) {
			this.score = scoreFromPrevious+((SimpleFrame) nextFrame).getBallsCount() +Constants.MAX_PIN ;
				
		}
		if(nextFrame instanceof SpareFrame) {
			this.score = scoreFromPrevious+((SpareFrame) nextFrame).getBallsCount() +Constants.MAX_PIN ;
				
		}
		if(nextFrame instanceof StrikeFrame) {
			this.score = scoreFromPrevious + Constants.MAX_PIN;
			if(nextFrame.getNextFrame() instanceof SpareFrame) {				
				this.score =this.score  + ((SpareFrame)nextFrame.getNextFrame()).getFirstBalls();
			}
			if(nextFrame.getNextFrame() instanceof StrikeFrame) {
				this.score =this.score  + Constants.MAX_PIN;
			}
			if(nextFrame.getNextFrame() instanceof LastFrame) {
				this.score =this.score  + ((LastFrame)nextFrame.getNextFrame()).getFirstBalls();
			}
			this.score = this.score  + Constants.MAX_PIN;
				
		}
		
		if(nextFrame instanceof LastFrame) {
			this.score = scoreFromPrevious + ((LastFrame)nextFrame).getFirstTwoBallsCount()+ Constants.MAX_PIN;			
		}
	
	}
	

	 

}
