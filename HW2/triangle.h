#include "shape.h"

class Triangle : public Shape{
public:
  Triangle(int init_x, int init_y, int _width, int _height);
  virtual void display();
  int get_width() {return width;}
  int get_height() {return height;}
private:
  int width;
  int height;
};