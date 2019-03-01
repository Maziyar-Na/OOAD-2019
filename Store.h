//
// Created by maaz on 2/28/19.
//

#ifndef HW3OOAD_STORE_H
#define HW3OOAD_STORE_H


#include "Inventory.h"

class Store {
private:
    Inventory inventory;
    vector<Customer> customers;

public:
    Store();
    void addCustomer(Customer _customer);
    vector<Customer> getCustomers();

};


#endif //HW3OOAD_STORE_H
