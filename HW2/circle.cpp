#include "circle.h"

Circle::Circle(int init_x, int init_y, int r)
    : Shape(init_x, init_y)
{
    if (r <= 0)
	    cout << "Error: radius is less than 0" << endl;
    radius = r;
}

void Circle::display()
{
    cout << "Circle: " << x << ',' << y << ',' << "Radius: " << radius << endl;
}
