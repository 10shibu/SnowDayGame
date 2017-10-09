package edu.brandeis.cs12b.pa4;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.Point;
import edu.brandeis.cs12b.pa4.provided.VehicleError;

public class RightSnowPlow extends LeftSnowPlow {
	

	@Override
	public void reportPlaceError() {
		System.out.println(VehicleError.RIGHTSNOWPLOWPLACEMENT);
	}

	@Override
	public void reportMoveError() {
		System.out.println(VehicleError.RIGHTSNOWPLOWERROR);
	}
	
	//turn RIGHT
	public Direction Turn(Direction facing) {
		switch (facing){
		case NORTH: return Direction.EAST;
		case SOUTH: return Direction.WEST;
		case EAST:  return Direction.SOUTH;
		case WEST:  return Direction.NORTH;
		default: break;
		}
		return null;
	}
	public String toString(){
		return "RightSnowPlow "+location;
	}

}
