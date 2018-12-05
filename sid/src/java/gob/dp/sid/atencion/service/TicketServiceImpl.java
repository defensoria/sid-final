/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.service;

import gob.dp.sid.atencion.bean.FiltroTicket;
import gob.dp.sid.atencion.dao.TicketDAO;
import gob.dp.sid.atencion.entity.AtencionTicket;
import gob.dp.sid.atencion.entity.Ticket;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JCARRILLO
 */

@Service
public class TicketServiceImpl implements TicketService {
    
    @Autowired 
    private TicketDAO ticketDAO;

    @Override
    public void registrarTicket(Ticket ticket) {
        ticketDAO.insertarTicket(ticket);
    }
    
    @Override
    public String obtenerCodigoTicket(Map<String,Object> params) {
        return ticketDAO.obtenerCodigoTicket(params);
    }
    
    @Override
    public Ticket obtenerTicketAtencion(FiltroTicket filtroTicket) {
        return ticketDAO.obtenerTicketAtencion(filtroTicket);
    }
    
    @Override
    public AtencionTicket obtenerDatosAtencionTicket(Long idTicket) {
        return ticketDAO.obtenerDatosAtencionTicket(idTicket);
    }
    
    @Override
    public void actualizarEstadoTicket(Ticket ticket) {
        ticketDAO.actualizarEstadoTicket(ticket);
    }
    
    @Override
    public void registrarAtencionTicket(AtencionTicket atencionTicket) {
        ticketDAO.insertarAtencionTicket(atencionTicket);
    }
    
    @Override
    public void actualizarFechaFinAtencionTicket(AtencionTicket atencionTicket) {
        ticketDAO.actualizarFechaFinAtencionTicket(atencionTicket);
    }
}
