/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.classes;
import java.io.*;
import java.util.*;

/**
 *
 * @author David H. Contreras C.
 */
public class drwImagen {
    
        public String doDir(){
            String nombreAleatorio="";
            //String rutaDestino="/usr/local/apache-tomcat-6.0/webapps/VistaInterna/Temporal/tmp/";   // SERVIDOR
            String rutaDestino="/tmp/Digitalizacion/";       // LOCAL
            try {

                    Random r1 = new Random(); /*Se genera un String aleatorio*/
                    nombreAleatorio = Long.toString(Math.abs(r1.nextLong()), 36); /*Se nombra el directorio con la cadena aleatoria que se genero*/
                    
                    File directorioTemp = new File(rutaDestino+nombreAleatorio);
                    
                    if(!directorioTemp.mkdir()){
                            System.out.println("Error al crear el Directorio Temporal");
                    }

            } catch (Exception e) {
                return "Error";
            }
            
            return nombreAleatorio +"_" +rutaDestino;
            
        }

        

        

}
