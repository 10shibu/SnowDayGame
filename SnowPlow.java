package edu.brandeis.cs12b.pa4;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.Point;
import edu.brandeis.cs12b.pa4.provided.VehicleError;

public class SnowPlow extends Vehicle {
	

	@Override
	public void reportPlaceError() {
		System.out.println(VehicleError.SNOWPLOWPLACEMENT);
	}

	@Override
	public void reportMoveError() {
		System.out.println(VehicleError.SNOWPLOWERROR);
	}
	//
	@Override
	public boolean place(City city, Point location, Direction facing) {
		//snowplows are not allowed to be placed on SNOWEDROAD or OFFROAD tiles or out of city
		if (super.place(city, location, facing)){
			if (city.isSnowed(location)) {
				city.clearSnow(location);	
			}
			//System.out.println("snowplow placed");
			return true;
		}
		return false;
		
	}
	@Override
	//
	public boolean move() {
		if (super.move()) {
			if (city.isSnowed(location.translate(facing))) {
				location = location.translate(facing);
				city.clearSnow(location);
				//System.out.println("snowplow cleared during move");
				return true;
			}
			location = location.translate(facing);
			return true;
		} 
		return false;
	}
	public String toString(){
		return "SnowPlow "+location;
	}

}
