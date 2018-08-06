package de.slashgarbage.example;

public interface Frame {
	public void computeScore();

	public void setPreviousFrame(Frame previousFrame);

	public void setNextFrame(Frame newFrame);

	public int getScore();

	public Frame getNextFrame();
}