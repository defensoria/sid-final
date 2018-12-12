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
public class UsuarioVentanilla {
    
    private Long idUsuVent;
    private String codigoUsuario;
    private Long idVentanilla;
    private Long idSede;
    private String descObservacion;
    private Integer estadoAsignacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
    private String usuarioCreacion;
    private Date fechaCreacion;

    private String codVentanilla;
    /**
     * @return the idUsuVent
     */
    public Long getIdUsuVent() {
        return idUsuVent;
    }

    /**
     * @param idUsuVent the idUsuVent to set
     */
    public void setIdUsuVent(Long idUsuVent) {
        this.idUsuVent = idUsuVent;
    }

    /**
     * @return the codigoUsuario
     */
    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * @param codigoUsuario the codigoUsuario to set
     */
    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

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
     * @return the idSede
     */
    public Long getIdSede() {
        return idSede;
    }

    /**
     * @param idSede the idSede to set
     */
    public void setIdSede(Long idSede) {
        this.idSede = idSede;
    }

    /**
     * @return the descObservacion
     */
    public String getDescObservacion() {
        return descObservacion;
    }

    /**
     * @param descObservacion the descObservacion to set
     */
    public void setDescObservacion(String descObservacion) {
        this.descObservacion = descObservacion;
    }

    /**
     * @return the estadoAsignacion
     */
    public Integer getEstadoAsignacion() {
        return estadoAsignacion;
    }

    /**
     * @param estadoAsignacion the estadoAsignacion to set
     */
    public void setEstadoAsignacion(Integer estadoAsignacion) {
        this.estadoAsignacion = estadoAsignacion;
    }

    /**
     * @return the usuarioModificacion
     */
    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    /**
     * @param usuarioModificacion the usuarioModificacion to set
     */
    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    /**
     * @return the fechaModificacion
     */
    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    /**
     * @param fechaModificacion the fechaModificacion to set
     */
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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
    
    
}
