/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.entity;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jcarrillo
 */
public class Atencion implements Serializable{

    private Long id;
    
    private String tipoMotivo;
    
    private String descMotivo;
    
    private String tipoAtencion;
    
    private String descAtencion;
    
    private String tipoTramite;
    
    private String descTramite;
    
    private String indicadorDocumentos;
    
    private Long idPersona;
    
    private String dni;
    
    private String nombres;
    
    private String apellidoPaterno;
    
    private String apellidoMaterno;
    
    private String atencionPreferencial;
    
    private String tipoDiscapacidad;
    
    private String observaciones;
    
    private String sexo;
    
    private String fechaNacimiento;
    
    private String discapacidad;
    private Date dtFechaNacimiento;
    private String indicadorCasoNuevo;
    private String indicadorCita;
    private String tipoDigitaliza;
    private String tipoDocumento;
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the tipoMotivo
     */
    public String getTipoMotivo() {
        return tipoMotivo;
    }

    /**
     * @param tipoMotivo the tipomotivo to set
     */
    public void setTipoMotivo(String tipoMotivo) {
        this.tipoMotivo = tipoMotivo;
    }

    /**
     * @return the tipoAtencion
     */
    public String getTipoAtencion() {
        return tipoAtencion;
    }

    /**
     * @param tipoAtencion the tipoAtencion to set
     */
    public void setTipoAtencion(String tipoAtencion) {
        this.tipoAtencion = tipoAtencion;
    }

    /**
     * @return the tipoTramite
     */
    public String getTipoTramite() {
        return tipoTramite;
    }

    /**
     * @param tipoTramite the tipoTramite to set
     */
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    /**
     * @return the indicadorDocumentos
     */
    public String getIndicadorDocumentos() {
        return indicadorDocumentos;
    }

    /**
     * @param indicadorDocumentos the indicadorDocumentos to set
     */
    public void setIndicadorDocumentos(String indicadorDocumentos) {
        this.indicadorDocumentos = indicadorDocumentos;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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
     * @return the tipoDiscapacidad
     */
    public String getTipoDiscapacidad() {
        return tipoDiscapacidad;
    }

    /**
     * @param tipoDiscapacidad the tipoDiscapacidad to set
     */
    public void setTipoDiscapacidad(String tipoDiscapacidad) {
        this.tipoDiscapacidad = tipoDiscapacidad;
    }
    
    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the discapacidad
     */
    public String getDiscapacidad() {
        return discapacidad;
    }

    /**
     * @param discapacidad the discapacidad to set
     */
    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    /**
     * @return the indicadorCasoNuevo
     */
    public String getIndicadorCasoNuevo() {
        return indicadorCasoNuevo;
    }

    /**
     * @param indicadorCasoNuevo the indicadorCasoNuevo to set
     */
    public void setIndicadorCasoNuevo(String indicadorCasoNuevo) {
        this.indicadorCasoNuevo = indicadorCasoNuevo;
    }

    /**
     * @return the indicadorCita
     */
    public String getIndicadorCita() {
        return indicadorCita;
    }

    /**
     * @param indicadorCita the indicadorCita to set
     */
    public void setIndicadorCita(String indicadorCita) {
        this.indicadorCita = indicadorCita;
    }

    /**
     * @return the tipoDigitaliza
     */
    public String getTipoDigitaliza() {
        return tipoDigitaliza;
    }

    /**
     * @param tipoDigitaliza the tipoDigitaliza to set
     */
    public void setTipoDigitaliza(String tipoDigitaliza) {
        this.tipoDigitaliza = tipoDigitaliza;
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
     * @return the dtFechaNacimiento
     */
    public Date getDtFechaNacimiento() {
        return dtFechaNacimiento;
    }

    /**
     * @param dtFechaNacimiento the dtFechaNacimiento to set
     */
    public void setDtFechaNacimiento(Date dtFechaNacimiento) {
        this.dtFechaNacimiento = dtFechaNacimiento;
    }
    
        /**
     * @return the tipoDocumento
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

            
}
