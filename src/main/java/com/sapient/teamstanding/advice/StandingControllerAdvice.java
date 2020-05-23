package com.sapient.teamstanding.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sapient.teamstanding.exception.CountryNotFoundException;
import com.sapient.teamstanding.model.ErrorModel;
import com.sapient.teamstanding.util.TeamStandingConstants;

@ControllerAdvice
public class StandingControllerAdvice {

	@ExceptionHandler(CountryNotFoundException.class)
	public ResponseEntity<?> handleCountryNotFoundException(CountryNotFoundException e){
		ErrorModel model = new ErrorModel();
		model.setErrorCode(TeamStandingConstants.COUNTRY_NOT_FOUND);
		return ResponseEntity.badRequest().body(model);
	}
	
}
