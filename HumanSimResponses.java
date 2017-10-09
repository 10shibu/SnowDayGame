package edu.brandeis.cs12b.pa4.provided;

public enum HumanSimResponses {
	START_SIMULATION("Simulation Ready"),
	LOAD_CITY("Load City:"),
	CITY_LOADED("City Loaded"),
	PROMPT_FOR_MOVE("What move would you like to make?"),
	CONFIRM_PLACE("Placement successful"),
	MAKING_STEP("Making Step..."),
	HUMAN_CAR("Directions for HumanCar?"),
	END_SIMULATION("Goodbye"),
	
	INVALID_COMMAND("Invalid command. Try something else."),
	INVALID_FILE("Invalid file. Try something else."),
	INVALID_PLACE("Place failed. Try something else."),
	INVALID_VEHICLE("Invalid Vehicle. Try something else."),
	INVALID_DIRECTION("Invalid Directions, Try something else.");
	
	
	private final String response;
	
	private HumanSimResponses(String response){
        this.response = response;
    }
	
	public String toString(){
		return this.response;
	}
}
