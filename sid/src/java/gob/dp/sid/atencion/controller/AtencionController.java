/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.controller;

import gob.dp.sid.atencion.entity.Atencion;
import gob.dp.sid.atencion.entity.Ciudadano;
import gob.dp.sid.atencion.service.PersonaCiudadanoService;
import gob.dp.sid.atencion.service.bean.FiltroPersona;
import gob.dp.sid.comun.controller.AbstractManagedBean;
import gob.dp.sid.comun.controller.ListasComunesController;
import gob.dp.sid.comun.entity.Parametro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
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
    
    private List<Parametro> listaTipoAtencion; 
    private List<Parametro> listaTipoTramite;
    
    @Autowired
    private ListasComunesController listasComunesController;
    
    @Autowired
    private PersonaCiudadanoService ciudadanoServie;
    
    public String cargarInicioAtencion() {
        try {
            atencion = new Atencion();
            listaTipoAtencion = new ArrayList<>();
            listaTipoTramite = new ArrayList<>();
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
                }
            }
            return "buscarDni";
        } catch (Exception e) {
            log.error("ERROR - accederBuscarDni()" + e);
        }
        return null;
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
}
