package com.verizon.apitester.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.apitester.model.RequestObj;
import com.verizon.apitester.model.ResponseObj;
import com.verizon.apitester.service.ApiTesterService;

@RestController
@RequestMapping("/api")
public class ApitesterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApitesterController.class);

	@Autowired
	ApiTesterService apiTesterService; // Service which will do all data retrieval/manipulation work

	@RequestMapping(value = "/postcall")
	public ResponseEntity<ResponseObj> makePostCall(@RequestBody RequestObj requestObj) throws Exception {
		LOGGER.info("making a POST call : {}", requestObj);
		ResponseObj responseObj = apiTesterService.postCallApiTester(requestObj);
		return ResponseEntity.ok().body(responseObj);

	}
	

	@RequestMapping(value = "/getcall")
	public ResponseEntity<ResponseObj> makeGetCall(@RequestBody RequestObj requestObj) throws Exception {
		LOGGER.info("making a POST call : {}t", requestObj);
		ResponseObj responseObj = apiTesterService.getCallApiTester(requestObj);
		return ResponseEntity.ok().body(responseObj);

	}

}
