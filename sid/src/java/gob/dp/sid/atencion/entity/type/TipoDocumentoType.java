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
public enum TipoDocumentoType {
    ACTA(1, "DOCUMENTO ACTA"),
    CARTA(2, "CARTA DOCUMENTO"),
    OFICIO(3, "OFICIO"),
    PARTIDA_NACIMIENTO(4, "PARTIDA DE NACIMIENTO"),
    COPIA_DNI(5, "COPIA DE DNI");
    
    /** La Constante list. */
    private static final List<TipoDocumentoType> list = new ArrayList<>();
    
    /** La Constante lookup. */
    private static final Map<Integer, TipoDocumentoType> lookup = new HashMap<>();

    static {
	for (TipoDocumentoType s : EnumSet.allOf(TipoDocumentoType.class)) {
		list.add(s);
                lookup.put(s.getKey(), s);
	}
    }
	
    /** El key. */
    private final Integer key;
	
    /** El value. */
    private final String value;

	
    private TipoDocumentoType(Integer key, String value) {
	this.key = key;
	this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
    	return value;
    }
        
    public static TipoDocumentoType get(Integer key) {
	return lookup.get(key);
    }
   }
