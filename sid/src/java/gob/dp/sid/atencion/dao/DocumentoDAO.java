/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.bean.FiltroTramite;
import gob.dp.sid.atencion.entity.Documento;
import gob.dp.sid.atencion.entity.TipoDocumento;

/**
 *
 * @author JMATOS
 */
public interface DocumentoDAO {
    public void registrarDocumento(Documento documento);
    
}
