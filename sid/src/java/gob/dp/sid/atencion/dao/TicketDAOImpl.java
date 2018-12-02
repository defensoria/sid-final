/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.entity.Ticket;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JMATOS
 */

@Repository
public class TicketDAOImpl extends SqlSessionDaoSupport implements TicketDAO {

    @Override
    public void insertarVisita(Ticket ticket) {
        getSqlSession().insert("gob.dp.sid.atencion.dao.TicketDAO.ticketInsertar", ticket);
        System.out.println("ID INSERTADO: " + ticket.getIdTicket());
    }
    
}
