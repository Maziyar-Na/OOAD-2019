//
// Created by maaz on 2/28/19.
//

#include "Inventory.h"
#include "Customer.h"

Inventory::Inventory(int _toolsRented, int _toolsAvailable, int _outstandingRentals)
{
    toolsRented = _toolsRented;
    toolsAvailable = _toolsAvailable;
    outstandingRentals = _outstandingRentals;
}

int Inventory::getToolsRented()
{
    return toolsRented;
}

void Inventory::setToolsRented(int _toolsRented)
{
    toolsRented = _toolsRented;
}

int Inventory::getOutstandingRentals()
{
    return outstandingRentals;
}

void Inventory::setOutstandingRentals(int _outstandingRentals)
{
    outstandingRentals = _outstandingRentals;
}

vector<Rental*> Inventory::getRentalsByDate()
{
	vector<Rental*> v;
	return v;
}

vector<Rental*> Inventory::getRentals()
{
    return rentalList;
}

void Inventory::addRental(Rental* _rental)
{
    int numOfTools = _rental->getToolCount();
    toolsAvailable -= numOfTools;
    toolsRented += numOfTools;
    rentalList.push_back(_rental);
    for(int i = 0 ; i < _rental->getToolList().size() ; i++){
        _rental-> setToolStatus(i, true);
    }
}

void Inventory::addTools(vector<Tool*> _tools)
{
    toolList = _tools;
}

vector<Tool*> Inventory::getTools()
{
    return toolList;
}

int Inventory::getToolsAvailable()
{
    return toolsAvailable;
}

void Inventory::updateRentals(int date){
    vector<Rental*> rentals = this->getRentals();
    for(int i = 0 ; i < rentals.size(); i++){
        if(rentals[i]->getEndDate() == date){
            rentals[i]->setIsActive(false);
            toolsAvailable+= rentals[i]->getToolCount();
            toolsRented -= rentals[i]->getToolCount();
            Customer* c = rentals[i]->getCustomer();
            c->setToolCount((c->getToolCount())-(rentals[i]->getToolCount()));
            for(int j = 0 ; j < rentals[i] -> getToolCount(); j++) {
                rentals[i]->setToolStatus(j, false);
            }
        }
    }
}
