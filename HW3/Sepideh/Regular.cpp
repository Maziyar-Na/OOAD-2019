//
// Created by sepideh on 2/28/19.
//

#include "Regular.h"

Regular::Regular(string name) :Customer(name){
    setMaxToolCount();
    setMinToolCount();
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