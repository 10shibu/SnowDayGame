package edu.brandeis.cs12b.pa4.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.brandeis.cs12b.pa4.Car;
import edu.brandeis.cs12b.pa4.HumanSim;
import edu.brandeis.cs12b.pa4.Simulator;
import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.HumanSimResponses;
import edu.brandeis.cs12b.pa4.provided.Point;
import edu.brandeis.cs12b.pa4.provided.VehicleError;

public class PartTwoTests {

	private PrintStream sysOut;
	private ByteArrayOutputStream outContent;
	private static final String newLine = System.getProperty("line.separator");
	
	@Before
	public void setUp() throws Exception {
		sysOut = System.out;
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void tearDown() throws Exception {
		System.setOut(sysOut);
	}
	
	@Test
	public void HumanSimTestBasic(){
		String simulatedInput =   "validCity" + newLine
								+ "place Car (3,1) SOUTH" + newLine
								+ "exit" + newLine;
								
		
		String expectedOutput = HumanSimResponses.START_SIMULATION + newLine
							  + HumanSimResponses.LOAD_CITY + newLine
							  + HumanSimResponses.CITY_LOADED + newLine
							  + "0000000000" + newLine
							  + "0002001100" + newLine
							  + "0002000100" + newLine
							  + "0002111100" + newLine
							  + "0111000000" + newLine
							  + "0001111110" + newLine
							  + "0001000000" + newLine
							  + "0000000000" + newLine + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + HumanSimResponses.CONFIRM_PLACE + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + HumanSimResponses.END_SIMULATION + newLine;
							  

		System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
		HumanSim sim = new HumanSim();
		assertEquals(expectedOutput, outContent.toString());
		
	}
	
	@Test
	public void HumanSimTestErrors(){
		String simulatedInput =   "invalidCity" + newLine
								+ "validCity" + newLine
								+ "place Car (3,1)" + newLine
								+ "place (3,1) SOUTH" + newLine
								+ "place notAVehicle (3,1) SOUTH" + newLine
								+ "place SnowPlow (-1,-1) SOUTH" + newLine
								+ "exit" + newLine;
								
		
		String expectedOutput = HumanSimResponses.START_SIMULATION + newLine
							  + HumanSimResponses.LOAD_CITY + newLine
							  + HumanSimResponses.INVALID_FILE + newLine
							  + HumanSimResponses.CITY_LOADED + newLine
							  + "0000000000" + newLine
							  + "0002001100" + newLine
							  + "0002000100" + newLine
							  + "0002111100" + newLine
							  + "0111000000" + newLine
							  + "0001111110" + newLine
							  + "0001000000" + newLine
							  + "0000000000" + newLine + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + HumanSimResponses.INVALID_PLACE + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + HumanSimResponses.INVALID_PLACE + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + HumanSimResponses.INVALID_VEHICLE + newLine
							  + HumanSimResponses.INVALID_PLACE + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + VehicleError.SNOWPLOWPLACEMENT + newLine
							  + HumanSimResponses.INVALID_PLACE + newLine
							  
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + HumanSimResponses.END_SIMULATION + newLine;
							  

		System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
		HumanSim sim = new HumanSim();
		assertEquals(expectedOutput, outContent.toString());
		
	}
	
	
	
	@Test
	public void HumanSimTestFinal(){
		String simulatedInput =   "validCity" + newLine
								+ "place Car (3,1) SOUTH" + newLine
								+ "list" + newLine
								+ "step" + newLine
								+ "list" + newLine
								+ "step" + newLine
								+ "list" + newLine
								+ "place SnowPlow (3,1) SOUTH" + newLine
								+ "step" + newLine
								+ "place HumanCar (3,1) SOUTH" + newLine
								+ "step" + newLine
								+ "SOUTH" + newLine
								+ "step" + newLine
								+ "SOUTH" + newLine
								+ "step" + newLine
								+ "EAST" + newLine
								+ "list" + newLine
								+ "exit" + newLine;
		
		String expectedOutput = HumanSimResponses.START_SIMULATION + newLine
							  + HumanSimResponses.LOAD_CITY + newLine
							  + HumanSimResponses.CITY_LOADED + newLine
							  +  "0000000000" + newLine
							  + "0002001100" + newLine
							  + "0002000100" + newLine
							  + "0002111100" + newLine
							  + "0111000000" + newLine
							  + "0001111110" + newLine
							  + "0001000000" + newLine
							  + "0000000000" + newLine + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + HumanSimResponses.CONFIRM_PLACE + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + "Car (3,1)" + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + "0000000000" + newLine
							  + "0002001100" + newLine
							  + "000*000100" + newLine
							  + "0002111100" + newLine
							  + "0111000000" + newLine
							  + "0001111110" + newLine
							  + "0001000000" + newLine
							  + "0000000000" + newLine + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + "Car (3,2)" + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + "0000000000" + newLine
							  + "0002001100" + newLine
							  + "0002000100" + newLine
							  + "000*111100" + newLine
							  + "0111000000" + newLine
							  + "0001111110" + newLine
							  + "0001000000" + newLine
							  + "0000000000" + newLine + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + "Car (3,3)" + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + HumanSimResponses.CONFIRM_PLACE + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + VehicleError.CARERROR + newLine
							  + "0000000000" + newLine
							  + "0002001100" + newLine
							  + "000*000100" + newLine
							  + "0002111100" + newLine
							  + "0111000000" + newLine
							  + "0001111110" + newLine
							  + "0001000000" + newLine
							  + "0000000000" + newLine + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + HumanSimResponses.CONFIRM_PLACE + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + HumanSimResponses.HUMAN_CAR + newLine
							  + "0000000000" + newLine
							  + "0002001100" + newLine
							  + "000*000100" + newLine
							  + "000*111100" + newLine
							  + "0111000000" + newLine
							  + "0001111110" + newLine
							  + "0001000000" + newLine
							  + "0000000000" + newLine + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + HumanSimResponses.HUMAN_CAR + newLine
							  + "0000000000" + newLine
							  + "0002001100" + newLine
							  + "0002000100" + newLine
							  + "000*111100" + newLine
							  + "011*000000" + newLine
							  + "0001111110" + newLine
							  + "0001000000" + newLine
							  + "0000000000" + newLine + newLine						 
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + HumanSimResponses.HUMAN_CAR + newLine
							  + VehicleError.HUMANCARERROR + newLine
							  + "0000000000" + newLine
							  + "0002001100" + newLine
							  + "0002000100" + newLine
							  + "0002111100" + newLine
							  + "0112000000" + newLine
							  + "000*111110" + newLine
							  + "0001000000" + newLine
							  + "0000000000" + newLine + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + "SnowPlow (3,5)" + newLine
							  + HumanSimResponses.PROMPT_FOR_MOVE + newLine
							  + HumanSimResponses.END_SIMULATION + newLine;

		System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
		HumanSim sim = new HumanSim();
		assertEquals(expectedOutput, outContent.toString());
		
	}
}
