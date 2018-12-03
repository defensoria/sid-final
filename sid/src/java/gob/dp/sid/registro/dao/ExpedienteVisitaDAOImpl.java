/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.registro.dao;

import gob.dp.sid.registro.entity.ExpedienteVisita;
import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class ExpedienteVisitaDAOImpl  extends SqlSessionDaoSupport implements ExpedienteVisitaDAO{

    @Override
    public void expedienteVisitaInsertar(ExpedienteVisita expedienteVisita) {
        getSqlSession().insert("gob.dp.sid.registro.dao.ExpedienteVisitaDAO.expedienteVisitaInsertar", expedienteVisita);
    }

    @Override
    public List<ExpedienteVisita> expedienteVisitaBuscarByCodigoExpediente(String codigoExpediente) {
        return getSqlSession().selectList("gob.dp.sid.registro.dao.ExpedienteVisitaDAO.expedienteVisitaBuscarByCodigoExpediente", codigoExpediente);
    }
    
}
