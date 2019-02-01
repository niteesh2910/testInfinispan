package com.test.mohit.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.niteesh.entity.ApplicationProperty;
import com.test.niteesh.service.CacheService;
import com.test.niteesh.service.InfiniService;

@Controller
@RequestMapping("/cache")
public class CacheController {
	
	private static final Logger logger = Logger.getLogger(CacheController.class);
	
	@Autowired
	private CacheService cacheService;
	
	@Autowired
	private InfiniService infiniService;
	
	@GetMapping
	public ResponseEntity<List<ApplicationProperty>> getAll() {
		logger.info("InfiniController.getAll called........" );
		List<ApplicationProperty> allProps = infiniService.getAllProps("test");
		logger.info("InfiniController.getAll exit.........");
		return new ResponseEntity<>(allProps, HttpStatus.OK);
	}
//	@GetMapping
//	public ResponseEntity<List<ApplicationProperty>> getAll() {
//		logger.info("InfiniController.getAll called........" );
//		List<ApplicationProperty> allProps = cacheService.getAllProps("test");
//		logger.info("InfiniController.getAll exit.........");
//		return new ResponseEntity<>(allProps, HttpStatus.OK);
//	}
}