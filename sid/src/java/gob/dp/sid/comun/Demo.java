/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.comun;

/**
 *
 * @author JMATOS
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Utilitarios utilitarios = new Utilitarios();
        String app = utilitarios.getProperties("pe.gob.dp.sid.application.name");
        System.out.println("app: " + app);
        
        String p = MEncript.randomAlphaNumeric(10);
        System.out.println("Codigo: " + p);
    }
    
}
