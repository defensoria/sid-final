/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.registro.dao;

import gob.dp.sid.registro.entity.MovilPersona;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JMATOS
 */
@Repository
public class MovilPersonaDAOImpl extends SqlSessionDaoSupport implements MovilPersonaDAO {

    @Override
    public void movilPersonaInsertar(MovilPersona movilPersona) {
        getSqlSession().insert("gob.dp.sid.registro.dao.MovilPersonaDAO.movilPersonaInsertar", movilPersona);
    }

    @Override
    public MovilPersona movilPersonaPorId(Long id) {
        return getSqlSession().selectOne("gob.dp.sid.registro.dao.MovilPersonaDAO.movilPersonaBusarId", id);
    }
}
