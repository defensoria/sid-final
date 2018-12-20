/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.sid.comun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author Administrador
 */
public class ComunUtil {

    private ComunUtil()
    {

    }

    public static boolean isCodigoListaValorPorDefecto(String codigo)
    {
        if (ConstantesUtil.LISTA_VALOR_SELECCIONE_CODIGO.equals(codigo))
            return true;
        if (ConstantesUtil.LISTA_VALOR_TODOS_CODIGO.equals(codigo))
            return true;
        if (ConstantesUtil.LISTA_VALOR_NINGUNO_CODIGO.equals(codigo))
            return true;
        return false;

    }
    
    public static String getDateToString(Date date){
        SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
        return fd.format(date);
    }

    public static Date getDateDDMMYYYY(String date) throws ParseException{
        SimpleDateFormat fd  = new SimpleDateFormat("dd/MM/yyyyy");
        return fd.parse(date);
    }
        
    public static String generateCodigoByDate() {
        SimpleDateFormat fd = new SimpleDateFormat("yyyyMMddHHmmss");
        return fd.format(new Date());
    }
    
}
