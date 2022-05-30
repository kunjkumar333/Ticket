package com.Jmd.Service;

import com.Jmd.Model.Ticket;

public interface kafkaService {

	public void Produce(Ticket user);
	
	public void saveToElastic(Ticket user);
	
	public void getByText(String text);
}
