/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.bean.FiltroTramite;
import gob.dp.sid.atencion.entity.TipoDocumento;
import java.util.List;

/**
 *
 * @author JMATOS
 */
public interface TipoDocumentoDAO {
    
    public List<TipoDocumento> listarTipoDocumento(FiltroTramite filtroTramite);
    public TipoDocumento obtenerTipoDocumentoById(FiltroTramite filtro);
}
