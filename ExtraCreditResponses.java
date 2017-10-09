package edu.brandeis.cs12b.pa4.provided;

public enum ExtraCreditResponses {
	CAR_HONK("CAR HONK"),
	SNOW_PLOW_HONK("SNOW PLOW HONK"),
	
	PATHING_CAR_WAITING("PATHING CAR WAITING FOR ROADS TO BE CLEARED"),
	PATHING_CAR_FAIL("PATHING CAR CANNOT POSSIBLY REACH DESTINATION"),
	PATHING_CAR_PLACEMENT("ERROR: PATHING CAR FAILED TO BE PLACED")
	;
	
	private final String response;
	
	private ExtraCreditResponses(String response){
        this.response = response;
    }
	
	public String toString(){
		return this.response;
	}
}
