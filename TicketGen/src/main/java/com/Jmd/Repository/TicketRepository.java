package com.Jmd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jmd.Model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
