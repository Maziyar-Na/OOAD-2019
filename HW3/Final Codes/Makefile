all: Simulation

Simulation: Store.o Tool.o Rental.o Regular.o Casual.o Business.o Customer.o Inventory.o Simulation.o main.o
	g++ main.o Simulation.o Customer.o Business.o Casual.o Regular.o Rental.o Tool.o Store.o Inventory.o -o Simulation

# shape.o: shape.cpp
# 	g++ -c shape.cpp

main.o: main.cpp
	g++ -c main.cpp

Simulation.o: Simulation.cpp
	g++ -c Simulation.cpp


Casual.o: Casual.cpp
	g++ -c Casual.cpp

Regular.o: Regular.cpp
	g++ -c Regular.cpp

Business.o: Business.cpp
	g++ -c Business.cpp

Customer.o: Customer.cpp
	g++ -c Customer.cpp

Inventory.o: Inventory.cpp
	g++ -c Inventory.cpp

Store.o: Store.cpp
	g++ -c Store.cpp

Rental.o: Rental.cpp
	g++ -c Rental.cpp

Tool.o: Tool.cpp
	g++ -c Tool.cpp

clean:
	rm -rf *.o Simulation
