package com.sapient.teamstanding.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class League {

	private String league_id;
	private String league_name;
	private String country_id;
	private String country_name;
	/*
	 * private String league_season; private String league_logo;
	 */
	
	public League() {
		
	}
	
	public String getLeague_id() {
		return league_id;
	}
	public void setLeague_id(String league_id) {
		this.league_id = league_id;
	}
	public String getLeague_name() {
		return league_name;
	}
	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	/*
	 * public String getLeague_season() { return league_season; } public void
	 * setLeague_season(String league_season) { this.league_season = league_season;
	 * } public String getLeadgue_logo() { return league_logo; } public void
	 * setLeadgue_logo(String leadgue_logo) { this.league_logo = leadgue_logo; }
	 */
	
	
}
