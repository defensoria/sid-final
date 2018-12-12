/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.dao;

import gob.dp.sid.atencion.entity.UsuarioVentanilla;
import java.util.List;

/**
 *
 * @author JCARRILLO
 */
public interface UsuarioVentanillaDAO {
    
    public void insertarUsuarioVentanilla(UsuarioVentanilla usuarioVentanilla);
    
    public void actualizarUsuarioVentanilla(UsuarioVentanilla usuarioVentanilla);
            
    public UsuarioVentanilla buscarUsuarioVentanilla(UsuarioVentanilla usuarioVentanilla);
    
    public List<UsuarioVentanilla> listarUsuarioVentanilla(UsuarioVentanilla usuarioVentanilla);
}
