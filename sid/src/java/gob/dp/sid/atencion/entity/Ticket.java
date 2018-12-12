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
public class Ticket {
    
    private Long idTicket;
    private Long idVisita;
    private Long idPersona;
    private Long idTramite;
    private Long idSede;
    private String nroTicket;
    private Integer atencionPreferente;
    private Integer estadoTicket;
    private Integer estadoRegistro;
    private String usuarioCreacion;
    private Date fechaCreacion;

    /**
     * @return the idTicket
     */
    public Long getIdTicket() {
        return idTicket;
    }

    /**
     * @param idTicket the idTicket to set
     */
    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    /**
     * @return the idVisita
     */
    public Long getIdVisita() {
        return idVisita;
    }

    /**
     * @param idVisita the idVisita to set
     */
    public void setIdVisita(Long idVisita) {
        this.idVisita = idVisita;
    }

    /**
     * @return the idPersona
     */
    public Long getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the idTramite
     */
    public Long getIdTramite() {
        return idTramite;
    }

    /**
     * @param idTramite the idTramite to set
     */
    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
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
     * @return the nroTicket
     */
    public String getNroTicket() {
        return nroTicket;
    }

    /**
     * @param nroTicket the nroTicket to set
     */
    public void setNroTicket(String nroTicket) {
        this.nroTicket = nroTicket;
    }

    /**
     * @return the atencionPreferente
     */
    public Integer getAtencionPreferente() {
        return atencionPreferente;
    }

    /**
     * @param atencionPreferente the atencionPreferente to set
     */
    public void setAtencionPreferente(Integer atencionPreferente) {
        this.atencionPreferente = atencionPreferente;
    }

    /**
     * @return the estadoTicket
     */
    public Integer getEstadoTicket() {
        return estadoTicket;
    }

    /**
     * @param estadoTicket the estadoTicket to set
     */
    public void setEstadoTicket(Integer estadoTicket) {
        this.estadoTicket = estadoTicket;
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
