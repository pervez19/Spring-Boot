package com.SpringBoot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String sayHello()
	{
		return "Hello World, server time is"+ LocalDateTime.now();
	}
	@GetMapping("/workout")
	public String getDailyWorkout()
	{
		return"Do hard or go home";
	}
	@GetMapping("/fortune")
	public String getDailyFortune()
	{
		return "Today is your lucky day";
	}
}
