package de.slashgarbage.example;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

public class FrameFactoryTest {
	@Test
	public void createFrame() throws Exception {

		Frame frame = FrameFactory.createFrame("34");
		assertEquals(SimpleFrame.class, frame.getClass());

	}
	@Test
	public void createFrame_valid() throws Exception {
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
	
	@Test
	public void createFrame_spareframe() throws Exception {
		Frame frame = FrameFactory.createFrame("5/");
		assertEquals(SpareFrame.class, frame.getClass());		
	}
	
	@Test
	public void createFrame_StrikeFrame() throws Exception {
		Frame frame = FrameFactory.createFrame("X");
		assertEquals(StrikeFrame.class, frame.getClass());		
	}
	@Test(expected = IllegalArgumentException.class)
	public void createFrame_StrikeFrame_invalid() throws Exception {
		FrameFactory.createFrame("x");				
	}
	
	@Test
	public void createFrame_StrikeFrame_tripeStrike() throws Exception {
		Frame frame = FrameFactory.createFrame("XXX");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test
	public void createFrame_StrikeFrame_tripeStrike_2() throws Exception {
		Frame frame = FrameFactory.createFrame("XX0");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	
	@Test
	public void createFrame_StrikeFrame_tripeStrike_3() throws Exception {
		Frame frame = FrameFactory.createFrame("X55");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	
	@Test
	public void createFrame_StrikeFrame_tripeStrike_33() throws Exception {
		Frame frame = FrameFactory.createFrame("XX5");
		assertEquals(LastFrame.class, frame.getClass());		
	}	
	
	@Test
	public void createFrame_StrikeFrame_tripeStrike_4() throws Exception {
		Frame frame = FrameFactory.createFrame("X0/");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test
	public void createFrame_StrikeFrame_tripeStrike_44() throws Exception {
		Frame frame = FrameFactory.createFrame("X0X");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test
	public void createFrame_StrikeFrame_tripeStrike_5() throws Exception {
		Frame frame = FrameFactory.createFrame("X9/");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test(expected = IllegalArgumentException.class)
	public void createFrame_StrikeFrame_tripeStrike_6() throws Exception {
		FrameFactory.createFrame("X56");				
	}
	@Test
	public void createFrame_StrikeFrame_tripeStrike_7() throws Exception {
		Frame frame = FrameFactory.createFrame("2/6");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	@Test
	public void createFrame_StrikeFrame_tripeStrike_8() throws Exception {
		Frame frame = FrameFactory.createFrame("2/X");
		assertEquals(LastFrame.class, frame.getClass());		
	}
	
	
}
