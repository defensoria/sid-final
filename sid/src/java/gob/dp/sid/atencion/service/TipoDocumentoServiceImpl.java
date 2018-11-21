/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.service;

import gob.dp.sid.atencion.bean.FiltroTramite;
import gob.dp.sid.atencion.dao.TipoDocumentoDAO;
import gob.dp.sid.atencion.entity.TipoDocumento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JMATOS
 */
@Service("tipoDocumentoService")
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoDAO tipoDocumentoDAO;
    
    @Override
    public List<TipoDocumento> listarDocumentosByTramite(FiltroTramite filtroTramite) {
        return tipoDocumentoDAO.listarTipoDocumento(filtroTramite);
    }

    @Override
    public TipoDocumento getTipoDocumentoById(FiltroTramite filtroTramite) {
        return tipoDocumentoDAO.obtenerTipoDocumentoById(filtroTramite);
    }
    
}
