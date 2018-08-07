package org.oracle.conject.assignment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.oracle.conject.assignment.BowlingGame;
import org.oracle.conject.assignment.exceptions.IllegalFrameDataException;

public class BowlingTest {

	@Test
	public void spare_print_scores() throws IllegalFrameDataException {
		
		BowlingGame game = BowlingGame.play("14|45|6/|5/|X|01|7/|6/|X|2/6|"); 
		assertEquals(133, game.finalScore());
		assertEquals("5|14|29|49|60|61|77|97|117|133|",game.scores());
		
	}
	
	@Test
	public void spare_test_plays() throws IllegalFrameDataException {
		BowlingGame game = BowlingGame.play("3/|00|00|00|00|00|00|00|00|00|"); 
		assertEquals(10, game.finalScore());
		assertEquals("10|10|10|10|10|10|10|10|10|10|",game.scores());
	}

	@Test
	public void strike_test_plays() throws IllegalFrameDataException {
		assertEquals(10, BowlingGame.play("X|00|00|00|00|00|00|00|00|00|").finalScore());
	}

	@Test
	public void spare_test_with_a_hit_after() throws IllegalFrameDataException {
		assertEquals(14, BowlingGame.play("3/|20|00|00|00|00|00|00|00|00|").finalScore());
	}

	@Test
	public void spare_test_with_two_hits_after() throws IllegalFrameDataException {
		assertEquals(19, BowlingGame.play("3/|25|00|00|00|00|00|00|00|00|").finalScore());
	}

	@Test
	public void strike_test_with_a_hit_after() throws IllegalFrameDataException {
		assertEquals(14, BowlingGame.play("X|20|00|00|00|00|00|00|00|00|").finalScore());
	}

	@Test
	public void strike_test_with_two_hits_after() throws IllegalFrameDataException {
		assertEquals(24, BowlingGame.play("X|25|00|00|00|00|00|00|00|00|").finalScore());
	}

	@Test
	public void strike_test_with_two_hits_and_hit_last_frame() throws IllegalFrameDataException {
		assertEquals(25, BowlingGame.play("X|25|00|00|00|00|00|00|00|01|").finalScore());
	}

	@Test
	public void strike_test_with_spare_after() throws IllegalFrameDataException {
		assertEquals(30, BowlingGame.play("X|3/|00|00|00|00|00|00|00|00|").finalScore());
	}

	@Test
	public void it_should_accept_double_strikes() throws IllegalFrameDataException {
		assertEquals(30, BowlingGame.play("X|X|00|00|00|00|00|00|00|00|").finalScore());
	}

	@Test
	public void acceptance_test() throws IllegalFrameDataException {
		assertEquals(300, BowlingGame.play("X|X|X|X|X|X|X|X|X|XXX|").finalScore());
		assertEquals(90, BowlingGame.play("90|90|90|90|90|90|90|90|90|90|").finalScore());
		assertEquals(150, BowlingGame.play("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/5|").finalScore());
		assertEquals(167, BowlingGame.play("X|7/|90|X|08|8/|06|X|X|X81|").finalScore());
	}

	@Test
	public void acceptance_simpleFrameTest() throws IllegalFrameDataException {

		assertEquals(0, BowlingGame.play("00|00|00|00|00|00|00|00|00|00|").finalScore());
		assertEquals(5, BowlingGame.play("14|00|00|00|00|00|00|00|00|00|").finalScore());
		assertEquals(10, BowlingGame.play("14|14|00|00|00|00|00|00|00|00|").finalScore());
		assertEquals(15, BowlingGame.play("14|14|14|00|00|00|00|00|00|00|").finalScore());
		assertEquals(20, BowlingGame.play("14|14|14|14|00|00|00|00|00|00|").finalScore());
		assertEquals(25, BowlingGame.play("14|14|14|14|14|00|00|00|00|00|").finalScore());
		assertEquals(30, BowlingGame.play("14|14|14|14|14|14|00|00|00|00|").finalScore());
		assertEquals(35, BowlingGame.play("14|14|14|14|14|14|14|00|00|00|").finalScore());
		assertEquals(40, BowlingGame.play("14|14|14|14|14|14|14|14|00|00|").finalScore());
		assertEquals(45, BowlingGame.play("14|14|14|14|14|14|14|14|14|00|").finalScore());
		assertEquals(50, BowlingGame.play("14|14|14|14|14|14|14|14|14|14|").finalScore());

	}

	@Test
	public void acceptance_test_allStrike() throws IllegalFrameDataException {

		assertEquals(300, BowlingGame.play("X|X|X|X|X|X|X|X|X|XXX|").finalScore());

	}

	@Test
	public void acceptance_test_spare_followedby_normal() throws IllegalFrameDataException {

		assertEquals(12, BowlingGame.play("00|7/|10|00|00|00|00|00|00|00|").finalScore());
		assertEquals(10, BowlingGame.play("7/|00|00|00|00|00|00|00|00|00|").finalScore());
		assertEquals(30, BowlingGame.play("7/|X|00|00|00|00|00|00|00|00|").finalScore());
		assertEquals(32, BowlingGame.play("7/|X|01|00|00|00|00|00|00|00|").finalScore());
	}

	@Test
	public void acceptance_test_misc() throws IllegalFrameDataException {
		assertEquals(167, BowlingGame.play("X|7/|90|X|08|8/|06|X|X|X81|").finalScore());
		assertEquals(133, BowlingGame.play("14|45|6/|5/|X|01|7/|6/|X|2/6|").finalScore());
		assertEquals("5|14|29|49|60|61|77|97|117|133|",BowlingGame.play("14|45|6/|5/|X|01|7/|6/|X|2/6|").scores());

	}

	@Test
	public void acceptance_test_misc_common() throws IllegalFrameDataException {

		assertEquals(90, BowlingGame.play("90|90|90|90|90|90|90|90|90|90|").finalScore());
		assertEquals(150, BowlingGame.play("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/5|").finalScore());
		assertEquals(30, BowlingGame.play("X|X|00|00|00|00|00|00|00|00|").finalScore());
		assertEquals(30, BowlingGame.play("X|3/|00|00|00|00|00|00|00|00|").finalScore());

	}

}