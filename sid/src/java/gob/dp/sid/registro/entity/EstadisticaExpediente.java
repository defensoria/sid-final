/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.registro.entity;

import java.io.Serializable;

/**
 *
 * @author JCARRILLO
 */
public class EstadisticaExpediente implements Serializable {
    
    private Integer cantQuejas;
    private Integer cantConsultas;
    private Integer cantPetitorios;
    private Integer cantTramite;
    private Integer cantConcluido;
    private Integer cantDesistido;
    private Integer cantEnBorrador;
    private Integer cantEnRegistro;
    private String codUsuario;
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

    /**
     * @return the cantTramite
     */
    public Integer getCantTramite() {
        return cantTramite;
    }

    /**
     * @param cantTramite the cantTramite to set
     */
    public void setCantTramite(Integer cantTramite) {
        this.cantTramite = cantTramite;
    }

    /**
     * @return the cantConcluido
     */
    public Integer getCantConcluido() {
        return cantConcluido;
    }

    /**
     * @param cantConcluido the cantConcluido to set
     */
    public void setCantConcluido(Integer cantConcluido) {
        this.cantConcluido = cantConcluido;
    }

    /**
     * @return the cantDesistido
     */
    public Integer getCantDesistido() {
        return cantDesistido;
    }

    /**
     * @param cantDesistido the cantDesistido to set
     */
    public void setCantDesistido(Integer cantDesistido) {
        this.cantDesistido = cantDesistido;
    }

    /**
     * @return the codUsuario
     */
    public String getCodUsuario() {
        return codUsuario;
    }

    /**
     * @param codUsuario the codUsuario to set
     */
    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    /**
     * @return the cantEnBorrador
     */
    public Integer getCantEnBorrador() {
        return cantEnBorrador;
    }

    /**
     * @param cantEnBorrador the cantEnBorrador to set
     */
    public void setCantEnBorrador(Integer cantEnBorrador) {
        this.cantEnBorrador = cantEnBorrador;
    }

    /**
     * @return the cantEnRegistro
     */
    public Integer getCantEnRegistro() {
        return cantEnRegistro;
    }

    /**
     * @param cantEnRegistro the cantEnRegistro to set
     */
    public void setCantEnRegistro(Integer cantEnRegistro) {
        this.cantEnRegistro = cantEnRegistro;
    }
    
}
