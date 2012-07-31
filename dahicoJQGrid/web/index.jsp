<%-- 
    Document   : index
    Created on : 4/02/2010, 10:39:22 PM
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>dahico-JQgrid</title>

<link rel="stylesheet" type="text/css" media="screen" href="css/jquery-ui-1.7.1.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>

        <script type="text/javascript">
              $().ready(function() {
                        var windowWidth = (document.documentElement.clientWidth - 100) /1.2;

                        jQuery("#gridUsuarios").jqGrid({
                                                url:'getGriddahico.jsp',
                                                datatype: "json",
                                                colNames:['id_Usuario','Usuario','Email'],
                                                colModel:[
                                                        {name:'id',index:'id_Usuario', width:10, hidden:true},
                                                        {name:'Usuario',index:'nombre_Usuario', width:150},
                                                        {name:'Email',index:'email_Usuario', width:350},
                                                ],
                                                rowNum:10,
                                                rowList:[10,20,30],
                                                multiselect: true,
                                                pager: '#pagGrid',
                                                sortname: 'id_Usuario',
                                                viewrecords: true,
                                                sortorder: "desc",
                                                width: windowWidth,
                                                height: "100%",
                                               // nSelectRow: subGridReferenciasImagenes,
                                                caption:"dahicotux.wordpress.com"
                        });

                        jQuery("#gridUsuarios").jqGrid('navGrid','#pagGrid',{edit:false,add:false,del:false});

              });


        </script>


</head>

<body style="background: #121212">


        <div id="Encabezado" class="ui-layout-north" style="padding:0px; background:#ccc">
                <div style="float:left;width: 100%; background:#9bd252; border :0px solid #ccc; height:55px">
                     <div class="logoLogin" >
                        <img src="images/logoLogin.png" alt="">
                    </div>
                    <div class="tituloheaderLogin" style="color:#1a1a1a; padding:20px; text-align: center; font-family: sans-serif; font-weight: bold" >
                            dahicotux.wordpress.com
                    </div>
                </div>
            
                <div class="topBar" style="background:#1c1c1c;">
                            
                </div>
        </div>

        <div id="LeftPane" class="ui-layout-west ui-widget ui-widget-content" >
                <table id="west-grid"></table>
	</div> <!-- #LeftPane -->

        <div id="RightPane" class="ui-layout-center ui-helper-reset ui-widget-content" ><!-- Tabs pane -->

            <div id="switcher"></div>

		<div id="tabs" class="jqgtabs">
                         
			<ul>

			</ul>

		</div>
                <div id="LogoPanel" style="width:90%; border:0px solid #000;margin-left:10%;  margin-top:2%; text-align:center; ">
                        <table id="gridUsuarios"></table>
                        <div id="pagGrid"></div>
                </div>
	</div> <!-- #RightPane -->

</body>

</html>