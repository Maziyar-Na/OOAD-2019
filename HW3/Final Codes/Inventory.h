//
// Created by maaz on 2/28/19.
//

#ifndef HW3OOAD_INVENTORY_H
#define HW3OOAD_INVENTORY_H

#include <vector>
#include "Rental.h"

using namespace std;

class Inventory {
private:
    int toolsRented;
    int toolsAvailable;
    int toolInventory = 20;
    int outstandingRentals;
    vector<Rental*> rentalList;
    vector<Tool*> toolList;

public:
    Inventory(int _toolsRented, int _toolsAvailable, int _outstandingRentals);
    int getToolsRented();
    void setToolsRented(int _toolsRented);
    int getOutstandingRentals();
    void setOutstandingRentals(int _outstandingRentals);
    vector<Rental*> getRentalsByDate();
    vector<Rental*> getRentals();
    void addRental(Rental* _rental);
    void addTools(vector<Tool*> _tools);
    vector<Tool*> getTools();
    int getToolsAvailable();
    void updateRentals(int date);
};


#endif //HW3OOAD_INVENTORY_H
