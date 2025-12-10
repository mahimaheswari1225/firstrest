package com.tcs.boot.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/rest/service")
public class HelloController {
	@GetMapping("/test")
	public String confirm() {
		return "connected";
	}
}
