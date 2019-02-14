#include "shape.h"
#include <algorithm>

class Collection {

public:
  Collection();
  void add_shape(Shape* _shape);
  void sort_shapes();
  vector<Shape*> get_collection();
  int get_num_of_shapes();

private:
  vector<Shape*> shapes;
};
