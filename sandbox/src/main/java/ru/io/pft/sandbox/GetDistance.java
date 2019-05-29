package ru.io.pft.sandbox;

public class GetDistance {
  public static void main(String[] args) {
    Point p1 = new Point(4, 6);
    Point p2 = new Point(8, 9);
    //Расстояние между заданными точками, вычисленное при помощи функции в запускаемом классе
    System.out.println("Расстояние между заданными точками, вычисленное при помощи функции в запускаемом классе:");
    System.out.println(distance(p1, p2));
    //Расстояние между заданными точками, вычисленное при помощи метода в классе Point
    System.out.println("Расстояние между заданными точками, вычисленное при помощи метода в классе Point:");
    System.out.println(p2.distanceMethod(p1));
  }

  //Функция для вычисления расстояния между заданными точками
  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
  }
}