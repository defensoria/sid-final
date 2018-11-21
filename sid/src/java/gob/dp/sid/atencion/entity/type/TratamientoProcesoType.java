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
 * @author JMATOS
 */
public enum TratamientoProcesoType {
    PROCESO_SGD(1, "PROCESAMIENTO SISTEMA DE GESTION DOCUMENTAL"),
    PROCESO_SID(2, "PROCESAMIENTO SISTEMA SID");
    
    /** La Constante list. */
    private static final List<TratamientoProcesoType> list = new ArrayList<>();
    /** La Constante lookup. */
    private static final Map<Integer, TratamientoProcesoType> lookup = new HashMap<>();
    static {
	for (TratamientoProcesoType s : EnumSet.allOf(TratamientoProcesoType.class)) {
		list.add(s);
                lookup.put(s.getKey(), s);
	}
    }
    /** El key. */
    private final Integer key;
    /** El value. */
    private final String value;
    
    private TratamientoProcesoType(Integer key, String value) {
	this.key = key;
	this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
    	return value;
    }
        
    public static TratamientoProcesoType get(Integer key) {
	return lookup.get(key);
    }
}
