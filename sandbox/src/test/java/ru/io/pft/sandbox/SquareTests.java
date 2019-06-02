package ru.io.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {
  @Test
  public void testArea() {
    Square s=new Square(5);
    Assert.assertEquals( s.area(),25.0);
  }
  @Test
  public void testAreaDouble(){
    Square s=new Square(3.5);
    Assert.assertEquals(s.area(),12.25);
  }
}
