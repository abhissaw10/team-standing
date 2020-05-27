package com.sapient.teamstanding.util;

public class StandingUtils {
	
	public static boolean validateInput(String countryName) {
		return TeamStandingConstants.EMPTY_STRING.equals(countryName) && countryName.matches("^[a-zA-Z]*$");
	}

}
