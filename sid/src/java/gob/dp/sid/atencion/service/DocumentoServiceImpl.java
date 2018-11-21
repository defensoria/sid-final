/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.service;

import gob.dp.sid.atencion.dao.DocumentoDAO;
import gob.dp.sid.atencion.entity.Documento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JMATOS
 */
@Service
public class DocumentoServiceImpl implements DocumentoService {
    
    @Autowired
    private DocumentoDAO documentoDAO;

    @Override
    public void registrarDocumento(Documento documento) {
        documentoDAO.registrarDocumento(documento);
    }

    @Override
    public void registrarDocumentosList(List<Documento> documentos) {
        /*documentos.forEach( item -> {
            documentoDAO.registrarDocumento(item);
        });*/
    }
    
}
