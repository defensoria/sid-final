/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.controller;

import gob.dp.sid.administracion.parametro.constantes.Constantes;
import gob.dp.sid.atencion.bean.ArchivoDocumentoBean;
import gob.dp.sid.atencion.bean.AtencionBean;
import gob.dp.sid.atencion.entity.Atencion;
import gob.dp.sid.atencion.entity.Ciudadano;
import gob.dp.sid.atencion.service.PersonaCiudadanoService;
import gob.dp.sid.atencion.bean.FiltroPersona;
import gob.dp.sid.atencion.bean.FiltroTramite;
import gob.dp.sid.atencion.entity.Documento;
import gob.dp.sid.atencion.entity.Ticket;
import gob.dp.sid.atencion.entity.TipoDocumento;
import gob.dp.sid.atencion.entity.VisitaCiudadano;
import gob.dp.sid.atencion.entity.type.TipoDocumentoType;
import gob.dp.sid.atencion.entity.type.TratamientoProcesoType;
import gob.dp.sid.atencion.service.DocumentoService;
import gob.dp.sid.atencion.service.TicketService;
import gob.dp.sid.atencion.service.TipoDocumentoService;
import gob.dp.sid.atencion.service.VisitaService;
import gob.dp.sid.comun.ComunUtil;
import gob.dp.sid.comun.ConstantesUtil;
import gob.dp.sid.comun.controller.AbstractManagedBean;
import gob.dp.sid.comun.controller.ListasComunesController;
import gob.dp.sid.comun.entity.FiltroParametro;
import gob.dp.sid.comun.entity.Parametro;
import gob.dp.sid.comun.service.ParametroService;
import gob.dp.sid.comun.type.EstadoNumberType;
import gob.dp.sid.comun.type.EstadoType;
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
    private List<ArchivoDocumentoBean> listaDocumentoServer;
    private Ticket ticket;
    
    private String serverPathDocument;
    private String disableField = "false";
    private String page;
    private Part fileUpload;
    private String message;
    private boolean success;
    
    private String strDocumento;
    
    private boolean renderTieneDiscapacidad = false;
            
    @Autowired
    private ListasComunesController listasComunesController;
    
    @Autowired
    private PersonaCiudadanoService ciudadanoServie;
    
    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @Autowired
    private ParametroService parametroService;
    
    @Autowired
    private VisitaService visitaService;
    
    @Autowired
    private DocumentoService documentoService;

    @Autowired
    private TicketService ticketService;
    
    public String atenderTicket() {
        return "iniciarTicket";
    }
    public void generarCaso(){
        
    }
    
    public String cargarInicioAtencion() {
        try {
            ticket =new Ticket();
            atencion = new Atencion();
            atencionBean = new AtencionBean();
            documento = new Documento();
            listaTipoAtencion = new ArrayList<>();
            listaTipoTramite = new ArrayList<>();
            listaTipoDocumto = new ArrayList<>();
            listaDocumentoServer = new ArrayList<>();
            message = null;
            listaDocumentosAtencion = new ArrayList<>();
            serverPathDocument = ConstantesUtil.SERVER_PATH_DOCUMENTOS;
            loadDocumentos();
            
            return "iniciarAtencion";
        } catch (Exception e) {
            log.error("ERROR - cargarInicioAtencion()" + e);
        }
        return null;
    }
    
    // Buscar
    public void onChangeDniField() {
        System.out.println("INICIANDO BUSQUEDA DE DATOS");
        if( atencion.getDni() != null ) {
            if(!consultarDatosReniec()) {
                FiltroPersona filtroPersona = new FiltroPersona();
                filtroPersona.setNumeroDni(atencion.getDni());
                Ciudadano persona = ciudadanoServie.buscarDatosCiudadanoByDNI(filtroPersona);
                if(persona != null){
                    atencion.setIdPersona(persona.getIdPersona());
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
        atencion.setDiscapacidad("NO");
    }
    
    public String onBuscarDatosCiudadano() {
        try {    
            if( atencion.getDni() != null ) {
                if(!consultarDatosReniec()) {
                    FiltroPersona filtroPersona = new FiltroPersona();
                    filtroPersona.setNumeroDni(atencion.getDni());
                    Ciudadano persona = ciudadanoServie.buscarDatosCiudadanoByDNI(filtroPersona);
                    if(persona != null){
                        atencion.setIdPersona(persona.getIdPersona());
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
            atencion.setDiscapacidad("NO");
            atencionBean.setNameTipoMotivo(MotivoAtencionType.get(atencion.getTipoMotivo()).getValue());
        } catch (Exception e) {
            log.error("ERROR - accederBuscarDni()" + e);
        }
        return "iniciarAtencion";
    }
    
    public boolean onChangeTipoTramite() {
        boolean result = false;
        if(StringUtils.equalsIgnoreCase(atencion.getTipoMotivo(), "D")){
            result = true;
        } else if(StringUtils.equalsIgnoreCase(atencion.getTipoMotivo(), "I")){
            result = StringUtils.equalsIgnoreCase(atencion.getIndicadorCasoNuevo(), "S");
        }
        return result;
    }
    
    public boolean onChangeBuscarTramite() {
        boolean result = false;
        if(StringUtils.equalsIgnoreCase(atencion.getTipoMotivo(), "I")){
            result = StringUtils.equalsIgnoreCase(atencion.getTipoAtencion(), "02") && 
                    StringUtils.equalsIgnoreCase(atencion.getIndicadorCasoNuevo(), "N");
        }
        return result;
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
            atencion.setDiscapacidad("NO");
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
    
    public void loadDocumentos() {
        listaDocumentoServer = documentoService.listarDocumentosServer();
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
        if (StringUtils.equals(atencion.getTipoMotivo(), "D")){
            if(StringUtils.equals(atencion.getTipoAtencion(), "01")){
                page = ConstantesUtil.PAGE_RECEPCION_DOCUMENTOS_ADMINISTRATIVOS;
            }else if(StringUtils.equals(atencion.getTipoAtencion(), "02")){
                    page = ConstantesUtil.PAGE_RECEPCION_DOCUMENTOS_EXPEDIENTE;
            }
        } else {
            if(StringUtils.equals(atencion.getTipoMotivo(), "I")){
                if(StringUtils.equals(atencion.getTipoAtencion(), "01")){
                    page = ConstantesUtil.PAGE_ATENCION_PRESENCIAL;
                }
            }
        }    
        // return ConstantesUtil.PAGE_RECEPCION_DOCUMENTOS_ADMINISTRATIVOS;
        return page;
    }
    
    public boolean validarCargarDocumentos() {
        if(StringUtils.isBlank(documento.getRutaDoc())){
            msg.messageAlert("Debe indicar la ruta del documento", null);
            return false;
        }
        if(documento.getIdTipoDocumento() == null){
            msg.messageAlert("Debe indicar el tipo de documento", null);
            return false;
        }
        if(StringUtils.isBlank(documento.getAnexo())){
            msg.messageAlert("Debe indicar si el documento es un anexo o no", null);
            return false;
        }
        return true;
    }
    
    public void onCargarDocumentosAtencion() {
        ///if(validarCargarDocumentos()){
            Documento oDocumento = new Documento();
            oDocumento.setCodDocumento(ComunUtil.generateCodigoByDate());
            oDocumento.setEstado(Constantes.ESTADO_ACTIVO);
            oDocumento.setDescEstado(documento.getDescEstado());

            oDocumento.setRutaDoc(documento.getRutaDoc());
            oDocumento.setExtensionDoc("PDF");  
            oDocumento.setAnexo(documento.getAnexo());
            oDocumento.setIdTipoDocumento(documento.getIdTipoDocumento());
            oDocumento.setUsuarioRegistro("JMATOS");
            oDocumento.setFechaRegistro(new Date());

            FiltroTramite oFiltroTramite = new FiltroTramite();
            oFiltroTramite.setIdTipoDocumento(documento.getIdTipoDocumento());
            TipoDocumento tipoDocumento = tipoDocumentoService.getTipoDocumentoById(oFiltroTramite);
            if(tipoDocumento != null)
                oDocumento.setDescTipoDocumento(tipoDocumento.getTipoDocumento());
            else
                oDocumento.setDescTipoDocumento(TipoDocumentoType.OTROS.getValue());
            listaDocumentosAtencion.add(oDocumento);
        // }
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
        atencion.setAtencionPreferencial("");
        listaDocumentosAtencion = new ArrayList<>();
        
        documento = new Documento();
        // listaDocumentosAtencion = new ArrayList<>();
        // fileUpload = null;
        // documento.setAnexo("");
        // documento.setIdTipoDocumento(null);
    }
    
    public void openDocumentDialog() {
        fileUpload = null;
        documento.setAnexo("");
        documento.setIdTipoDocumento(null);
    }
    
    public void guardarAtencionCiudadano() {
       if(validarFormularioAtencion()){
            VisitaCiudadano visita = new VisitaCiudadano();
            visita.setFechaVisita(new Date());
            visita.setMotivo(atencion.getTipoMotivo());
            visita.setEstado(EstadoNumberType.ACTIVO.getKey());
            visita.setTieneDiscapacidad(0);
            visita.setObservacion(atencion.getObservaciones());
            
            visita.setTipoAtencionDiscapacidad(atencion.getTipoDiscapacidad());
            visita.setAtencionPreferencial(atencion.getAtencionPreferencial());
            
            
            visita.setTipoTramite(atencion.getTipoTramite());
            visita.setTipoAtencion(atencion.getTipoAtencion());
            visita.setDni(atencion.getDni());
            visita.setUsuarioCreacion("JMATOS");
            visita.setFechaCreacion(new Date());
            if (StringUtils.equals(atencion.getTipoMotivo(), "D")){
                if((StringUtils.equals(atencion.getTipoAtencion(), "01")) || (StringUtils.equals(atencion.getTipoAtencion(), "02"))){
                    visita.setIndicadorTratamiento(TratamientoProcesoType.PROCESO_SGD.getKey());
                } 
            } else if(StringUtils.equals(atencion.getTipoMotivo(), "I")){
                visita.setCasoNuevo(atencion.getIndicadorCasoNuevo());
                if(StringUtils.equalsIgnoreCase(atencion.getIndicadorCasoNuevo(), "N")){
                   if(StringUtils.equalsIgnoreCase(atencion.getIndicadorCita(), "S")){
                       visita.setTieneCita(1);
                   } else {
                       visita.setTieneCita(0);
                   }
                }
                if(StringUtils.equals(atencion.getTipoAtencion(), "01")){
                    visita.setIndicadorTratamiento(TratamientoProcesoType.PROCESO_SID.getKey());
                }
            }
            visitaService.registrarVisita(visita);
            guardarDocumentoAtencion(visita);
            guardarDatosTicket(visita);//Registro del ticket
            message = "La Atención del Ciudadano " + visita.getDni() + " ha sido registrada correctamente.";
            msg.messageInfo(message, "Registro de Atención");
            limpiarIniciarAtencion();
       } 
       
    }
    
    public void guardarDatosTicket(VisitaCiudadano visita){
        ticket = new Ticket();
        ticket.setIdVisita(visita.getId());
        ticket.setIdPersona(atencion.getIdPersona());
        ticket.setIdSede(1L);
        ticket.setNroTicket("CP001");
        if(visita.getAtencionPreferencial().equals("S")){
            ticket.setAtencionPreferente(1);
        }else{
            ticket.setAtencionPreferente(2);
        }
        ticket.setEstadoTicket(1);//1:En Cola
        ticket.setEstadoRegistro(1);//1:Activo
        ticket.setUsuarioCreacion("JCARRILLO");
        ticket.setFechaCreacion(new Date());
        ticketService.registrarTicket(ticket);
    }
    
    public boolean validarFormularioAtencion() {
        if (StringUtils.isBlank(atencion.getDni())) {
            msg.messageAlert("Debe Ingresar el DNI del Ciudadano", null);
            return false;
        }
        if(StringUtils.isBlank(atencion.getTipoMotivo())){
            msg.messageAlert("Debe indicar el motivo de la atención", null);
            return false;
        }
        if(StringUtils.isBlank(atencion.getTipoAtencion())){
            msg.messageAlert("Debe indicar el tipo de atención", null);
            return false;
        }
        if(StringUtils.isBlank(atencion.getIndicadorDocumentos())){
            msg.messageAlert("Debe indicar si trae o no documentos", null);
            return false;
        }
        if(atencion.getIndicadorDocumentos() != null && atencion.getIndicadorDocumentos().equals("S")){
            if(listaDocumentosAtencion == null || listaDocumentosAtencion.size() <= 0){
                msg.messageAlert("Debe adjuntar al menos un documento", "Documentos");
                return false;
            }
        }
        
        if(StringUtils.equals(atencion.getTipoMotivo(), "I")){
            if(StringUtils.isBlank(atencion.getIndicadorCasoNuevo())){
                msg.messageAlert("Debe indicar si se trata de un caso nuevo o no", null);
                return false;
            }else{
                if(StringUtils.equalsIgnoreCase(atencion.getIndicadorCasoNuevo(), "N")){
                    if(StringUtils.isBlank(atencion.getIndicadorCita())){
                        msg.messageAlert("Debe inidcar si el ciudadano cuenta con cita o no", null);
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public String onGuardarAtencionVisita() {
        try {
            VisitaCiudadano visita = new VisitaCiudadano();
            visita.setFechaVisita(new Date());

            visita.setMotivo(atencion.getTipoMotivo());
            visita.setEstado(EstadoNumberType.ACTIVO.getKey());
            visita.setTieneDiscapacidad(0);
            visita.setObservacion(atencion.getObservaciones());
            visita.setTipoAtencionDiscapacidad(atencion.getAtencionPreferencial());

            visita.setTipoTramite(atencion.getTipoTramite());
            visita.setTipoAtencion(atencion.getTipoAtencion());
            visita.setDni(atencion.getDni());
            visita.setUsuarioCreacion("JMATOS");
            visita.setFechaCreacion(new Date());

            if (StringUtils.equals(atencion.getTipoMotivo(), "D")){
                if((StringUtils.equals(atencion.getTipoAtencion(), "01")) || (StringUtils.equals(atencion.getTipoAtencion(), "02"))){
                    visita.setIndicadorTratamiento(TratamientoProcesoType.PROCESO_SGD.getKey());
                } 
            } else if(StringUtils.equals(atencion.getTipoMotivo(), "I")){
                if(StringUtils.equals(atencion.getTipoAtencion(), "01")){
                    visita.setIndicadorTratamiento(TratamientoProcesoType.PROCESO_SID.getKey());
                }
            }
            visitaService.registrarVisita(visita);
            guardarDocumentoAtencion(visita);
            message = "La Atención del Ciudadano " + visita.getDni() + " ha sido registrada correctamente.";
            System.out.println("Registro Guardado" + visita.getDni());
        } catch (Exception e) {
            message = "Ocurrió un error en el aplicativo, por favor intente mas tarde.";
            e.printStackTrace();
        }
        
        return page;
    }
    
    public void guardarDocumentoAtencion(VisitaCiudadano oVisita) {
        System.out.println("Guardando Documentos...");
        for(Documento d : listaDocumentosAtencion) {
            d.setIdRegVisita(Integer.parseInt(String.valueOf(oVisita.getId())));
            documentoService.registrarDocumento(d);
        }
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
                if (StringUtils.equals(idAtencion, "01") && StringUtils.equals(idMotivo, "D")) {
                    listaTipoTramite = listasComunesController.listaTramiteDocumentarioAdministrativo(false, false, false);
                } else if (StringUtils.equals(idAtencion, "02") && StringUtils.equals(idMotivo, "D")) {
                    listaTipoTramite = listasComunesController.listaTramiteExistenteDocumentario(false, false, false);
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

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return the serverPathDocument
     */
    public String getServerPathDocument() {
        return serverPathDocument;
    }

    /**
     * @param serverPathDocument the serverPathDocument to set
     */
    public void setServerPathDocument(String serverPathDocument) {
        this.serverPathDocument = serverPathDocument;
    }

    /**
     * @return the strDocumento
     */
    public String getStrDocumento() {
        return strDocumento;
    }

    /**
     * @param strDocumento the strDocumento to set
     */
    public void setStrDocumento(String strDocumento) {
        this.strDocumento = strDocumento;
    }

    /**
     * @return the listaDocumentoServer
     */
    public List<ArchivoDocumentoBean> getListaDocumentoServer() {
        return listaDocumentoServer;
    }

    /**
     * @param listaDocumentoServer the listaDocumentoServer to set
     */
    public void setListaDocumentoServer(List<ArchivoDocumentoBean> listaDocumentoServer) {
        this.listaDocumentoServer = listaDocumentoServer;
    }
}
