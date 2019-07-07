package ru.io.pft.sandbox;

public class Equality {

  public static void main(String[] args) {
    String a1 = "firefox 2.0";
    String a2 = "firefox "+Math.sqrt(4.0);
    System.out.println(a1==a2);
    System.out.println(a1.equals(a2));
  }
}
