package com.mrathena.spring.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

public class SpringKafkaConsumerListener implements MessageListener<String, String> {

	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		System.out.println("消费开始");
		String topic = data.topic();
		String key = data.key();
		String value = data.value();
		long offset = data.offset();
		int partition = data.partition();
		System.out.println("topic:" + topic);
		System.out.println("value:" + value);
		System.out.println("key:" + key);
		System.out.println("offset:" + offset);
		System.out.println("partition:" + partition);
		System.out.println("消费结束");
	}

}