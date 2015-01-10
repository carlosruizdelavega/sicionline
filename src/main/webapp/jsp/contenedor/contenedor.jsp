<!DOCTYPE html>
<html lang="es">

	<head>

		<!-- establecer parametros de configuracion de pagina -->
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<!-- establecer titulo de pagina -->
		<title>ESSALUD - Sistema de Citas</title>
		
		<!-- establecer icono de pagina -->
		<link rel="shortcut icon" href="./recursosWeb/images/favicon.ico"></link>
		
		<!-- importar librerias generales -->
		<%@include file="/jsp/include/taglibs.jsp" %>
		<%@include file="/jsp/include/libGeneralJS.jsp" %>
		<%@include file="/jsp/include/libGeneralCSS.jsp" %>
		
	</head>
	
	<body>
		
		<!-- header -->
		<div class="row-fluid">
			<div class="span1"></div>	
			<div class="span10" style="height:103px; margin-top:10px; margin-bottom:5px;">
				<div style="display:block; width:729px; height:103px; margin:auto;">
					<img alt="Sistema de Citas" 
						src="recursosWeb/images/titleSistema_2.png" width="729" height="103" 
						style="float:left; border:0px;" />
				</div>
			</div>
			<div class="span1"></div>
		</div>

		<!-- content -->
		<div class="row-fluid">
			<div class="span1"></div>
			<div class="span10">
				
				<div id="contenido"></div>
				
			</div>
			<div class="span1"></div>
		</div>
			
		<!-- footer -->
		<div class="row-fluid">
			<div class="span1"></div>
			<div class="span10" style="margin-top:20px; margin-bottom:20px;">
			
				<div style="display:block; width:305px; height:81px; margin: auto;">

					<div style="float:left; width:235px; height:81px;">
						<p style="line-height: 16px; margin-top:2px;">
							<small>
								<strong>Gerencia de Tecnolog&iacute;a de la Informaci&oacute;n</strong><br />
							</small>
						</p>							
						<p class="text-info" style="line-height: 16px;">
							<strong>Equipo:</strong> ADS - Jenkins
						</p>														
					</div>
				</div>
				
			</div>
			<div class="span1"></div>
		</div>

	</body>
	
</html>