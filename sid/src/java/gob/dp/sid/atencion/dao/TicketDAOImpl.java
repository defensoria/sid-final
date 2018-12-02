/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.bean.FiltroTicket;
import gob.dp.sid.atencion.entity.Ticket;
import java.util.Map;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JMATOS
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
}
