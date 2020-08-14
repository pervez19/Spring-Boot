package com.SpringBoot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@Value("${Coach.name}")
	public String coachName;
	@Value("${Team.name}")
	public String teamName;
	@GetMapping("/")
	public String sayHello()
	{
		return "Hello World, server time is"+ LocalDateTime.now();
	}
	@GetMapping("/teaminfo")
	public String getTeamInfo()
	{
		return "Team Name: "+teamName+"<br> Coach Name: "+coachName;
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
