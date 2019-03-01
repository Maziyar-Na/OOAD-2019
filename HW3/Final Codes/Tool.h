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
    string category;

public:
    Tool(int toolID,string toolName, double toolPrice, bool rentStat, string toolCategory);

    int geToolID();

    void setToolID(int toolID);

    string getName();

    void setName(string toolName);

    double getPrice();

    void setPrice(double toolPrice);

    void setRentalStat(bool rentStat);

    bool getRentalStat();

    string getToolCategory();

    void setToolCategory(string toolCategory);
};

#endif
