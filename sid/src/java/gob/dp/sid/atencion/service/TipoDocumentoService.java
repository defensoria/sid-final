/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.service;

import gob.dp.sid.atencion.bean.FiltroTramite;
import gob.dp.sid.atencion.entity.TipoDocumento;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author JMATOS
 */

@Service
public interface TipoDocumentoService {
    public List<TipoDocumento> listarDocumentosByTramite(FiltroTramite filtroTramite);
    public TipoDocumento getTipoDocumentoById(FiltroTramite filtroTramite);
}
