/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.service;

import gob.dp.sid.atencion.entity.Ciudadano;
import gob.dp.sid.atencion.bean.FiltroPersona;

/**
 *
 * @author JMATOS
 */
public interface PersonaCiudadanoService {
    public Ciudadano buscarDatosCiudadanoByDNI(FiltroPersona filtroPersona);
    public Ciudadano registrarCiudadano(Ciudadano ciudadano);
}
