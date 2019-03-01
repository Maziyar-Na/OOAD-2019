#include "Tool.h"
#include <iostream>
#include <string>
using namespace std;


Tool :: Tool(int toolID,string toolName, double toolPrice, bool rentStat, string toolCategory)
{
    tool_ID = toolID;
    name = toolName;
    price = toolPrice;
    isRented = rentStat;
    category = toolCategory;
}

int Tool::geToolID() {
    return this->tool_ID;
}

void Tool::setToolID(int toolID) {
    this->name = tool_ID;
}

string Tool::getName() {
    return this->name;
}

void Tool::setName(string toolName) {
    this->name = toolName;
}

double Tool::getPrice() {
    return this->price;
}

void Tool::setPrice(double toolPrice) {
    this->price = toolPrice;
}

void Tool::setRentalStat(bool rentStat) {
    this->isRented = rentStat;
}

bool Tool::getRentalStat() {
    return this->isRented;
}

string Tool::getToolCategory() {
    return this->category;
}

void Tool::setToolCategory(string toolCategory) {
    this->category = toolCategory;
}
