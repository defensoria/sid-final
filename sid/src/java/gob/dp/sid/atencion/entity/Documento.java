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
 * @author JMATOS
 */
public class Documento implements Serializable {
    
    private Long id;
    private String codDocumento;
    private String extensionDoc;
    private String tamanioDoc;
    private Integer estado;
    private String rutaDoc;
    private Integer anexo;
    private String codDocPadre;
    private Date fechaRegistro;
    private String usuarioRegistro;
    private Date fechaModifica;
    private String usuarioModifica;
    private Integer idRegVisita;
    private Integer idTipoVisita;

    public Documento() {
    }

    public Documento(Long id, String codDocumento, String extensionDoc, String tamanioDoc, Integer estado, String rutaDoc, Integer anexo, String codDocPadre, Date fechaRegistro, String usuarioRegistro, Date fechaModifica, String usuarioModifica, Integer idRegVisita, Integer idTipoVisita) {
        this.id = id;
        this.codDocumento = codDocumento;
        this.extensionDoc = extensionDoc;
        this.tamanioDoc = tamanioDoc;
        this.estado = estado;
        this.rutaDoc = rutaDoc;
        this.anexo = anexo;
        this.codDocPadre = codDocPadre;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaModifica = fechaModifica;
        this.usuarioModifica = usuarioModifica;
        this.idRegVisita = idRegVisita;
        this.idTipoVisita = idTipoVisita;
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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getRutaDoc() {
        return rutaDoc;
    }

    public void setRutaDoc(String rutaDoc) {
        this.rutaDoc = rutaDoc;
    }

    public Integer getAnexo() {
        return anexo;
    }

    public void setAnexo(Integer anexo) {
        this.anexo = anexo;
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

    public Integer getIdTipoVisita() {
        return idTipoVisita;
    }

    public void setIdTipoVisita(Integer idTipoVisita) {
        this.idTipoVisita = idTipoVisita;
    }
    
    
}
