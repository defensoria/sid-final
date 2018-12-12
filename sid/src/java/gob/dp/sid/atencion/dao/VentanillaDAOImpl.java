/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.entity.Ventanilla;
import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JCARRILLO
 */
@Repository
public class VentanillaDAOImpl extends SqlSessionDaoSupport implements VentanillaDAO {

    @Override
    public List<Ventanilla> listarVentanillas(Ventanilla ventanilla) {
        return getSqlSession().selectList("gob.dp.sid.atencion.dao.VentanillaDAO.listarVentanillas", ventanilla);
    }
    
}
