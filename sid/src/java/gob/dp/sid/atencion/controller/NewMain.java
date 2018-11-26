/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.atencion.controller;

import java.io.File;

/**
 *
 * @author JMATOS
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // create a file that is really a directory
        File aDirectory = new File("D:/temp");

    // get a listing of all files in the directory
    String[] filesInDir = aDirectory.list();

    // sort the list of files (optional)
    // Arrays.sort(filesInDir);

    // have everything i need, just print it now
    for ( int i=0; i<filesInDir.length; i++ )
    {
      System.out.println( "file: " + filesInDir[i] );
    }
    }
    
}
