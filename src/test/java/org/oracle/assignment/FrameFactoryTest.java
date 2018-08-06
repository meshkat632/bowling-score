package org.oracle.assignment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.oracle.assignment.def.Frame;
import org.oracle.assignment.exceptions.IllegalFrameDataException;
import org.oracle.assignment.impl.FrameFactory;
import org.oracle.assignment.impl.LastFrame;
import org.oracle.assignment.impl.SimpleFrame;
import org.oracle.assignment.impl.SpareFrame;
import org.oracle.assignment.impl.StrikeFrame;
public class FrameFactoryTest {
	@Test
	public void createFrame_simpleFrame() throws IllegalFrameDataException {
		Frame frame = FrameFactory.createFrame("34");
		assertEquals(SimpleFrame.class, frame.getClass());

	}
	@Test
	public void createFrame_simpleFrame_zero() throws IllegalFrameDataException {
		Frame frame = FrameFactory.createFrame("00");
		assertEquals(SimpleFrame.class, frame.getClass());
	}

	@Test(expected = IllegalFrameDataException.class)
	public void createFrame_max_pin_10() throws IllegalFrameDataException {
		FrameFactory.createFrame("69");
	}

	@Test(expected = IllegalFrameDataException.class)
	public void createFrame_invalid_char() throws IllegalFrameDataException {
		FrameFactory.createFrame("Cd");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createFrame_invalid_spare() throws IllegalFrameDataException {
		FrameFactory.createFrame("/5");
	}
	@Test
	public void createFrame_spareframe() throws IllegalFrameDataException {
		Frame frame = FrameFactory.createFrame("5/");
		assertEquals(SpareFrame.class, frame.getClass());		
	}
	
	@Test
	public void createFrame_strikeFrame() throws IllegalFrameDataException {
		Frame frame = FrameFactory.createFrame("X");
		assertEquals(StrikeFrame.class, frame.getClass());		
	}
	@Test(expected = IllegalFrameDataException.class)
	public void createFrame_StrikeFrame_invalid() throws IllegalFrameDataException {
		FrameFactory.createFrame("x");				
	}
	
	@Test
	public void createFrame_LastFrame_tripeStrike() throws IllegalFrameDataException {
		Frame frame = FrameFactory.createFrame("XXX");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test
	public void createFrame_LastFrame_doubleStrike() throws IllegalFrameDataException {
		Frame frame = FrameFactory.createFrame("XX0");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	
	@Test
	public void createFrame_LastFrame_strike_with_normal() throws IllegalFrameDataException {
		Frame frame = FrameFactory.createFrame("X55");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	
	@Test
	public void createFrame_LastFrame_doubleStrike_normal() throws IllegalFrameDataException {
		Frame frame = FrameFactory.createFrame("XX5");
		assertEquals(LastFrame.class, frame.getClass());		
	}	
	
	@Test
	public void createFrame_LastFrame_strike_with_spare() throws IllegalFrameDataException {
		Frame frame = FrameFactory.createFrame("X0/");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test
	public void createFrame_LastFrame_strike_followed_by_strike() throws IllegalFrameDataException {
		Frame frame = FrameFactory.createFrame("X0X");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test
	public void createFrame_LastFrame_strike_followedby_spare() throws IllegalFrameDataException {
		Frame frame = FrameFactory.createFrame("X9/");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test(expected = IllegalArgumentException.class)
	public void createFrame_StrikeFrame_tripeStrike_max_pin_10() throws IllegalFrameDataException {
		FrameFactory.createFrame("X56");				
	}
	@Test
	public void createFrame_lastFrame_normal_followedby_spare_normal() throws IllegalFrameDataException {
		Frame frame = FrameFactory.createFrame("2/6");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test
	public void createFrame_LastFrame_normal_followedby_spare_strike() throws IllegalFrameDataException {
		Frame frame = FrameFactory.createFrame("2/X");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	
	
}
