class Triangle : public Shape(){
public:
  Triangle(int init_x, int init_y, int _width, int _height);
  virtual void display();
  int get_width() {return width;}
  int get_height() {return height;}
private:
  int width;
  int height;
};

Triangle::Triangle(int init_x, int init_y, int _width, int _height)
  :Shape(init_x, init_y)
{
  if (_width <= 0 || _height <= 0)
    throw IllegalArgumentException();
  width = _width;
  height = _height;
}

void Triangle::display(){
  cout << "Triangle: " << x << ',' << y << ',' << width << ',' << height << endl;
}
