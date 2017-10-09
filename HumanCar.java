package edu.brandeis.cs12b.pa4;

import java.util.Scanner;

import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.HumanSimResponses;
import edu.brandeis.cs12b.pa4.provided.Point;
import edu.brandeis.cs12b.pa4.provided.VehicleError;

public class HumanCar extends Car {
	@Override
	public void reportPlaceError() {
		System.out.println(VehicleError.HUMANCARPLACEMENT);
	}

	@Override
	public void reportMoveError() {
		System.out.println(VehicleError.HUMANCARERROR);
	}
	//TODO finish this
	public  void setDirection(Direction direction) {
		facing =direction;
	}
	
	public String toString(){
		return "HumanCar "+location;
	}

}
