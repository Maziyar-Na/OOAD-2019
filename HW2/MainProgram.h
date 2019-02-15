#include "collection.h"
#include "circle.h"
#include "square.h"
#include "triangle.h"
/*We created a class responsible for implementing the question's procedure(to be able to run different procedures without changing the main.cpp).*/
class MainProgram {
  public:
    MainProgram();
    void run();
  private:
    Collection db;
};
