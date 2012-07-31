/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.classes;
import  java.sql.*;


/**
 *
 * @author David H. Contreras C.
 */
public class funciones {
     String strQuery;
    ResultSet rs = null;

    public Boolean CrearUsuario(String Usuario, String Pass, String Nombre, String Apellido, String Email, String NombreEquipo, int TipoUsuario, int Bloqueado, int permEmail, int permDescargar, int permImprimir, int permVisor){
        try {
                 /*-------------------------------Inicia la Conexión a la base de datos MySql-----------------------------------*/
                    conexion  conexiondb = new conexion();
                    conexiondb.Conectar();
                /*-----------------------------------------------------------------------------------------------------*/

                strQuery ="";
                strQuery= "INSERT INTO tbl_Usuarios (rela_Roles_Usuarios, usuario_Usuarios, clave_Usuarios, nombres_Usuarios, apellidos_Usuarios, email_Usuarios, nomequipo_Usuarios,bloqueado_Usuarios, " +
                                    " permEmail_Usuarios, permDescargar_Usuarios, permImprimir_Usuarios, permVisor_Usuarios) " +
                                    "VALUES ("+TipoUsuario+",\""+Usuario+"\",'"+Pass+"','"+Nombre+"','"+Apellido+"','"+Email+"','"+NombreEquipo+"',"+Bloqueado+","+permEmail+","+permDescargar+","+permImprimir+","+permVisor+")";

                if(!conexiondb.Ejecutar(strQuery)){
                    return  false;
                }

        } catch (Exception e) {
            String msg = e.getMessage();
        }
        return true;
    }

    public Boolean CrearCliente(String Usuario, String Pass, String Nombre, String Apellido, String Email, String NombreEquipo, int TipoUsuario, int Bloqueado, String rfcCliente, int permEmail, int permDescargar, int permImprimir,int permDocsInternos, int permVisor){
        try {
                 /*-------------------------------Inicia la Conexión a la base de datos MySql-----------------------------------*/
                    conexion  conexiondb = new conexion();
                    conexiondb.Conectar();
                /*-----------------------------------------------------------------------------------------------------*/

                strQuery ="";
                strQuery= "INSERT INTO tbl_Usuarios (rela_Roles_Usuarios, usuario_Usuarios, clave_Usuarios, nombres_Usuarios, apellidos_Usuarios, email_Usuarios, nomequipo_Usuarios,bloqueado_Usuarios, " +
                                    " rfcCliente_Usuarios,permEmail_Usuarios, permDescargar_Usuarios, permImprimir_Usuarios, permDocInternos_Usuarios, permVisor_Usuarios) " +
                                    "VALUES ("+TipoUsuario+",\""+Usuario+"\",'"+Pass+"','"+Nombre+"','"+Apellido+"','"+Email+"','"+NombreEquipo+"',"+Bloqueado+",'"+rfcCliente+"',"+permEmail+","+permDescargar+","+permImprimir+","+permDocsInternos+","+permVisor+")";

                if(!conexiondb.Ejecutar(strQuery)){
                    return  false;
                }

        } catch (Exception e) {
            String msg = e.getMessage();
        }
        return true;
    }

    public Boolean ModificarUsuario(int IdUsuario, String Usuario, String Pass, String Nombre, String Apellido, String Email, String NombreEquipo, int TipoUsuario, int Bloqueado,String rfcCliente, int permEmail, int permDescargar, int permImprimir, int permDocsInternos,int permVisor){
        try {
                 /*-------------------------------Inicia la Conexión a la base de datos MySql-----------------------------------*/
                conexion  conexiondb = new conexion();
                conexiondb.Conectar();
                /*-----------------------------------------------------------------------------------------------------*/

                strQuery ="";
                strQuery = "UPDATE tbl_Usuarios SET rela_Roles_Usuarios = " + 
                                    TipoUsuario + ", usuario_Usuarios = '"+Usuario +"', " +
                                    "clave_Usuarios = '" + Pass +"', " +
                                    "nombres_Usuarios='"+Nombre+"', " +
                                    "apellidos_Usuarios='"+Apellido+"', " +
                                    "email_Usuarios='"+Email+"', " +
                                    "nomequipo_Usuarios='"+NombreEquipo+"', " +
                                    "bloqueado_Usuarios="+Bloqueado+", " +
                                    "rfcCliente_Usuarios = '"+rfcCliente+"', "+
                                    "permEmail_Usuarios="+permEmail+", " +
                                    "permDescargar_Usuarios="+permDescargar+", " +
                                    "permImprimir_Usuarios="+permImprimir+", " +
                                    "permDocInternos_Usuarios="+permDocsInternos+", " +
                                    "permVisor_Usuarios="+permVisor+
                                    "  WHERE id_Usuarios = " +IdUsuario;
                
                if(!conexiondb.Ejecutar(strQuery)){
                    conexiondb.Close();
                    return  false;

                }
                conexiondb.Close();

        } catch (Exception e) {
            String msg = e.getMessage();
        }
        return true;
    }
    
}
