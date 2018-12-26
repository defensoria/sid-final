/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.registro.service;

import gob.dp.sid.registro.dao.MovilPersonaDAO;
import gob.dp.sid.registro.entity.MovilPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JMATOS
 */
@Service
public class MovilPersonaServiceImpl implements MovilPersonaService {

    @Autowired
    private MovilPersonaDAO movilPersonaDAO;
    
    @Override
    public void movilPersonaRegistro(MovilPersona movilPersona) {
        movilPersonaDAO.movilPersonaInsertar(movilPersona);
    }

    @Override
    public MovilPersona movilPersonaBuscarId(Long id) {
        return movilPersonaDAO.movilPersonaPorId(id);
    }
    
}
