package com.sapient.teamstanding.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.teamstanding.exception.CountryNotFoundException;
import com.sapient.teamstanding.exception.StandingNotFoundException;
import com.sapient.teamstanding.model.Country;
import com.sapient.teamstanding.model.League;
import com.sapient.teamstanding.model.Standing;
import com.sapient.teamstanding.util.TeamStandingConstants;

@Service
public class TeamStandingService {
	Logger log =LoggerFactory.getLogger(TeamStandingService.class);
	
	@Value("${country.service.url}")
	private String countryServiceURL;
	
	@Value("${league.service.url}")
	private String leagueServiceURL;
	
	@Value("${apiKey}")
	private String apiKey;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper mapper;
	
	/**
	 * Searching by search criteria
	 * @param searchBy
	 * @param value
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 */
	public List<Standing> getTeamStanding(String countryName) throws Exception {
		List<Standing> standingList = new ArrayList<>();
		Optional<Country> country = getCountry(countryName);
		List<League> leagues = getLeague(country.get().getCountry_id());
		leagues.stream().forEach(l->{
			try {
				getStanding(l.getLeague_id(),standingList);
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
				
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		});
		return standingList;
	}	
	/**
	 * 
	 * @param countryName
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	private Optional<Country> getCountry(String countryName) throws JsonMappingException, JsonProcessingException {
		String response = restTemplate.getForObject(URI.create(constructURL(TeamStandingConstants.GET_COUNTRIES)),String.class);
		List<Country> countries = mapper.readValue(response, new TypeReference<List<Country>>() {});
		return countries
		.stream()
		.filter((s)->countryName.equalsIgnoreCase(s.getCountry_name()))
		.findFirst();
	}
	/**
	 * 
	 * @param country_id
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	private List<League> getLeague(String country_id) throws JsonMappingException, JsonProcessingException {
		//https://apiv2.apifootball.com/?action=get_leagues&country_id=41&APIkey=xxxxxxxxxxxxxx
		String uri = constructURL(TeamStandingConstants.GET_LEAGUES.concat(TeamStandingConstants.COUNTRY_ID).concat(country_id));
		String response = restTemplate.getForObject(URI.create(uri),String.class);
		List<League> leagues = mapper.readValue(response, new TypeReference<List<League>>() {});
		return leagues;
	}
	
	private List<Standing> getStanding(String league_id, List<Standing> standings) throws JsonMappingException, JsonProcessingException {
		//https://apiv2.apifootball.com/?action=get_standings&league_id=148&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978
		String uri = constructURL(TeamStandingConstants.GET_STANDINGS.concat(TeamStandingConstants.LEAGUE_ID).concat(league_id));
		String response = restTemplate.getForObject(URI.create(uri),String.class);
		standings.addAll(mapper.readValue(response, new TypeReference<List<Standing>>() {}));
		return standings;
	}
	
	
	private String constructURL(String entityContext) {
		String url = countryServiceURL.
				concat(TeamStandingConstants.ACTION)
				.concat(entityContext)
				.concat(TeamStandingConstants.APIKEY).
				concat(apiKey);
		return url;		
	}
	
	private void defaultFallBack() {
		
	}
	
}
