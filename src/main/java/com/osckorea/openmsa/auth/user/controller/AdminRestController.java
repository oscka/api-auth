package com.osckorea.openmsa.auth.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RequiredArgsConstructor
@RestController
public class AdminRestController {
	@GetMapping("/hello")
	public String hello() throws Exception {
		log.info("==========simple-api hello world");
		return "hello world!!!";

	}

	@GetMapping("/version")
	public String version() {
		log.info("version 1.0");
		return "=====  version 1.0";

	}

}
