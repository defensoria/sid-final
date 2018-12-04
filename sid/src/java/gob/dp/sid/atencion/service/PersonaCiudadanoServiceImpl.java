/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.service;

import gob.dp.sid.atencion.entity.Ciudadano;
import gob.dp.sid.atencion.bean.FiltroPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gob.dp.sid.atencion.dao.CiudadanoDAO;

/**
 *
 * @author JMATOS
 */
@Service("ciudadanoServie")
public class PersonaCiudadanoServiceImpl implements  PersonaCiudadanoService {

    @Autowired
    private CiudadanoDAO ciudadanoDAO;
    
    @Override
    public Ciudadano buscarDatosCiudadanoByDNI(FiltroPersona filtroPersona) {
        return ciudadanoDAO.obtenerDatosPersonaByDni(filtroPersona);
    }

    @Override
    public Ciudadano registrarCiudadano(Ciudadano ciudadano) {
        return ciudadanoDAO.insertarDatosCiudadano(ciudadano);
    }
    
}
