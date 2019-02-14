#include "shape.h"

class Circle : public Shape {
public:
    Circle(int init_x, int init_y, int r);
    virtual void display();
    int get_radius() {return radius;}
private:
    int radius;
};