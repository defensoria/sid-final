/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.bean.FiltroTicket;
import gob.dp.sid.atencion.entity.Ticket;
import java.util.Map;

/**
 *
 * @author JMATOS
 */
public interface TicketDAO {
    
    public void insertarTicket(Ticket ticket);
    
    public String obtenerCodigoTicket(Map<String,Object> params);
    
    public Ticket obtenerTicketAtencion(FiltroTicket filtroTicket);
}
