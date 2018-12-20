/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.service;

import gob.dp.sid.atencion.bean.ArchivoDocumentoBean;
import gob.dp.sid.atencion.dao.DocumentoDAO;
import gob.dp.sid.atencion.entity.Documento;
import gob.dp.sid.comun.ConstantesUtil;
import java.io.File;
import java.util.ArrayList;
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

    @Override
    public List<ArchivoDocumentoBean> listarDocumentosServer() {
        
        List<ArchivoDocumentoBean> listFiles = new ArrayList<>();
        
        String dirName = ConstantesUtil.SERVER_PATH_DOCUMENTOS;
        File aDirectory = new File(dirName);
        String[] filesInDir = aDirectory.list();
        
        for(int i = 0; i<filesInDir.length; i++){
            ArchivoDocumentoBean fileDocumento = new ArchivoDocumentoBean();
            fileDocumento.setFilename(filesInDir[i]);
            fileDocumento.setCodfile("doc"+i);
            listFiles.add(fileDocumento);
        }
        return listFiles;
    }

    @Override
    public List<Documento> buscarExpedienteByVisita(Long id) {
        return documentoDAO.buscarExpedienteByVisita(id);
    }
    
}
