/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.classes;

import java.sql.*;


/**
 *
 * @author dahico
 */
public class conexion {
        Connection con;
        Statement st=null;
        ResultSet rs=null;
        
        /*--------- Procedimiento para crear la conexión a la base de Datos----------*/
        public void Conectar() {
                try {

                      Class.forName("com.mysql.jdbc.Driver");
                      con = DriverManager.getConnection("jdbc:mysql://localhost/dahicotux", "root", "developer");

                } catch (Exception e) {

                     e.getMessage();


                }
                
        }

        /*----Procedimiento para Ejecutar una sentencia SQL en la base de datos--*/
        public Boolean Ejecutar(String sql){

            String error="";

            try {

                    st = con.createStatement();
                    st.execute(sql);

            } catch (Exception e) {

                error = e.getMessage();
                return false;

            }

            return true;

        }

        /*-----Procedimiento para ejecutar un Consulta SQL en la base de Datos*/
        public ResultSet Consulta(String sql){

                String error="";

                try {

                    st = con.createStatement();
                    rs = st.executeQuery(sql);

                } catch (Exception e) {

                    error = e.getMessage();

                }

                return (rs);

        }

        public Boolean Close(){

                String error="";

                try {

                    con.close();

                } catch (Exception e) {

                    error = e.getMessage();
                    return false;

                }

                return true;

        }

        public Integer countRec(String campo, String tabla){
            try {

                int conteo =0;

                String strSql = "SELECT DISTINCT count("+campo+") AS conteo FROM "+tabla;

                ResultSet rcount = Consulta(strSql);
                
                while(rcount.next()){
                    conteo= rcount.getInt("conteo");
                }
                return conteo;
            } catch (Exception e) {
                return  0;
            }
            
        }

          public Integer countRecPer( String campo, String query){
            try {

                int conteo =0;
                int resconteo =0;

                String strSql = query;

                ResultSet rcount = Consulta(strSql);

                while(rcount.next()){
                  //  resconteo= rcount.getInt("cuenta");
                    conteo++;
                }
                return conteo;
                //return  resconteo;
            } catch (Exception e) {
                return  0;
            }

        }

          public Integer countRecBit( String campo, String query){
            try {

                int conteo =0;
                int resconteo =0;

                String strSql = query;

                ResultSet rcount = Consulta(strSql);

                while(rcount.next()){
                    resconteo= rcount.getInt("cuenta");
                    //conteo++;
                }
                return conteo;
                //return  resconteo;
            } catch (Exception e) {
                return  0;
            }

        }
}
