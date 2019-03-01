//
// Created by sepideh on 2/28/19.
//

#include "Rental.h"

void Rental::setStartDate(int startDate) {
    Rental::startDate = startDate;
}

void Rental::setEndDate(int endDate) {
    Rental::endDate = endDate;
}

void Rental::setCustomerName(const string customerName) {
    Rental::customerName = customerName;
}

void Rental::setToolCount(int toolCount) {
    Rental::toolCount = toolCount;
}

void Rental::setToolList(const vector<Tool> toolList) {
    Rental::toolList = toolList;
}

void Rental::setRentalNights(int rentalNights) {
    Rental::rentalNights = rentalNights;
}

void Rental::setRentalID(int rentalID) {
    Rental::rentalID = rentalID;
}

void Rental::setIsActive(bool isActive) {
    Rental::isActive = isActive;
}

void Rental::setTotalRentalFee(double totalRentalFee) {
    Rental::totalRentalFee = totalRentalFee;
}

int Rental::getStartDate() const {
    return startDate;
}

int Rental::getEndDate() const {
    return endDate;
}

const string Rental::getCustomerName() const {
    return customerName;
}

int Rental::getToolCount() const {
    return toolCount;
}

const vector<Tool> Rental::getToolList() const {
    return toolList;
}

int Rental::getRentalNights() const {
    return rentalNights;
}

int Rental::getRentalID() const {
    return rentalID;
}

int Rental::getMaxRentalNights() const {
    return maxRentalNights;
}

bool Rental::isIsActive() const {
    return isActive;
}

double Rental::getTotalRentalFee() const {
    return totalRentalFee;
}
