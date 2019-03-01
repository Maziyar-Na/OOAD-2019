//
// Created by sepideh on 2/28/19.
//

#include "Business.h"

Business::Business(string name) :Customer(name){
    setMaxToolCount();
    setMinToolCount();
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