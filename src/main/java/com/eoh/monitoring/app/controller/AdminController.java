package com.eoh.monitoring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eoh.monitoring.app.service.UserServices;

@RestController
@RequestMapping("/admins")
@CrossOrigin("*")
public class AdminController {
	
	@Autowired
	private UserServices userServices;
	
	//@GetMapping("/")
}
