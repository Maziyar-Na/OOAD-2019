#include "collection.h"

Collection::Collection(){

}

void Collection::add_shape(Shape* _shape){
  shapes.push_back(_shape);
}
/*We added a sort function to the collection class(Now, we can change the sort algorithm without changing the main program).*/
void Collection::sort_shapes(){
  if (shapes.size() <= 1)
    return;
  for (int i = 0; i < shapes.size(); ++i){
    for (int j = i; j < shapes.size(); ++j ){
      if ( shapes[j]->get_x() < shapes[i]->get_x() ){
        Shape* temp = shapes[i];
        shapes[i] = shapes[j];
        shapes[j] = temp;
      }
    }
  }
}
/* We added functions: 1- get_num_of_shapes and 2- get_collection to the collection class to abstract the functionality of "get number of shapes" and "how collection saves shapes" of the collection class from the main program. */
vector<Shape*> Collection::get_collection(){
  return shapes;
}

int Collection::get_num_of_shapes(){
  return shapes.size();
}
