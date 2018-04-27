package com.mrathena.spring.kafka.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@RequestMapping("index")
	public String sendKafka(String string) {
		System.out.println(string);
		ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("mrathena", string);
		try {
			System.out.println(result.get().toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return string;
	}

}