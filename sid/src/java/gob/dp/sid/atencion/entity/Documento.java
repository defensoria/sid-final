/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.entity;

import gob.dp.sid.atencion.entity.type.TipoDocumentoType;
import gob.dp.sid.comun.type.EstadoType;
import java.io.Serializable;
import java.util.Date;
import javax.servlet.http.Part;

/**
 *
 * @author JMATOS
 */
public class Documento implements Serializable {

    private Long id;
    private String codDocumento;
    private String extensionDoc;
    private String tamanioDoc;
    private String estado;
    private String rutaDoc;
    private String anexo;
    private String codDocPadre;
    private Date fechaRegistro;
    private String usuarioRegistro;
    private Date fechaModifica;
    private String usuarioModifica;
    private Integer idRegVisita;
    private Integer idTipoDocumento;
    private String observaciones;
    
    // TEMPORALES
    private String descEstado;
    private String descTipoDocumento;
    private Part documento;
    private String fileName;

    public Documento() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodDocumento() {
        return codDocumento;
    }

    public void setCodDocumento(String codDocumento) {
        this.codDocumento = codDocumento;
    }

    public String getExtensionDoc() {
        return extensionDoc;
    }

    public void setExtensionDoc(String extensionDoc) {
        this.extensionDoc = extensionDoc;
    }

    public String getTamanioDoc() {
        return tamanioDoc;
    }

    public void setTamanioDoc(String tamanioDoc) {
        this.tamanioDoc = tamanioDoc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRutaDoc() {
        return rutaDoc;
    }

    public void setRutaDoc(String rutaDoc) {
        this.rutaDoc = rutaDoc;
    }

    public String getCodDocPadre() {
        return codDocPadre;
    }

    public void setCodDocPadre(String codDocPadre) {
        this.codDocPadre = codDocPadre;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public String getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public Integer getIdRegVisita() {
        return idRegVisita;
    }

    public void setIdRegVisita(Integer idRegVisita) {
        this.idRegVisita = idRegVisita;
    }

        /**
     * @return the idTipoDocumento
     */
    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    /**
     * @param idTipoDocumento the idTipoDocumento to set
     */
    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
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
     * @return the anexo
     */
    public String getAnexo() {
        return anexo;
    }

    /**
     * @param anexo the anexo to set
     */
    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }
    
    public String getDescEstado() {
        if(estado != null)
            descEstado = EstadoType.get(estado).getValue();
        return descEstado;
    }

    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
    }

    public String getDescTipoDocumento() {
        /*if(idTipoDocumento != null)
            descTipoDocumento = TipoDocumentoType.get(idTipoDocumento).getValue();*/
        return descTipoDocumento;
    }

    public void setDescTipoDocumento(String descTipoDocumento) {
        this.descTipoDocumento = descTipoDocumento;
    }

    /**
     * @return the documento
     */
    public Part getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(Part documento) {
        this.documento = documento;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
