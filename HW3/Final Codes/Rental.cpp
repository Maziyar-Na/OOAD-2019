//
// Created by sepideh on 2/28/19.
//

#include "Rental.h"

Rental::Rental(int startDate, int endDate, Customer* customer, int toolCount, int rentalNights, int rentalID, bool isActive, vector<Tool*>toolList):
startDate(startDate), endDate(endDate), customer(customer), toolCount(toolCount), rentalNights(rentalNights), rentalID(rentalID),isActive(isActive), toolList(toolList)
{
    this->totalRentalFee= computeRentalFees();
}

void Rental::setStartDate(int startDate) {
    Rental::startDate = startDate;
}

void Rental::setEndDate(int endDate) {
    Rental::endDate = endDate;
}

void Rental::setCustomer(Customer* customer) {
    Rental::customer = customer;
}

void Rental::setToolCount(int toolCount) {
    Rental::toolCount = toolCount;
}

void Rental::setToolList(const vector<Tool*> toolList) {
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
    for(int i = 0; i < toolList.size(); i++){
        toolList[i]->setRentalStat(isActive);
    }
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

Customer* Rental::getCustomer() const {
    return customer;
}

int Rental::getToolCount() const {
    return toolCount;
}

const vector<Tool*> Rental::getToolList() const {
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

double Rental::computeRentalFees() {
    double fee = 0.0;
    for(int i = 0; i < toolList.size(); i++){
        fee += ((toolList[i]->getPrice()) * rentalNights) ;
    }
    return fee;
}

void Rental::setToolStatus(int i, bool val){
    toolList[i]->setRentalStat(val);
}
