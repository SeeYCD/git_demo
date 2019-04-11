package com.hcrh.hibernatedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 集成了responsebody
@RequestMapping(value = "/demo")
public class DemoController {
	@GetMapping(value = "/helloWorld")
	public String helloWorld(String ss) {

		return "ok";
	}

}
