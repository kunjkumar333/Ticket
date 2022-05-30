package com.Jmd.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jmd.Model.Ticket;
import com.Jmd.Repository.TicketRepository;
import com.Jmd.Service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketRepository tRepo;
	
	@Override
	public void save(Ticket message) {
		tRepo.save(message);
	}
	
	

}
