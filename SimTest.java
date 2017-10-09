package edu.brandeis.cs12b.pa4.tests;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.brandeis.cs12b.pa4.Car;
import edu.brandeis.cs12b.pa4.Simulator;
import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.Point;

public class SimTest {
	
	private PrintStream sysOut;
	private ByteArrayOutputStream outContent;
	private static final String newLine = System.getProperty("line.separator");
	
	private City straightLineSnowed;
	private City straightLineCleared;
	private City elbowSnowed;
	
	@Before
	public void setUp() throws Exception {
		sysOut = System.out;
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		//HERE ARE SOME STOCK CITIES FOR YOU TO USE ON YOUR TESTS
		straightLineSnowed = new City(new int[][]{
			{0,0,0},
			{0,1,0},
			{0,1,0},
			{0,1,0},
			{0,1,0},
			{0,1,0},
			{0,1,0},
			{0,0,0},
		});
		straightLineCleared = new City(new int[][]{
			{0,0,0},
			{0,2,0},
			{0,2,0},
			{0,2,0},
			{0,2,0},
			{0,2,0},
			{0,2,0},
			{0,0,0},
		});
		elbowSnowed = new City(new int[][]{
	        {0,0,0,0,0,0},
			{0,0,1,0,0,0},
			{0,0,1,0,0,0},
			{0,0,1,0,0,0},
			{0,0,1,0,0,0},
			{0,0,1,0,0,0},
			{0,0,1,1,0,0},
			{0,0,0,0,0,0},
		});
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(sysOut);
	}
	
	@Test
	public void testClearedCity() {
		Simulator sim = new Simulator(straightLineCleared);
		assertTrue(sim.isClear());
	}
	
	@Test
	public void testSnowedCity() {
		Simulator sim = new Simulator(straightLineSnowed);
		assertFalse(sim.isClear());
	}
}