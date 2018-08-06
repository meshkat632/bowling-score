package de.slashgarbage.example;

import java.util.ArrayList;
import java.util.List;

public class MyBowling {

	public static int play(String gameFrame) throws Exception {

		// String gameFrame = "X|X|X|X|X|X|X|X|X|XXX|";
		String[] splitGameFrame = gameFrame.split("\\|");

		List<Frame> frames = new ArrayList<>();
		Frame lastFrame = null;
		for (int i = 0; i < splitGameFrame.length; i++) {
			Frame newFrame = FrameFactory.createFrame(splitGameFrame[i], i);
			if (lastFrame != null) {
				newFrame.setPreviousFrame(lastFrame);
				if (i < 10) {
					lastFrame.setNextFrame(newFrame);
				}
			}
			lastFrame = newFrame;
			frames.add(newFrame);
		}

		return frames.stream().filter(frame -> {
			frame.computeScore();
			if (frame instanceof LastFrame)
				return true;
			else
				return false;
		}).findFirst().get().getScore();

	}
}