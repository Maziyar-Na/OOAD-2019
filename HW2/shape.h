#ifndef __SHAPE__
#define __SHAPE__

#include <iostream>
#include <vector>
using namespace std;

class Shape {
public:
    Shape(int init_x, int init_y) : x(init_x), y(init_y) {}
    int get_x() const { return x; }
    int get_y() const { return y; }
/* The display function has been changed (It only shows a line containing the coordinates of the center of the shape and their specific elements like radius for circle).*/
    virtual void display() = 0;
protected:
    int x;
    int y;
};

#endif