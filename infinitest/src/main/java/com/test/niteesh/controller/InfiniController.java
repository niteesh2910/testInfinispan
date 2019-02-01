package com.test.niteesh.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.niteesh.entity.ApplicationProperty;
import com.test.niteesh.service.InfiniService;

@Controller
@RequestMapping("/infini")
public class InfiniController {

	private static final Logger logger = Logger.getLogger(InfiniController.class);
	
	@Autowired
	private InfiniService infiniService;
	
	@GetMapping
	public ResponseEntity<List<ApplicationProperty>> getAll() {
		logger.info("InfiniController.getAll called........" );
		List<ApplicationProperty> allProps = infiniService.getAllProps("test");
		logger.info("InfiniController.getAll exit.........");
		return new ResponseEntity<>(allProps, HttpStatus.OK);
	}
}
