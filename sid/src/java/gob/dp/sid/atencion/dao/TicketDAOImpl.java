/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.bean.FiltroTicket;
import gob.dp.sid.atencion.entity.AtencionTicket;
import gob.dp.sid.atencion.entity.Ticket;
import java.util.Map;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JCARRILLO
 */

@Repository
public class TicketDAOImpl extends SqlSessionDaoSupport implements TicketDAO {

    @Override
    public void insertarTicket(Ticket ticket) {
        getSqlSession().insert("gob.dp.sid.atencion.dao.TicketDAO.ticketInsertar", ticket);
        System.out.println("ID INSERTADO: " + ticket.getIdTicket());
    }
    
    @Override
    public String obtenerCodigoTicket(Map<String,Object> params) {
        return getSqlSession().selectOne("gob.dp.sid.atencion.dao.TicketDAO.obtenerCodigoTicket", params);
    }
    
    @Override
    public Ticket obtenerTicketAtencion(FiltroTicket filtroTicket) {
        Ticket t = getSqlSession().selectOne("gob.dp.sid.atencion.dao.TicketDAO.obtenerTicketAtencion", filtroTicket);
        return t;
    }
    
    @Override
    public AtencionTicket obtenerDatosAtencionTicket(Long idTicket) {
        AtencionTicket at = getSqlSession().selectOne("gob.dp.sid.atencion.dao.TicketDAO.obtenerDatosAtencionTicket", idTicket);
        return at;
    }
    
    @Override
    public void actualizarEstadoTicket(Ticket ticket) {
        getSqlSession().insert("gob.dp.sid.atencion.dao.TicketDAO.actualizarEstadoTicket", ticket);
        System.out.println("ESTADO ACTUALIZADO: " + ticket.getIdTicket());
    }
    
    @Override
    public void insertarAtencionTicket(AtencionTicket atencionTicket) {
        getSqlSession().insert("gob.dp.sid.atencion.dao.TicketDAO.atencionTicketInsertar", atencionTicket);
        System.out.println("ID INSERTADO: " + atencionTicket.getIdAtencionTicket());
    }
    
    @Override
    public void actualizarFechaFinAtencionTicket(AtencionTicket atencionTicket) {
        getSqlSession().insert("gob.dp.sid.atencion.dao.TicketDAO.atencionTicketFechaFinUpdate", atencionTicket);
        System.out.println("ID ACTUALIZADO: " + atencionTicket.getIdAtencionTicket());
    }
}
