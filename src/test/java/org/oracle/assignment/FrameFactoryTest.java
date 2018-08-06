package org.oracle.assignment;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;
import org.oracle.assignment.Frame;
import org.oracle.assignment.FrameFactory;
import org.oracle.assignment.LastFrame;
import org.oracle.assignment.SimpleFrame;
import org.oracle.assignment.SpareFrame;
import org.oracle.assignment.StrikeFrame;

public class FrameFactoryTest {
	@Test
	public void createFrame_simpleFrame() throws Exception {
		Frame frame = FrameFactory.createFrame("34");
		assertEquals(SimpleFrame.class, frame.getClass());

	}
	@Test
	public void createFrame_simpleFrame_zero() throws Exception {
		Frame frame = FrameFactory.createFrame("00");
		assertEquals(SimpleFrame.class, frame.getClass());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createFrame_max_pin_10() throws Exception {
		FrameFactory.createFrame("69");
	}

	@Test(expected = IllegalArgumentException.class)
	public void createFrame_invalid_char() throws Exception {
		FrameFactory.createFrame("Cd");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createFrame_invalid_spare() throws Exception {
		FrameFactory.createFrame("/5");
	}
	@Test
	public void createFrame_spareframe() throws Exception {
		Frame frame = FrameFactory.createFrame("5/");
		assertEquals(SpareFrame.class, frame.getClass());		
	}
	
	@Test
	public void createFrame_strikeFrame() throws Exception {
		Frame frame = FrameFactory.createFrame("X");
		assertEquals(StrikeFrame.class, frame.getClass());		
	}
	@Test(expected = IllegalArgumentException.class)
	public void createFrame_StrikeFrame_invalid() throws Exception {
		FrameFactory.createFrame("x");				
	}
	
	@Test
	public void createFrame_LastFrame_tripeStrike() throws Exception {
		Frame frame = FrameFactory.createFrame("XXX");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test
	public void createFrame_LastFrame_doubleStrike() throws Exception {
		Frame frame = FrameFactory.createFrame("XX0");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	
	@Test
	public void createFrame_LastFrame_strike_with_normal() throws Exception {
		Frame frame = FrameFactory.createFrame("X55");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	
	@Test
	public void createFrame_LastFrame_doubleStrike_normal() throws Exception {
		Frame frame = FrameFactory.createFrame("XX5");
		assertEquals(LastFrame.class, frame.getClass());		
	}	
	
	@Test
	public void createFrame_LastFrame_strike_with_spare() throws Exception {
		Frame frame = FrameFactory.createFrame("X0/");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test
	public void createFrame_LastFrame_strike_followed_by_strike() throws Exception {
		Frame frame = FrameFactory.createFrame("X0X");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test
	public void createFrame_LastFrame_strike_followedby_spare() throws Exception {
		Frame frame = FrameFactory.createFrame("X9/");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test(expected = IllegalArgumentException.class)
	public void createFrame_StrikeFrame_tripeStrike_max_pin_10() throws Exception {
		FrameFactory.createFrame("X56");				
	}
	@Test
	public void createFrame_lastFrame_normal_followedby_spare_normal() throws Exception {
		Frame frame = FrameFactory.createFrame("2/6");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test
	public void createFrame_LastFrame_normal_followedby_spare_strike() throws Exception {
		Frame frame = FrameFactory.createFrame("2/X");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	
	
}
