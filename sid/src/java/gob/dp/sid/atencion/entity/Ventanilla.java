/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.entity;

import java.util.Date;

/**
 *
 * @author JCARRILLO
 */
public class Ventanilla {
    
    private Long idVentanilla;
    private String codVentanilla;
    private String descVentanilla;
    private Integer estadoRegistro;
    private String usuarioCreacion;
    private Date fechaCreacion;

    /**
     * @return the idVentanilla
     */
    public Long getIdVentanilla() {
        return idVentanilla;
    }

    /**
     * @param idVentanilla the idVentanilla to set
     */
    public void setIdVentanilla(Long idVentanilla) {
        this.idVentanilla = idVentanilla;
    }

    /**
     * @return the codVentanilla
     */
    public String getCodVentanilla() {
        return codVentanilla;
    }

    /**
     * @param codVentanilla the codVentanilla to set
     */
    public void setCodVentanilla(String codVentanilla) {
        this.codVentanilla = codVentanilla;
    }

    /**
     * @return the descVentanilla
     */
    public String getDescVentanilla() {
        return descVentanilla;
    }

    /**
     * @param descVentanilla the descVentanilla to set
     */
    public void setDescVentanilla(String descVentanilla) {
        this.descVentanilla = descVentanilla;
    }

    /**
     * @return the estadoRegistro
     */
    public Integer getEstadoRegistro() {
        return estadoRegistro;
    }

    /**
     * @param estadoRegistro the estadoRegistro to set
     */
    public void setEstadoRegistro(Integer estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    /**
     * @return the usuarioCreacion
     */
    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    /**
     * @param usuarioCreacion the usuarioCreacion to set
     */
    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    

}
