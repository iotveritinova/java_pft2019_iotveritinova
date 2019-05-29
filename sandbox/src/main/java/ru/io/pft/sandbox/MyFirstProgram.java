package ru.io.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("brave new world");
    hello("sick sad world");

    Square s = new Square(5);
    //s.lenth = 3;
    double plow = area(s);
    System.out.println("Площадь квадрата со стороной " + s.lenth + " = " + plow);

    Rectangle r = new Rectangle(9,3);
    //r.a = 7;
    //r.b = 6;

    System.out.println("Площадь прямоугольника со стороной " + r.a + " и " + r.b + " = " +
            area(r)
    );
  }


  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }


  public static double area(Square s) {
    return s.lenth * s.lenth;
  }


  public static double area(Rectangle r) {
    return r.a * r.b;
  }
}

