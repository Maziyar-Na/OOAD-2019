//
// Created by maaz on 2/28/19.
//

#include "Store.h"

Store::Store(){ }

void Store::addCustomer(Customer _customer)
{
    customers.push_back(_customer);
}

vector<Customer> Store::getCustomers()
{
    return customers;
}