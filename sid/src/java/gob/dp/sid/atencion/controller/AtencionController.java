/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.controller;

import gob.dp.sid.administracion.parametro.constantes.Constantes;
import gob.dp.sid.administracion.seguridad.controller.LoginController;
import gob.dp.sid.administracion.seguridad.entity.Usuario;
import gob.dp.sid.administracion.seguridad.service.UsuarioService;
import gob.dp.sid.atencion.bean.ArchivoDocumentoBean;
import gob.dp.sid.atencion.bean.AtencionBean;
import gob.dp.sid.atencion.entity.Atencion;
import gob.dp.sid.atencion.entity.Ciudadano;
import gob.dp.sid.atencion.service.PersonaCiudadanoService;
import gob.dp.sid.atencion.bean.FiltroPersona;
import gob.dp.sid.atencion.bean.FiltroTicket;
import gob.dp.sid.atencion.bean.FiltroTramite;
import gob.dp.sid.atencion.entity.AtencionTicket;
import gob.dp.sid.atencion.entity.Documento;
import gob.dp.sid.atencion.entity.Ticket;
import gob.dp.sid.atencion.entity.TipoDocumento;
import gob.dp.sid.atencion.entity.UsuarioVentanilla;
import gob.dp.sid.atencion.entity.Ventanilla;
import gob.dp.sid.atencion.entity.VisitaCiudadano;
import gob.dp.sid.atencion.entity.type.EstadoRegistroType;
import gob.dp.sid.atencion.entity.type.EstadoTicketType;
import gob.dp.sid.atencion.entity.type.TipoDocumentoType;
import gob.dp.sid.atencion.entity.type.TratamientoProcesoType;
import gob.dp.sid.atencion.service.DocumentoService;
import gob.dp.sid.atencion.service.TicketService;
import gob.dp.sid.atencion.service.TipoDocumentoService;
import gob.dp.sid.atencion.service.UsuarioVentanillaService;
import gob.dp.sid.atencion.service.VentanillaService;
import gob.dp.sid.atencion.service.VisitaService;
import gob.dp.sid.comun.AlphanumFileComparator;
import gob.dp.sid.comun.ComunUtil;
import gob.dp.sid.comun.ConstantesUtil;
import gob.dp.sid.comun.controller.AbstractManagedBean;
import gob.dp.sid.comun.controller.ListasComunesController;
import gob.dp.sid.comun.entity.FiltroParametro;
import gob.dp.sid.comun.entity.Parametro;
import gob.dp.sid.comun.service.ParametroService;
import gob.dp.sid.comun.service.UbigeoService;
import gob.dp.sid.comun.type.EstadoNumberType;
import gob.dp.sid.comun.type.MotivoAtencionType;
import gob.dp.sid.comun.type.TipoDocumentoIdentidadType;
import gob.dp.sid.registro.controller.RegistroController;
import gob.dp.sid.registro.entity.Expediente;
import gob.dp.sid.registro.entity.ExpedienteVisita;
import gob.dp.sid.registro.service.ExpedienteService;
import gob.dp.sid.registro.service.ExpedienteVisitaService;
import java.io.BufferedReader;
import java.io.FileFilter;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pe.gob.defensoria.wsdl.service.ServiceReniec;
import java.io.File; 
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author jcarrillo
 */
@Named
@Scope("session")
public class AtencionController extends AbstractManagedBean implements Serializable {

    private static final Logger log = Logger.getLogger(AtencionController.class);
    private Usuario usuarioSession;
    private Atencion atencion;
    private AtencionTicket atencionTicket;
    private List<Parametro> listaTipoDocumentoIdentidad;
    private UsuarioVentanilla usuarioVentanilla;
    private Ventanilla ventanilla;
    private Documento documento;
    private AtencionBean atencionBean;
    private List<Parametro> listaTipoAtencion; 
    private List<Parametro> listaTipoTramite;
    private List<TipoDocumento> listaTipoDocumto;
    private List<Documento> listaDocumentosAtencion;
    private List<Documento> listaDocumentosAtencionRetorno;
    private List<ArchivoDocumentoBean> listaDocumentoServer;
    private boolean disableField = false;
    private Ticket ticket;
    private List<Expediente> listaExpedienteXDNIPaginado;
    private List<Usuario> listaUsuarios;
    private List<Ventanilla> listaVentanilla;
    private List<UsuarioVentanilla> listaUsuarioVentanilla;
    private Integer nroPagina = 1;
    private String serverPathDocument;
    private String page;
    private Part fileUpload;
    private String message;
    private boolean success;
    private boolean disabledGuardar;
    private String strDocumento;
    private VisitaCiudadano visitaCiudadano;
    private boolean renderTieneDiscapacidad = false;
    private boolean renderTicketAtencion = false;
    private boolean disableTipoAtencion = false;
    private boolean adjuntarArchivosExpedExiste = false;
    private boolean disabledAgregarUsuVen;
    private Expediente expediente;
            
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
    
    @Autowired
    private ExpedienteService expedienteService;

    @Autowired
    private UbigeoService ubigeoService;
    
    @Autowired
    private ExpedienteVisitaService expedienteVisitaService;
    
    @Autowired
    private UsuarioVentanillaService usuarioVentanillaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private VentanillaService ventanillaService;
    
    public String cargarUsuarioVentanilla() {
        usuarioSession();
        UsuarioVentanilla usuarioParam =new UsuarioVentanilla();
        usuarioVentanilla =new UsuarioVentanilla();
        ventanilla =new Ventanilla();
        listaUsuarios = new ArrayList<>();
        listaVentanilla = new ArrayList<>();
        listaVentanilla = ventanillaService.listarVentanillas(ventanilla);
        List<Usuario> listaUsuarioTmp = usuarioService.buscarUsuarioTotal();
        for(Usuario u : listaUsuarioTmp){
            if(u.getCodigoOD().equals(usuarioSession.getCodigoOD())){
                listaUsuarios.add(u);
            }
        }
        usuarioParam.setIdSede(usuarioSession.getCodigoOD().longValue());
        listaUsuarioVentanilla = usuarioVentanillaService.listarUsuarioVentanilla(usuarioParam);
        for(UsuarioVentanilla uv: listaUsuarioVentanilla){
            for(Ventanilla v: listaVentanilla){
                if(uv.getIdVentanilla().equals(v.getIdVentanilla())){
                    uv.setCodVentanilla(v.getCodVentanilla());
                }
            }
        }
        disabledAgregarUsuVen=true;
        return "asignarUsuarioVentanilla";
    }
    
    public void leerArchivoAction(){
        leerArchivosTemporales();
    }
    
    private void leerArchivosTemporales(){
        listaDocumentosAtencion = new ArrayList();
        Scanner sc = new Scanner(System.in);
        //String ruta = sc.nextLine();
        String ruta = ConstantesUtil.FILE_DONWLOAD_SCANNER+"/";
        //System.out.println("Escribe la extension: ");
        //String ext = sc.nextLine();
        String ext = "pdf";
        File carpeta = new File(ruta);
        FileFilter fileFilter = new WildcardFileFilter("*." + ext);
        if (carpeta.exists()) {
            if (carpeta.isDirectory()) {
                File[] archivos = carpeta.listFiles(fileFilter);
                Arrays.sort(archivos, new AlphanumFileComparator());
                for (int i = 0; i < archivos.length; i++) {
                    //System.out.println(archivos[i].getName());
                    Documento doc = new Documento();
                    doc.setFileName(archivos[i].getName());
                    listaDocumentosAtencion.add(doc);
                }
            }
        }
    }
    
    public String editarUsuarioVentanilla(UsuarioVentanilla usuVen,String accion) {
        disabledAgregarUsuVen=false;
        if(accion.equals("I")){
            if(usuVen.getEstadoAsignacion().equals(0)){
                usuVen.setEstadoAsignacion(1);
            }else{
                usuVen.setEstadoAsignacion(0);
            }
            usuVen.setUsuarioModificacion(usuarioSession.getCodigo());
            usuVen.setFechaModificacion(new Date());
            usuarioVentanillaService.actualizarUsuarioVentanilla(usuVen);
        }else{
            usuarioVentanilla=usuVen;    
        }
        return "asignarUsuarioVentanilla";
    }
    
    public String modificarUsuarioVentanilla(){
        usuarioVentanilla.setUsuarioModificacion(usuarioSession.getCodigo());
        usuarioVentanilla.setFechaModificacion(new Date());
        usuarioVentanillaService.actualizarUsuarioVentanilla(usuarioVentanilla);
        cargarUsuarioVentanilla();
        return "asignarUsuarioVentanilla";
    }
    
    public String asignarUsuarioVentanilla() {
        try {
            usuarioVentanilla.setIdSede(usuarioSession.getCodigoOD().longValue());
            usuarioVentanilla.setEstadoAsignacion(EstadoRegistroType.ACTIVO.getKey());
            usuarioVentanilla.setUsuarioCreacion(usuarioSession.getCodigo());
            usuarioVentanilla.setFechaCreacion(new Date());
            usuarioVentanillaService.registrarUsuarioVentanilla(usuarioVentanilla);
            cargarUsuarioVentanilla();
        } catch (Exception e) {
            log.error("ERROR - asignarUsuarioVentanilla()" + e);
        }
        return "asignarUsuarioVentanilla";
    }
    
    public String atenderTicket() {
        usuarioSession();
        atencion =new Atencion();
        atencionTicket =new AtencionTicket();
        UsuarioVentanilla usuarioParam =new UsuarioVentanilla();
        UsuarioVentanilla usuarioVentanilla =new UsuarioVentanilla();
        ticket = new Ticket();
        FiltroTicket filtroTicket = new FiltroTicket();
        filtroTicket.setEstadoRegistro(EstadoRegistroType.ACTIVO.getKey());
        filtroTicket.setEstadoTicket(EstadoTicketType.TICKET_EN_COLA.getKey());
        filtroTicket.setIdSede(usuarioSession.getCodigoOD().longValue());
        
        usuarioParam.setCodigoUsuario(usuarioSession.getCodigo());
        usuarioVentanilla = usuarioVentanillaService.buscarUsuarioVentanilla(usuarioParam);
        
        if(usuarioVentanilla != null){
            ticket = ticketService.obtenerTicketAtencion(filtroTicket);
            if(ticket != null && ticket.getIdTicket() != null){
                atencionTicket =ticketService.obtenerDatosAtencionTicket(ticket.getIdTicket());
                atencionTicket.setIdTicket(ticket.getIdTicket());
                atencionTicket.setIdSede(usuarioSession.getCodigoOD().longValue());
                atencionTicket.setCodigoUsuarioAtencionTicket(usuarioSession.getCodigo());
                atencionTicket.setFechaInicioAtencionTicket(new Date());
                atencionTicket.setEstadoAtencionTicket(EstadoRegistroType.ACTIVO.getKey());
                atencionTicket.setIdVentanilla(usuarioVentanilla.getIdVentanilla());
                ticketService.actualizarEstadoTicket(ticket);
                registrarAtencionTicket();
            }else{
                message = "No existen Ticket pendientes.";
                msg.messageInfo(message, "Atención de Tickets");
            }    
        }else{
            message = "Usted no tiene asignado una ventanilla de atención de tickets.";
            msg.messageInfo(message, "Atención de Tickets");
        }

        return "iniciarTicket";
    }
    
    public void inicializarProcesoSolicitudIntervencion() {
        // Inicializar con solicitud de intervencion
        atencion.setTipoMotivo(MotivoAtencionType.SOLICITUD_INTERVENCION.getKey());
        actualizarListaTipoAtencion(MotivoAtencionType.SOLICITUD_INTERVENCION.getKey());
    }
    
    public void registrarAtencionTicket(){
        try {
            ticketService.registrarAtencionTicket(atencionTicket);
        } catch (Exception e) {
            log.error("ERROR - registrarAtencionTicket()" + e);
        }
    }
    
    public void actualizarFechaFinAtencionTicket(){
        try {
            atencionTicket.setFechaFinAtencionTicket(new Date());
            ticketService.actualizarFechaFinAtencionTicket(atencionTicket);
        } catch (Exception e) {
            log.error("ERROR - registrarAtencionTicket()" + e);
        }
    }
    
    public void generarTicket(){
        try {
            guardarAtencionCiudadano(true);
            guardarDatosTicket(visitaCiudadano);
            message = "Se ha generado el Ticket " + ticket.getNroTicket() + " correctamente.";
            msg.messageInfo(message, "Generación de Ticket");
            cargarInicioAtencion();
        } catch (Exception e) {
            log.error("ERROR - generarTicket()" + e);
        }
    }
    
    private void usuarioSession() {
        try {
            usuarioSession = new Usuario();
            FacesContext context = FacesContext.getCurrentInstance();
            LoginController loginController = (LoginController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "loginController");
            usuarioSession = loginController.getUsuarioSesion();
            usuarioSession.setNombreDepartamento(ubigeoService.departamentoOne(usuarioSession.getIdDepartamento()).getDescripcion());
        } catch (Exception e) {
            log.error("ERROR - usuarioSession()" + e);
        }
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
            // listaDocumentosAtencionRetorno = new ArrayList<>();
            serverPathDocument = ConstantesUtil.FILE_DONWLOAD;
            listaExpedienteXDNIPaginado = new ArrayList<>();
            disabledGuardar = false;
            // loadDocumentos();
            visitaCiudadano = new VisitaCiudadano();
            disableTipoAtencion = false;
            adjuntarArchivosExpedExiste = false;
            expediente = new Expediente();
            usuarioSession();
            
            listaTipoDocumentoIdentidad = new ArrayList<>();
            disableField = false;
            
            // iniciar Tipo de Documentos
            List<Parametro> parametros = listasComunesController.listaTipoDocumentoIdentidad(false, false, false);
            for(Parametro p: parametros){
                if(p.getValorParametro().equals(ConstantesUtil.PARAMETRO_TIPO_DOCUMENTO_DNI) 
                        || p.getValorParametro().equals(ConstantesUtil.PARAMETRO_TIPO_DOCUMENTO_CE) 
                        || p.getValorParametro().equals(ConstantesUtil.PARAMETRO_TIPO_DOCUMENTO_INDOCUMENTADO)){
                    listaTipoDocumentoIdentidad.add(p);
                }
            }
            
            // Inicializar con solicitud de intervencion
            inicializarProcesoSolicitudIntervencion();
            return "iniciarAtencion";
        } catch (Exception e) {
            log.error("ERROR - cargarInicioAtencion()" + e);
        }
        return null;
    }
    
    public void limpiarDatosCiudadano() {
        atencion.setApellidoPaterno("");
        atencion.setApellidoMaterno("");
        atencion.setNombres("");
        atencion.setFechaNacimiento("");
        atencion.setSexo("");
        atencion.setDiscapacidad("");
    }
    
    public void guardarDatosPersona() throws Exception{
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setDni(atencion.getDni());
        ciudadano.setNombre1(atencion.getNombres());
        ciudadano.setApellidoPaterno(atencion.getApellidoPaterno());
        ciudadano.setApellidoMaterno(atencion.getApellidoMaterno());
        // ciudadano.setTipoDocumento(TipoDocumentoIdentidadType.DNI.getKey());
        ciudadano.setTipoDocumento(atencion.getTipoDocumento());
        ciudadano.setFechaNacimiento(atencion.getDtFechaNacimiento());
        
        if(atencion.getSexo() != null)
            ciudadano.setSexo("" + atencion.getSexo().charAt(0));
        if(atencion.getDiscapacidad() != null){
            if(atencion.getDiscapacidad().equals("SI")){
                ciudadano.setDiscacidad(1);
            } else {
                ciudadano.setDiscacidad(0);
            }
        }
        ciudadano.setFechaCreacion(new Date());
        ciudadano.setUsuarioCreacion(usuarioSession.getCodigo());
        ciudadano = ciudadanoServie.registrarCiudadano(ciudadano);
        atencion.setIdPersona(ciudadano.getIdPersona());
    }
    
    
    // Buscar
    public void onChangeDniField() {
        limpiarDatosCiudadano();
        System.out.println("INICIANDO BUSQUEDA DE DATOS");
        if( atencion.getDni() != null ) {
            FiltroPersona filtroPersona = new FiltroPersona();
            filtroPersona.setNumeroDni(atencion.getDni());
            Ciudadano persona = ciudadanoServie.buscarDatosCiudadanoByDNI(filtroPersona);
            if(persona != null){
                atencion.setIdPersona(persona.getIdPersona());
                atencion.setNombres(persona.getNombre1() + " " + (persona.getNombre2() != null ? persona.getNombre2() : "" ) );
                atencion.setApellidoPaterno(persona.getApellidoPaterno());
                atencion.setApellidoMaterno(persona.getApellidoMaterno());
                atencion.setSexo(persona.getSexo());
                if(persona.getFechaNacimiento() != null)
                    atencion.setFechaNacimiento(ComunUtil.getDateToString(persona.getFechaNacimiento()));
            } else {
                if(atencion.getTipoDocumento().equals(ConstantesUtil.PARAMETRO_TIPO_DOCUMENTO_DNI)){
                    consultarDatosReniec();
                } 
            }  
            // Habilitar campos
            if(atencion.getIdPersona() != null) {
                disableField = true;
            } else{
                disableField = false;
            }
            /*if(atencion.getTipoDocumento().equals(ConstantesUtil.PARAMETRO_TIPO_DOCUMENTO_DNI)){
                disableField = true;
            } else if(atencion.getTipoDocumento().equals(ConstantesUtil.PARAMETRO_TIPO_DOCUMENTO_CE) 
                    || atencion.getTipoDocumento().equals(ConstantesUtil.PARAMETRO_TIPO_DOCUMENTO_INDOCUMENTADO)){
                disableField = false;
            } */
            // Buscar Tramites:
            buscarListaExpedienteByDNI(1, atencion.getDni());
        }
        atencion.setDiscapacidad("NO");
        atencion.setAtencionPreferencial("N");
    }
    
    public String onBuscarDatosCiudadano() {
        try {    
            limpiarDatosCiudadano();
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
                    } else {
                        if(atencion.getTipoDocumento().equals(ConstantesUtil.PARAMETRO_TIPO_DOCUMENTO_DNI)){
                            consultarDatosReniec();
                        }
                    }
                    
                    // Habilitar campos
                    if(atencion.getTipoDocumento().equals(ConstantesUtil.PARAMETRO_TIPO_DOCUMENTO_DNI)){
                        disableField = true;
                    } else if(atencion.getTipoDocumento().equals(ConstantesUtil.PARAMETRO_TIPO_DOCUMENTO_CE) 
                            || atencion.getTipoDocumento().equals(ConstantesUtil.PARAMETRO_TIPO_DOCUMENTO_INDOCUMENTADO)){
                        disableField = false;
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
        Ciudadano ciudadano = new Ciudadano();
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
                ciudadano.setDni(atencion.getDni());
                ciudadano.setNombre1(atencion.getNombres());
                ciudadano.setApellidoPaterno(atencion.getApellidoPaterno());
                ciudadano.setApellidoMaterno(atencion.getApellidoMaterno());
                ciudadano.setTipoDocumento(TipoDocumentoIdentidadType.DNI.getKey());
                ciudadano.setFechaNacimiento(date);
                ciudadano.setSexo(atencion.getSexo());
                ciudadano.setDiscacidad(0);
                ciudadano.setFechaCreacion(new Date());
                ciudadano.setUsuarioCreacion(usuarioSession.getCodigo());
                ciudadano = ciudadanoServie.registrarCiudadano(ciudadano);
                atencion.setIdPersona(ciudadano.getIdPersona());
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
        if(documento.getIdTipoDocumento() == null){
            msg.messageAlert("Debe indicar el tipo de documento", null);
            return false;
        }
        if(StringUtils.isBlank(documento.getAnexo())){
            msg.messageAlert("Debe indicar si el documento es un anexo o no", null);
            return false;
        }
        if(fileUpload == null){
            msg.messageAlert("Debe indicar la ruta del documento", null);
            return false;
        }
        return true;
    }
    
    public void onCargarDocumentosAtencion() {
        String folderServer = ConstantesUtil.FILE_DONWLOAD;
        if(validarCargarDocumentos()){
            Documento oDocumento = new Documento();
            oDocumento.setCodDocumento(ComunUtil.generateCodigoByDate());
            oDocumento.setEstado(Constantes.ESTADO_ACTIVO);
            oDocumento.setDescEstado(documento.getDescEstado());
            String ext = FilenameUtils.getExtension(fileUpload.getSubmittedFileName());
            String filename = ComunUtil.generateCodigoByDate() + "_" + usuarioSession.getCodigoOD() + "." + ext;
            oDocumento.setRutaDoc(folderServer+"/"+filename);
            //oDocumento.setRutaDoc(filename);
            oDocumento.setRutaDoc(filename);
            oDocumento.setFileName(filename);
            oDocumento.setExtensionDoc(fileUpload.getContentType());
            oDocumento.setTamanioDoc(String.valueOf(fileUpload.getSize()));
            oDocumento.setAnexo(documento.getAnexo());
            oDocumento.setIdTipoDocumento(documento.getIdTipoDocumento());
            oDocumento.setUsuarioRegistro(usuarioSession.getCodigo());
            oDocumento.setFechaRegistro(new Date());
            oDocumento.setDocumento(fileUpload);
            
            FiltroTramite oFiltroTramite = new FiltroTramite();
            oFiltroTramite.setIdTipoDocumento(documento.getIdTipoDocumento());
            TipoDocumento tipoDocumento = tipoDocumentoService.getTipoDocumentoById(oFiltroTramite);
            if(tipoDocumento != null)
                oDocumento.setDescTipoDocumento(tipoDocumento.getTipoDocumento());
            else
                oDocumento.setDescTipoDocumento(TipoDocumentoType.OTROS.getValue());
            listaDocumentosAtencion.add(oDocumento);
            documento.setIdTipoDocumento(null);
            documento.setAnexo(null);
        }
    }
    
    public Documento onDefinirDocumento(Documento oDocumento) {
            oDocumento.setCodDocumento(oDocumento.getFileName());
            oDocumento.setEstado(Constantes.ESTADO_ACTIVO);
            oDocumento.setDescEstado(documento.getDescEstado());
            //String ext = FilenameUtils.getExtension(fileUpload.getSubmittedFileName());
            //String filename = ComunUtil.generateCodigoByDate() + "_" + usuarioSession.getCodigoOD() + "." + ext;
            oDocumento.setRutaDoc(ConstantesUtil.FILE_DONWLOAD_SCANNER_FINAL+"/"+oDocumento.getFileName());

            //oDocumento.setExtensionDoc(fileUpload.getContentType());
            //oDocumento.setExtensionDoc(getFileExtension(oDocumento.getFileName()));
            //oDocumento.setTamanioDoc(String.valueOf(fileUpload.getSize()));
            //oDocumento.setAnexo(documento.getAnexo());
            //oDocumento.setIdTipoDocumento(documento.getIdTipoDocumento());
            oDocumento.setUsuarioRegistro(usuarioSession.getCodigo());
            oDocumento.setFechaRegistro(new Date());
            //oDocumento.setDocumento(fileUpload);
            
            /*FiltroTramite oFiltroTramite = new FiltroTramite();
            oFiltroTramite.setIdTipoDocumento(documento.getIdTipoDocumento());
            TipoDocumento tipoDocumento = tipoDocumentoService.getTipoDocumentoById(oFiltroTramite);
            if(tipoDocumento != null)
                oDocumento.setDescTipoDocumento(tipoDocumento.getTipoDocumento());
            else*/
                oDocumento.setDescTipoDocumento(TipoDocumentoType.OTROS.getValue());
            //listaDocumentosAtencion.add(oDocumento);
            //documento.setIdTipoDocumento(null);
            //documento.setAnexo(null);
        
        return oDocumento;
    }
    
    
    public String getFileExtension(String name) {
        try {
            return name.substring(name.lastIndexOf("."));
        } catch (Exception e) {
            return "";
        }
    }
    
    public void handleFileUpload(AjaxBehaviorEvent event) {
        System.out.println("file size: " + fileUpload.getSize());
        System.out.println("file type: " + fileUpload.getContentType());
        System.out.println("file info: " + fileUpload.getHeader("Content-Disposition"));
        
    
    }

    
    public void uploadFileServer() {
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void limpiarIniciarAtencion() {
        atencion = new Atencion();
        atencion.setTipoMotivo("");
        atencion.setTipoAtencion("0");
        atencion.setIndicadorDocumentos("");
         atencion.setTipoDocumento("");
        
        listaTipoAtencion = new ArrayList<>();
        listaTipoTramite = new ArrayList<>();
        listaTipoDocumto = new ArrayList<>();
        atencion.setAtencionPreferencial("");
        listaDocumentosAtencion = new ArrayList<>();
        listaDocumentosAtencionRetorno = null;
        listaExpedienteXDNIPaginado = new ArrayList<>();
        documento = new Documento();
        disabledGuardar = false;
        visitaCiudadano = new VisitaCiudadano();
        disableTipoAtencion = false;
        adjuntarArchivosExpedExiste = false;
        expediente = new Expediente();
        disableField = false;
        
        inicializarProcesoSolicitudIntervencion();
    }
    
    public void openDocumentDialog() {
        fileUpload = null;
        documento.setAnexo("");
        documento.setIdTipoDocumento(null);
    }
    
    public void guardarAtencionCiudadano(boolean isTicket) {
        try {
            listaDocumentosAtencionRetorno = new ArrayList<>();
          //  if(validarFormularioAtencion()){
                if(!atencion.getTipoDocumento().equals(ConstantesUtil.PARAMETRO_TIPO_DOCUMENTO_DNI)){
                    guardarDatosPersona();
                }
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
                visita.setUsuarioCreacion(usuarioSession.getCodigo());
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
                    /**revisar cleonv*/
                    if(StringUtils.equals(atencion.getTipoAtencion(), "01") || StringUtils.equals(atencion.getTipoAtencion(), "02")){
                        visita.setIndicadorTratamiento(TratamientoProcesoType.PROCESO_SID.getKey());
                    }
                } else if(StringUtils.equals(atencion.getTipoMotivo(), "P")){
                    visita.setIndicadorTratamiento(TratamientoProcesoType.PROCESO_SGD.getKey());
                }
                visita.setIdPersona(Integer.valueOf(String.valueOf(atencion.getIdPersona())));
                visitaService.registrarVisita(visita);
                guardarDocumentoAtencion(visita);
                //guardarDatosTicket(visita);
                
                visitaCiudadano = visita;
                if(!isTicket){
                   message = "La Atención del Ciudadano " + visita.getDni() + " ha sido registrada correctamente.";
                   msg.messageInfo(message, "Registro de Atención");
                }
                // limpiarIniciarAtencion();
                disabledGuardar = true;
                if(visita.getId() != null)
                    listaDocumentosAtencionRetorno = documentoService.buscarExpedienteByVisita(visita.getId());
                
        //}  
            //FacesContext.getCurrentInstance().getExternalContext().redirect("iniciarAtencion.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       // return "iniciarAtencion";
    }
    
    public void onVerificarAtencionTicket() {
        
        boolean tramiteDocRecepcionDocAdmin = StringUtils.equalsIgnoreCase(atencion.getTipoMotivo(), "D") 
                    && StringUtils.equalsIgnoreCase(atencion.getTipoAtencion(), "01");
        
        boolean tramiteDocRecepDocExped = StringUtils.equalsIgnoreCase(atencion.getTipoMotivo(), "D")
                        && StringUtils.equalsIgnoreCase(atencion.getTipoAtencion(), "02");
        if(tramiteDocRecepcionDocAdmin){
            renderTicketAtencion = true;
        } else if(tramiteDocRecepDocExped){
            renderTicketAtencion = false;
        }
        renderTicketAtencion = true;
        
        
        
    }
    
    public void guardarDatosTicket(VisitaCiudadano visita){
        Map<String, Object> params = new HashMap<String, Object>();
        ticket = new Ticket();
        ticket.setIdVisita(visita.getId());
        ticket.setIdPersona(atencion.getIdPersona());
        ticket.setIdSede(usuarioSession.getCodigoOD().longValue());
        if(visita.getAtencionPreferencial().equals("S")){
            ticket.setAtencionPreferente(1);
        }else{
            ticket.setAtencionPreferente(2);
        }
        params.put("inPreferente", ticket.getAtencionPreferente());
        params.put("inSede", ticket.getIdSede());
        params.put("outNroTicket", null);
        ticketService.obtenerCodigoTicket(params);
        ticket.setNroTicket(params.get("outNroTicket").toString());
        ticket.setEstadoTicket(EstadoTicketType.TICKET_EN_COLA.getKey());
        ticket.setEstadoRegistro(EstadoRegistroType.ACTIVO.getKey());
        ticket.setUsuarioCreacion(usuarioSession.getCodigo());
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
        if(atencion.getIndicadorDocumentos() != null 
                && atencion.getIndicadorDocumentos().equals("S")){
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
                
        if(atencion.getTipoDocumento().equalsIgnoreCase(ConstantesUtil.PARAMETRO_TIPO_DOCUMENTO_CE)){
            if(StringUtils.isBlank(atencion.getNombres())){
                msg.messageAlert("Debe inidicar los nombres del ciudadano.", null);
                return false;
            }

            if(StringUtils.isBlank(atencion.getApellidoPaterno())){
                msg.messageAlert("Debe indicar el apellido paterno del ciudadano", null);
                return false;
            }

            if(StringUtils.isBlank(atencion.getApellidoMaterno())){
                msg.messageAlert("Debe inidcar el apellido materno del ciudadano", null);
                return false;
            }

            /*if(StringUtils.isBlank(atencion.getFechaNacimiento())){
                msg.messageAlert("Debe indicar la fecha de nacimiento del ciudadano", null);
                return false;
            }*/

            if(StringUtils.isBlank(atencion.getSexo())){
                msg.messageAlert("Debe indicar el sexo del ciudadano", null);
                return false;
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
            visita.setUsuarioCreacion(usuarioSession.getCodigo());
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
    
    public void buscarListaExpedienteByDNI(Integer pagina, String dni) {
        try {
            Expediente e = new Expediente();
            e.setFiltroNroDNI(dni);
            if (pagina > 0) {
                int paginado = ConstantesUtil.PAGINADO_10;
                Integer ini = paginado * (pagina - 1) + 1;
                Integer fin = paginado * pagina;
                if (pagina == 0) {
                    ini = 1;
                    fin = 10;
                }
                e.setIni(ini);
                e.setFin(fin);
                List<Expediente> list = expedienteService.expedienteBuscarPersonaByDNIPaginado(e);
                
                FacesContext context = FacesContext.getCurrentInstance();
                RegistroController registroController = (RegistroController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "registroController");
                
                if (list.size() > 0) {
                    for (Expediente e1 : list) {
                        e1.setEtapaDetalle(registroController.devolverEtapa(e1));
                        if (StringUtils.isNoneBlank(e1.getNumero())) {
                            e1.setEstadoDetalle(registroController.detalleUltimoEstado(e1.getNumero()));
                        }
                    }
                    listaExpedienteXDNIPaginado = list;
                    nroPagina = pagina;
                }
            }
            System.out.println("Expedientes: " + listaExpedienteXDNIPaginado.size());
        } catch (Exception e) {
            log.error("ERROR - buscarListaExpedienteByDNI()" + e);
        }
    }
    
    
    public void guardarDocumentoAtencion(VisitaCiudadano oVisita) {
        System.out.println("Guardando Documentos...");
        for(Documento d : listaDocumentosAtencion) {
            d.setIdRegVisita(Integer.parseInt(String.valueOf(oVisita.getId())));
            moverArchivosAtencion(d);
            documentoService.registrarDocumento(onDefinirDocumento(d));
        }
            
        if(oVisita.getIndicadorTratamiento().equals(TratamientoProcesoType.PROCESO_SID.getKey())){
            // Integrar Documentos al SID 
            if(adjuntarArchivosExpedExiste){
                ExpedienteVisita expedienteVisita = new ExpedienteVisita();
                expedienteVisita.setCodigoExpediente(expediente.getNumero());
                expedienteVisita.setIdVisita(oVisita.getId());
                expedienteVisitaService.expedienteVisitaInsertar(expedienteVisita);
        }
        } else if(oVisita.getIndicadorTratamiento().equals(TratamientoProcesoType.PROCESO_SGD.getKey())){
            // Proceso de integración al SGD.
    }
    }
    
    public void moverArchivosAtencion(Documento d){
        String formato = RandomStringUtils.random(32, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray());
        d.setExtensionDoc(getFileExtension(d.getFileName()));
        String ruta = formato + d.getExtensionDoc();
        File myFile = new File(ConstantesUtil.FILE_DONWLOAD_SCANNER+"/"+d.getFileName());
        myFile.renameTo(new File(ConstantesUtil.FILE_DONWLOAD_SCANNER_FINAL+"/"+ruta));
        d.setFileName(ruta);
        d.setRutaDoc(ConstantesUtil.FILE_DONWLOAD_SCANNER_FINAL+"/"+ruta);
    }
    
    public void actualizarListaTipoAtencion(String idMotivo){
        try {
            listaTipoTramite.clear();
            if (StringUtils.equals(idMotivo, "")) {
                listaTipoAtencion.clear();
            } else {
                if (StringUtils.equals(idMotivo, "D")) {
                    listaTipoAtencion = listasComunesController.listaTipoAtencionDocumentario(false, false, false);
                    // atencion.setIndicadorDocumentos("S");
                    
                } else if (StringUtils.equals(idMotivo, "I")) {
                    listaTipoAtencion = listasComunesController.listaTipoAtencionIntervencion(false, false, false);
                } else if(StringUtils.equals(idMotivo, "P")) {
                    listaTipoAtencion = listasComunesController.listaTipoAtencionPostulacionCAS(false, false, false);
                    // atencion.setIndicadorDocumentos("S");
                }
            }
            atencion.setTipoAtencion("0");
            atencion.setIndicadorDocumentos("");
            casoNuevoSolicitudIntervencion();
            adjuntarArchivosExpedExiste = false;
        } catch (Exception e) {
            log.error("ERROR - actualizarListaTipoAtencion()" + e);
        }
    }
    
     public boolean verificarTramiteDocumentario() {
        if(atencion.getTipoMotivo() != null && atencion.getTipoAtencion() != null){
            boolean isIntervencionDocumental = atencion.getTipoMotivo().equalsIgnoreCase("I") && 
                    atencion.getIndicadorCasoNuevo() != null && (atencion.getIndicadorCasoNuevo().equals("S"));
            
            if(atencion.getTipoMotivo().equalsIgnoreCase("P") || 
                    ( atencion.getTipoMotivo().equalsIgnoreCase("D") &&
                        atencion.getTipoAtencion().equalsIgnoreCase("01"))
                    || isIntervencionDocumental){
                return true;
            }
            
            if(atencion.getTipoMotivo().equalsIgnoreCase("I") && 
                    atencion.getIndicadorCasoNuevo() != null && atencion.getIndicadorCasoNuevo().equals("N") && atencion.getTipoTramite() != null 
                    && !atencion.getTipoTramite().equals("6")) {
                return true;
        }
            
            if(adjuntarArchivosExpedExiste)
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean verificaTieneExpediente() {
        if(atencion.getTipoMotivo() != null && atencion.getTipoAtencion() != null && atencion.getTipoTramite() != null){
            boolean isExisteExpedienteTramiteDoc = atencion.getTipoMotivo().equalsIgnoreCase("D") && 
                atencion.getTipoAtencion().equalsIgnoreCase("02");
            boolean isExpedienteSolIntervencion = atencion.getTipoMotivo().equalsIgnoreCase("I") && 
                    atencion.getTipoTramite().equals("6");
            if(isExisteExpedienteTramiteDoc || isExpedienteSolIntervencion){
                return true;
            } 
        }
        return false;
    }
    
    public void valueChangeMethod(ValueChangeEvent e){
        System.out.println("Verificar:....");
        verificaTieneExpediente();
        verificarTramiteDocumentario();
    }

    public void abrirVentanaAdjuntarDocumentos(int indexExpediente){
        adjuntarArchivosExpedExiste = true; 
        verificarTramiteDocumentario();
        expediente = listaExpedienteXDNIPaginado.get(indexExpediente);
    }
    
    public void eliminarDocumento(int i) {
        listaDocumentosAtencion.remove(i);
        msg.messageInfo("El documento ha sido eliminado con éxito.", null);
    }
    
    public void casoNuevoSolicitudIntervencion() {
        if(StringUtils.equals(atencion.getTipoMotivo(), "I") && atencion.getIndicadorCasoNuevo() != null){
            if(StringUtils.equals(atencion.getIndicadorCasoNuevo(), "S")){
                atencion.setTipoAtencion("01");
            }else {
                atencion.setTipoAtencion("02");
            }
            actualizarListaTipoTramite(atencion.getTipoAtencion(), atencion.getTipoMotivo());
            disableTipoAtencion = true;
        } else {
            disableTipoAtencion = false;
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
                } else if (StringUtils.equals(idAtencion, "02") && StringUtils.equals(idMotivo, "I")) {
                    listaTipoTramite = listasComunesController.listaTramiteIntervencionDocumental(false, false, false);
                }
            }
            
            
            if(atencion.getTipoMotivo() != null && atencion.getTipoAtencion() != null){
                boolean isIntervencionDocumental = atencion.getTipoMotivo().equalsIgnoreCase("I");         
                disabledGuardar = isIntervencionDocumental && 
                        StringUtils.equals(idAtencion, "01");
             
                if(atencion.getTipoMotivo().equalsIgnoreCase("P") || 
                        ( atencion.getTipoMotivo().equalsIgnoreCase("D") )
                        || isIntervencionDocumental){
                    atencion.setIndicadorDocumentos("S");
                } else {
                    atencion.setIndicadorDocumentos("N");
                }
            }
            
            
            
        } catch (Exception e) {
            log.error("ERROR - actualizarListaTipoTramite()" + e);
        }
    }
    
    public void iniciarListaTipoDocumento(FiltroTramite filtroTramite) {
        listaTipoDocumto = tipoDocumentoService.listarDocumentosByTramite(filtroTramite);
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
    public boolean getDisableField() {
        return disableField;
    }

    /**
     * @param disableField the disableField to set
     */
    public void setDisableField(boolean disableField) {
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

    /**
     * @return the listaExpedienteXDNIPaginado
     */
    public List<Expediente> getListaExpedienteXDNIPaginado() {
        return listaExpedienteXDNIPaginado;
    }

    /**
     * @param listaExpedienteXDNIPaginado the listaExpedienteXDNIPaginado to set
     */
    public void setListaExpedienteXDNIPaginado(List<Expediente> listaExpedienteXDNIPaginado) {
        this.listaExpedienteXDNIPaginado = listaExpedienteXDNIPaginado;
    }

    /**
     * @return the nroPagina
     */
    public Integer getNroPagina() {
        return nroPagina;
    }

    /**
     * @param nroPagina the nroPagina to set
     */
    public void setNroPagina(Integer nroPagina) {
        this.nroPagina = nroPagina;
    }

    /**
     * @return the disabledGuardar
     */
    public boolean isDisabledGuardar() {
        return disabledGuardar;
    }

    /**
     * @param disabledGuardar the disabledGuardar to set
     */
    public void setDisabledGuardar(boolean disabledGuardar) {
        this.disabledGuardar = disabledGuardar;
    }
    /**
     * @return the atencionTicket
     */
    public AtencionTicket getAtencionTicket() {
        return atencionTicket;
    }

    /**
     * @param atencionTicket the atencionTicket to set
     */
    public void setAtencionTicket(AtencionTicket atencionTicket) {
        this.atencionTicket = atencionTicket;
    }

    /**
     * @return the visitaCiudadano
     */
    public VisitaCiudadano getVisitaCiudadano() {
        return visitaCiudadano;
    }

    /**
     * @param visitaCiudadano the visitaCiudadano to set
     */
    public void setVisitaCiudadano(VisitaCiudadano visitaCiudadano) {
        this.visitaCiudadano = visitaCiudadano;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * @return the usuarioSession
     */
    public Usuario getUsuarioSession() {
        return usuarioSession;
    }

    /**
     * @param usuarioSession the usuarioSession to set
     */
    public void setUsuarioSession(Usuario usuarioSession) {
        this.usuarioSession = usuarioSession;
    }
    
    /**
     * @return the renderTicketAtencion
     */
    public boolean isRenderTicketAtencion() {
        return renderTicketAtencion;
    }
    
    /**
     * @param renderTicketAtencion the renderTicketAtencion to set
     */
    public void setRenderTicketAtencion(boolean renderTicketAtencion) {
        this.renderTicketAtencion = renderTicketAtencion;
}

    /**
     * @return the disableTipoAtencion
     */
    public boolean isDisableTipoAtencion() {
        return disableTipoAtencion;
    }

    /**
     * @param disableTipoAtencion the disableTipoAtencion to set
     */
    public void setDisableTipoAtencion(boolean disableTipoAtencion) {
        this.disableTipoAtencion = disableTipoAtencion;
    }

    /**
     * @return the adjuntarArchivosExpedExiste
     */
    public boolean isAdjuntarArchivosExpedExiste() {
        return adjuntarArchivosExpedExiste;
    }

    /**
     * @param adjuntarArchivosExpedExiste the adjuntarArchivosExpedExiste to set
     */
    public void setAdjuntarArchivosExpedExiste(boolean adjuntarArchivosExpedExiste) {
        this.adjuntarArchivosExpedExiste = adjuntarArchivosExpedExiste;
    }

    /**
     * @return the expediente
     */
    public Expediente getExpediente() {
        return expediente;
    }

    /**
     * @param expediente the expediente to set
     */
    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    /**
     * @return the usuarioVentanilla
     */
    public UsuarioVentanilla getUsuarioVentanilla() {
        return usuarioVentanilla;
    }

    /**
     * @param usuarioVentanilla the usuarioVentanilla to set
     */
    public void setUsuarioVentanilla(UsuarioVentanilla usuarioVentanilla) {
        this.usuarioVentanilla = usuarioVentanilla;
    }

    /**
     * @return the listaUsuarios
     */
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * @param listaUsuarios the listaUsuarios to set
     */
    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /**
     * @return the listaVentanilla
     */
    public List<Ventanilla> getListaVentanilla() {
        return listaVentanilla;
    }

    /**
     * @param listaVentanilla the listaVentanilla to set
     */
    public void setListaVentanilla(List<Ventanilla> listaVentanilla) {
        this.listaVentanilla = listaVentanilla;
    }

    /**
     * @return the listaUsuarioVentanilla
     */
    public List<UsuarioVentanilla> getListaUsuarioVentanilla() {
        return listaUsuarioVentanilla;
    }

    /**
     * @param listaUsuarioVentanilla the listaUsuarioVentanilla to set
     */
    public void setListaUsuarioVentanilla(List<UsuarioVentanilla> listaUsuarioVentanilla) {
        this.listaUsuarioVentanilla = listaUsuarioVentanilla;
    }

    /**
     * @return the disabledAgregarUsuVen
     */
    public boolean isDisabledAgregarUsuVen() {
        return disabledAgregarUsuVen;
    }

    /**
     * @param disabledAgregarUsuVen the disabledAgregarUsuVen to set
     */
    public void setDisabledAgregarUsuVen(boolean disabledAgregarUsuVen) {
        this.disabledAgregarUsuVen = disabledAgregarUsuVen;
    }

    public List<Documento> getListaDocumentosAtencionRetorno() {
        return listaDocumentosAtencionRetorno;
    }

    public void setListaDocumentosAtencionRetorno(List<Documento> listaDocumentosAtencionRetorno) {
        this.listaDocumentosAtencionRetorno = listaDocumentosAtencionRetorno;
    }
    
    /**
     * @return the listaTipoDocumentoIdentidad
     */
    public List<Parametro> getListaTipoDocumentoIdentidad() {
        return listaTipoDocumentoIdentidad;
    }

    /**
     * @param listaTipoDocumentoIdentidad the listaTipoDocumentoIdentidad to set
     */
    public void setListaTipoDocumentoIdentidad(List<Parametro> listaTipoDocumentoIdentidad) {
        this.listaTipoDocumentoIdentidad = listaTipoDocumentoIdentidad;
    }
    
}
