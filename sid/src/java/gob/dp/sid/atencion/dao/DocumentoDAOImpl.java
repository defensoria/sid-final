/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.entity.Documento;
import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JMATOS
 */
@Repository
public class DocumentoDAOImpl extends SqlSessionDaoSupport implements DocumentoDAO {

    @Override
    public void registrarDocumento(Documento documento) {
        getSqlSession().insert("gob.dp.sid.atencion.dao.DocumentoDAO.documentoInsertar", documento);
        System.out.println("Registro guardado: " + documento.getId());
    }

    @Override
    public List<Documento> buscarExpedienteByVisita(Long id) {
        return getSqlSession().selectList("gob.dp.sid.atencion.dao.DocumentoDAO.buscarExpedienteByVisita", id);
    }

}
