/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.entity.VisitaCiudadano;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JMATOS
 */

@Repository
public class VisitaDAOImpl extends SqlSessionDaoSupport implements VisitaDAO {

    @Override
    public void insertarVisita(VisitaCiudadano visita) {
        getSqlSession().insert("gob.dp.sid.atencion.dao.VisitaDAO.visitaInsertar", visita);
        System.out.println("ID INSERTADO: " + visita.getId());
    }

    @Override
    public VisitaCiudadano insertarVisitaObject(VisitaCiudadano visitaCiudadano) {
        getSqlSession().insert("gob.dp.sid.atencion.dao.VisitaDAO.visitaInsertar", visitaCiudadano);
        return visitaCiudadano;
    }
    
}
