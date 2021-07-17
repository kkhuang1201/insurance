package com.accenture.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.accenture.models.TokenResponse;


@RestController
@RequestMapping("/insurance/calendars")
public class CalendarController {
	
	
	private static String apiKey = "AIzaSyCjC9MhZq8rIo7LZIhV-S6e2wPZyPP9PB8";
	
	private final static String clientID = "93285477909-r5ri296ddhhpavpbs1oinl3f4hqmh31v.apps.googleusercontent.com";
	private final static String clientSecret = "8lpyXTQD04p_6DbQCpr6Ks4P";
	private final static String calendarID = "kennyhuang1201@gmail.com" ;
	private static String code = "4/0AY0e-g7bzPOpQxooPest2wAOrs_mCfSWohVOXr6Vii3soVheoI1CC6lYFTfr0TFn9Rlk5A";
	private static String refreshToken = "1//0donHdKLVxMffCgYIARAAGA0SNwF-L9IrWzfeY0R2HCBobmYR7KCm9ML0y_65ohFdp2INznAsxXbGlLBYo8Udt5v1cCIxK9k7JCc";
	private static String accessToken;
	
	@GetMapping("/events")
	public Object list() throws Exception {

		final String url = "https://www.googleapis.com/calendar/v3/calendars/"+ calendarID 
							+ "/events?key=" + apiKey;

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders hearders = new HttpHeaders();
		
		if(accessToken!=null) {
			hearders.set("Authorization","Bearer "+ accessToken);
		}
		
		else {
			
			return "AccessToken Not Found!";
			
		}
		hearders.set("Accept", "application/json");

		HttpEntity<String> entity = new HttpEntity<>(hearders);
		
		try {
			ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
			return response.getBody();
		}catch(Exception e) {
			return e.getMessage();
		}
		

		
	}

	@GetMapping("/calendar")
	public Object getCalendar() {
		
		final String url = "https://www.googleapis.com/calendar/v3/calendars/" + calendarID + "?key=" + apiKey;
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders hearders = new HttpHeaders();
		
		if(accessToken!=null){
			hearders.set("Authorization","Bearer "+ accessToken);
		}
		else {
			return "AccessToken Not Found!";	
		}
	
		hearders.set("Accept", "application/json");

		HttpEntity<String> entity = new HttpEntity<>(hearders);
		
		try {
			
			ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
			return response.getBody();	
			
		}catch(Exception e) {
			
			return e.getMessage();
			
		}
		
	}
	
	@GetMapping("refresh-token")
	public String getToken() throws NoSuchFieldException, SecurityException{
		
		final String url = "https://accounts.google.com/o/oauth2/token";
		
		RestTemplate restTemplate = new RestTemplate();
				
		HttpHeaders hearders = new HttpHeaders();
		hearders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String,String> map = new LinkedMultiValueMap<>();  
		
		if(refreshToken==null || clientID==null || clientSecret==null ) {
			
			return "One Or More Request Parameters Not Found";
		}
		
		map.add("refresh_token",refreshToken);
		map.add("client_id", clientID);
		map.add("client_secret",clientSecret);
		map.add("grant_type", "refresh_token");
		
		try {
			
			HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map,hearders);

			ResponseEntity<TokenResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity, TokenResponse.class);
			accessToken = response.getBody().getAccess_token();
			return accessToken;
			
		}catch(Exception e) {
			
			return e.getMessage();
			
		}
		

	}
	
	@GetMapping("authentication")
	public void auth(){
		

	}

}
