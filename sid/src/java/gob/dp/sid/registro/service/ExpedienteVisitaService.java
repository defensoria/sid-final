/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.registro.service;

import gob.dp.sid.registro.entity.ExpedienteVisita;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface ExpedienteVisitaService {
    
    public void expedienteVisitaInsertar(ExpedienteVisita expedienteVisita);
    
    public List<ExpedienteVisita> expedienteVisitaBuscarByCodigoExpediente(String codigoExpediente);
    
}
