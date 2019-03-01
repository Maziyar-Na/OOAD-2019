//
// Created by sepideh on 2/28/19.
//

#include "Customer.h"

const string Customer::getName() const {
    return name;
}

bool Customer::isIsRenting() const {
    return isRenting;
}

int Customer::getMaxToolCount() const {
    return maxToolCount;
}

int Customer::getMinToolCount() const {
    return minToolCount;
}

int Customer::getToolCount() const {
    return toolCount;
}

const vector<Rental*> Customer::getRentalStatus() const {
    return rentalStatus;
}

void Customer::setName(const string name) {
    Customer::name = name;
}
void Customer::setIsRenting(bool isRenting) {
    Customer::isRenting = isRenting;
}

void Customer::setToolCount(int toolCount) {
    Customer::toolCount = toolCount;
}

bool Customer::addRental(Rental* rent){
    int t = rent->getToolCount();
    int n = rent->getRentalNights();
    if(toolCount + t <= maxToolCount && toolCount + t >= minToolCount && n <= maxRentalNight && n >= minRentalNight) {
        toolCount += t;
        rentalStatus.push_back(rent);
        return true;
    }
    return false;
}
