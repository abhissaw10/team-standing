package com.sapient.teamstanding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.teamstanding.service.TeamStandingService;

@RestController
@RequestMapping("/standing/")
public class TeamStandingController {
	
	@Autowired
	TeamStandingService service;
	
	@GetMapping("byCountryName/{countryName}")
	public ResponseEntity<?> getTeamStanding(@PathVariable(name = "countryName",required = true) String countryName) throws Exception{
		return ResponseEntity.ok(service.getTeamStanding(countryName));
	}

}
