/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.comun.type;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JMATOS
 */
public enum EstadoNumberType {
    ACTIVO(1, "ACTIVO"),
    INACTIVO(0, "INACTIVO");
        
    /** La Constante list. */
    private static final List<EstadoNumberType> list = new ArrayList<>();
	
    /** La Constante lookup. */
    private static final Map<Integer, EstadoNumberType> lookup = new HashMap<>();

    static {
	for (EstadoNumberType s : EnumSet.allOf(EstadoNumberType.class)) {
            list.add(s);
            lookup.put(s.getKey(), s);
	}
    }
	
    /** El key. */
    private final Integer key;	
    /** El value. */
    private final String value;

	
    private EstadoNumberType(Integer key, String value) {
	this.key = key;
	this.value = value;
    }

    public Integer getKey() {
	return key;
    }

    public String getValue() {
	return value;
    }
        
    public static EstadoNumberType get(Integer key) {
	return lookup.get(key);
    }
}
