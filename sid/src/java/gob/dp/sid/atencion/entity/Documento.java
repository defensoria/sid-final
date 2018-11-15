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
public class Documento {
    
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
}
