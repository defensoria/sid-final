/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.service;

import gob.dp.sid.atencion.bean.ArchivoDocumentoBean;
import gob.dp.sid.atencion.entity.Documento;
import java.util.List;

/**
 *
 * @author JMATOS
 */
public interface DocumentoService {
    
    public void registrarDocumento(Documento documento);
    public void registrarDocumentosList(List<Documento> documentos);
    
    public List<ArchivoDocumentoBean> listarDocumentosServer();
    
    public List<Documento> buscarExpedienteByVisita(Long id);
}
