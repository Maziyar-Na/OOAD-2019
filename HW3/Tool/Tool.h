#ifndef TOOL_H
#define TOOL_H
#include <iostream>
#include <string>
using namespace std;

class Tool {
    
private:
    int tool_ID;
    string name;
    double price;
    bool isRented;
    int rentalDuration;
    int rentalDate;
    int rentalID;
    string category;
    
public:
    Tool(int toolID,string toolName, double toolPrice, bool rentStat, int rentDate, int rentDuration, int rentID, string toolCategory);
    
    int geToolID();

    void setToolID(int toolID);

    string getName();
    
    void setName(string toolName);
    
    double getPrice();
    
    void setPrice(double toolPrice);
    
    void setRentalStat(bool rentStat);
    
    void setRentalDate(int rentDate);
    
    int getRentalDate();
    
    bool getRentalStat();
    
    int getRentalDuration();
    
    void setRentalDuration(int rentDuration);
    
    int getRentalID();
    
    void setRentalID(int rentID);
    
    string getToolCategory();
    
    void setToolCategory(string toolCategory);
};

#endif
