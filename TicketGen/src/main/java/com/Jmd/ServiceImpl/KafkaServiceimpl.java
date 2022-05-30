package com.Jmd.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

import com.Jmd.Model.Ticket;
import com.Jmd.Repository.TicketElasticRepo;
import com.Jmd.Service.kafkaService;

@Service
public class KafkaServiceimpl implements kafkaService {

	@Autowired
	public KafkaTemplate<String, Ticket> kafkaTemp;

	@Autowired
	public TicketElasticRepo tERepo;

	String KafkaTopic = "Token_micro";

	// producing data into kafka
	@Override
	public void Produce(Ticket message) {
		kafkaTemp.send(KafkaTopic, message);
	}

	@Override
	public void saveToElastic(final Ticket user) {
		tERepo.save(user);
	}

	@Override
	public void getByText(String text) {
		tERepo.findByDescriptionContaining(text);
	}

}
