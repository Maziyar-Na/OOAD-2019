//
// Created by maaz on 2/28/19.
//

#ifndef HW3OOAD_STORE_H
#define HW3OOAD_STORE_H


#include "Inventory.h"
#include "Customer.h"

class Store {
private:
    Inventory* inventory;
    vector<Customer*> customers;
    int revenue;

public:
    Store();
    void addCustomers(vector<Customer*> _customers);
    vector<Customer*> getCustomers();
    Inventory* getInventory();
    //Customer* getCustomerByIndex(int i);
    void addRental(Customer* _customer, Rental* _rental);
    int getAvailableTools();
    vector<Tool*> getAvailableToolList();
    void updateRentals(int date);
    double getRevenue();
};


#endif //HW3OOAD_STORE_H
