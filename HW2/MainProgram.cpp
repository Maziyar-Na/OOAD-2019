#include "MainProgram.h"

MainProgram::MainProgram(){

}
/*We created a class responsible for implementing the question's procedure(to be able to run different procedures without changing the main.cpp).*/
void MainProgram::run(){
  Circle* c = new Circle(1, 2, 5);
  Square* s = new Square(4, 5, 5, 5);
  Triangle* t = new Triangle(2, 3, 6, 6);
  //Adding shapes to collection
  db.add_shape(c);
  db.add_shape(s);
  db.add_shape(t);

  cout << "Number of shapes in the database is: " << db.get_num_of_shapes() << endl;
  
  db.sort_shapes();
  
  vector<Shape*> v = db.get_collection();
  for(int i = 0; i < v.size(); ++i)
    v[i]->display();

  delete(c);
  delete(s);
  delete(t);
}
