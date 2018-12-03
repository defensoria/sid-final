/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.registro.service;

import gob.dp.sid.registro.dao.ExpedienteVisitaDAO;
import gob.dp.sid.registro.entity.ExpedienteVisita;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ExpedienteVisitaServiceImpl implements ExpedienteVisitaService{
    
    @Autowired
    private ExpedienteVisitaDAO expedienteVisitaDAO;

    @Override
    public void expedienteVisitaInsertar(ExpedienteVisita expedienteVisita) {
        expedienteVisitaDAO.expedienteVisitaInsertar(expedienteVisita);
    }

    @Override
    public List<ExpedienteVisita> expedienteVisitaBuscarByCodigoExpediente(String codigoExpediente) {
        return expedienteVisitaDAO.expedienteVisitaBuscarByCodigoExpediente(codigoExpediente);
    }
    
}
