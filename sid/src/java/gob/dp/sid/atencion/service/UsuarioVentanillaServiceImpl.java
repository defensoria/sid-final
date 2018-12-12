/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.service;

import gob.dp.sid.atencion.dao.UsuarioVentanillaDAO;
import gob.dp.sid.atencion.entity.UsuarioVentanilla;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JCARRILLO
 */

@Service
public class UsuarioVentanillaServiceImpl implements UsuarioVentanillaService {
    
    @Autowired 
    private UsuarioVentanillaDAO usuarioVentanillaDAO;

    @Override
    public void registrarUsuarioVentanilla(UsuarioVentanilla usuarioVentanilla) {
        usuarioVentanillaDAO.insertarUsuarioVentanilla(usuarioVentanilla);
    }
    
    @Override
    public void actualizarUsuarioVentanilla(UsuarioVentanilla usuarioVentanilla) {
        usuarioVentanillaDAO.actualizarUsuarioVentanilla(usuarioVentanilla);
    }
    
    @Override
    public UsuarioVentanilla buscarUsuarioVentanilla(UsuarioVentanilla usuarioVentanilla) {
        return usuarioVentanillaDAO.buscarUsuarioVentanilla(usuarioVentanilla);
    }
    
    @Override
    public List<UsuarioVentanilla> listarUsuarioVentanilla(UsuarioVentanilla usuarioVentanilla) {
        return usuarioVentanillaDAO.listarUsuarioVentanilla(usuarioVentanilla);
    }
}
