#ifndef TOOL_H
#define TOOL_H

class Tool {

private:
	string name;
	double price;
	bool isRented;
	int rentalDuration;
	int rentalDate;
	int rentalID;
	string category;

public:
	Tool(string toolName, double toolPrice, bool rentStat, int rentDate, int rentDuration, int rentID, string toolCategory);
	
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
