<%-- 
    Document   : getGriddahico
    Created on : 4/02/2010, 11:00:58 PM
--%>

<%@page import="java.sql.*" %>
<%@page import="app.classes.conexion" %>


  <%
                            int start=0;
                            int total=0;
                            int total_pages =0;

                            int intpage = new Integer(request.getParameter("page"));
                            int limit = new Integer(request.getParameter("rows"));

                            String sidx = request.getParameter("sidx");
                            String sord = request.getParameter("sord");
                          
                            String strQuery="";
                            String json ="";

                            boolean rc;

                            ResultSet rs = null;

                            if(sidx ==""){
                                sidx ="1";
                            }


                            /*-----------------------------------Conexión a la base de datos MySql-------------------------------------------*/
                            conexion  conexiondb = new conexion();
                            conexiondb.Conectar();
                            /*-----------------------------------------------------------------------------------------------------------*/

                            total = conexiondb.countRec("id_Usuario", "tbl_Usuario");
                            
                            if( total>0 ) {
                                double d = Math.ceil( (double)(total) / (double)(limit) );
                                total_pages = (int)(d);
                            } else {
                                total_pages = 0;
                            }

                            if (intpage > total_pages) {
                                intpage=total_pages;
                            }

                            start = limit * intpage - limit; 

                            if(start < 0 ){
                                start = 0;
                            }

                            strQuery = "SELECT * FROM tbl_Usuario ORDER BY "+sidx + " " +sord +" LIMIT "+start+" , "+limit;

                            rs = conexiondb.Consulta(strQuery);

                            total = conexiondb.countRec("id_Usuario", "tbl_Usuario");

                            response.setContentType("text/x-json");
                            response.setCharacterEncoding("utf-8");
                            response.setHeader("Pragma", "no-cache");
                            response.setHeader("Cache-Control", "no-cache, must-revalidate");
                            response.setHeader("Pragma", "no-cache");

                            json ="";
                            json = json + "{\n";
                            json = json + " \"page\":\""+intpage+"\",\n";
                            json = json + "\"total\":"+total_pages+",\n";
                            json = json + "\"records\":"+total+",\n";
                            json = json + "\"rows\": [";
                            rc =false;

                            while(rs.next()){
                                
                                if(rc){
                                    json = json + ",";
                                }
                                json = json + "\n{";
                                json = json + "\"id\":\""+rs.getInt("id_Usuario")+"\",";
                                json = json + "\"cell\":["+rs.getInt("id_Usuario")+"";
                                json = json + ",\""+rs.getString("nombre_Usuario")+"\"";
                                json = json + ",\""+rs.getString("email_Usuario")+"\"]";
                                json = json + "}";

                                rc=true;
                            }
                            json = json +"]\n";

                            json = json +"}";

                            out.print(json);
                            out.close();


        %>

