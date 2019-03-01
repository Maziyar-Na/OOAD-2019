//
// Created by maaz on 2/28/19.
//

#include "Store.h"

Store::Store(){
    inventory = new Inventory(0 , 20, 0);
    revenue = 0;
}

void Store::addCustomers(vector<Customer*> _customers)
{
    customers = _customers;
}

vector<Customer*> Store::getCustomers()
{
    return customers;
}

Inventory* Store::getInventory()
{
    return inventory;
}

void Store::addRental(Customer* _customer, Rental* _rental)
{
    if(_customer->addRental(_rental)){
        inventory->addRental(_rental);
        revenue += _rental->computeRentalFees();
    }

}

int Store::getAvailableTools()
{
    return inventory->getToolsAvailable();
}

vector<Tool*> Store::getAvailableToolList(){
    vector<Tool*> availableToolList ;
    vector<Tool*> tools = inventory->getTools();
    for(int i = 0 ; i < tools.size() ; i++){
        if(tools[i]->getRentalStat() == false){
            availableToolList.push_back(tools[i]);
        }
    }
    return availableToolList;
}

void Store::updateRentals(int date){
    inventory->updateRentals(date);
}

double Store::getRevenue()
{
    return revenue;
}
