package ru.io.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance() {
    Point p1 = new Point(4, 6);
    Point p2 = new Point(8, 9);
    Assert.assertEquals(p2.distanceMethod(p1), 5.0);
  }

  @Test
  public void testDistanceSame() {
    Point p1 = new Point(4, 11);
    Point p2 = new Point(4, 11);
    Assert.assertEquals(p2.distanceMethod(p1), 0.0);
  }

  @Test
  public void testDistanceNegative() {
    Point p1 = new Point(-2, 1);
    Point p2 = new Point(6, -5);
    Assert.assertEquals(p2.distanceMethod(p1), 10.0);
  }
}
