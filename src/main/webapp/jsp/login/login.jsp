<!-- importar librerias -->
<%@include file="/jsp/include/taglibs.jsp" %>
<script type="text/javascript" src="${ruta}/recursosWeb/particular/login/js/login.js"></script>

<!-- contenido -->
<div class="backContent" style="display:block; width: 568px; height: 198px; margin:auto; 
	margin-top:40px; margin-bottom: 40px; background: url('recursosWeb/images/backForm.png') #F4F4F4 no-repeat right top;">
		
	<div style="display:block; width:568px; height:198px;">						 

		<div class="form-horizontal" style=" margin-left: -80px; margin-top: 40px;">
		    	
		    <div class="control-group" style="">
			    <label class="control-label" for="usuario">DNI</label>
			    <div class="controls">
			    	<input type="text" style="padding: 4px 6px;" id="txtUser" name="txtUser" 
			    		placeholder="Ingrese DNI" onkeydown="fnValidarNumero(this)" 
			    		onkeyup="fnValidarNumero(this)" maxlength="8" value="44380447"/>
			    </div>
			</div>
			
		    <div class="control-group">
		    	<label class="control-label" for="password">Contrase&ntilde;a</label>
		    	<div class="controls">
		    		<input type="password" style="padding: 4px 6px;" id="codigo" name="codigo" 
		    			placeholder="Ingrese contrase&ntilde;a" maxlength="15" value="44380447"/>
		    	</div>
		    </div>
		    
		    <div class="control-group">
		    	<div class="controls">
		    		<button id="btnLoginIngresar" onClick="fnAccesoSistema();" class="btn btn-primary">
		    			Ingresar
		    		</button>
		    	</div>
		    </div>

		</div>
	
	</div>
	
</div>