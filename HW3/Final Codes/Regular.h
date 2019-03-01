//
// Created by sepideh on 2/28/19.
//

#ifndef OOHW3_REGULAR_H
#define OOHW3_REGULAR_H


#include "Customer.h"

class Regular: public Customer {
public:
    Regular(string name);

    void setMaxRentalNight();

    void setMinRentalNight();

    void setMaxToolCount();

    void setMinToolCount();

    void setToolCount(int toolCount);

    string getType();
};


#endif //OOHW3_REGULAR_H
