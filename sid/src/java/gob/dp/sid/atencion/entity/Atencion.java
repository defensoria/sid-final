/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.entity;
import java.io.Serializable;

/**
 *
 * @author jcarrillo
 */
public class Atencion implements Serializable{
    
    private Long id;
    
    private String tipoMotivo;
    
    private String tipoAtencion;
    
    private String tipoTramite;
    
    private String indicadorDocumentos;
    
    private String dni;
    
    private String nombres;
    
    private String apellidoPaterno;
    
    private String apellidoMaterno;
    
    private String atencionPreferencial;
    
    private String tipoDiscapacidad;
    
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
            
}
