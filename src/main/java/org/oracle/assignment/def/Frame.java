package org.oracle.assignment.def;

public interface Frame {
	public void computeScore();

	public void setPreviousFrame(Frame previousFrame);

	public void setNextFrame(Frame newFrame);

	public int getScore();

	public Frame getNextFrame();
}