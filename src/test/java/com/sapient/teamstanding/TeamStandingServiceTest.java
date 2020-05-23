package com.sapient.teamstanding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.teamstanding.service.TeamStandingService;

@RunWith(SpringRunner.class)
public class TeamStandingServiceTest {

	@Autowired
	TeamStandingService service;
	
	@Test
	public void givenCountryNameReturnsStandings() {
		
	}
}
