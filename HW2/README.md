# OOAD-2019
 CSCI 5448 Homework 2 problem 6
 Group members:
1. Sepideh Goodarzy
2. Maram Kurdi
3. Maziyar Nazari
4. Dwight Browne

 * File list
   - main.cpp: main function
   - shape.h, square.cpp, square.h, triangle.cpp, triangle.h, circle.cpp, circle.h : Class
   - MainProgram.cpp, MainProgram.h : A class responsible for simulating the program which was asked in the HW1 (adds a circle, a atriangle and a square, then sorts them based on their x coordinate, then calls each shape's display mathod)
   - collection.cpp, collection.h : collection class (also plays role as a database) 
 * Compile: make
 * Usage: ./Q6
 * Clean: make clean
 * Change log: We added a sort function to the collection class(Now, we can change the sort algorithm without changing the main program). The display function has been changed (It only shows a line containing the coordinates of the center of the shape and their specific elements like radius for circle). We created a class responsible for implementing the question's procedure(to be able to run different procedures without changing the main.cpp). We added functions: 1- get_num_of_shapes and 2- get_collection to the collection class to abstract the functionality of "get number of shapes" and "how collection saves shapes" of the collection class from the main program. 