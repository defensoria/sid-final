/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.service;

import gob.dp.sid.atencion.entity.Ticket;

/**
 *
 * @author JMATOS
 */
public interface TicketService {
    
    public void registrarTicket(Ticket ticket);
    
    public String obtenerCodigoTicket(Ticket ticket);
}
