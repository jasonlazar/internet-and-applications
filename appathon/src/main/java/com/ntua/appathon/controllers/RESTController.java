package com.ntua.appathon.controllers;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntua.appathon.models.Distribution;
import com.ntua.appathon.services.services;

@RestController
@RequestMapping("/api")
public class RESTController {

	private final services myservices;
	
	@Autowired
	public RESTController(services serv) {
		myservices = serv;
	}
	
	@GetMapping(value="/municipalities/{district}", produces = "application/json")
	public ResponseEntity<String> municipalities(@PathVariable("district") String district) {
		JSONObject obj =  new JSONObject();
		List<String> l = myservices.getMunicipalities(district);
		obj.put("result", l);
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}
	
	@GetMapping(value="/distribution/{district}/total", produces = "application/json")
	public ResponseEntity<String> totalDist(@PathVariable("district") String district) {
		JSONObject obj =  new JSONObject();
		Distribution dist = myservices.getTotalDist(district);
		obj.put("men", dist.getMen());
		obj.put("women", dist.getWomen());
		obj.put("total", dist.getTotal());
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}
	
	@GetMapping(value="/distribution/{district}/{municipality}", produces = "application/json")
	public ResponseEntity<String> distribution(@PathVariable("district") String district,
			@PathVariable("municipality") String municipality) {
		JSONObject obj =  new JSONObject();
		Distribution dist = myservices.getDist(district, municipality);
		obj.put("men", dist.getMen());
		obj.put("women", dist.getWomen());
		obj.put("total", dist.getTotal());
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}
}
