package com.kodakandla;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping( value = "/getProps",  method = RequestMethod.GET)
	public ResponseEntity<?> whoami() {
		
		Map<String, String> map = new HashMap<>();
		map.put("propOne", propOne);
		map.put("propTwo", propTwo);
		map.put("propThree", propThree);
		
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	@Value("${test.prop.one}")
	private String propOne;
	
	@Value("${test.prop.two}")
	private String propTwo;
	
	@Value("${test.prop.three}")
	private String propThree;
}
