<!-- importar librerias -->
<%@include file="/jsp/include/taglibs.jsp" %>
<script type="text/javascript" src="${ruta}/recursosWeb/particular/menuPrincipal/js/menuPrincipal.js"></script>

<!-- contenido -->
<div class="backContent" style="display:block; width: 800px; height:230px; margin:auto; margin-top:20px;">
	
	<!-- titulo -->
	<div style="display: block; text-align:center; height:32px;">
		<span class="titulo01">Men&uacute; principal</span>
	</div>
	
	<!-- linea -->
	<div style="display:block; height:8px; min-height:8px; border-top:1px solid #E5E5E5;"></div>

	<div style="float:left; clear:left; display: block; height: auto; margin-left:288px;">

		<div class="btnIcon03" style="border: 0px;"	onclick="fnRegistrarCita()"></div>

	</div>

	<div style="float:left; clear:left; width:460px; height:auto;  margin-left:330px;">
				
				<div style="font-size:11px;color:#660000;margin-bottom: 30px;text-align: right;" >
					<span><strong>USUARIO: </strong></span>${datUsuario}
					<input name="usuario" type="hidden" id="usuario" value="${datUsuario}" >
				</div>
				
				<button type="button" class="btn btn-primary" onclick="fnCerrarSesion();">
					<i class="icon-lock icon-white"></i>
					&nbsp;Cerrar sesi&oacute;n
				</button>
				
			
	</div>
			
</div>