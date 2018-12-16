/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.registro.entity;

import gob.dp.sid.atencion.entity.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author JCARRILLO
 */
public class EstadisticaExpediente implements Serializable {
    
    private Integer cantQuejas;
    private Integer cantConsultas;
    private Integer cantPetitorios;

    /**
     * @return the cantQuejas
     */
    public Integer getCantQuejas() {
        return cantQuejas;
    }

    /**
     * @param cantQuejas the cantQuejas to set
     */
    public void setCantQuejas(Integer cantQuejas) {
        this.cantQuejas = cantQuejas;
    }

    /**
     * @return the cantConsultas
     */
    public Integer getCantConsultas() {
        return cantConsultas;
    }

    /**
     * @param cantConsultas the cantConsultas to set
     */
    public void setCantConsultas(Integer cantConsultas) {
        this.cantConsultas = cantConsultas;
    }

    /**
     * @return the cantPetitorios
     */
    public Integer getCantPetitorios() {
        return cantPetitorios;
    }

    /**
     * @param cantPetitorios the cantPetitorios to set
     */
    public void setCantPetitorios(Integer cantPetitorios) {
        this.cantPetitorios = cantPetitorios;
    }
    
}
