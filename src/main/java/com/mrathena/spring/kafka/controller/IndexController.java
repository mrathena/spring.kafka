package com.mrathena.spring.kafka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping("index")
	public String sendKafka(String string) {
		System.out.println(string);
		return string;
	}

}