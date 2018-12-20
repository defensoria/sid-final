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
public class AtencionTicket {
    
    private Long idAtencionTicket;
    private Long idTicket;
    private String nroTicket;
    private Integer estadoTicket;
    private Long idPersona;
    private String dniPersona;
    private String nombrePersona;
    private String apePatPersona;
    private String apeMatPersona;
    private String codMotivo;
    private String descMotivo;
    private String codAtencion;
    private String descAtencion;
    private String codTramite;
    private String descTramite;
    private Long idSede;
    private String codigoUsuarioAtencionTicket;
    private Date fechaInicioAtencionTicket;
    private Date fechaFinAtencionTicket;
    private Integer estadoAtencionTicket;
    private Long idVentanilla;
    
    private String tipoClasificion;
    
    
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
     * @return the dniPersona
     */
    public String getDniPersona() {
        return dniPersona;
    }

    /**
     * @param dniPersona the dniPersona to set
     */
    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    /**
     * @return the nombrePersona
     */
    public String getNombrePersona() {
        return nombrePersona;
    }

    /**
     * @param nombrePersona the nombrePersona to set
     */
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    /**
     * @return the apePatPersona
     */
    public String getApePatPersona() {
        return apePatPersona;
    }

    /**
     * @param apePatPersona the apePatPersona to set
     */
    public void setApePatPersona(String apePatPersona) {
        this.apePatPersona = apePatPersona;
    }

    /**
     * @return the apeMatPersona
     */
    public String getApeMatPersona() {
        return apeMatPersona;
    }

    /**
     * @param apeMatPersona the apeMatPersona to set
     */
    public void setApeMatPersona(String apeMatPersona) {
        this.apeMatPersona = apeMatPersona;
    }

    /**
     * @return the codMotivo
     */
    public String getCodMotivo() {
        return codMotivo;
    }

    /**
     * @param codMotivo the codMotivo to set
     */
    public void setCodMotivo(String codMotivo) {
        this.codMotivo = codMotivo;
    }

    /**
     * @return the descMotivo
     */
    public String getDescMotivo() {
        return descMotivo;
    }

    /**
     * @param descMotivo the descMotivo to set
     */
    public void setDescMotivo(String descMotivo) {
        this.descMotivo = descMotivo;
    }

    /**
     * @return the codAtencion
     */
    public String getCodAtencion() {
        return codAtencion;
    }

    /**
     * @param codAtencion the codAtencion to set
     */
    public void setCodAtencion(String codAtencion) {
        this.codAtencion = codAtencion;
    }

    /**
     * @return the descAtencion
     */
    public String getDescAtencion() {
        return descAtencion;
    }

    /**
     * @param descAtencion the descAtencion to set
     */
    public void setDescAtencion(String descAtencion) {
        this.descAtencion = descAtencion;
    }

    /**
     * @return the codTramite
     */
    public String getCodTramite() {
        return codTramite;
    }

    /**
     * @param codTramite the codTramite to set
     */
    public void setCodTramite(String codTramite) {
        this.codTramite = codTramite;
    }

    /**
     * @return the descTramite
     */
    public String getDescTramite() {
        return descTramite;
    }

    /**
     * @param descTramite the descTramite to set
     */
    public void setDescTramite(String descTramite) {
        this.descTramite = descTramite;
    }

    /**
     * @return the idAtencionTicket
     */
    public Long getIdAtencionTicket() {
        return idAtencionTicket;
    }

    /**
     * @param idAtencionTicket the idAtencionTicket to set
     */
    public void setIdAtencionTicket(Long idAtencionTicket) {
        this.idAtencionTicket = idAtencionTicket;
    }

    /**
     * @return the fechaInicioAtencionTicket
     */
    public Date getFechaInicioAtencionTicket() {
        return fechaInicioAtencionTicket;
    }

    /**
     * @param fechaInicioAtencionTicket the fechaInicioAtencionTicket to set
     */
    public void setFechaInicioAtencionTicket(Date fechaInicioAtencionTicket) {
        this.fechaInicioAtencionTicket = fechaInicioAtencionTicket;
    }

    /**
     * @return the fechaFinAtencionTicket
     */
    public Date getFechaFinAtencionTicket() {
        return fechaFinAtencionTicket;
    }

    /**
     * @param fechaFinAtencionTicket the fechaFinAtencionTicket to set
     */
    public void setFechaFinAtencionTicket(Date fechaFinAtencionTicket) {
        this.fechaFinAtencionTicket = fechaFinAtencionTicket;
    }

    /**
     * @return the estadoAtencionTicket
     */
    public Integer getEstadoAtencionTicket() {
        return estadoAtencionTicket;
    }

    /**
     * @param estadoAtencionTicket the estadoAtencionTicket to set
     */
    public void setEstadoAtencionTicket(Integer estadoAtencionTicket) {
        this.estadoAtencionTicket = estadoAtencionTicket;
    }

    /**
     * @return the codigoUsuarioAtencionTicket
     */
    public String getCodigoUsuarioAtencionTicket() {
        return codigoUsuarioAtencionTicket;
    }

    /**
     * @param codigoUsuarioAtencionTicket the codigoUsuarioAtencionTicket to set
     */
    public void setCodigoUsuarioAtencionTicket(String codigoUsuarioAtencionTicket) {
        this.codigoUsuarioAtencionTicket = codigoUsuarioAtencionTicket;
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
     * @return the tipoClasificion
     */
    public String getTipoClasificion() {
        return tipoClasificion;
    }

    /**
     * @param tipoClasificion the tipoClasificion to set
     */
    public void setTipoClasificion(String tipoClasificion) {
        this.tipoClasificion = tipoClasificion;
    }

    
}
