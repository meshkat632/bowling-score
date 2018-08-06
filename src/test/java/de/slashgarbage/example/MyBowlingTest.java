package de.slashgarbage.example;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class MyBowlingTest {

	@Test
	public void basic_tests() throws Exception {

		// assertEquals(MyBowling.play("X|X|X|X|X|X|X|X|X|XXX|"),300);
		assertEquals(MyBowling.play("00|00|00|00|00|00|00|00|00|00|"), 0);
		assertEquals(MyBowling.play("14|00|00|00|00|00|00|00|00|00|"), 5);
		assertEquals(MyBowling.play("14|14|00|00|00|00|00|00|00|00|"), 10);
		assertEquals(MyBowling.play("14|14|14|00|00|00|00|00|00|00|"), 15);
		assertEquals(MyBowling.play("14|14|14|14|00|00|00|00|00|00|"), 20);
		assertEquals(MyBowling.play("14|14|14|14|14|00|00|00|00|00|"), 25);
		assertEquals(MyBowling.play("14|14|14|14|14|14|00|00|00|00|"), 30);
		assertEquals(MyBowling.play("14|14|14|14|14|14|14|00|00|00|"), 35);
		assertEquals(MyBowling.play("14|14|14|14|14|14|14|14|00|00|"), 40);
		assertEquals(MyBowling.play("14|14|14|14|14|14|14|14|14|00|"), 45);
		assertEquals(MyBowling.play("14|14|14|14|14|14|14|14|14|14|"), 50);

	}

	@Test
	public void basic_tests_strike() throws Exception {

		assertEquals(MyBowling.play("X|X|X|X|X|X|X|X|X|XXX|"), 300);

	}

	@Test
	public void basic_tests_spare() throws Exception {

		assertEquals(12, MyBowling.play("00|7/|10|00|00|00|00|00|00|00|"));
		assertEquals(10, MyBowling.play("7/|00|00|00|00|00|00|00|00|00|"));
		assertEquals(30, MyBowling.play("7/|X|00|00|00|00|00|00|00|00|"));
		assertEquals(32, MyBowling.play("7/|X|01|00|00|00|00|00|00|00|"));
	}

	@Test
	public void basic_tests_spare_1() throws Exception {
		assertEquals(167, MyBowling.play("X|7/|90|X|08|8/|06|X|X|X81|"));
		assertEquals(133, MyBowling.play("14|45|6/|5/|X|01|7/|6/|X|2/6|"));

	}

	@Test
	public void acceptance_test() throws Exception {
		
		assertEquals(90, MyBowling.play("90|90|90|90|90|90|90|90|90|90|"));
		assertEquals(150, MyBowling.play("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/5|"));
		assertEquals(30, MyBowling.play("X|X|00|00|00|00|00|00|00|00|"));
		assertEquals(30, MyBowling.play("X|3/|00|00|00|00|00|00|00|00|"));
		
		
	}

}