/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.entity.UsuarioVentanilla;
import java.util.List;
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
    
    @Override
    public void actualizarUsuarioVentanilla(UsuarioVentanilla usuarioVentanilla) {
        getSqlSession().insert("gob.dp.sid.atencion.dao.UsuarioVentanillaDAO.actualizarUsuarioVentanilla", usuarioVentanilla);
        System.out.println("ID ACTUALIZADO: " + usuarioVentanilla.getIdUsuVent());
    }
    
    @Override
    public UsuarioVentanilla buscarUsuarioVentanilla(UsuarioVentanilla usuarioVentanilla) {
        
        UsuarioVentanilla u = getSqlSession().selectOne("gob.dp.sid.atencion.dao.UsuarioVentanillaDAO.buscarUsuarioVentanilla", usuarioVentanilla);
        return u;
    }
    
    @Override
    public List<UsuarioVentanilla> listarUsuarioVentanilla(UsuarioVentanilla usuarioVentanilla) {
        return getSqlSession().selectList("gob.dp.sid.atencion.dao.UsuarioVentanillaDAO.listarUsuarioVentanilla", usuarioVentanilla);
    }
}
