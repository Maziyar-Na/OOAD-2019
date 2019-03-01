//
// Created by sepideh on 2/28/19.
//

#include "Business.h"

Business::Business(string name) :Customer(name){
    setMaxRentalNight();
    setMinRentalNight();
    setMaxToolCount();
    setMinToolCount();
}

void Business::setMaxRentalNight(){
    Customer::maxRentalNight = 7 ;
}

void Business::setMinRentalNight(){
    Customer::minRentalNight = 7 ;
}

void Business::setMaxToolCount() {
    Customer::maxToolCount = 3;
}

void Business::setMinToolCount() {
    Customer::minToolCount = 3;
}

void Business::setToolCount(int toolCount) {
    Customer::toolCount = toolCount;
}

string Business::getType(){
    return "Business" ;
}