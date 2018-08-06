package org.oracle.assignment;

import java.util.ArrayList;
import java.util.List;

import org.oracle.assignment.def.Frame;
import org.oracle.assignment.exceptions.IllegalFrameDataException;
import org.oracle.assignment.impl.FrameFactory;
import org.oracle.assignment.impl.LastFrame;

public class Bowling {

	public static int play(String gameFrame) throws IllegalFrameDataException {
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
		return frames.stream().filter(frame -> {
			frame.computeScore();
			if (frame instanceof LastFrame)
				return true;
			else
				return false;
		}).findFirst().get().getScore();
		

	}
}