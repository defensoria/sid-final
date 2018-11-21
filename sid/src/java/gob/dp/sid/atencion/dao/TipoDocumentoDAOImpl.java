/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.bean.FiltroTramite;
import gob.dp.sid.atencion.entity.TipoDocumento;
import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JMATOS
 */
@Repository
public class TipoDocumentoDAOImpl extends SqlSessionDaoSupport implements TipoDocumentoDAO {

    @Override
    public List<TipoDocumento> listarTipoDocumento(FiltroTramite filtroTramite) {
        return getSqlSession().selectList("gob.dp.sid.atencion.dao.TipoDocumentoDAO.listarTipoDocumentoByTramite", filtroTramite);
    }
    
    @Override
    public TipoDocumento obtenerTipoDocumentoById(FiltroTramite filtro) {
        return getSqlSession().selectOne("gob.dp.sid.atencion.dao.TipoDocumentoDAO.obtenerTipoDocumento", filtro);
    }
}
