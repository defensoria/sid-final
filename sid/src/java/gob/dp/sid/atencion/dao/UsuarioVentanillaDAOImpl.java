/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.entity.UsuarioVentanilla;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JCARRILLO
 */

@Repository
public class UsuarioVentanillaDAOImpl extends SqlSessionDaoSupport implements UsuarioVentanillaDAO {

    @Override
    public void insertarUsuarioVentanilla(UsuarioVentanilla usuarioVentanilla) {
        getSqlSession().insert("gob.dp.sid.atencion.dao.UsuarioVentanillaDAO.insertarUsuarioVentanilla", usuarioVentanilla);
        System.out.println("ID INSERTADO: " + usuarioVentanilla.getIdUsuVent());
    }
    
}
