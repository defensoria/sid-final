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
    
}
