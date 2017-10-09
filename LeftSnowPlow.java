package edu.brandeis.cs12b.pa4;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.Point;
import edu.brandeis.cs12b.pa4.provided.VehicleError;

public class LeftSnowPlow extends SnowPlow {
	
//	public LeftSnowPlow (City city) {
//		super(city);
//	}
	@Override
	public void reportPlaceError() {
		System.out.println(VehicleError.LEFTSNOWPLOWPLACEMENT);
	}

	@Override
	public void reportMoveError() {
		System.out.println(VehicleError.LEFTSNOWPLOWERROR);
	}
	
	@Override
	//
	public boolean move() {
		Point newLocation = location.translate(facing);
		//System.out.println(facing);
		Direction newFacing = Turn(facing);
		//System.out.println(newLocation);
		if (newLocation.x>city.maxX || newLocation.y>city.maxY) {
			reportMoveError();
			return false;
		} else if (city.isSnowed(newLocation)) {
			city.clearSnow(newLocation);
		} else if (city.isOffRoad(newLocation)) {
			newLocation=location.translate(newFacing);
			if (city.isOffRoad(newLocation)) {
				reportMoveError();
		    	return false;
		    } else if (city.isSnowed(newLocation)) {
				city.clearSnow(newLocation);
			}
			facing=newFacing;
		}
		//System.out.println("Leftsnowplow cleared during move");
		location = newLocation;
		return true;
	}
	//turn left
	public Direction Turn(Direction facing) {
		switch (facing){
		case NORTH: return Direction.WEST;
		case SOUTH: return Direction.EAST;
		case EAST:  return Direction.NORTH;
		case WEST:  return Direction.SOUTH;
		default: break;
		}
		return null;
	}
	public String toString(){
		return "LeftSnowPlow "+location;
	}

}
