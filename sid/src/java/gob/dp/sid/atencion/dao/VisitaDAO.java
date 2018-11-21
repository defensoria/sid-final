/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.entity.VisitaCiudadano;

/**
 *
 * @author JMATOS
 */
public interface VisitaDAO {
    
    public void insertarVisita(VisitaCiudadano visita);
    public VisitaCiudadano insertarVisitaObject(VisitaCiudadano visitaCiudadano);
}
