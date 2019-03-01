//
// Created by sepideh on 2/28/19.
//

#ifndef OOHW3_RENTAL_H
#define OOHW3_RENTAL_H

#include <string>
#include <vector>

using namespace std ;

class Rental {

public:

    void setStartDate(int startDate);

    void setEndDate(int endDate);

    void setCustomerName(const string customerName);

    void setToolCount(int toolCount);

    void setToolList(const vector<Tool> toolList);

    void setRentalNights(int rentalNights);

    void setRentalID(int rentalID);

    void setIsActive(bool isActive);

    void setTotalRentalFee(double totalRentalFee);

    int getStartDate() const;

    int getEndDate() const;

    const string getCustomerName() const;

    int getToolCount() const;

    const vector<Tool> getToolList() const;

    int getRentalNights() const;

    int getRentalID() const;

    int getMaxRentalNights() const;

    bool isIsActive() const;

    double getTotalRentalFee() const;

    void addTool(Tool temp);

    void deleteTool(Tool temp);

    double computeRentalFees();

private:
    int startDate;
    int endDate;
    string customerName;
    int toolCount;
    vector<Tool>toolList;
    int rentalNights;
    int rentalID;
    int maxRentalNights = 7;
    bool isActive;
    double totalRentalFee ;
};


#endif //OOHW3_RENTAL_H
