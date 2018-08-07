package org.oracle.conject.assignment.impl;

import org.oracle.conject.assignment.Constants;
import org.oracle.conject.assignment.def.Frame;
import org.oracle.conject.assignment.exceptions.IllegalFrameDataException;

public class FrameFactory {

	private static final int MAX_PIN = Constants.MAX_PIN;

	public static Frame createFrame(String grameFrame, int index) throws IllegalFrameDataException {
		if (grameFrame.length() == 1) {
			if (grameFrame.charAt(0) == 'X') {
				return new StrikeFrame();
			}
			throw new IllegalFrameDataException("'X' is only valid symbol for STRIKE.");
		}
		if (grameFrame.matches("[0-9]{2}")) {

			int firstBalls = Integer.parseInt("" + grameFrame.charAt(0));
			int secondBalls = Integer.parseInt("" + grameFrame.charAt(1));
			if (firstBalls + secondBalls > MAX_PIN) {
				throw new IllegalFrameDataException("maximum number of pin is " + MAX_PIN + ".");
			}
			if (index == 9)
				return new LastFrame(firstBalls, secondBalls, 0);
			return new SimpleFrame(firstBalls, secondBalls);
		}
		if (grameFrame.matches("[0-9]{1}/")) {
			int firstBalls = Integer.parseInt("" + grameFrame.charAt(0));
			return new SpareFrame(firstBalls);
		}
		if (grameFrame.matches("[0-9]{1}XX")) {
			int firstBalls = Integer.parseInt("" + grameFrame.charAt(0));
			return new LastFrame(firstBalls, MAX_PIN, MAX_PIN);
		}
		if (grameFrame.matches("X[0-9]{2}")) {
			int secondBalls = Integer.parseInt("" + grameFrame.charAt(1));
			int thirdBalls = Integer.parseInt("" + grameFrame.charAt(2));
			if (secondBalls + thirdBalls > MAX_PIN) {
				throw new IllegalFrameDataException("maximum number of pin is " + MAX_PIN + ".");
			}
			return new LastFrame(MAX_PIN, secondBalls, thirdBalls);
		}
		if (grameFrame.matches("XX[0-9]{1}")) {
			int thirdBalls = Integer.parseInt("" + grameFrame.charAt(2));
			return new LastFrame(MAX_PIN, MAX_PIN, thirdBalls);
		}
		if (grameFrame.matches("X[0-9]{1}/")) {
			int secondBalls = Integer.parseInt("" + grameFrame.charAt(1));
			return new LastFrame(MAX_PIN, secondBalls, MAX_PIN - secondBalls);
		}
		if (grameFrame.matches("XXX")) {
			return new LastFrame(MAX_PIN, MAX_PIN, MAX_PIN);
		}
		if (grameFrame.matches("X[0-9]{1}/")) {
			int secondBalls = Integer.parseInt("" + grameFrame.charAt(1));
			return new LastFrame(MAX_PIN, secondBalls, MAX_PIN - secondBalls);
		}
		if (grameFrame.matches("X0X")) {
			int secondBalls = Integer.parseInt("" + grameFrame.charAt(1));
			return new LastFrame(MAX_PIN, secondBalls, MAX_PIN - secondBalls);
		}
		if (grameFrame.matches("[0-9]{1}/[0-9]{1}")) {
			int firstBalls = Integer.parseInt("" + grameFrame.charAt(0));
			int thirdBalls = Integer.parseInt("" + grameFrame.charAt(2));
			return new LastFrame(firstBalls, MAX_PIN - firstBalls, thirdBalls);
		}
		if (grameFrame.matches("[0-9]{1}/X")) {
			int firstBalls = Integer.parseInt("" + grameFrame.charAt(0));
			return new LastFrame(firstBalls, MAX_PIN - firstBalls, MAX_PIN);
		}
		throw new IllegalFrameDataException("invalid chars");
	}

	public static Frame createFrame(String grameFrame) throws IllegalFrameDataException {
		return createFrame(grameFrame, -1);
	}

}
