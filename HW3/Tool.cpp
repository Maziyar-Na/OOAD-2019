#include "Tool.h"

Tool :: Tool(string toolName, double toolPrice, bool rentStat, int rentDate, int rentDuration, int rentID, string toolCategory)
{
name = toolName;
price = toolPrice;
isRented = rentStat; 
rentalDate = rentDate; 
rentalDuration = rentDuration;
rentalID = rentID; 
category = toolCategory; 
}
string Tool::getName() {
	return this->name;
}

void Tool::setName(string toolName) {
	this->name = toolName;
}

double Tool::getPrice() {
	return this->price;
}

void Tool::setPrice(double toolPrice) {
	this->price = toolPrice;
}

void Tool::setRentalStat(bool rentStat) {
	this->isRented = rentStat;
}

bool Tool::getRentalStat() {
	return this->isRented;
}

void Tool::setRentalDate(int rentDate) {
	this->rentalDate = rentDate;
}

int Tool::getRentalDate() {
	return this->rentalDate;
}

int Tool::getRentalDuration() {
	return this->rentalDuration;
}

void Tool::setRentalDuration(int rentDuration) {
	this->rentalDuration = rentDuration;
}

int Tool::getRentalID() {
	return this->rentalID;
}

void Tool::setRentalID(int rentID) {
	this->rentalID = rentID;
}

string Tool::getToolCategory() {
	return this->category;
}

void Tool::setToolCategory(string toolCategory) {
	this->category = toolCategory;
}
