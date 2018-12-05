/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.entity.type;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JCARRILLO
 */
public enum EstadoTicketType {
    TICKET_EN_COLA(1, "TICKET EN COLA"),
    TICKET_EN_ATENCION(2, "TICKET EN ATENCION"),
    TICKET_ATENDIDO(3, "TICKET ATENDIDO"),
    TICKET_EN_ABANDONO(4, "TICKET EN ABANDONO");
    
    /** La Constante list. */
    private static final List<EstadoTicketType> list = new ArrayList<>();
    /** La Constante lookup. */
    private static final Map<Integer, EstadoTicketType> lookup = new HashMap<>();
    static {
	for (EstadoTicketType s : EnumSet.allOf(EstadoTicketType.class)) {
		list.add(s);
                lookup.put(s.getKey(), s);
	}
    }
    /** El key. */
    private final Integer key;
    /** El value. */
    private final String value;
    
    private EstadoTicketType(Integer key, String value) {
	this.key = key;
	this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
    	return value;
    }
        
    public static EstadoTicketType get(Integer key) {
	return lookup.get(key);
    }
}
