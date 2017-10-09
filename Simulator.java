package edu.brandeis.cs12b.pa4;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.Point;

public class Simulator {
	
	private City city;
	protected ArrayList <Vehicle> vList;
	protected ArrayList <Vehicle> removedList;
	
	/**
	 * Creates a new simulation for a city
	 * @param city to be simulated
	 */
	public Simulator(City city){
		this.city = city;
		vList = new ArrayList<Vehicle>();
		removedList = new ArrayList<Vehicle>();
	}
	protected Simulator(){
		
	}

	/**
	 * Move all vehicles in the city
	 * @param numberOfSteps the number of times each vehicle should move
	 */
	public void step(int numberOfSteps) {

		for (int i=numberOfSteps;i>0;i--) {
			for (Vehicle v:vList) {
				if (!(v.move())) {
					removedList.add(v);
				}
			}
			vList.removeAll(removedList);
			//System.out.println(city);
		}
	}
	/**
	 * Places a Vehicle in the city
	 * @param vehicle to place in the city
	 * @param location to place the vehicle in the city
	 * @return true if vehicle is successfully placed, false if not
	 */
	public boolean placeVehicle(Vehicle vehicle, Point location, Direction facing){
		vList.add(vehicle);
		return (vehicle.place(city, location, facing));
	}
	
	/**
	 * Check to see if the Simulation's city is clear
	 * @return true if the city is clear, false if not
	 */
	public boolean isClear(){
		return this.city.isClear();
	}
	
	public String toString(){
		return this.city.toString();
	}
}
