/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.entity;

import java.util.Date;

/**
 *
 * @author JMATOS
 */
public class VisitaCiudadano {
    
    private Long id;
    private Date fechaVisita;
    private String motivo;
    private Integer tieneDiscapacidad;
    private Integer estado;
    private String observacion;
    private String tipoAtencionDiscapacidad;
    private String tipoTramite;
    private String tipoAtencion;
    private String dni;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModifica;
    private Date fechaModifica;
    private Integer indicadorTratamiento;
    private String atencionPreferencial;
    private String casoNuevo;
    private Integer tieneCita;
    private Integer idPersona;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Integer getTieneDiscapacidad() {
        return tieneDiscapacidad;
    }

    public void setTieneDiscapacidad(Integer tieneDiscapacidad) {
        this.tieneDiscapacidad = tieneDiscapacidad;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipoAtencionDiscapacidad() {
        return tipoAtencionDiscapacidad;
    }

    public void setTipoAtencionDiscapacidad(String tipoAtencionDiscapacidad) {
        this.tipoAtencionDiscapacidad = tipoAtencionDiscapacidad;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getTipoAtencion() {
        return tipoAtencion;
    }

    public void setTipoAtencion(String tipoAtencion) {
        this.tipoAtencion = tipoAtencion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public Integer getIndicadorTratamiento() {
        return indicadorTratamiento;
    }

    public void setIndicadorTratamiento(Integer indicadorTratamiento) {
        this.indicadorTratamiento = indicadorTratamiento;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the atencionPreferencial
     */
    public String getAtencionPreferencial() {
        return atencionPreferencial;
    }

    /**
     * @param atencionPreferencial the atencionPreferencial to set
     */
    public void setAtencionPreferencial(String atencionPreferencial) {
        this.atencionPreferencial = atencionPreferencial;
    }

    /**
     * @return the casoNuevo
     */
    public String getCasoNuevo() {
        return casoNuevo;
    }

    /**
     * @param casoNuevo the casoNuevo to set
     */
    public void setCasoNuevo(String casoNuevo) {
        this.casoNuevo = casoNuevo;
    }

    /**
     * @return the tieneCita
     */
    public Integer getTieneCita() {
        return tieneCita;
    }

    /**
     * @param tieneCita the tieneCita to set
     */
    public void setTieneCita(Integer tieneCita) {
        this.tieneCita = tieneCita;
    }

    /**
     * @return the idPersona
     */
    public Integer getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    
}
