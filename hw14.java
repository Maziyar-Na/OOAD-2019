/*-------------------------------------
 * CSCI5448 Homework 1 problem 4
 * Team member : Jaeyoung Oh, Sepideh Goodarzy, Maram Kurdi, Maziyar Nazari
 * Compile: javac hw14.java Shape.java Square.java Triangle.java Circle.java
 * Usage: java hw14
 * ShpaeList.txt : collection of shapes
 * 1/29/2019
 * Reference code: http://www.angelfire.com/tx4/cus/shapes/java.html  
 * -------------------------------------*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;

public class hw14 {

   public static void Display(List<Shape> dp, int i) {
      Shape a = dp.get(i);
      a.draw();
   }

   public static void main(String args[]) throws Exception {

      int choice;
      Scanner keyboard = new Scanner(System.in);
      List<Shape> shapes = new LinkedList<Shape>();
      String[] collection = new String[3];
      int j = 0;
      
      // open input file (DB)
      BufferedReader r = new BufferedReader(new FileReader("ShapeList.txt"));
      // read the first line of the file
      String line = r.readLine();
      while (line != null) {   
         collection[j]= line;
         line = r.readLine();
         j++;
      }
      // Sorting the shpae collection
      Arrays.sort(collection);
      
      // Make all Shapes instances 
      for (j=0;j<collection.length;j++) {
         // from https://stackoverflow.com/questions/4337313/why-is-class-preferred-to-class
         Class<?> theClass = Class.forName(collection[j]);
         // from https://stackoverflow.com/questions/46393863/what-to-use-instead-of-class-newinstance 
         Shape s = (Shape)theClass.getDeclaredConstructor().newInstance();
         shapes.add(s);
      }
      // Display the shppe list and select shape to draw
      //while(true){
         System.out.println("");
         System.out.println("==Select the numer of shape==");
         for(int i = 0;i<shapes.size();i++){
            System.out.printf("%d: %s %n",i+1,collection[i]);
            Display(shapes,i);
         }
         /*
         System.out.println("4: Exit");
         // Keyboard input
         choice = keyboard.nextInt();

         if(choice == 1 || choice == 2 || choice ==3){
            Display(shapes,choice-1);
         }else if(choice == 4){
            System.exit(0);
         }else{
            System.out.println("Please type number 1 ~ 4.");
         }*/
      //}
   }
}