package org.oracle.conject.assignment;

import java.util.ArrayList;
import java.util.List;

import org.oracle.conject.assignment.def.Frame;
import org.oracle.conject.assignment.exceptions.IllegalFrameDataException;
import org.oracle.conject.assignment.impl.FrameFactory;
import org.oracle.conject.assignment.impl.LastFrame;

public class BowlingGame {
	
	private List<Frame> frames;
	private int finalScore;
	
	private BowlingGame(List<Frame> frames, int finalScore){
		this.frames = frames;
		this.finalScore = finalScore;
	}
	

	public static BowlingGame play(String gameFrame) throws IllegalFrameDataException {
		// validate input
		String[] gameFrames = gameFrame.split("\\|");
		if(gameFrames.length < 10) throw new IllegalFrameDataException("There must be 10 frames.");
		
		// create Frame objects
		List<Frame> frames = new ArrayList<>();
		Frame lastFrame = null;
		for (int i = 0; i < gameFrames.length; i++) {
			Frame newFrame = FrameFactory.createFrame(gameFrames[i], i);
			if (lastFrame != null) {
				newFrame.setPreviousFrame(lastFrame);
				if (i < 10) {
					lastFrame.setNextFrame(newFrame);
				}
			}
			lastFrame = newFrame;
			frames.add(newFrame);
		}

		// compute the score
		int finalScore = frames.stream().filter(frame -> {
			frame.computeScore();
			if (frame instanceof LastFrame)
				return true;
			else
				return false;
		}).findFirst().get().getScore();
		
		return new BowlingGame(frames, finalScore);
		

	}


	public int finalScore() {		
		return finalScore;
	}
}