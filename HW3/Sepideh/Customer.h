//
// Created by sepideh on 2/28/19.
//

#ifndef OOHW3_CUSTOMER_H
#define OOHW3_CUSTOMER_H

#include <string>
#include <vector>
#include "Rental.h"


using namespace std;

class Customer {
public:
    Customer(string name): name(name), toolCount(0){};

    const string getName() const;

    bool isIsRenting() const;

    int getMaxToolCount() const;

    int getMinToolCount() const;

    int getToolCount() const;

    const vector<Rental> getRentalStatus() const;

    void setName(const string name);

    void setIsRenting(bool isRenting);

    virtual void setMaxToolCount();

    virtual void setMinToolCount();

    virtual void setToolCount(int toolCount);

    void addRental(Rental rent);

private:
    string name ;
    bool isRenting;
    vector<Rental> rentalStatus;

protected:
    int maxToolCount;
    int minToolCount;
    int toolCount;
};


#endif //OOHW3_CUSTOMER_H
