<!-- importar librerias -->
<%@include file="/jsp/include/taglibs.jsp"%>

<div style="margin:auto; width:800px; height:auto;">

</div>

<div style="margin:auto; width:800px; height:auto; margin-top: 10px;">

	
	<table class="registrarActa_tabla01" style="width:800px; border-collapse:collapse;">
	
		<tr style="background-color: #efefef;">			
			<th style="width: 200px;">DATOS</th>			
			<th style="width: 300px;">PACIENTE</th>	
		</tr>

		<tr>
			<td>Tipo de documento</td>
			<td><c:out value="${aseguradoBean.tiDocumento}"></c:out></td>
		</tr>

		<tr>
			<td>N&uacute;mero de documento</td>
			<td><c:out value="${aseguradoBean.aseguradoDni}"></c:out></td>
		</tr>

		<tr>
			<td>Apellidos y Nombres</td>
			<td><c:out value="${aseguradoBean.aseguradoNombres}"></c:out></td>
		</tr>

		<tr>
			<td>Fecha de Nacimiento</td>
			<td><c:out value="${aseguradoBean.feNaci}"></c:out></td>
		</tr>

		<tr>
			<td>Sexo</td>
			<td><c:out value="${aseguradoBean.sexo}"></c:out></td>
		</tr>

		<tr>
			<td>Domicilio</td>
			<td><c:out value="${aseguradoBean.domicilio}"></c:out></td>
		</tr>

		<tr>
			<td>Tel&eacute;fono de Casa</td>
			<td><c:out value="${aseguradoBean.telCasa}"></c:out></td>
		</tr>
		
		<tr>
			<td>Tel&eacute;fono Opcional</td>
			<td><c:out value="${aseguradoBean.telOpcional}"></c:out></td>
		</tr>

		<tr>
			<td>Correo Electr&oacute;nico</td>
			<td><c:out value="${aseguradoBean.correoElectronico}"></c:out></td>
		</tr>
		
	</table>

</div>

<div style="margin:auto; width:800px; height:auto; margin-top: 10px;">

	<table class="registrarActa_tabla01" style="width:800px; border-collapse:collapse;">
	
		<tr style="background-color: #efefef;">			
			<th style="width: 200px;">DATOS</th>			
			<th style="width: 300px;">CITA</th>	
		</tr>

		<tr>
			<td>Departamento</td>
			<td><c:out value="${citaBean.departamento}"></c:out></td>
		</tr>

		<tr>
			<td>Centro Asistencial</td>
			<td><c:out value="${citaBean.centroAsistencial}"></c:out></td>
		</tr>

		<tr>
			<td>Especialidad</td>
			<td><c:out value="${citaBean.especialidad}"></c:out></td>
		</tr>

		<tr>
			<td>Fecha</td>
			<td><c:out value="${citaBean.fecha}"></c:out></td>
		</tr>

		<tr>
			<td>Turno</td>
			<td><c:out value="${citaBean.turno}"></c:out></td>
		</tr>

		<tr>
			<td>Descripci&oacute;n del malestar</td>
			<td style="border-bottom:1px solid #333;"><c:out value="${citaBean.malestar}"></c:out></td>
		</tr>
		
	</table>
	
</div>
<div style="margin:auto; width:800px; height:auto;">

	<div style="margin:auto; width:600px; height:30px; text-align: center; margin-top:5px;">

	</div>

</div>