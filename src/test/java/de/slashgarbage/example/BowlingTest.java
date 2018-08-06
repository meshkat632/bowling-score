package de.slashgarbage.example;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class BowlingTest {

   @Test
   public void
   myTest() {

      String gameFrame = "14|00|00|00|00|00|00|00|00|00|";
      String[] splitGameFrame = gameFrame.split("\\|");
      Stream<String> gameFrameStream = Arrays.stream(splitGameFrame );
      gameFrameStream.forEach(frame ->{
         System.out.println("frame:" + frame);
      });
      /*
      IntStream intStream = testString.chars();
      Stream<Character> characterStream = testString.chars().mapToObj(c -> (char) c);
      characterStream.forEach(c ->{
         System.out.println(c);
      });
      */


      //assertEquals(MyBowling.play("14|45|6/|5/|X|01|00|00|00|00||"),61);
      /*
      assertEquals(Bowling.play("14|--|--|--|--|--|--|--|--|--||"),5);
      assertEquals(Bowling.play("14|45|--|--|--|--|--|--|--|--||"),14);
      assertEquals(Bowling.play("14|45|6/|01|--|--|--|--|--|--||"),25);
      assertEquals(Bowling.play("14|45|6/|5/|01|--|--|--|--|--||"),40);
      assertEquals(Bowling.play("14|45|6/|5/|X|01|--|--|--|--||"),61);
      */
      //assertEquals(Bowling.play("14|45|6/|5/|X|01|7/|6/|X|2/6||"),133);

   }
/*
   @Test 
   public void 
   a_looser_plays() {
      assertEquals(Bowling.play("--|--|--|--|--|--|--|--|--|--||"), 0);
      assertEquals(Bowling.play("3-|--|--|--|--|--|--|--|--|--||"), 3);
      assertEquals(Bowling.play("3-|5-|--|--|--|--|--|--|--|--||"), 8);
      assertEquals(Bowling.play("3/|--|--|--|--|--|--|--|--|--||"),10);

      assertEquals(Bowling.play("14|--|--|--|--|--|--|--|--|--||"),5);
      assertEquals(Bowling.play("14|45|--|--|--|--|--|--|--|--||"),14);

   } 


   @Test 
   public void 
   a_semi_looser_plays() {

   } 


 
   @Test 
   public void 
   spare_test_plays() {
      assertEquals(Bowling.play("3/|--|--|--|--|--|--|--|--|--||"),10);
   } 
 
   @Test 
   public void 
   strike_test_plays() {
      assertEquals(Bowling.play("X|--|--|--|--|--|--|--|--|--||"),10);
   } 
 
   @Test 
   public void 
   spare_test_with_a_hit_after() {
      assertEquals(Bowling.play("3/|2-|--|--|--|--|--|--|--|--||"),14);
   } 
 
   @Test 
   public void 
   spare_test_with_two_hits_after() {
      assertEquals(Bowling.play("3/|25|--|--|--|--|--|--|--|--||"),19);
   } 
 
   @Test 
   public void 
   strike_test_with_a_hit_after() {
      assertEquals(Bowling.play("X|2-|--|--|--|--|--|--|--|--||"),14);
   } 
 
   @Test 
   public void 
   strike_test_with_two_hits_after() {
      assertEquals(Bowling.play("X|25|--|--|--|--|--|--|--|--||"),24);
   } 
 
   @Test 
   public void 
   strike_test_with_two_hits_and_hit_last_frame() {
      assertEquals(Bowling.play("X|25|--|--|--|--|--|--|--|-1||"),25);
   } 
 
   @Test 
   public void 
   strike_test_with_spare_after() {
      assertEquals(Bowling.play("X|3/|--|--|--|--|--|--|--|--||"),30);
   }

   @Ignore
   @Test 
   public void 
   it_should_accept_double_strikes() {
      assertEquals(Bowling.play("X|X|--|--|--|--|--|--|--|--||"),30);
   } 

   @Ignore
   @Test
   public void 
   acceptance_test() {
      assertEquals(Bowling.play("X|X|X|X|X|X|X|X|X|X||XX"),300);
      assertEquals(Bowling.play("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||"),90);
      assertEquals(Bowling.play("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5"),150);
      assertEquals(Bowling.play("X|7/|9-|X|-8|8/|-6|X|X|X||81"),167);
   }
*/
}