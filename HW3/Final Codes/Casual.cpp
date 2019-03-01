//
// Created by sepideh on 2/28/19.
//

#include "Casual.h"

Casual::Casual(string name) :Customer(name){
    setMaxRentalNight();
    setMinRentalNight();
    setMaxToolCount();
    setMinToolCount();
}


void Casual::setMaxRentalNight(){
    Customer::maxRentalNight = 2 ;
}

void Casual::setMinRentalNight(){
    Customer::minRentalNight = 1 ;
}

void Casual::setMaxToolCount() {
    Customer::maxToolCount = 2;
}

void Casual::setMinToolCount() {
    Customer::minToolCount = 1;
}

void Casual::setToolCount(int toolCount) {
    Customer::toolCount = toolCount;
}

string Casual::getType(){
    return "Casual" ;
}