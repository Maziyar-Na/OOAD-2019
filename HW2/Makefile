all: Q4

Q4: collection.o circle.o square.o triangle.o MainProgram.o main.o 
	g++ main.o MainProgram.o circle.o square.o triangle.o collection.o -o Q6

# shape.o: shape.cpp
# 	g++ -c shape.cpp

main.o: main.cpp
	g++ -c main.cpp

MainProgram.o: MainProgram.cpp 
	g++ -c MainProgram.cpp


circle.o: circle.cpp
	g++ -c circle.cpp

square.o: square.cpp
	g++ -c square.cpp

triangle.o: triangle.cpp
	g++ -c triangle.cpp

collection.o: collection.cpp
	g++ -c collection.cpp

clean:
	rm -rf *.o Q6