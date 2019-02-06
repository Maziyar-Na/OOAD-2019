/*-------------------------------------
 * CSCI5448 Homework 1 problem 4
 * Team member : Jaeyoung Oh, Sepideh Goodarzy, Maram Kurdi, Maziyar Nazari
 * Compile: javac hw14.java Shape.java Square.java Triangle.java Circle.java
 * Usage: java hw14
 * ShpaeList.txt : collection of shapes
 * 1/29/2019
 * Reference code: https://introcs.cs.princeton.edu/java/13flow/Circle.java.html 
 * -------------------------------------*/

class Circle extends Shape {
    private int radius;
    private int n = 5;
   // constructor
/*    Circle(int newradius) {
      //super(newx, newy);
      setRadius(newradius);
   } */

   // access radius
    int getRadius() { return radius; }
   // set radius
   void setRadius(int newradius) { radius = newradius; } 

   // draw the circle
   public void draw() {
      System.out.println("Drawing a Circle");
        for (int i = -n; i <= n; i++) {
            for (int j = -n; j <= n; j++) {
                if (i*i + j*j <= n*n) System.out.print("* ");
                else                  System.out.print("  ");
            }
            System.out.println();
        }
   }
}