/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.sid.comun;

import java.io.Serializable;

/**
 *
 * @author carlos
 */
public class ConstantesUtil implements Serializable{
    
    public static final int PAGINADO_5=5;
    
    public static final int PAGINADO_10=10;
    
    public static final int PAGINADO_15=15;
    
    public static final int PAGINADO_20=20;
    
    public static final int PAGINADO_30=30;
    
    public static final String LISTA_VALOR_TODOS_CODIGO = "-1000";
    public static final String LISTA_VALOR_TODOS_NOMBRE = "TODOS";

    public static final String LISTA_VALOR_NINGUNO_CODIGO = "-2000";
    public static final String LISTA_VALOR_NINGUNO_NOMBRE = "NINGUNO";

    public static final String LISTA_VALOR_SELECCIONE_CODIGO = "-3000";
    public static final String LISTA_VALOR_SELECCIONE_NOMBRE = "SELECCIONE";
    
    public static final String LISTA_VALOR_PERU_CODIGO = "170";
    
    public static final String LISTA_VALOR_PERSONA_CODIGO = "PER";//01
    
    public static final String LISTA_VALOR_ORGANIZACION_CODIGO = "ORG";//02
    
    //public static String FILE_DONWLOAD = "C:/filesystem";
    
    public static String FILE_DONWLOAD = "/srv/sid/filesystem";
    
    //public static String FILE_DONWLOAD_SCANNER = "C:/scaner";
    
    public static String FILE_DONWLOAD_SCANNER = "/srv/sid/scaner";
    
    //public static String FILE_DONWLOAD_SCANNER_FINAL = "C:/filesystemAtencionCiudadano";
    
    public static String FILE_DONWLOAD_SCANNER_FINAL = "/srv/sid/filesystemAtencionCiudadano";
    
    // PAGINAS ATENCION:
    public static String PAGE_RECEPCION_DOCUMENTOS_ADMINISTRATIVOS = "recepDocumentosAdm";
    public static String PAGE_RECEPCION_DOCUMENTOS_EXPEDIENTE = "";
    public static String PAGE_ATENCION_PRESENCIAL = "atencionPresencial";
    
    public static final Integer PARAMETRO_LISTA_TIPO_ATENCION_DOCUMENTARIO = 4403;
    public static final Integer PARAMETRO_LISTA_TRAMITE_DOCUMENTARIO_ADMINISTRATIVO = 100;
    public static final Integer PARAMETRO_LISTA_TIPO_ATENCION_INTERVENCION = 4404;
    
    
    
    public static final String SERVER_PATH_DOCUMENTOS = "C:/server/sid/mac/documentos";
    // public static final String SERVER_PATH_DOCUMENTOS = "/var/sid/mac/documentos";
    
    public static final String PARAMETRO_SOLICITUD_INTERVENCION_CONSULTA_CASO_EXISTENTE = "6";
    public static final String PARAMETRO_TIPO_DOCUMENTO_DNI = "02";
    public static final String PARAMETRO_TIPO_DOCUMENTO_CE = "05";
    public static final String PARAMETRO_TIPO_DOCUMENTO_INDOCUMENTADO = "07";
    
    // Parametros Mail
    public static final String MAIL_USERNAME = "pe.gob.dp.sid.smtp.username";
    public static final String MAIL_PASSWORD = "pe.gob.dp.sid.smtp.password";
    public static final String MAIL_HOST = "pe.gob.dp.sid.smtp.host";
    public static final String MAIL_PORT = "pe.gob.dp.sid.smtp.port";
    public static final String MAIL_FROM = "pe.gob.dp.sid.smtp.mail.from";
    
    // Parametros Mail
    public static final String MAIL_GMAIL_USERNAME = "pe.gob.dp.sid.gmail.smtp.username";
    public static final String MAIL_GMAIL_PASSWORD = "pe.gob.dp.sid.gmail.smtp.password";
    public static final String MAIL_GMAIL_HOST = "pe.gob.dp.sid.gmail.smtp.host";
    public static final String MAIL_GMAIL_PORT = "pe.gob.dp.sid.gmail.smtp.port";
    
    public static final String MAIL_BODY_CODIGO_AUTO = "pe.gob.dp.sid.mail.body.autogeneracion.code";
    public static final String MAIL_SUBJECT_CODIGO_AUTO = "pe.gob.dp.sid.mail.subject.autogeneracion.code";
    
    public static final String CODIGO_OD_LIMA = "pe.gob.dp.sid.codigo.od.lima";
    public static final String CODIGO_CANAL_INGRESO_VERBAL ="pe.gob.dp.sid.codigo.canal.ingreso.verbal";
    public static final String CODIGO_CANAL_INGRESO_ESCRITO = "pe.gob.dp.sid.codigo.canal.ingreso.escrito";
    public static final String CODIGO_CANAL_INGRESO_ITINERANTE = "pe.gob.dp.sid.codigo.canal.ingreso.itinerante";
    public static final String CODIGO_CANAL_INGRESO_TELEFONICO = "pe.gob.dp.sid.codigo.canal.ingreso.telefonico";
    
}