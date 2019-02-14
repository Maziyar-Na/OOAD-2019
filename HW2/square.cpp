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

Square::Square(int init_x, int init_y, int w, int h)
    : Shape(init_x, init_y)
{
    if (w <= 0 || h <= 0)
	    throw IllegalArgumentException();
    width = w;
    height = h;
}

void Square::display()
{
    cout << "Square: " << x << ',' << y << ',' << width << ',' << height << endl;
}
