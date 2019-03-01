//
// Created by sepideh on 2/28/19.
//

#ifndef OOHW3_RENTAL_H
#define OOHW3_RENTAL_H

#include <string>
#include <vector>
#include "Tool.h"

class Customer ;

using namespace std ;

class Rental {

public:

    Rental(int startDate, int endDate, Customer* customer, int toolCount, int rentalNights, int rentalID, bool isActive, vector<Tool*>toolList);

    void setStartDate(int startDate);

    void setEndDate(int endDate);

    void setCustomer( Customer* customer);

    void setToolCount(int toolCount);

    void setToolList(const vector<Tool*> toolList);

    void setRentalNights(int rentalNights);

    void setRentalID(int rentalID);

    void setIsActive(bool isActive);

    void setTotalRentalFee(double totalRentalFee);

    int getStartDate() const;

    int getEndDate() const;

    Customer* getCustomer() const;

    int getToolCount() const;

    const vector<Tool*> getToolList() const;

    int getRentalNights() const;

    int getRentalID() const;

    int getMaxRentalNights() const;

    bool isIsActive() const;

    double getTotalRentalFee() const;

    void addTool(Tool* temp);

    double computeRentalFees();

    void setToolStatus(int i, bool val);

private:
    int startDate;
    int endDate;
    Customer* customer;
    int toolCount;
    vector<Tool*>toolList;
    int rentalNights;
    int rentalID;
    int maxRentalNights = 7;
    bool isActive;
    double totalRentalFee ;
};


#endif //OOHW3_RENTAL_H
