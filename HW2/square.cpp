#include "square.h"

Square::Square(int init_x, int init_y, int w, int h)
    : Shape(init_x, init_y)
{
    if (w <= 0 || h <= 0)
	    cout << "Error: Width or Height is less than 0" << endl;
    width = w;
    height = h;
}

void Square::display()
{
    cout << "Square: " << x << ',' << y << ',' << "Width: " << width << ',' <<"Height: " << height << endl;
}
