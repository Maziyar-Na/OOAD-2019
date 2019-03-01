//
// Created by sepideh on 2/28/19.
//

#include "Casual.h"

Casual::Casual(string name) :Customer(name){
    setMaxToolCount();
    setMinToolCount();
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