package org.oracle.assignment.impl;

import org.oracle.assignment.def.Frame;

public abstract class AbstractFrame implements Frame {
	protected int score;
	protected Frame previousFrame;
	protected Frame nextFrame;

	@Override
	public void setPreviousFrame(Frame previousFrame) {
		this.previousFrame = previousFrame;

	}

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
