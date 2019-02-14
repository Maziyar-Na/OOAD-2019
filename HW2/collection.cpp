class Collection {

public:
  Collection();
  void add_shape(Shape _shape);
  void sort_shapes();
  vector<Shape> get_collection();
  int get_num_of_shapes();

private:
  vector<Shape> shapes;
};

Collection::Collection(){

}

void Collection::add_shape(Shape _shape){
  shapes.push_back(_shape);
}

void Collection::sort_shapes(){
  sort(shapes.begin(),
          shapes.end(),
          [](const Shape& lhs, const Shape& rhs)
          {
            return lhs.get_x() < rhs.get_x();
          });
}

vector<Shape> Collection::get_collection(){
  return shapes;
}

int Collection::get_num_of_shapes(){
  return shapes.size();
}
