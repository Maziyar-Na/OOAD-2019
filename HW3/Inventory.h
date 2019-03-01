//
// Created by maaz on 2/28/19.
//

#ifndef HW3OOAD_INVENTORY_H
#define HW3OOAD_INVENTORY_H

#include <vector>
using namespace std;

class Inventory {
private:
    int toolsRented;
    int toolsAvailable;
    int toolInventory = 20;
    int outstandingRentals;
    vector<Rental> rentalList;
    vector<Tool> toolList;

public:
    Inventory(int _toolsRented, int _toolsAvailable, int _outstandingRentals);
    int getToolsRented();
    void setToolsRented(int _toolsRented);
    int getOutstandingRentals();
    void setOutstandingRentals(int _outstandingRentals);
    vector<Rental> getRentalsByDate();
    vector<Rental> getRentals();
    void addRental(Rental _rental);
    void addTool(Tool _tool);
    vector<Tool> getTools();
};


#endif //HW3OOAD_INVENTORY_H
