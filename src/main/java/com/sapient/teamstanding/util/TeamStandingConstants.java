package com.sapient.teamstanding.util;

public interface TeamStandingConstants {

	public static String ACTION = "?action=";
	
	public static String GET_COUNTRIES = "get_countries";
	
	public static String GET_LEAGUES = "get_leagues";
	
	public static String GET_STANDINGS = "get_standings";
	
	public static String COUNTRY_ID = "&country_id=";
	
	public static String LEAGUE_ID = "&league_id=";
	
	public static String APIKEY = "&APIkey=";
	
	public static String COUNTRY_NOT_FOUND = "C001";
	
	public static String EMPTY_STRING = "";
	
	public static String HYSTRIX_ERROR_THRESH_PERC = "circuitBreaker.errorThresholdPercentage";
	
	public static String HYSTRIX_REQUEST_VOLUME_THRESH = "circuitBreaker.requestVolumeThreshold";
	
	public static String HYSTRIX_SLEEP_WINDOW = "circuitBreaker.sleepWindowInMilliseconds";
	
}
