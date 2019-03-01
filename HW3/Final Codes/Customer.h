//
// Created by sepideh on 2/28/19.
//

#ifndef OOHW3_CUSTOMER_H
#define OOHW3_CUSTOMER_H

//#include <string>
//#include <vector>
#include "Rental.h"
using namespace std;

//class Rental;
class Customer {
public:
    Customer(string name): name(name), toolCount(0){};

    const string getName() const;

    bool isIsRenting() const;

    int getMaxToolCount() const;

    int getMinToolCount() const;

    int getToolCount() const;

    const vector<Rental*> getRentalStatus() const;

    void setName(const string name);

    void setIsRenting(bool isRenting);

    virtual void setMaxToolCount() = 0;

    virtual void setMinToolCount() = 0;

    void setToolCount(int toolCount);

    virtual void setMaxRentalNight() = 0;

    virtual void setMinRentalNight() = 0;

    virtual string getType() = 0 ;

    bool addRental(Rental* rent);

private:
    string name ;
    bool isRenting;
    vector<Rental*> rentalStatus;
    int toolCount;

protected:
    int maxRentalNight;
    int minRentalNight;
    int maxToolCount;
    int minToolCount;
};


#endif //OOHW3_CUSTOMER_H