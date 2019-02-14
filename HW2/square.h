#include "shape.h"

class Square : public Shape {
public:
    Square(int init_x, int init_y, int w, int h);
    virtual void display();
    int get_width() {return width;}
    int get_height() {return height;}
private:
    int width;
    int height;
};