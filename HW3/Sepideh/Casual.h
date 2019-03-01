//
// Created by sepideh on 2/28/19.
//

#ifndef OOHW3_CASUAL_H
#define OOHW3_CASUAL_H


#include "Customer.h"

class Casual : public Customer{
public:
    Casual(string name);

    void setMaxToolCount();

    void setMinToolCount();

    void setToolCount(int toolCount);
};


#endif //OOHW3_CASUAL_H
