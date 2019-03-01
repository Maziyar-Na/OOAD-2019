//
// Created by Maziyar Nazari on 2019-02-28.
//

#include "Simulation.h"

Simulation::Simulation() {
    report.open("report.txt");
}

void Simulation::simulate()
{
    store = new Store();
    vector<Tool*> tools = generateToolList();
    vector<Customer*> customers = generateCustomerList();
    store->addCustomers(customers);
    store->getInventory()->addTools(tools);//change
    int count = 0 ;
    for (int dateNumber = 0; dateNumber < 35; dateNumber++) {
        for(int trial = 0 ; trial < 10; trial++) {
            int random = rand() % 10;
            if (customers[random]->getMaxToolCount() <= store->getAvailableTools()) {
                vector<Tool*> availableToolList = store->getAvailableToolList();
                Rental *r = generateRental(customers[random], dateNumber , availableToolList, count);
                store->addRental(customers[random], r);
                count++ ;
            }
        }
        store->updateRentals(dateNumber);
    }
    report << "The number of tools available in the store is: " << store->getAvailableTools() << endl;
    if (store->getAvailableTools() > 0){
        for (int i = 0; i < store->getAvailableTools(); ++i) {
            report << "The tool " << i << " available is: " << store->getAvailableToolList()[i]->getName() << endl;
        }
    }
    report << "The amount of money that store has made in 35 days is: " << store-> getRevenue() << endl;
    report << "Record of all the rentals is below: " << endl;
    for (int j = 0; j < store->getInventory()->getRentals().size(); ++j) {
        report << "Rental " << j << " completed is: " << store->getInventory()->getRentals()[j]->getRentalID();
        for (int i = 0; i < store->getInventory()->getRentals()[j]->getToolList().size(); ++i) {
            report << " tool " << i << " rented in this rental is: " <<  store->getInventory()->getRentals()[j]->getToolList()[i]->getName() << " ";
        }
        report << endl << "--- Customer who rented this rental: " << store->getInventory()->getRentals()[j]->getCustomer()->getName() << endl;
        report << "--- Duration of the rental is: " << store->getInventory()->getRentals()[j]->getRentalNights() << endl;
        report << "--- The amount of this rental is: " << store->getInventory()->getRentals()[j]->computeRentalFees() << endl;
    }
    report << "Record of all the active rentals is below" << endl;
    for (int j = 0; j < store->getInventory()->getRentals().size(); ++j) {
        if (store->getInventory()->getRentals()[j]->isIsActive()) {
            report << "Rental " << j << " completed is: " << store->getInventory()->getRentals()[j]->getRentalID();
            for (int i = 0; i < store->getInventory()->getRentals()[j]->getToolList().size(); ++i) {
                report << " tool " << i << " rented in this rental is: "
                       << store->getInventory()->getRentals()[j]->getToolList()[i]->getName() << " ";
            }
            report << endl << "--- Customer who rented this rental: "
                   << store->getInventory()->getRentals()[j]->getCustomer()->getName() << endl;
            report << "--- Duration of the rental is: " << store->getInventory()->getRentals()[j]->getRentalNights()
                   << endl;
            report << "--- The amount of this rental is: "
                   << store->getInventory()->getRentals()[j]->computeRentalFees() << endl;
        }
    }
    report.close();
}

vector<Tool*> Simulation::generateToolList(){
    vector<Tool*> res;
    res.push_back( new Tool(1,"Tape",10,false,"Painting"));
    res.push_back( new Tool(2,"Paint tray",10,false,"Painting"));
    res.push_back( new Tool(3,"Paint roller",10,false,"Painting"));
    res.push_back( new Tool(4,"Brushes",10,false,"Painting"));

    res.push_back( new Tool(5,"Saws",50,false,"Concrete"));
    res.push_back( new Tool(6,"Shovel",50,false,"Concrete"));
    res.push_back( new Tool(7,"Screed",50,false,"Concrete"));
    res.push_back( new Tool(8,"Laser level",50,false,"Concrete"));

    res.push_back( new Tool(9,"Pipe wrenches",30,false,"Plumbing"));
    res.push_back( new Tool(10,"Adjustable wrench",30,false,"Plumbing"));
    res.push_back( new Tool(11,"Rib-joint pliers",30,false,"Plumbing"));
    res.push_back( new Tool(12,"Pipe cutter",30,false,"Plumbing"));

    res.push_back( new Tool(13,"Hammer",15,false,"Woodwork"));
    res.push_back( new Tool(14,"Utility Knife",15,false,"Woodwork"));
    res.push_back( new Tool(15,"Sliding Bevel",15,false,"Woodwork"));
    res.push_back( new Tool(16,"Screwdriver",15,false,"Woodwork"));

    res.push_back( new Tool(17,"Wheelbarrows",25,false,"Yardwork"));
    res.push_back( new Tool(18,"Mattock",25,false,"Yardwork"));
    res.push_back( new Tool(19,"Hoe",25,false,"Yardwork"));
    res.push_back( new Tool(20,"Weeder",25,false,"Yardwork"));
    return res;
}

vector<Customer*> Simulation::generateCustomerList(){
    vector<Customer*> customers ;
    customers.push_back(new Business("Steve"));
    customers.push_back(new Regular("Ann"));
    customers.push_back(new Casual("Andy"));
    customers.push_back(new Business("Paul"));
    customers.push_back(new Regular("Sarah"));
    customers.push_back(new Casual("Will"));
    customers.push_back(new Business("Max"));
    customers.push_back(new Regular("John"));
    customers.push_back(new Casual("Carol"));
    customers.push_back(new Casual("Nicole"));
    return customers;
}

Rental* Simulation::generateRental(Customer* customer, int dateNumber, vector<Tool*> availableToolList, int ID){
    Rental* r ;
    if(customer-> getType() == "Business"){
        vector<Tool*>toolList ;
        for(int i = 0 ; i < 3 ; i++){
            toolList.push_back(availableToolList[i]);
        }
        r =  new Rental(dateNumber, dateNumber+ 7, customer, 3, 7, ID, true, toolList);
    }
    else if(customer -> getType() == "Regular"){
        int duration = rand()%3 + 3;
        int numOfTools = rand()%3+1;
        vector<Tool*>toolList ;
        for(int i = 0 ; i < numOfTools ; i++){
            toolList.push_back(availableToolList[i]);
        }
        r =  new Rental(dateNumber, dateNumber+duration, customer, numOfTools, duration, ID, true, toolList);
    }
    else if(customer -> getType() == "Casual"){
        int duration = rand()%2 + 1;
        int numOfTools = rand()%2+1;
        vector<Tool*>toolList ;
        for(int i = 0 ; i < numOfTools ; i++){
            toolList.push_back(availableToolList[i]);
        }
        r =  new Rental(dateNumber, dateNumber+duration, customer, numOfTools, duration, ID, true, toolList);
    }
    return r;
}
