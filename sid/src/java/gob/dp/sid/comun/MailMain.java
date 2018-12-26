/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.comun;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JMATOS
 */
public class MailMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> to = new ArrayList<>();
        to.add("jesus.matosp@gmail.com");
        
        List<String> cc =  new ArrayList<>();
        cc.add("careli3010@gmail.com");
        
        String emailBody = "Este correo es una prueba";
        String subject = "Caliiitoooos";
        try {
            MailUtilitario.sendEmailGmail(to, true, cc, emailBody, subject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
