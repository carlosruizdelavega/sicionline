<!-- importar librerias -->
<%@include file="/jsp/include/taglibs.jsp" %>

<script type="text/javascript" src="${ruta}/recursosWeb/particular/citaMedica/js/inicioCitaMedica.js"></script>

<link rel="stylesheet" type="text/css" href="${ruta}/recursosWeb/particular/citaMedica/css/inicioCitaMedica.css"></link>

<!-- scripts propios -->
<script type="text/javascript">

</script>

<!-- menu -->
<div class="navbar">

	<div class="navbar-inner">
 
		<div class="container">
      
			<!-- titulo -->
			<a class="brand" href="#.">SICI</a>
   
			<!-- links particulares -->
			<c:set var="titulo" value="Registro de Cita" scope="request"></c:set>
			<c:set var="classTituloRegistro" value="dropdown active" scope="request"></c:set>
			<ul class="nav">

				<li class="${classTituloRegistro}">								
					<a href="#" onclick="fnRegistrarCita();" class="dropdown-toggle" data-toggle="dropdown">
						Registro de Cita
					</a>
				</li>
	
			</ul>

			<!-- links generales -->
			<%@include file="/jsp/menuPrincipal/linksGenerales.jsp" %>
   
		</div>
 
	</div>
 
</div>

<!-- contenido -->
<div class="backContent" style="display:block; width:auto; height:auto; padding:5px;">
	
	<!-- ini: formulario principal -->
    <div class="contenedorForm">

	    <!-- contenedor del titulo -->
	    <div style="display:block; height:32px; margin-top:15px; margin-left:10px;">
	    
	    	<!-- titulo -->
			<div style="float:left;">
				<span class="titulo02">
					Cita M&eacute;dica
				</span>
			</div>
			
		</div>
			
		<!-- linea -->
		<div style="display:block; height:20px;  border-top:1px solid #E5E5E5; width:auto; margin-left:10px;"></div>									    

		<!-- Tabs -->
		<div id="tabs" style="margin-bottom: 10px;" class="tabs">
		
			<ul>
				
				<li>
					<a href="#tabs-1" style="background-color:#F5F5F5;border-bottom:1px solid #F5F5F5">
						Datos del Paciente y la Cita<!-- Datos de los Contrayentes -->
					</a>
				</li>
				
				<li>
					<a href="#tabs-2" style="background-color:#F5F5F5; border-bottom:1px solid #F5F5F5">
						Vista Previa
					</a>
				</li>
				
			</ul>
			
			<!-- Inicia tabs-1 (Paciente y Cita) -->
			<div id="tabs-1" style="background-color:#F5F5F5; border:1px solid #000000;border-top:0px">
						 	
				<!-- contenido del tab -->
				<div id="divContentTab1" style="margin-left: -20px"></div>
	
				<!-- boton siguiente -->
			 	<div style="margin-left:-15px; padding-right:30px; border-top:1px solid black; width:100%; 
			 		height:42px;">
			 	
			 		<button id="btnSiguiente" 
			 			class="btn btnNext btn-small btn-primary" 
						style="float:right; margin-top:16px; margin-left:738px;" 
						onclick="fnMostrarTabVistaPrevia(1);">
						<i class="icon-forward icon-white"></i>&nbsp;Siguiente
					</button>

				</div>
						
			</div>
				

			<div id="tabs-2" style=" background-color:white;  border:1px solid #000000;border-top:0px;">
			
				<!-- contenido del tab -->
				<div id="divContentTab2"></div>
				
				<!-- boton anterior y siguiente -->
				<div style="margin-left:-15px; padding-right:30px; border-top:1px solid black; width:100%; 
					height:42px;">

					<button id="btnImprimirCita" 
					        class="btn btn-small btn-primary" 
							style="float:right; 
							       margin-top:16px; 
							       margin-left:10px; 
							       display:none;" 
							onclick="imprimirCita();">
						<i class="icon-print icon-white"></i>&nbsp;Imprimir Constancia
					</button>
					
					<button id="btnGuardarCita" 
							class="btn btn-small btn-primary" 
							style="float:right; 
								   margin-top:16px; 
								   margin-left:10px;" 
							onclick="fnRegistrarCitaMedica();">
						<i class="icon-hdd icon-white"></i>&nbsp;Guardar Datos
					</button>
					
				</div>

			</div>
			
			
		</div>
	
	<!-- inicio dialogo confirmacion de  Registrar cita medica -->
	<div id="divModalRegistrarCita" style="display:none">
		<p>
			<span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>
				Confirmar el registro de la cita
		</p>
	</div>	
	
	<!-- inicio dialogo confirmacion de  Impresion de constancia de cita medica -->
	<div id="divModalConstanciaCita" style="display:none">
		<p>
			<span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>
				Confirmar la impresi&oacute;n de la constancia
		</p>
	</div>
	</div>

</div>