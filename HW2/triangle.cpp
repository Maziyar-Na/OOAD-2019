#include "triangle.h"

Triangle::Triangle(int init_x, int init_y, int _width, int _height)
  :Shape(init_x, init_y)
{
  if (_width <= 0 || _height <= 0)
    cout << "Error: Width or Height is less than 0" << endl;
  width = _width;
  height = _height;
}

void Triangle::display(){
  cout << "Triangle: " << x << ',' << y << ',' << "Width: " << width << ',' <<"Height: " << height << endl;
}
