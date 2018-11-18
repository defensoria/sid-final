/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.controller;

import gob.dp.sid.atencion.bean.AtencionBean;
import gob.dp.sid.atencion.entity.Atencion;
import gob.dp.sid.atencion.entity.Ciudadano;
import gob.dp.sid.atencion.service.PersonaCiudadanoService;
import gob.dp.sid.atencion.bean.FiltroPersona;
import gob.dp.sid.comun.ComunUtil;
import gob.dp.sid.comun.ConstantesUtil;
import gob.dp.sid.comun.controller.AbstractManagedBean;
import gob.dp.sid.comun.controller.ListasComunesController;
import gob.dp.sid.comun.entity.Parametro;
import gob.dp.sid.comun.type.MotivoAtencionType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author jcarrillo
 */
@Named
@Scope("session")
public class AtencionController extends AbstractManagedBean implements Serializable {

    private static final Logger log = Logger.getLogger(AtencionController.class);
    
    private Atencion atencion;
    private AtencionBean atencionBean;
    private List<Parametro> listaTipoAtencion; 
    private List<Parametro> listaTipoTramite;
    private String disableField = "false";
    private String page;
    
    private boolean renderTieneDiscapacidad = false;
            
    @Autowired
    private ListasComunesController listasComunesController;
    
    @Autowired
    private PersonaCiudadanoService ciudadanoServie;
    
    public String cargarInicioAtencion() {
        try {
            atencion = new Atencion();
            atencionBean = new AtencionBean();
            listaTipoAtencion = new ArrayList<>();
            listaTipoTramite = new ArrayList<>();
            // atencionBean.setNameTipoMotivo(MotivoAtencionType.get(atencion.getTipoMotivo()).getValue());
            
            return "iniciarAtencion";
        } catch (Exception e) {
            log.error("ERROR - cargarInicioAtencion()" + e);
        }
        return null;
    }
    
    public String accederBuscarDni() {
        try {
            if( atencion.getDni() != null ) {
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
            
            BeanUtils.copyProperties(atencionBean, atencion);
            atencionBean.setTipoMotivo(atencion.getTipoMotivo());
            atencionBean.setNameTipoMotivo(MotivoAtencionType.get(atencion.getTipoMotivo()).getValue());
            if (StringUtils.equals(atencion.getTipoMotivo(), "D")){
                if(StringUtils.equals(atencion.getTipoAtencion(), "01")){
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
    
    public String irRecepcionDocumentosAdministrativos() {
        return ConstantesUtil.PAGE_RECEPCION_DOCUMENTOS_ADMINISTRATIVOS;
    }
    
    public void onBuscarDatosCiudadano() {
        System.err.println("Hola mundo");
    }
    
    public void limpiarIniciarAtencion() {
        atencion = new Atencion();
        atencion.setTipoMotivo("");
        atencion.setTipoAtencion("0");
        atencion.setIndicadorDocumentos("");
        listaTipoAtencion = new ArrayList<>();
        listaTipoTramite = new ArrayList<>();
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
}
