/*-------------------------------------
 * CSCI5448 Homework 1 problem 4
 * Team member : Sepideh Goodarzy, Maram Kurdi, Maziyar Nazari, Dwight Browne
 * Compile: javac hw14.java Shape.java Square.java Triangle.java Circle.java
 * Usage: java hw14
 * ShpaeList.txt : collection of shapes
 * 1/29/2019
 * -------------------------------------*/

class Triangle extends Shape {
   private int width;
   private int height;

   // constructor
/*    Triangle(int newwidth, int newheight) {
      //super(newx, newy);
      setWidth(newwidth);
      setHeight(newheight);
   } */
   
   // access width, height
   int getWidth() { return width; }
   int getHeight() { return height; }
   // set width, height
   void setWidth(int newwidth) { width = newwidth; }
   void setHeight(int newheight) { height = newheight; }

   // draw the Triangle
   public void draw() {
        System.out.println("Drawing a Triangle");
        System.out.println("      ^      ");
        System.out.println("     / \\     ");
        System.out.println("    /   \\    ");
        System.out.println("   /     \\   ");
        System.out.println("  /       \\  ");
        System.out.println(" /         \\ ");
        System.out.println("/___________\\");
   }
}
