<!-- importar librerias -->
<%@include file="/jsp/include/taglibs.jsp"%>
<script type="text/javascript"
	src="${ruta}/recursosWeb/particular/citaMedica/js/datosPacienteyCita.js"></script>

<!-- Datos del Paciente -->
<div style="height: 215px; margin: 8px;">

	<div class="contenedorForm01"
		style="float: left; border: 1px solid #555555;">

		<div style="margin: auto; width: 100%;">

			<!-- titulo -->
			<div style="float: left; clear: left; margin-top: 10px;">

				<div style="float: left; clear: left; width: auto; height: 30px;">
					<span class="titulo03">Datos del Paciente</span>
				</div>

			</div>

			<div id="divCon01">

				<!-- Tipo de documento, Nro.Documento, Fecha Nac., Sexo -->
				<div style="float: left; clear: left; width: 100%;">

					<div style="margin-top: 10px; float: left; width: auto;">

						<div style="float: left; width: auto;">
							<label> 
							<small style="font-size: 11px; font-weight: bold;"> Tipo de documento </small>
							</label>

						</div>

						<div style="float: left; width: auto; margin-left: 10px;">
							<select id="cboTipoDocumento01" style="width: 165px; font-size: 12px;">
								<option value="DNI/LE" selected="selected">DNI/LE</option>
								<option value="ACTA DE NACIMIENTO" >ACTA DE NACIMIENTO</option>
							</select>
							
						</div>

						<div style="float: left; width: auto; margin-left: 25px;">
							<label> 
							<small style="font-size: 11px; font-weight: bold;"> Nro. Documento </small>
							</label>
							
						</div>

						<div style="float: left; width: auto; margin-left: 10px;">
							<input id="txtNroDocumento01" type="text"
								style="width: 120px; text-transform: uppercase; font-size: 12px;"
								maxlength="15" ondrop="return false;" />
						</div>
						
						<div style="float: left; width: auto; margin-left: 25px;">
							<label> 
							<small style="font-size: 11px; font-weight: bold;">Fecha Nac.</small>
							</label>
							
						</div>
						
						<div style="float: left; width: auto; margin-left: 10px;">
							<input id="txtFeNacimiento" type="text"
							style="font-size: 12px; width: 86px; text-align: center"
							maxlength="6"/>
							
						</div>

						<div style="float: left; width: auto; margin-left: 25px;">
							<label> 
							<small style="font-size: 11px; font-weight: bold;">Sexo</small>
							</label>
						</div>
						
						<div style="float: left; width: auto; margin-left: 10px;">
							<select id="cboListaTipoSexo01"
								style="height: 26px; font-size: 12px; width: 110px">

								<option value="MASCULINO" selected="selected">MASCULINO</option>
								<option value="FEMENINO">FEMENINO</option>

							</select>
						</div>
					</div>

				</div>

				<!-- Primer Apellido, Segundo Apellido -->
				<div style="float: left; clear: left; width: 100%;">

					<div style="margin-top: 10px; float: left; width: auto;">
					
						<div style="float: left; width: auto;">
							<label> 
							<small style="font-size: 11px; font-weight: bold;">Primer Apellido </small>
							</label>
							
						</div>
						
						<div style="float: left; width: auto; margin-left: 10px;">
							<input id="txtApPrimer01" type="text" style="width: 280px; text-transform: uppercase; font-size: 12px;"
							maxlength="40" ondrop="return false;"/>
						</div>
						
						<div style="float: left; width: auto; margin-left: 25px;">
							<label> 
							<small style="font-size: 11px; font-weight: bold;">Segundo Apellido </small>
							</label>
						</div>
						
						<div style="float: left; width: auto; margin-left: 10px;">
							<input id="txtApSegundo01" type="text" style="width: 280px; text-transform: uppercase; font-size: 12px;"
							maxlength="40" ondrop="return false;"/>
						</div>
					</div>

				</div>
				
				<!-- Nombres, Direccion -->
				<div style="float: left; clear: left; width: 100%;">
				
					<div style="margin-top: 10px; float: left; width: auto;">
						
						<div style="float: left; width: auto;">
							<label> 
							<small style="font-size: 11px; font-weight: bold;">Nombres </small>
							</label>
							
						</div>
						
						<div style="float: left; width: auto; margin-left: 10px;">
							<input id="txtPreNomInscrito01" type="text" style="width: 314px; text-transform: uppercase; font-size: 12px;"
							maxlength="60" ondrop="return false;"/>
							
						</div>
						
						<div style="float: left; width: auto; margin-left: 25px;">
						<label> 
							<small style="font-size: 11px; font-weight: bold;">Direcci&oacute;n</small>
						</label>
						
						</div>
						
						<div style="float: left; width: auto; margin-left: 10px;">
							<input id="txtDeDomicilio01" type="text" style="width: 413px; text-transform: uppercase; font-size: 12px;"
						maxlength="120" ondrop="return false;"/>
						</div>
					</div>
				</div>

				<!-- Telefono de casa, Telefono Opcional, Correo Electronico -->
				<div style="float: left; clear: left; width: 100%;">

					<div style="margin-top: 10px; float: left; width: auto;">
						
						<div style="float: left; width: auto;">
							<label> 
							<small style="font-size: 11px; font-weight: bold;">Tel&eacute;fono de casa</small>
							</label>
							
						</div>
						
						<div style="float: left; width: auto; margin-left: 10px;">
							<input id="txtDeTlfCasa01" type="text" style="width: 150px; text-transform: uppercase; font-size: 12px;"
						maxlength="10" ondrop="return false;"/>
							
						</div>
						
						<div style="float: left; width: auto; margin-left: 25px;">
							<label> 
							<small style="font-size: 11px; font-weight: bold;">Tel&eacute;fono opcional</small>
							</label>
						
						</div>
						
						<div style="float: left; width: auto; margin-left: 10px;">
							<input id="txtDeTlfOpcional01" type="text" style="width: 150px; text-transform: uppercase; font-size: 12px;" maxlength="10" ondrop="return false;"/>
						</div>
						
						<div style="float: left; width: auto; margin-left: 25px;">
							<label> 
							<small style="font-size: 11px; font-weight: bold;">
							Correo Electr&oacute;nico
							</small>
							</label>
						</div>
						
						<div style="float: left; width: auto; margin-left: 10px;">
							<input id="txtCorreoElect01" type="text"
							style="width: 194px; font-size: 12px;"
							maxlength="200"/>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

</div>

<div style="height: 20px; margin: 10px;"></div>

<!-- Datos de la Cita -->
<div style="height: 215px; margin: 8px;">
	
	<div class="contenedorForm02" style="float: left; border: 1px solid #555555;">

		<div style="margin: auto; width: 100%;">

			<!-- titulo -->
			<div style="float: left; clear: left; margin-top: 10px;">

				<div style="float: left; clear: left; width: auto; height: 30px;">
					<span class="titulo03">Datos de la Cita</span>
				</div>

			</div>

			<div id="divCon02">
				
				<!-- Departamento, Centro Asistencial, Especialidad -->
				<div style="float: left; clear: left; width: 100%;">

					<div style="margin-top: 10px; float: left; width: auto;">
					
						<div style="float: left; width: auto;">
							<label> 
							<small style="font-size: 11px; font-weight: bold;"> Departamento </small>
							</label>

						</div>
					
						<div style="float: left; width: auto; margin-left: 10px;">
							<select id="cboListaDepa02" style="height: 26px; font-size: 12px; width: 160px">
							
							<option value="00" selected="selected">SELECCIONE</option>
							<option value="AMAZONAS">AMAZONAS</option>
							<option value="ANCASH">ANCASH</option>
							<option value="APURIMAC">APURIMAC</option>
							<option value="AREQUIPA">AREQUIPA</option>
							<option value="AYACUCHO">AYACUCHO</option>
							<option value="CAJAMARCA">CAJAMARCA</option>
							<option value="CUSCO">CUSCO</option>
							<option value="HUANCAVELICA">HUANCAVELICA</option>
							<option value="HUANUCO">HUANUCO</option>
							<option value="ICA">ICA</option>
							<option value="JUNIN">JUNIN</option>
							<option value="LA LIBERTAD">LA LIBERTAD</option>
							<option value="LAMBAYEQUE">LAMBAYEQUE</option>
							<option value="LIMA">LIMA</option>
							<option value="LORETO">LORETO</option>
							<option value="MADRE DE DIOS">MADRE DE DIOS</option>
							<option value="MOQUEGUA">MOQUEGUA</option>
							<option value="PASCO">PASCO</option>
							<option value="PIURA">PIURA</option>
							<option value="PUNO">PUNO</option>
							<option value="SAN MARTIN">SAN MARTIN</option>
							<option value="TACNA">TACNA</option>
							<option value="UCAYALI">UCAYALI</option>
						</select>
						</div>
						
						<div style="float: left; width: auto; margin-left: 25px;">
							<label> 
							<small style="font-size: 11px; font-weight: bold;"> Centro Asistencial </small>
							</label>
						</div>
						
						<div style="float: left; width: auto; margin-left: 10px;">
							<select id="cboListaCentAsis02" style="height: 26px; font-size: 12px; width: 160px">
		
								<option value="00" selected="selected">SELECCIONE</option>
								<option value="ATALAYA">ATALAYA</option>
								<option value="AUCAYACU">AUCAYACU</option>
								<option value="AYAVIRI">AYAVIRI</option>
								<option value="BAÑOS">BAÑOS</option>
								<option value="CABALLOCOCHA">CABALLOCOCHA</option>
								<option value="CABANILLAS">CABANILLAS</option>
								<option value="CALCA">CALCA</option>
								<option value="CAMPO VERDE">CAMPO VERDE</option>
								<option value="CARAZ">CARAZ</option>
								<option value="CARHUAZ">CARHUAZ</option>
								<option value="CHALHUANCA">CHALHUANCA</option>
								<option value="CHICA">CHICA</option>
								<option value="CHICRIN">CHICRIN</option>
								<option value="CHUPACA">CHUPACA</option>
								<option value="CHUQUIBAMBILLA">CHUQUIBAMBILLA</option>
								<option value="HUAYLLAY">HUAYLLAY</option>
								<option value="HUYRO">HUYRO</option>
								<option value="ILAVE">ILAVE</option>
								<option value="LAMPA">LAMPA</option>
								<option value="PANAO">PANAO</option>
								<option value="REQUENA">REQUENA</option>
								<option value="SICUANI">SICUANI</option>
								<option value="TORATA">TORATA</option>
							</select>
						</div>
						
						<div style="float: left; width: auto; margin-left: 25px;">
							<label> 
							<small style="font-size: 11px; font-weight: bold;">Especialidad</small>
							</label>
						
						</div>
						
						<div style="float: left; width: auto; margin-left: 10px;">
						
							<select id="cboListaEspec02" style="height: 26px; font-size: 12px; width: 250px">
								<option value="00" selected="selected">SELECCIONE</option>
								<option value="ALERGIA">ALERGIA</option>
								<option value="CARDIOLOGIA">CARDIOLOGIA</option>
								<option value="DERMATOLOGIA">DERMATOLOGIA</option>
								<option value="ENDOCRINOLOGIA">ENDOCRINOLOGIA</option>
								<option value="GASTROENTEROLOGIA">GASTROENTEROLOGIA</option>
								<option value="GERIATRIA">GERIATRIA</option>
								<option value="MEDICINA COMPLEMENTARIA">MEDICINA
									COMPLEMENTARIA</option>
								<option value="MEDICINA FISICA Y REHABILI">MEDICINA
									FISICA Y REHABILI</option>
								<option value="MEDICINA GENERAL">MEDICINA GENERAL</option>
								<option value="MEDICINA INTERNA">MEDICINA INTERNA</option>
								<option value="HEMODIALISIS">HEMODIALISIS</option>
								<option value="NEUMOLOGIA">NEUMOLOGIA</option>
								<option value="NEUROLOGIA">NEUROLOGIA</option>
								<option value="ONCOLOGIA">ONCOLOGIA</option>
								<option value="PSIQUIATRIA">PSIQUIATRIA</option>
								<option value="REUMATOLOGIA">REUMATOLOGIA</option>
								<option value="MEDICINA INTENSIVA">MEDICINA INTENSIVA</option>
								<option value="OFTALMOLOGIA">OFTALMOLOGIA</option>
								<option value="ORTOPEDIA Y TRAUMATOLOGIA">ORTOPEDIA Y
									TRAUMATOLOGIA</option>
								<option value="OTORRINOLARINGOLOGIA">OTORRINOLARINGOLOGIA</option>
								<option value="UROLOGIA">UROLOGIA</option>
								<option value="GINECOLOGIA Y OBSTETRICIA">GINECOLOGIA Y
									OBSTETRICIA</option>
								<option value="ODONTOLOGIA">ODONTOLOGIA</option>
							</select>
						</div>
					</div>

				</div>

				<!-- Fecha, Turno, Descripcion del malestar fisico -->
				<div style="float: left; clear: left; width: 100%;">
				
					<div style="margin-top: 10px; float: left; width: auto;">

						<div style="float: left; width: auto;">
							<label> <small style="font-size: 11px; font-weight: bold;">Fecha</small>
							</label>
							
						</div>
						
						<div style="float: left; width: auto; margin-left: 10px;">
							<input id="txtFehoCelebracion" type="text"
						style="font-size: 12px; width: 86px; text-align: center"
						maxlength="8"/>
						</div>
						
						<div style="float: left; width: auto; margin-left: 25px;">
							<label> <small style="font-size: 11px; font-weight: bold;">Turno</small>
							</label>
						</div>
						
						<div style="float: left; width: auto; margin-left: 10px;">
							<select id="cboListaTurno02" style="height: 26px; font-size: 12px; width: 90px">
								<option value="MAÑANA" selected="selected">MAÑANA</option>
								<option value="TARDE">TARDE</option>
							</select>
						</div>
						
						<div style="float: left; width: auto; margin-left: 25px;">
							<label> <small style="font-size: 11px; font-weight: bold;">Descripci&oacute;n del Malestar F&iacute;sico</small>
							</label>
						</div>
						
						<div style="float: left; width: auto; margin-left: 10px;">
							<textarea id="txaDesMalestar" style="width: 384px; height: 90px; text-transform: uppercase; font-size: 12px; margin-top: -6px;"
							maxlength="100" ondrop="return false;"></textarea>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

</div>