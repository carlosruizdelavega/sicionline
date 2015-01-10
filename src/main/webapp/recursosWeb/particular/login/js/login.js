/**
 * Funcion que permite ejecutar las operaciones especificadas, cuando se ha cargado completamente el DOM
 */
$(document).ready(function(){

	//enfocar en campo de texto usuario
	$("#txtUser").focus();
	
});

/**
 * Funcion que permite obtener acceso al sistema
 */
function fnAccesoSistema(){
 
	//validaciones
    var nuDNI = $("#txtUser").val();
    var passw=$("#codigo").val();
	 
    if($.trim(nuDNI) == ""){
    	cAlert("Debe ingresar el DNI", "txtUser",0);
        return;
    }
    
    if($.trim(passw).length == ""){
    	cAlert("Debe ingresar la Contrase\u00f1a", "codigo",0);
        return;
    }
    
    if($.trim(passw).length < 8){
    	cAlert("La Contrase\u00f1a no puede tener menos de 8 caracteres", "codigo",0);
        return;
    }
   
    //verifica usuario
    var codRpta = -1;
    var parametros = {
    		connect:{
        		url: "obtenerAccesoSistema.htm",
                type: "POST" 
    		},
    		data:{
        		coUsuario: nuDNI,
                paUsuario: passw 
    		}
        };
    cRequestAjax(parametros, function(response){
        codRpta = parseInt(response.coStatus);
        if(codRpta != 0){
        	cAlert(response.deStatus, null);
        }else{
        	fnCargarContenido("menuPrincipal.htm", null, "#contenido");
        }
    });

}

/**
 * Funcion que permite cerrar la sesion del sistema
 */
function fnCerrarSesion(){
	var parametros = {
    		connect:{
        		url: "cerrarSesion.htm",
                type: "POST" 
    		},
			data:{
				
			}
        };
    cRequestAjax(parametros, function(response){
                
        if(response == "OK"){
        	fnCargarContenido("login.htm", null, "#contenido");
        	//window.location.href = "contenedor.htm";
        }else{
        	//cAlert(response, null,0);
        	fnCargarContenido("login.htm", null, "#contenido");
        	
        }
    });
	
}

