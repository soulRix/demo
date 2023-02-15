package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Greeting
@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	//Create a variable to store Reference to component
	private GreetingComponent gc;
	
	//define a constructor
	//Inject/initialize component in the constructor
	@Autowired
	public GreetingController(GreetingComponent gc) {
		this.gc = gc;
	}
	
	//Define a method to call component's methods
	@GetMapping("/testgc")
	public ResponseEntity<String> getMessage(){
		return ResponseEntity.ok(gc.getMessage());
	}
	
	//Define the Service's method
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
