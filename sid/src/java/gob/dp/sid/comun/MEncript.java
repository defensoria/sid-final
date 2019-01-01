/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.sid.comun;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Clock;
import org.apache.log4j.Logger;

public class MEncript {
    private static final Logger log = Logger.getLogger(MEncript.class);
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    /* Encriptación de la clave */
    private static String toHexadecimal(byte[] digest){
        String hash = "";
        for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }
        return hash;
    }

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
        int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
        builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }


    public static String getStringMessageDigest(String message)
    {
        byte[] digest = null;
        byte[] buffer = message.getBytes();
        try {
            // MessageDigest messageDigest = MessageDigest.getInstance("SHA512");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            log.error("Error creando Digest : "+ex);
        } catch (Exception e) {
            log.error("Error creando Digest : "+e);
        }
        return toHexadecimal(digest);
    }
    
    public static String fromHexadecimal(String hex){
        String psw ="";
        try{
            hex = hex.replaceAll("^(00)+", "");
            byte[] bytes = new byte[hex.length() / 2];
            for (int i = 0; i < hex.length(); i += 2) {
                bytes[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
            }
            psw =new String(bytes, "UTF-8");
        } catch (Exception e) {
            log.error("Error fromHexadecimal : "+e);
        }
        System.out.print("clave: "+psw);
        return psw;
    }

}
