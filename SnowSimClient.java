package edu.brandeis.cs12b.pa4;

import static org.junit.Assert.assertTrue;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.HumanSimResponses;
import edu.brandeis.cs12b.pa4.provided.Point;
import edu.brandeis.cs12b.pa4.provided.VehicleError;

public class SnowSimClient {
	private static final String newLine = System.getProperty("line.separator");

	public static void main(String[] args) throws Exception{
		/*
		 *  You may use this class as your main method if you want. This class will not be
		 *  graded by automated tests, but you should share it with your TA when you have your
		 *  grading meeting
		 */
		City straightLineSnowed = new City(new int[][]{
			{0,1,2},
			{1,1,0},
			{0,1,1},
			{0,1,1},
			{0,1,1},
			{0,1,1},
			{0,1,0},
			{0,0,0},
		});
		City straightLineCleared = new City(new int[][]{
			{0,0,0},
			{0,2,0},
			{0,2,0},
			{0,2,0},
			{0,2,0},
			{0,2,0},
			{0,2,0},
			{0,0,0},
		});
		City elbowSnowed = new City(new int[][]{
			{0,0,0,0,0,0},
			{0,0,1,0,0,0},
			{0,0,1,0,0,0},
			{0,0,1,0,0,0},
			{0,0,1,0,0,0},
			{0,0,1,0,0,0},
			{0,0,1,1,0,0},
			{0,0,0,0,0,0},
		});
		City city = new City(new int[][]{
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,0,0,1,1,0,0},
			{0,0,0,1,0,0,0,1,0,0},
			{0,0,0,1,1,1,1,1,0,0},
			{0,1,1,1,0,0,0,0,0,0},
			{0,0,0,1,1,1,1,1,1,0},
			{0,0,0,1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0}});
		HumanSim sim = new HumanSim();

		
//		Simulator sim = new Simulator(city);
//		LeftSnowPlow leftSnowPlow = new LeftSnowPlow();
//		System.out.println(leftSnowPlow.facing);
//		sim.placeVehicle(leftSnowPlow, new Point(8, 5), Direction.WEST);
//		System.out.println(leftSnowPlow.facing);
//		SnowPlow snowPlow = new SnowPlow();
//		System.out.println(snowPlow.facing);
//		sim.placeVehicle(snowPlow, new Point(1,4), Direction.EAST);
//		System.out.println(snowPlow.facing);
//		RightSnowPlow rightSnowPlow = new RightSnowPlow();
//		sim.placeVehicle(rightSnowPlow, new Point(6,1), Direction.EAST);
//		sim.step(9);

		//System.out.println(sim.isClear());
	}

}
