package edu.brandeis.cs12b.pa4;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.HumanSimResponses;
import edu.brandeis.cs12b.pa4.provided.Point;

public abstract class Vehicle {

	protected Point location;
	protected City city;
	public Direction facing;
	
	/**
	 * This method should move your vehicle one cell in the direction it was facing.
	 * If your vehicle can't move because there's a wall in the way, it should stay in
	 * same place and call the reportError(), then return false so it can be taken
	 * off the list of active vehicles
	 * @return true if the move was successfully made, false if not
	 */
	public boolean move(){
		Point newLocation = location.translate(facing);
		if (newLocation.x>city.maxX || newLocation.y>city.maxY  || city.isOffRoad(newLocation)) {
			reportMoveError();
			return false;
		}
		//this.location = newLocation
		return true;
	}

	/**
	 * This places your vehicle into a city. If this fails, print out the proper VehicleError
	 * string.
	 * @param city the city to be placed into
	 * @param location the location in the city to be placed
	 * @param facing this direction
	 * @return true if this happens successfully, false if not
	 */
	public boolean place(City city, Point location, Direction facing){
		this.city = city;
		this.facing = facing;
		this.location = location;
		if (location.x>city.maxX || location.y>city.maxY || city.isOffRoad(location) || location.x<0 || location.y<0){
			reportPlaceError();
			return false;
		}
		return true;
	}
	
	/**
	 * These methods reports if a vehicle can't be placed or moved, respectively.
	 * This should be different for each vehicle.
	 * Use the VehicleError Enum to get the text to print out.
	 */
	public abstract void reportPlaceError();
	public abstract void reportMoveError();
	public abstract String toString();

	public static boolean isValidVehicle (String veh) {
		if (veh.equals("Car") || veh.equals("SnowPlow") || veh.equals("LeftSnowPlow") || veh.equals("RightSnowPlow") || veh.equals("HumanCar")) {
            return true;
		}
		System.out.println(HumanSimResponses.INVALID_VEHICLE);
		return false;
	}

	public void setDirection(Direction turnStringToDirection) {
		// TODO Auto-generated method stub
		
	}

	
}
