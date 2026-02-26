package br.com.jonatashub.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonatashub.config.GreetingConfiguration;
import br.com.jonatashub.model.Greeting;

@RestController
public class GreetingController {

	private static final String template = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private GreetingConfiguration configuration;

	// http://localhost:8080/greeting?name=Leandro
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
		if (name.isEmpty())
			name = configuration.defaultValue();
		return new Greeting(counter.incrementAndGet(), String.format(template, configuration.greeting(), name));
	}
}
