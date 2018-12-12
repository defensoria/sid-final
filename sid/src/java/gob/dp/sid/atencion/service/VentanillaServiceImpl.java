/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.service;

import gob.dp.sid.atencion.dao.VentanillaDAO;
import gob.dp.sid.atencion.entity.Ventanilla;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JCARRILLO
 */

@Service
public class VentanillaServiceImpl implements VentanillaService {

    @Autowired
    private VentanillaDAO ventanillaDAO;
    
    @Override
    public List<Ventanilla> listarVentanillas(Ventanilla ventanilla) {
        return ventanillaDAO.listarVentanillas(ventanilla);
    }

}
