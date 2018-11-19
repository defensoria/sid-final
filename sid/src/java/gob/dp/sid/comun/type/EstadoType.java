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
public enum EstadoType {
    ACTIVO("A", "ACTIVO"),
    INACTIVO("I", "INACTIVO");
        
    /** La Constante list. */
    private static final List<EstadoType> list = new ArrayList<>();
	
    /** La Constante lookup. */
    private static final Map<String, EstadoType> lookup = new HashMap<>();

    static {
	for (EstadoType s : EnumSet.allOf(EstadoType.class)) {
            list.add(s);
            lookup.put(s.getKey(), s);
	}
    }
	
    /** El key. */
    private final String key;	
    /** El value. */
    private final String value;

	
    private EstadoType(String key, String value) {
	this.key = key;
	this.value = value;
    }

    public String getKey() {
	return key;
    }

    public String getValue() {
	return value;
    }
        
    public static EstadoType get(String key) {
	return lookup.get(key);
    }
}
