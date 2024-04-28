package com.edu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/testController")
@RestController
@RequiredArgsConstructor
public class TestController {

	@GetMapping("")
	public ResponseEntity<String> sayHello() {
		return ResponseEntity.ok("hello from secured endpoint");
	}

}
