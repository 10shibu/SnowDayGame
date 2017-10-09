# SnowDayGame

City

A City is the game board for your simulation. It contains a 2 dimensional array of tiles. There are 3 different kinds of tiles a city can have at any location: * Snow-covered roads, represented as 1 or SNOWEDROAD * Snow-cleared roads, represented as 2 or CLEAREDROAD * Non-road tiles, represented as 0 or OFFROAD

Cities also contain the methods necessary for interacting with the game board. Methods like isSnowed or isOffRoad will tell you if a particular tile on the City is a snowed-in road or not a road at all. Later, you'll be placing Vehicles in your city and simulating their movement, so make sure you understand the game board. NOTE: When defining a City's Layout, notice that the coordinate (0,0) is in the top, left-hand corner of the board, since it is the first element of both the outer and inner arrays

Vehicle

The Vehicle class is an abstract class that defines the basic methods of a Vehicle. It describes the default movement pattern for a vehicle with the move method, and the procedure for placing a Vehicle in a City with the place method. You are allowed to change the methods in the Vehicle class. The automated testing suite that we will grade you with will access your Vehicle class by calling methods in your Simulator. Remember that you can't instantiate an abstract class; rather, you'll be using Vehicle as a blueprint for the specific Vehicles you'll be creating. NOTE: All new vehicles should be added to the edu.brandeis.cs12b.pa4 package, or else the automated tests won't work.

Simulator

The Simulator is what controls your game. It keeps track of your City, any Vehicles you add to it, and sets your simulation in motion. The Simulator is in charge of negotiating each step of the game, ie when each Vehicle is given a command to act (usually move in a direction). In addition, the Simulator keeps track of the active Vehicles placed in a City. If a Vehicle gets stuck somewhere (such as a Car trying to drive OFFROAD) it should be removed from the active Vehicles list, and no longer be issued move orders. Note that for the step method, each active Vehicle should be moved once, before any Vehicle is moved a second time. Vehicles should be moved in the order they were added to the list.

Direction

The Direction class contains an enum that stores the cardinal directions your vehicles can move.
VehicleError

The VehicleError class is also an enum. It contains a set of error messages that you'll print out with System.out.println() when a vehicle can't move successfully, or isn't placed succesfully.

Point

Similar to the Point class in PA2, Points store a location on the City's Layout. They can also translate their location in a Direction.

SnowSimClient

This Class is where you may put client code to run your simulation. This class will not be graded by our automated tests, but it will be looked at in your TA meetings. Development of this Class is optional.

Car

The Car class is the simplest vehicle. It responds to the following methods: * place will put the car on a City, in a particular location and facing a particular direction. Cars are not allowed to be placed on SNOWEDROAD or OFFROAD tiles, however.

● move will move the Car one tile forward in the direction it is facing. However, Cars cannot drive on snowed-in roads. If they are told to move forward into a tile that is either SNOWEDROAD or OFFROAD, they should be removed from the active vehicles list and send an error message with the reportError method.

SnowPlow

SnowPlows are the next step up in complexity. They have the following methods:

● Unlike cars, SnowPlows are allowed to move on SNOWEDROAD. When they do, they clear the snow from the tile underneath them, turning the tile they're currently on into CLEAREDROAD. However, if a SnowPlow tries to move into a tile that is OFFROAD, it should be removed from the active vehicles list and reportError.

● place acts almost the same as Car's place method. The only difference is that SnowPlows can be placed on SNOWEDROAD, and they clear the road when they're placed there.

LeftSnowPlow

LeftSnowPlows are almost the same as a normal SnowPlow, except that it turns to the left when it gets to the end of a road.

● If a LeftSnowPlow tries to move onto a tile of OFFROAD, it should instead turn left and attempt to move forward again. If it again encounters OFFROAD (during the same move call), it should then stop, reportError and be removed from the active vehicles list.

● place is exactly the same as SnowPlows's method place.

RightSnowPlow

RightSnowPlow behaves in exactly the same way LeftSnowPlow, except that it turns right instead of left when encountering OFFROAD.
