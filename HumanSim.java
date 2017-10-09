package edu.brandeis.cs12b.pa4;

import java.io.File;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.HumanSimResponses;
import edu.brandeis.cs12b.pa4.provided.Point;

public class HumanSim extends Simulator {
	
    protected static City city;
    protected static int[][] layout;
    final static int convertNum =48;
    
	private static Scanner console;
	public HumanSim(City city) {
		super(city);
		// TODO Auto-generated constructor stub
	}
    
	public HumanSim() {
		// TODO Auto-generated constructor stub
		this(createCity(loadfile()));
//		this.city=createCity(loadfile());
//		this.start();
		
		boolean valid =true;
		do {
			System.out.println(HumanSimResponses.PROMPT_FOR_MOVE);
			valid=action (console.nextLine());
		} while (valid);
	}
	//create 2d array City with the file provided 
	public static City createCity (Scanner cityReader) {
		int y = cityReader.nextInt();
		int x = cityReader.nextInt();
		layout = new int[x][y];
		int j=0;
		String line = cityReader.nextLine();
		StringBuilder display = new StringBuilder();
		while (cityReader.hasNextLine()) {
			line = cityReader.nextLine();
			display.append(line+"\n");
			for (int i=0; i<y ;i++) {
				layout[j][i]=line.charAt(i)-convertNum;
			}
			j++;		
		}
		city = new City(layout);
		System.out.println(HumanSimResponses.CITY_LOADED);
		System.out.println(display);
		return city;
	}
	
	public static void start() {
		System.out.println(HumanSimResponses.START_SIMULATION);
//		createCity(loadfile());
	}

	/**
	 * This method loads a city from a file given by a user's input
	 * since this code handles FileNotFound exceptions, you can use it as is.
	 * You may also modify it however you like
	 */
	private static Scanner loadfile(){
		start();
		System.out.println(HumanSimResponses.LOAD_CITY);
		Scanner cityReader;
		console = new Scanner(System.in);
		while(true){ //This while loop continues until the method returns.
			try { //Attempt to read file. If file not found, go to catch block
				cityReader = new Scanner(new File(console.nextLine()));
				return cityReader; //return the scanner for use elsewhere
			} catch (FileNotFoundException e) {
				//If file was not found, print out error, and go back to the while loop
				System.out.println(HumanSimResponses.INVALID_FILE);
			}
		}
	}
	public boolean action (String input) {
		if (input.length()<4) {
			System.out.println(HumanSimResponses.INVALID_COMMAND);
			return true;
		}
		switch (input.substring(0, 4)) {
		case "list": list();
		break;
		case "step": step();
		break; 
		case "plac": place(input);
		break;
		case "exit": exit();
		return false;
		default: System.out.println(HumanSimResponses.INVALID_COMMAND);
		break;
		}
		return true;
	}
	/**
	 * list will print out vehicle type and location
	 */
	public void list () {
		for (Vehicle v:vList) {
			System.out.println(v);
		}
		
	}
	/**
	 * 
	 */
	public void step () {
		for (Vehicle v:vList) {
			if (v.toString().substring(0, 8).equals("HumanCar")) {
				System.out.println(HumanSimResponses.HUMAN_CAR);
				String input = console.nextLine();
				while (!Direction.isValidDirection(input)) {
					System.out.println(HumanSimResponses.INVALID_DIRECTION);
					System.out.println(HumanSimResponses.HUMAN_CAR);
					input = console.nextLine();
				}
				//Direction d= turnStringToDirection(input);
				v.setDirection(turnStringToDirection(input));
			}
			if (!(v.move())) {
				removedList.add(v);
			}
		}
		vList.removeAll(removedList);
		
		//super.step(1);
		//vList.removeAll(removedList);
		printCity();
	}
	
    public Direction turnStringToDirection (String s) {
    	Direction facing = null;
    	switch (s) {
    	case "SOUTH": facing = Direction.SOUTH;
    	break;
    	case "NORTH": facing = Direction.NORTH;
    	break;
    	case "EAST": facing = Direction.EAST;
    	break;
    	case "WEST": facing = Direction.WEST;
    	break;
    	default: break;
    	}
    	return facing;
    }
	
	public void printCity(){
		String[][] display2 = new String[layout.length][];
		for(int index = 0; index < layout.length; index++) {
			display2[index] = new String[layout[index].length];
			for(int subIndex = 0; subIndex < layout[index].length; subIndex++){
				display2[index][subIndex] = Integer.toString(layout[index][subIndex]);
			}
		}
		int x,y;
		for (Vehicle v:vList) {
			y = v.location.x;
			x = v.location.y;
			display2[x][y] = "*";
		}
		for (int index = 0; index < display2.length; index++) {
			for (int subIndex = 0; subIndex < layout[index].length; subIndex++) {
				System.out.print(display2[index][subIndex]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * overload/override place method
	 * @param input
	 * @return
	 */
    public boolean place (String input) {
    	String[] words=input.split("\\s");
    	//the pattern has to be "place validVehicle (int,int) potentialEnum"
    	if (words.length == 4) {
    		if (words[0].equals("place") && Vehicle.isValidVehicle(words[1]) && Direction.isValidDirection(words[3]) && isValidLocation(words[2])) {
    			Vehicle v = turnStringToVehicle(words[1]);
    			//System.out.println(words[2].charAt(1));
    			if (words[2].charAt(1)=='-' || words[2].charAt(4)=='-') {
    				v.reportPlaceError();
    				System.out.println(HumanSimResponses.INVALID_PLACE);
    				return false;
    			}
    			Point location = new Point ((int)words[2].charAt(1)-convertNum,(int)words[2].charAt(3)-convertNum);
    			//Direction facing = Vehicle.turnStringToDirection(words[3]);
    			Direction facing = turnStringToDirection(words[3]);
    			if (super.placeVehicle(v, location, facing))
    			{
    				//super.placeVehicle(v, location, facing);
    				System.out.println(HumanSimResponses.CONFIRM_PLACE);
        			return true;
    			}
    		}
    	}
    	System.out.println(HumanSimResponses.INVALID_PLACE);
    	return false;
    }

    
    /**
     * turn valid car type String into responding vehicle type
     * @param s
     * @return
     */
    public Vehicle turnStringToVehicle (String s) {
    	Vehicle v = null;
    	switch (s) {
    	case "Car": v=new Car();
    	break;
    	case "SnowPlow": v=new SnowPlow();
    	break;
    	case "LeftSnowPlow": v=new LeftSnowPlow();
    	break;
    	case "RightSnowPlow": v=new RightSnowPlow();
    	break;
    	case "HumanCar": v=new HumanCar();
    	break;
    	default: break;
    	}
    	return v;
    }
    
    /**
     * if the pattern matches (int,int), then it is a valid location
     * @param loc
     * @return
     */
    public boolean isValidLocation(String loc) {
    	if (loc.length()==5 && loc.charAt(0)=='(' && Character.isDigit(loc.charAt(1)) && loc.charAt(2)==',' && Character.isDigit(loc.charAt(3)) && loc.charAt(4)==')') {
    		return true;
    	} else if (loc.length()==7 && loc.charAt(0)=='(' && Character.isDigit(loc.charAt(2)) && loc.charAt(3)==',' && Character.isDigit(loc.charAt(5)) && loc.charAt(6)==')') {
    		return true;
    	}
    	System.out.println(HumanSimResponses.INVALID_PLACE);
    	return false;
    }
    
    /**
     * print out exit line and return false
     */
    public void exit () {
    	System.out.println(HumanSimResponses.END_SIMULATION);
    }
}
