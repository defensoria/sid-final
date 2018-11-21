/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.service;

import gob.dp.sid.atencion.dao.VisitaDAO;
import gob.dp.sid.atencion.entity.VisitaCiudadano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JMATOS
 */

@Service
public class VisitaServiceImpl implements VisitaService {
    
    @Autowired 
    private VisitaDAO visitaDAO;

    @Override
    public void registrarVisita(VisitaCiudadano visita) {
        visitaDAO.insertarVisita(visita);
    }

    @Override
    public VisitaCiudadano registrarVisitaObject(VisitaCiudadano visita) {
        return visitaDAO.insertarVisitaObject(visita);
    }
    
    
}
