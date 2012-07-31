/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.classes;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream ;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.Date; 

/**
 *
 * @author David H. Contreras C.
 */
public class NZipCompresser {

static final int BUFFER = 2048;

public static void main(String argv[]){

    try{
             String dirLeer=argv[0].toString();
             String rutaNombreZip=argv[1].toString();
            
             BufferedInputStream origin = null;
             FileOutputStream dest = new
             FileOutputStream(rutaNombreZip); // Parametro 1 ---- La ruta en donde se guardara el Zip
             ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
             //out.setMethod(ZipOutputStream.DEFLATED);
             byte data[] = new byte[BUFFER];
             //obtenemos la lista de los archivos del directorio actual

             File f = new File(dirLeer); // Parametro 0 ---- La ruta donde se leera los archivos
             String files[] = f.list();

             for (int i=0; i<=files.length; i++){

                 System.out.println("Adding: "+files[i]);
                 FileInputStream fi = new FileInputStream(files[i]);
                 origin = new BufferedInputStream(fi, BUFFER);
                 ZipEntry entry = new ZipEntry(files[i]);
                 out.putNextEntry(entry);
                 int count;

                 while((count = origin.read(data, 0,BUFFER))!= -1){
                        out.write(data, 0, count);
                 }
                 
                 origin.close();
                 
            }
            
             out.close();

         }catch(Exception e){

             String x = e.getMessage();
             String xa = x;
             //e.printStrackTrace();
         }
}

} 