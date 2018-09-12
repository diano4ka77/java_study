package ru.stqa.pft.sandbox;

public class MySecondProgram {

  public static void main(String[] args) {
    Point p1 = new Point(6, 4);
    Point p2 = new Point(10, 9);
    System.out.println("Расстояние между точками = " + p1.distance(p2));
  }

}
