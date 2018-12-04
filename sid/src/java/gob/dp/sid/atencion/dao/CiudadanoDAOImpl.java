/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.entity.Ciudadano;
import gob.dp.sid.atencion.bean.FiltroPersona;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JMATOS
 */
@Repository
public class CiudadanoDAOImpl extends SqlSessionDaoSupport implements CiudadanoDAO{

    @Override
    public Ciudadano obtenerDatosPersonaByDni(FiltroPersona filtroPersona) {
        
        Ciudadano c = getSqlSession().selectOne("gob.dp.sid.atencion.dao.CiudadanoDAO.buscarDatosCiudadano", filtroPersona);
        return c;
        //return getSqlSession().selectOne("gob.dp.sid.atencion.dao.CiudadanoDAO.buscarDatosCiudadano", filtroPersona);
    }

    @Override
    public Ciudadano insertarDatosCiudadano(Ciudadano ciudadano) {
        getSqlSession().insert("gob.dp.sid.atencion.dao.CiudadanoDAO.ciudadanoInsertar", ciudadano);
        return ciudadano;
    }
    
}
