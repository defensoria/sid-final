/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.entity.Ciudadano;
import gob.dp.sid.atencion.bean.FiltroPersona;

/**
 *
 * @author JMATOS
 */
public interface CiudadanoDAO {
    public Ciudadano obtenerDatosPersonaByDni(FiltroPersona filtroPersona);
    public Ciudadano insertarDatosCiudadano(Ciudadano ciudadano);
}
