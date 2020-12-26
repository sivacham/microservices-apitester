package com.siva.apitester.service;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.siva.apitester.model.RequestObj;
import com.siva.apitester.model.ResponseObj;

@Service
public class ApiTesterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiTesterService.class);

	@Autowired
	RestTemplate restTemplate;

	public ResponseObj postCallApiTester(RequestObj requestObj) throws Exception {

		String url = requestObj.getBaseUrl();

		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		if (requestObj.getAuthkey() != null) {
			headers.add("Authorization", requestObj.getAuthkey());
		}

		// build the request
		HttpEntity entity = null;

		if (requestObj.getParams() != null) {
			entity = new HttpEntity<>(requestObj.getParams(), headers);
		} else {
			entity = new HttpEntity(headers);
		}

		// send POST request
		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

		// check response
		ResponseObj responseObj = new ResponseObj();
		if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
			LOGGER.trace("POST request successfull");
			responseObj.setStatus("SUCCESS");
			responseObj.setResponse(response.getBody().replaceAll("\\\\", "").replaceAll("\\r\\n", "<br>"));
		} else {
			LOGGER.trace("POST request failed");
			responseObj.setStatus("FAILED");
			responseObj.setResponse(response.getBody().replaceAll("\\\\", "").replaceAll("\\r\\n", "<br>"));
		}

		return responseObj;
	}

	public ResponseObj getCallApiTester(RequestObj requestObj) throws Exception {

		String url = requestObj.getBaseUrl();

		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		if (requestObj.getAuthkey() != null) {
			headers.add("Authorization", requestObj.getAuthkey());
		}
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		// For URL
		if (requestObj.getParams() != null) {
			builder.buildAndExpand(requestObj.getParams());
		}

		HttpEntity<?> entity = new HttpEntity<>(headers);

		// send POST request
		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				String.class);

		// check response
		ResponseObj responseObj = new ResponseObj();
		if (response.getStatusCode() == HttpStatus.OK ) {
			LOGGER.trace("GET request successfull");
			responseObj.setStatus("SUCCESS");
			responseObj.setResponse(response.getBody().replaceAll("\\\\", ""));
		} else {
			LOGGER.trace("GET request failed");
			responseObj.setStatus("FAILED");
			responseObj.setResponse(response.getBody().replaceAll("\\\\", ""));
		}

		return responseObj;
	}

}
