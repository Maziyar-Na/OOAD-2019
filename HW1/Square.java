/*-------------------------------------
 * CSCI5448 Homework 1 problem 4
 * Team member : Jaeyoung Oh, Sepideh Goodarzy, Maram Kurdi, Maziyar Nazari
 * Compile: javac hw14.java Shape.java Square.java Triangle.java Circle.java
 * Usage: java hw14
 * ShpaeList.txt : collection of shapes
 * 1/29/2019
 * -------------------------------------*/

class Square extends Shape {
   private int width;
   private int height;

   // constructor
/*    Square(int newwidth) {
      //super(newx, newy);
      setWidth(newwidth);
      //setHeight(newheight);
   } */

   // access width
   int getWidth() { return width; }
   int getHeight() { return height; }
   // set width
   void setWidth(int newwidth) { width = newwidth; } 
   void setHeight(int newheight) { height = newheight; }

   // draw the Square
   public void draw() {
        //int nw = getWidth();
         System.out.println("Drawing a Square");
         System.out.println(" _______________");
         System.out.println("|               |");
         System.out.println("|               |");
         System.out.println("|               |");
         System.out.println("|               |");
         System.out.println("|_______________|");
   }
}