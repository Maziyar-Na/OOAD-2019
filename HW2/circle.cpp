class Circle : public Shape {
public:
    Circle(int init_x, int init_y, int r);
    virtual void display();
    int get_radius() {return radius;}
private:
    int radius;
};

Circle::Circle(int init_x, int init_y, int r)
    : Shape(init_x, init_y)
{
    if (r <= 0)
	    throw IllegalArgumentException();
    radius = r;
}

void Circle::display()
{
    cout << "Circle: " << x << ',' << y << ',' << radius << endl;
}
