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
    
    private String tipomotivo;
    
    private String tipoAtencion;
    
    private String tipoTramite;
    
    private String indicadorDocumentos;

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
     * @return the tipomotivo
     */
    public String getTipomotivo() {
        return tipomotivo;
    }

    /**
     * @param tipomotivo the tipomotivo to set
     */
    public void setTipomotivo(String tipomotivo) {
        this.tipomotivo = tipomotivo;
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
            
}
