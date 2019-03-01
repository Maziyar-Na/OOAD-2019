//
// Created by sepideh on 2/28/19.
//

#ifndef OOHW3_BUSINESS_H
#define OOHW3_BUSINESS_H


#include "Customer.h"

class Business: public Customer {
public:
    Business(string name);

    void setMaxToolCount();

    void setMinToolCount();

    void setToolCount(int toolCount);
};


#endif //OOHW3_BUSINESS_H
