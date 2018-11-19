/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.controller;

import gob.dp.sid.administracion.parametro.constantes.Constantes;
import gob.dp.sid.atencion.bean.AtencionBean;
import gob.dp.sid.atencion.entity.Atencion;
import gob.dp.sid.atencion.entity.Ciudadano;
import gob.dp.sid.atencion.service.PersonaCiudadanoService;
import gob.dp.sid.atencion.bean.FiltroPersona;
import gob.dp.sid.atencion.bean.FiltroTramite;
import gob.dp.sid.atencion.entity.Documento;
import gob.dp.sid.atencion.entity.TipoDocumento;
import gob.dp.sid.atencion.service.TipoDocumentoService;
import gob.dp.sid.comun.ComunUtil;
import gob.dp.sid.comun.ConstantesUtil;
import gob.dp.sid.comun.controller.AbstractManagedBean;
import gob.dp.sid.comun.controller.ListasComunesController;
import gob.dp.sid.comun.entity.FiltroParametro;
import gob.dp.sid.comun.entity.Parametro;
import gob.dp.sid.comun.service.ParametroService;
import gob.dp.sid.comun.type.MotivoAtencionType;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.servlet.http.Part;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pe.gob.defensoria.wsdl.service.ServiceReniec;

/**
 *
 * @author jcarrillo
 */
@Named
@Scope("session")
public class AtencionController extends AbstractManagedBean implements Serializable {

    private static final Logger log = Logger.getLogger(AtencionController.class);
    
    private Atencion atencion;
    private Documento documento;
    private AtencionBean atencionBean;
    private List<Parametro> listaTipoAtencion; 
    private List<Parametro> listaTipoTramite;
    private List<TipoDocumento> listaTipoDocumto;
    private List<Documento> listaDocumentosAtencion;
    private String disableField = "false";
    private String page;
    private Part fileUpload;
    
    private boolean renderTieneDiscapacidad = false;
            
    @Autowired
    private ListasComunesController listasComunesController;
    
    @Autowired
    private PersonaCiudadanoService ciudadanoServie;
    
    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @Autowired
    private ParametroService parametroService;

    public String cargarInicioAtencion() {
        try {
            atencion = new Atencion();
            atencionBean = new AtencionBean();
            documento = new Documento();
            listaTipoAtencion = new ArrayList<>();
            listaTipoTramite = new ArrayList<>();
            listaTipoDocumto = new ArrayList<>();
            // atencionBean.setNameTipoMotivo(MotivoAtencionType.get(atencion.getTipoMotivo()).getValue());
            setListaDocumentosAtencion(new ArrayList<>());
            return "iniciarAtencion";
        } catch (Exception e) {
            log.error("ERROR - cargarInicioAtencion()" + e);
        }
        return null;
    }
    
    public String accederBuscarDni() {
        try {
            if( atencion.getDni() != null ) {
                if(!consultarDatosReniec()) {
                    FiltroPersona filtroPersona = new FiltroPersona();
                    filtroPersona.setNumeroDni(atencion.getDni());
                    Ciudadano persona = ciudadanoServie.buscarDatosCiudadanoByDNI(filtroPersona);
                    if(persona != null){
                        atencion.setNombres(persona.getNombre1() + " " + persona.getNombre2());
                        atencion.setApellidoPaterno(persona.getApellidoPaterno());
                        atencion.setApellidoMaterno(persona.getApellidoMaterno());
                        atencion.setSexo(persona.getSexo());
                        if(persona.getFechaNacimiento() != null)
                            atencion.setFechaNacimiento(ComunUtil.getDateToString(persona.getFechaNacimiento()));
                        disableField = "true";
                    }
                }
            }
            atencionBean.setNameTipoMotivo(MotivoAtencionType.get(atencion.getTipoMotivo()).getValue());
            
            FiltroParametro filtroParametro = new FiltroParametro();
            
            if (StringUtils.equals(atencion.getTipoMotivo(), "D")){
                if(StringUtils.equals(atencion.getTipoAtencion(), "01")){
                    
                    // Tipo Atención
                    filtroParametro.setCodigoPadreParametro(ConstantesUtil.PARAMETRO_LISTA_TIPO_ATENCION_DOCUMENTARIO);
                    filtroParametro.setValorParametro(atencion.getTipoAtencion());
                    Parametro parametro = parametroService.consultarParametroValor(filtroParametro);
                    atencionBean.setNameTipoAtencion(parametro.getNombreParametro());
                    
                    // Tipo Tramite
                    filtroParametro.setCodigoPadreParametro(ConstantesUtil.PARAMETRO_LISTA_TRAMITE_DOCUMENTARIO_ADMINISTRATIVO);
                    filtroParametro.setValorParametro(atencion.getTipoTramite());
                    
                    parametro = parametroService.consultarParametroValor(filtroParametro);
                    atencionBean.setNameTipoTramite(parametro.getNombreParametro());
                    
                    page = ConstantesUtil.PAGE_RECEPCION_DOCUMENTOS_EXPEDIENTE;
                }else if(StringUtils.equals(atencion.getTipoAtencion(), "02")){
                    page = ConstantesUtil.PAGE_RECEPCION_DOCUMENTOS_ADMINISTRATIVOS;
                }
            } else {
                if(StringUtils.equals(atencion.getTipoMotivo(), "I")){
                    if(StringUtils.equals(atencion.getTipoAtencion(), "01")){
                        page = ConstantesUtil.PAGE_ATENCION_PRESENCIAL;
                    }
                }
            }
            return page;
        } catch (Exception e) {
            log.error("ERROR - accederBuscarDni()" + e);
        }
        return null;
    }
    
    public boolean consultarDatosReniec() {
        try {
            ServiceReniec reniec = new ServiceReniec();
            List<String> list = reniec.getConsultarServicio(atencion.getDni());
            if (list != null) {
                atencion.setApellidoPaterno(list.get(1));
                atencion.setApellidoMaterno(list.get(2));
                atencion.setNombres(list.get(4));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                Date date = formatter.parse(list.get(20));
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                atencion.setFechaNacimiento(formatter.format(date));
                if (StringUtils.equals(list.get(13), "1")) {
                    atencion.setSexo("M");
                } else {
                    atencion.setSexo("F");
                }
            } else {
                return false;
            }  
        } catch (Exception e) {
            log.error("ERROR - consultarReniec()" + e);
            msg.messageError("El servicio de RENIEC no esta disponible", null);
        }
        
        return true;
    }
    
    public String irRecepcionDocumentosAdministrativos() {
        FiltroTramite filtroTramite = new FiltroTramite();
        filtroTramite.setIdTipoTramite(Integer.parseInt(atencion.getTipoTramite()));
        iniciarListaTipoDocumento(filtroTramite);
        return ConstantesUtil.PAGE_RECEPCION_DOCUMENTOS_ADMINISTRATIVOS;
    }
    
    public void onBuscarDatosCiudadano() {
        System.err.println("Hola mundo");
    }
    
    public void onCargarDocumentosAtencion() {
        Documento oDocumento = new Documento();
        oDocumento.setCodDocumento(ComunUtil.generateCodigoByDate());
        oDocumento.setEstado(Constantes.ESTADO_ACTIVO);
        oDocumento.setDescEstado(documento.getDescEstado());
        oDocumento.setTamanioDoc(String.valueOf(fileUpload.getSize()/1024L));
        oDocumento.setExtensionDoc(fileUpload.getContentType());
        oDocumento.setAnexo(documento.getAnexo());
        oDocumento.setIdTipoDocumento(documento.getIdTipoDocumento());
        oDocumento.setUsuarioRegistro("JMATOS");
        oDocumento.setFechaRegistro(new Date());
        listaDocumentosAtencion.add(oDocumento);
    }
    
    public void handleFileUpload(AjaxBehaviorEvent event) {
        System.out.println("file size: " + fileUpload.getSize());
        System.out.println("file type: " + fileUpload.getContentType());
        System.out.println("file info: " + fileUpload.getHeader("Content-Disposition"));
    }

    
    public void limpiarIniciarAtencion() {
        atencion = new Atencion();
        atencion.setTipoMotivo("");
        atencion.setTipoAtencion("0");
        atencion.setIndicadorDocumentos("");
        listaTipoAtencion = new ArrayList<>();
        listaTipoTramite = new ArrayList<>();
        listaTipoDocumto = new ArrayList<>();
        setListaDocumentosAtencion((List<Documento>) new ArrayList());
    }
    
    public void actualizarListaTipoAtencion(String idMotivo){
        try {
            listaTipoTramite.clear();
            if (StringUtils.equals(idMotivo, "")) {
                listaTipoAtencion.clear();
            } else {
                if (StringUtils.equals(idMotivo, "D")) {
                    listaTipoAtencion = listasComunesController.listaTipoAtencionDocumentario(false, false, false);
                } else if (StringUtils.equals(idMotivo, "I")) {
                    listaTipoAtencion = listasComunesController.listaTipoAtencionIntervencion(false, false, false);
                }
            }
            atencion.setTipoAtencion("0");
            atencion.setIndicadorDocumentos("");
        } catch (Exception e) {
            log.error("ERROR - actualizarListaTipoAtencion()" + e);
        }
    }
    
    public void actualizarListaTipoTramite(String idAtencion,String idMotivo){
        try {
            if (StringUtils.equals(idAtencion, "")) {
                listaTipoTramite.clear();
            } else {
                if ((StringUtils.equals(idAtencion, "01") || StringUtils.equals(idAtencion, "02")) && StringUtils.equals(idMotivo, "D")) {
                    listaTipoTramite = listasComunesController.listaTramiteDocumentarioAdministrativo(false, false, false);
                } else if (StringUtils.equals(idAtencion, "01") && StringUtils.equals(idMotivo, "I")) {
                    listaTipoTramite = listasComunesController.listaTramiteIntervencionPresencial(false, false, false);
                }
            }
        } catch (Exception e) {
            log.error("ERROR - actualizarListaTipoTramite()" + e);
        }
    }
    
    public void iniciarListaTipoDocumento(FiltroTramite filtroTramite) {
        listaTipoDocumto = tipoDocumentoService.listarDocumentosByTramite(filtroTramite);
    }

    public void cargarModalAdjuntarDocumentos() {
        
    }
    
    
    /**
     * @return the atencion
     */
    public Atencion getAtencion() {
        return atencion;
    }

    /**
     * @param atencion the atencion to set
     */
    public void setAtencion(Atencion atencion) {
        this.atencion = atencion;
    }
    
    /**
     * @return the listaTipoAtencion
     */
    public List<Parametro> getListaTipoAtencion() {
        return listaTipoAtencion;
    }

    /**
     * @param listaTipoAtencion the listaTipoAtencion to set
     */
    public void setListaTipoAtencion(List<Parametro> listaTipoAtencion) {
        this.listaTipoAtencion = listaTipoAtencion;
    }

    /**
     * @return the listaTipoTramite
     */
    public List<Parametro> getListaTipoTramite() {
        return listaTipoTramite;
    }

    /**
     * @param listaTipoTramite the listaTipoTramite to set
     */
    public void setListaTipoTramite(List<Parametro> listaTipoTramite) {
        this.listaTipoTramite = listaTipoTramite;
    }
    
    /**
     * @return the disableField
     */
    public String getDisableField() {
        return disableField;
    }

    /**
     * @param disableField the disableField to set
     */
    public void setDisableField(String disableField) {
        this.disableField = disableField;
    }
    
    /**
     * @return the page
     */
    public String getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(String page) {
        this.page = page;
    }

    /**
     * @return the atencionBean
     */
    public AtencionBean getAtencionBean() {
        return atencionBean;
    }

    /**
     * @param atencionBean the atencionBean to set
     */
    public void setAtencionBean(AtencionBean atencionBean) {
        this.atencionBean = atencionBean;
    }

    /**
     * @return the renderTieneDiscapacidad
     */
    public boolean isRenderTieneDiscapacidad() {
        return renderTieneDiscapacidad;
    }

    /**
     * @param renderTieneDiscapacidad the renderTieneDiscapacidad to set
     */
    public void setRenderTieneDiscapacidad(boolean renderTieneDiscapacidad) {
        this.renderTieneDiscapacidad = renderTieneDiscapacidad;
    }

    /**
     * @return the listaTipoDocumto
     */
    public List<TipoDocumento> getListaTipoDocumto() {
        return listaTipoDocumto;
    }

    /**
     * @param listaTipoDocumto the listaTipoDocumto to set
     */
    public void setListaTipoDocumto(List<TipoDocumento> listaTipoDocumto) {
        this.listaTipoDocumto = listaTipoDocumto;
    }

    /**
     * @return the fileUpload
     */
    public Part getFileUpload() {
        return fileUpload;
    }

    /**
     * @param fileUpload the fileUpload to set
     */
    public void setFileUpload(Part fileUpload) {
        this.fileUpload = fileUpload;
    }

    /**
     * @return the listaDocumentosAtencion
     */
    public List<Documento> getListaDocumentosAtencion() {
        return listaDocumentosAtencion;
    }

    /**
     * @param listaDocumentosAtencion the listaDocumentosAtencion to set
     */
    public void setListaDocumentosAtencion(List<Documento> listaDocumentosAtencion) {
        this.listaDocumentosAtencion = listaDocumentosAtencion;
    }
    
    /**
     * @return the documento
     */
    public Documento getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
}
