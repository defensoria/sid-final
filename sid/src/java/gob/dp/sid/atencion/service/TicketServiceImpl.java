/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.service;

import gob.dp.sid.atencion.dao.TicketDAO;
import gob.dp.sid.atencion.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JMATOS
 */

@Service
public class TicketServiceImpl implements TicketService {
    
    @Autowired 
    private TicketDAO ticketDAO;

    @Override
    public void registrarTicket(Ticket ticket) {
        ticketDAO.insertarVisita(ticket);
    }
    
    @Override
    public String obtenerCodigoTicket(Ticket ticket) {
        return ticketDAO.obtenerCodigoTicket(ticket);
    }
}
