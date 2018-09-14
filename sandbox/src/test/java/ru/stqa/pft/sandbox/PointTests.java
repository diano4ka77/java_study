package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class PointTests {

  public void testDistanceSuccessful() {
    Point p1 = new Point(6, 4);
    Point p2 = new Point(10, 9);
    Assert.assertEquals(p1.distance(p2), 6.4031242374328485);
  }

  public void testDistanceZero() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 0);
    Assert.assertEquals(p1.distance(p2), 0.0);
  }

  public void testDistanceNegativeNumber() {
    Point p1 = new Point(-6, 4);
    Point p2 = new Point(10, -9);
    Assert.assertEquals(p1.distance(p2), 20.615528128088304);
  }

}

