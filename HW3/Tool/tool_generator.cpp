#include "Tool.h"
#include <iostream>
#include <string>
using namespace std;


int main () {
    Tool tool_1 (1,"Tape",10,false,0,0,0,"Painting");
    Tool tool_2 (2,"Paint tray",10,false,0,0,0,"Painting");
    Tool tool_3 (3,"Paint roller",10,false,0,0,0,"Painting");
    Tool tool_4 (4,"Brushes",10,false,0,0,0,"Painting");
    
    Tool tool_5 (5,"Saws",50,false,0,0,0,"Concrete");
    Tool tool_6 (6,"Shovel",50,false,0,0,0,"Concrete");
    Tool tool_7 (7,"Screed",50,false,0,0,0,"Concrete");
    Tool tool_8 (8,"Laser level",50,false,0,0,0,"Concrete");
    
    Tool tool_9  (9,"Pipe wrenches",30,false,0,0,0,"Plumbing");
    Tool tool_10 (10,"Adjustable wrench",30,false,0,0,0,"Plumbing");
    Tool tool_11 (11,"Rib-joint pliers",30,false,0,0,0,"Plumbing");
    Tool tool_12 (12,"Pipe cutter",30,false,0,0,0,"Plumbing");
    
    Tool tool_13 (13,"Hammer",15,false,0,0,0,"Woodwork");
    Tool tool_14 (14,"Utility Knife",15,false,0,0,0,"Woodwork");
    Tool tool_15 (15,"Sliding Bevel",15,false,0,0,0,"Woodwork");
    Tool tool_16 (16,"Screwdriver",15,false,0,0,0,"Woodwork");
    
    Tool tool_17 (17,"Wheelbarrows",25,false,0,0,0,"Yardwork");
    Tool tool_18 (18,"Mattock",25,false,0,0,0,"Yardwork");
    Tool tool_19 (19,"Hoe",25,false,0,0,0,"Yardwork");
    Tool tool_20 (20,"Weeder",25,false,0,0,0,"Yardwork");
    
    return 0;
}
