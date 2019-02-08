/*-------------------------------------
 * CSCI5448 Homework 1 problem 4
 * Team member : Sepideh Goodarzy, Maram Kurdi, Maziyar Nazari, Dwight Browne
 * Compile: javac hw14.java Shape.java Square.java Triangle.java Circle.java
 * Usage: java hw14
 * ShpaeList.txt : collection of shapes
 * 1/29/2019
 * -------------------------------------*/

public abstract class Shape {
   private int x;
   private int y;

   // constructor
/* Shape() {
      //System.out.println("Drawing");
   } */

   // access for x & y
   int getX() { return x; }
   int getY() { return y; }

   // set for x & y
   void setX(int newx) { x = newx; }
   void setY(int newy) { y = newy; } 

   // virtual draw method
   public abstract void draw();
}
