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
    
    
    public static String FILE_DONWLOAD = "C:/filesystem";
    
    //public static String FILE_DONWLOAD = "/srv/sid/filesystem";
    
    public static String FILE_DONWLOAD_SCANNER = "C:/scaner";
    
    // public static String FILE_DONWLOAD_SCANNER = "/srv/sid/scaner";
    
    public static String FILE_DONWLOAD_SCANNER_FINAL = "C:/filesystemAtencionCiudadano";
    
    //public static String FILE_DONWLOAD_SCANNER_FINAL = "/srv/sid/filesystemAtencionCiudadano";
    
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
}
