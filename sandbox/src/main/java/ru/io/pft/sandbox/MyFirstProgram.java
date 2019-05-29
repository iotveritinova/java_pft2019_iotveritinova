package ru.io.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("world");

    Square s = new Square(9);
    System.out.println("Площадь квадрата со стороной " + s.lenth + " = " + s.area());

    Rectangle r = new Rectangle(9, 3);
    System.out.println("Площадь прямоугольника со стороной " + r.a + " и " + r.b + " = " +
            r.area()
    );
  }
  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }


}

