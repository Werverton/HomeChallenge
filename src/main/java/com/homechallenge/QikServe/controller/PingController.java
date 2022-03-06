package com.homechallenge.QikServe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {

	@GetMapping
	public String ping() {

		String text = "Api de produtos! UP! 1.0.1 ";
		System.out.println(text);
		return text;

	}

}