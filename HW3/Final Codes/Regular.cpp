//
// Created by sepideh on 2/28/19.
//

#include "Regular.h"

Regular::Regular(string name) :Customer(name){
    setMaxRentalNight();
    setMinRentalNight();
    setMaxToolCount();
    setMinToolCount();
}

void Regular::setMaxRentalNight(){
    Customer::maxRentalNight = 5 ;
}

void Regular::setMinRentalNight(){
    Customer::minRentalNight = 3 ;
}

void Regular::setMaxToolCount() {
    Customer::maxToolCount = 3;
}

void Regular::setMinToolCount() {
    Customer::minToolCount = 1;
}

void Regular::setToolCount(int toolCount) {
    Customer::toolCount = toolCount;
}

string Regular::getType(){
    return "Regular" ;
}