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
public enum SiNoType {
    SI("S", "Si"),
    NO("N", "No");
        
    /** La Constante list. */
    private static final List<SiNoType> list = new ArrayList<>();
	
    /** La Constante lookup. */
    private static final Map<String, SiNoType> lookup = new HashMap<>();

    static {
	for (SiNoType s : EnumSet.allOf(SiNoType.class)) {
            list.add(s);
            lookup.put(s.getKey(), s);
	}
    }
	
    /** El key. */
    private final String key;	
    /** El value. */
    private final String value;

	
    private SiNoType(String key, String value) {
	this.key = key;
	this.value = value;
    }

    public String getKey() {
	return key;
    }

    public String getValue() {
	return value;
    }
        
    public static SiNoType get(String key) {
	return lookup.get(key);
    }
}
