package org.oracle.assignment;


import org.junit.Test;
import org.oracle.assignment.Bowling;


import static org.junit.Assert.*;

public class BowlingTest {

	@Test
	public void spare_test_plays() throws Exception {
		assertEquals(10, Bowling.play("3/|00|00|00|00|00|00|00|00|00|"));
	}

	@Test
	public void strike_test_plays() throws Exception {
		assertEquals(10, Bowling.play("X|00|00|00|00|00|00|00|00|00|"));
	}

	@Test
	public void spare_test_with_a_hit_after() throws Exception{
		assertEquals(14, Bowling.play("3/|20|00|00|00|00|00|00|00|00|"));
	}

	@Test
	public void spare_test_with_two_hits_after() throws  Exception{
		assertEquals(19, Bowling.play("3/|25|00|00|00|00|00|00|00|00|"));
	}

	@Test
	public void strike_test_with_a_hit_after() throws Exception{
		assertEquals(14, Bowling.play("X|20|00|00|00|00|00|00|00|00|"));
	}

	@Test
	public void strike_test_with_two_hits_after() throws Exception{
		assertEquals(24, Bowling.play("X|25|00|00|00|00|00|00|00|00|"));
	}

	@Test
	public void strike_test_with_two_hits_and_hit_last_frame() throws Exception {
		assertEquals(25, Bowling.play("X|25|00|00|00|00|00|00|00|01|"));
	}

	@Test
	public void strike_test_with_spare_after() throws Exception{
		assertEquals(30, Bowling.play("X|3/|00|00|00|00|00|00|00|00|"));
	}
	
	@Test
	public void it_should_accept_double_strikes() throws Exception{
		assertEquals(30, Bowling.play("X|X|00|00|00|00|00|00|00|00|"));
	}
	
	@Test
	public void acceptance_test() throws Exception {
		assertEquals(300, Bowling.play("X|X|X|X|X|X|X|X|X|XXX|"));
		assertEquals(90, Bowling.play("90|90|90|90|90|90|90|90|90|90|"));
		assertEquals(150, Bowling.play("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/5|"));
		assertEquals(167, Bowling.play("X|7/|90|X|08|8/|06|X|X|X81|"));
	}
	
	@Test
	public void acceptance_simpleFrameTest() throws Exception {

		assertEquals(Bowling.play("00|00|00|00|00|00|00|00|00|00|"), 0);
		assertEquals(Bowling.play("14|00|00|00|00|00|00|00|00|00|"), 5);
		assertEquals(Bowling.play("14|14|00|00|00|00|00|00|00|00|"), 10);
		assertEquals(Bowling.play("14|14|14|00|00|00|00|00|00|00|"), 15);
		assertEquals(Bowling.play("14|14|14|14|00|00|00|00|00|00|"), 20);
		assertEquals(Bowling.play("14|14|14|14|14|00|00|00|00|00|"), 25);
		assertEquals(Bowling.play("14|14|14|14|14|14|00|00|00|00|"), 30);
		assertEquals(Bowling.play("14|14|14|14|14|14|14|00|00|00|"), 35);
		assertEquals(Bowling.play("14|14|14|14|14|14|14|14|00|00|"), 40);
		assertEquals(Bowling.play("14|14|14|14|14|14|14|14|14|00|"), 45);
		assertEquals(Bowling.play("14|14|14|14|14|14|14|14|14|14|"), 50);

	}

	@Test
	public void acceptance_test_allStrike() throws Exception {

		assertEquals(Bowling.play("X|X|X|X|X|X|X|X|X|XXX|"), 300);

	}

	@Test
	public void acceptance_test_spare_followedby_normal() throws Exception {

		assertEquals(12, Bowling.play("00|7/|10|00|00|00|00|00|00|00|"));
		assertEquals(10, Bowling.play("7/|00|00|00|00|00|00|00|00|00|"));
		assertEquals(30, Bowling.play("7/|X|00|00|00|00|00|00|00|00|"));
		assertEquals(32, Bowling.play("7/|X|01|00|00|00|00|00|00|00|"));
	}

	@Test
	public void acceptance_test_misc() throws Exception {
		assertEquals(167, Bowling.play("X|7/|90|X|08|8/|06|X|X|X81|"));
		assertEquals(133, Bowling.play("14|45|6/|5/|X|01|7/|6/|X|2/6|"));

	}

	@Test
	public void acceptance_test_misc_common() throws Exception {

		assertEquals(90, Bowling.play("90|90|90|90|90|90|90|90|90|90|"));
		assertEquals(150, Bowling.play("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/5|"));
		assertEquals(30, Bowling.play("X|X|00|00|00|00|00|00|00|00|"));
		assertEquals(30, Bowling.play("X|3/|00|00|00|00|00|00|00|00|"));

	}


}