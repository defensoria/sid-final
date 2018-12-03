/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.registro.dao;

import gob.dp.sid.registro.entity.ExpedienteVisita;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface ExpedienteVisitaDAO {
    
    public void expedienteVisitaInsertar(ExpedienteVisita expedienteVisita);
    
    public List<ExpedienteVisita> expedienteVisitaBuscarByCodigoExpediente(String codigoExpediente);
    
}
