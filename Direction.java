package edu.brandeis.cs12b.pa4.provided;


/*
 * DON'T CHANGE THIS ENUM
 */

public enum Direction {
	NORTH,SOUTH,EAST,WEST;
	
	/**
	 * Tests to see if a string can be cast to a direction.
	 * Use Direction.valueof(STRING) to get a Direction object from a string
	 * after checking it here
	 * @param potentialEnum string to be tested
	 * @return true if a valid Direction, false otherwise
	 */
	public static boolean isValidDirection(String potentialEnum){
		try {
			Direction.valueOf(potentialEnum);
		} catch (Exception e){
			//System.out.println(HumanSimResponses.INVALID_DIRECTION);
			return false;
		}
		return true;
	}
}


