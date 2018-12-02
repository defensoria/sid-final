/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.bean;

/**
 *
 * @author JMATOS
 */
public class FiltroTicket {
    
    private Long idSede;
    
    private Integer atencionPreferente;
    
    private Integer estadoTicket;
    
    private Integer estadoRegistro;

    /**
     * @return the idSede
     */
    public Long getIdSede() {
        return idSede;
    }

    /**
     * @param idSede the idSede to set
     */
    public void setIdSede(Long idSede) {
        this.idSede = idSede;
    }

    /**
     * @return the atencionPreferente
     */
    public Integer getAtencionPreferente() {
        return atencionPreferente;
    }

    /**
     * @param atencionPreferente the atencionPreferente to set
     */
    public void setAtencionPreferente(Integer atencionPreferente) {
        this.atencionPreferente = atencionPreferente;
    }

    /**
     * @return the estadoTicket
     */
    public Integer getEstadoTicket() {
        return estadoTicket;
    }

    /**
     * @param estadoTicket the estadoTicket to set
     */
    public void setEstadoTicket(Integer estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    /**
     * @return the estadoRegistro
     */
    public Integer getEstadoRegistro() {
        return estadoRegistro;
    }

    /**
     * @param estadoRegistro the estadoRegistro to set
     */
    public void setEstadoRegistro(Integer estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    
}
