//
// Created by Maziyar Nazari on 2019-02-28.
//

#ifndef OOADHW3_SIMULATION_H
#define OOADHW3_SIMULATION_H

#include "Store.h"
#include "Business.h"
#include "Regular.h"
#include "Casual.h"
#include <fstream>

class Simulation {
public:
    Simulation();
    void simulate();

private:
    Store* store;
    ofstream report;

    vector<Tool*> generateToolList();
    vector<Customer*> generateCustomerList();
    Rental* generateRental(Customer* customer, int dateNumber, vector<Tool*> availableToolList, int ID);
};


#endif //OOADHW3_SIMULATION_H
