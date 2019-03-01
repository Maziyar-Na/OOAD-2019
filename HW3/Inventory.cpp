//
// Created by maaz on 2/28/19.
//

#include "Inventory.h"

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

vector<Rental> Inventory::getRentalsByDate()
{

}

vector<Rental> Inventory::getRentals()
{
    return rentalList;
}

void Inventory::addRental(Rental _rental)
{
    rentalList.push_back(_rental);
}

void Inventory::addTool(Tool _tool)
{
    toolList.push_back(_tool);
}

vector<Tool> Inventory::getTools()
{
    return toolList;
}