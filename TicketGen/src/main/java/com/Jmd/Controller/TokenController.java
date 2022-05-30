package com.Jmd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Jmd.Model.Ticket;

import com.Jmd.Service.TicketService;
import com.Jmd.Service.kafkaService;

@RestController
@RequestMapping("/token")
public class TokenController {

	@Autowired
	private TicketService tService;

	@Autowired
	public kafkaService kService;

	@PostMapping("/createtoken")
	public String create(@RequestBody Ticket user) {
		tService.save(user);
		kService.Produce(user);
		return "saved";
	}

	@GetMapping("/getByText/{text}")
	public void getDesByText(@RequestParam("text") String text) {
		kService.getByText(text);
	}

}
