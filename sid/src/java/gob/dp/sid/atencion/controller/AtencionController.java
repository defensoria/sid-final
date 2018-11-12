/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.controller;

import gob.dp.sid.atencion.entity.Atencion;
import gob.dp.sid.comun.controller.AbstractManagedBean;
import gob.dp.sid.registro.entity.Persona;
import java.io.Serializable;
import javax.inject.Named;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author jcarrillo
 */
@Named
@Scope("session")
public class AtencionController extends AbstractManagedBean implements Serializable {
    
    private static final Logger log = Logger.getLogger(AtencionController.class);
    
    private Atencion atencion;
    
    public String cargarInicioAtencion() {
        try {
            atencion = new Atencion();
            return "iniciarAtencion";
        } catch (Exception e) {
            log.error("ERROR - cargarInicioAtencion()" + e);
        }
        return null;
    }
    
}
