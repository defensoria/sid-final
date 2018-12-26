/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.registro.service;

import gob.dp.sid.registro.entity.MovilPersona;

/**
 *
 * @author JMATOS
 */
public interface MovilPersonaService {
    
    public void movilPersonaRegistro(MovilPersona movilPersona);
    public MovilPersona movilPersonaBuscarId(Long id);
    
}
