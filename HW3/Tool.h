#ifndef TOOL_H
#define TOOL_H

class Tool {

private:
	string name;
	double price;
	bool isRented;
	int rentalDuration;
	Date rentalDate;
	int rentalID;
	string category;

public:
	string getName();

	void setName(string toolName);

	double getPrice();

	void setPrice(double toolPrice);

	void setRentalStat(bool rentStat);

	bool getRentalStat();

	int getRentalDuration();

	void setRentalDuration(int rentDuration);

	int getRentalID();

	void setRentalID(int rentID);

	string getToolCategory();

	void setToolCategory(string toolCategory);
};

#endif
