package com.Jmd.Listner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.Jmd.Model.Ticket;
import com.Jmd.Service.kafkaService;



@Component
public class KafkaListner {
	
	@Autowired
	private kafkaService kService;
	
	//Consuming data from kafka
		@KafkaListener(topics = "Token_micro", groupId = "group_id")
		public void consume(Ticket message) {
         kService.saveToElastic(message);
		}

}
