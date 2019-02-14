#include "collection.h"

Collection::Collection(){

}

void Collection::add_shape(Shape* _shape){
  shapes.push_back(_shape);
}

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

vector<Shape*> Collection::get_collection(){
  return shapes;
}

int Collection::get_num_of_shapes(){
  return shapes.size();
}
