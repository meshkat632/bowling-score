package de.slashgarbage.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//String gameFrame = "X|7/|90|X|08|8/|06|X|X|X81|";
		//String gameFrame = "X|X|X|X|X|X|X|X|X|XXX|";
		//String gameFrame = "14|00|00|00|00|00|00|00|00|00|";
		//String gameFrame = "00|7/|10|00|00|00|00|00|00|00|";
		//String gameFrame = "X|7/|90|X|08|8/|06|X|X|X81|";
		//String gameFrame = "14|45|6/|5/|X|01|7/|6/|X|2/6|";
		String gameFrame = "7/|X|01|00|00|00|00|00|00|00|";
		
		
		String[] splitGameFrame = gameFrame.split("\\|");		

		List<Frame> frames = new ArrayList<>();
		Frame  lastFrame = null;
		for(int i = 0; i< splitGameFrame.length; i++) {
			Frame newFrame = FrameFactory.createFrame(splitGameFrame[i], i);
			if(lastFrame != null) { 
				newFrame.setPreviousFrame(lastFrame);
				if(i < 10 ) {
					lastFrame.setNextFrame(newFrame);
				}
			}
			lastFrame = newFrame;
			frames.add(newFrame);
		}		
		
		
		int finalScore = frames.stream().filter(frame -> {
			frame.computeScore();
			if(frame instanceof LastFrame)
				return true;
			else 
				return false;
		}).findFirst().get().getScore();
		
		System.out.println(finalScore);

	}

}
