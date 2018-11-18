/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.bean;

import gob.dp.sid.comun.type.MotivoAtencionType;
import java.io.Serializable;

/**
 *
 * @author JMATOS
 */
public class AtencionBean implements Serializable {
    
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
    private String observaciones;
    private String nameTipoMotivo;
    private String nameTipoAtencion;
    private String nameTipoTramite;

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
     * @param tipoMotivo the tipoMotivo to set
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

    /**
     * @return the nameTipoMotivo
     */
    public String getNameTipoMotivo() {
        if(tipoMotivo != null){
            nameTipoMotivo = MotivoAtencionType.get(tipoMotivo).getValue();
        }
        return nameTipoMotivo;
    }

    /**
     * @param nameTipoMotivo the nameTipoMotivo to set
     */
    public void setNameTipoMotivo(String nameTipoMotivo) {
        this.nameTipoMotivo = nameTipoMotivo;
    }

    /**
     * @return the nameTipoAtencion
     */
    public String getNameTipoAtencion() {
        return nameTipoAtencion;
    }

    /**
     * @param nameTipoAtencion the nameTipoAtencion to set
     */
    public void setNameTipoAtencion(String nameTipoAtencion) {
        this.nameTipoAtencion = nameTipoAtencion;
    }

    /**
     * @return the nameTipoTramite
     */
    public String getNameTipoTramite() {
        return nameTipoTramite;
    }

    /**
     * @param nameTipoTramite the nameTipoTramite to set
     */
    public void setNameTipoTramite(String nameTipoTramite) {
        this.nameTipoTramite = nameTipoTramite;
    }
    
    
}
