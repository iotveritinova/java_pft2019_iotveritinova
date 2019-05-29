package ru.io.pft.sandbox;

public class Point {
  public double x;
  public double y;

  //конструктор
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  //Метод для вычисления расстояния между заданными точками
  public double distanceMethod(Point p1) {
    return Math.sqrt(Math.pow((this.x - p1.x), 2) + Math.pow((this.y - p1.y), 2));
  }

}
