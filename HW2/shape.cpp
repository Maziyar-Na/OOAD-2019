class Shape {
public:
    Shape(int init_x, int init_y) : x(init_x), y(init_y) {}
    int get_x() const { return x; }
    int get_y() const { return y; }

    virtual void display() = 0;
protected:
    int x;
    int y;
};
