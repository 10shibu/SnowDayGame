package edu.brandeis.cs12b.pa4;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.Point;
import edu.brandeis.cs12b.pa4.provided.VehicleError;

public class Car extends Vehicle {

	@Override
	public void reportPlaceError() {
		System.out.println(VehicleError.CARPLACEMENT);
	}

	@Override
	public void reportMoveError() {
		System.out.println(VehicleError.CARERROR);
	}

	/**
	 * If you need to modify the behavior of your default place method for your Car, you can
	 * do it here
	 * 
	 */
//	@Override
	public boolean place(City city, Point location, Direction facing) {
		//Cars are not allowed to be placed on SNOWEDROAD or OFFROAD tiles or out of city
		super.place(city, location, facing);
		if (city.isSnowed(location)){
			reportPlaceError();
			return false;
		}
		return true;
		
	}
	
	/**
	 * If you need to modify the behavior of your default Move method for your car, you can
	 * do it here
	 * 
	 */
//	@Override
	public boolean move() {
		if (super.move()) {
			this.location = location.translate(facing);
			if (!(city.isSnowed(location))) {	
				return true;
			}
			reportMoveError();	
		}	
		return false;
	}
	public String toString(){
		return "Car "+location;
	}

}
