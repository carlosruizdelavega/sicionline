/**
 * Funcion que permite ejecutar las operaciones especificadas, cuando se ha cargado completamente el DOM
 */
$(document).ready(function(){
	
	//cargar tabs
	$("#tabs").tabs();
	
	//mostrar tab Datos del Paciente y Cita
	fnMostrarTabPacienteyCita(0);	
});

function fnRegistrarCitaMedica(){
	cModal("divModalRegistrarCita", "Registrar Cita Médica", 250, 200, "registrarCitaMedica()",3);
}

/**
 * Funcion que permite registrar los datos de la cita medica
 */
function registrarCitaMedica(){
		
	//preparar parametros
	var parametros = {
			connect:{
	    		url: "registrarCitaMedica.htm",
	            type: "POST"
			},
			data:{}
	};
	
	//consultar al controlador
	cRequestAjax(parametros, function(response){
		if(response == "1"){
			
			//mostrar mensaje satisfactorio
			var msg = "Los datos del paciente y la cita se registraron exitosamente";
			cAlert(msg, null, "0", "despuesGuardarCitaMedica()");
			
		}else{
			
			//mostrar mensaje fallido
			var msg = "Error al registrar los datos del paciente y la cita";
			cAlert(msg, null, "0", null);
			
		}
	});		

}


/**
 * Funcion que permite mostrar boton de impresion
 */
function despuesGuardarCitaMedica(){
	
	//ocultar boton para guardar acta de celebracion
	$("#btnGuardarCita").css("display", "none");

	//mostrar boton para imprimir acta de celebracion
	$("#btnImprimirCita").css("display", "block");
	
	//mostrar acta de celebracion generada
	//$("#divContentActaGenerada").css("display", "block");
	//$("#txtNroActaCelebracion").val(actaCelebracion);
	
}

/**
 * Funcion que permite confirmar impresion de acta de celebracion
 * 
 */

function imprimirCita(){
	cModal("divModalConstanciaCita", "Imprimir Constancia", 250, 200, "imprimirConstanciaCita()",3);
}

function imprimirConstanciaCita(){

			fnMostrarPdf();
			
			//mostrar mensaje satisfactorio
			cAlert("Constancia impresa correctamente", 
				   null, 
				   "2", 
				   "despuesImprimirConstanciaCita()", 
				   "imprimirConstanciaCita()");
}

/**
 * Funcion que permite limpiar datos en sesion de la cita medica
 */
function despuesImprimirConstanciaCita(){
	
	//preparar parametros
	var parametros = {
			connect:{
	    		url: "limpiarDatosCitaMedica.htm",
	            type: "POST"
			},
			data:{}
	};
	
	//consultar al controlador
	cRequestAjax(parametros, function(response){
		if(response == "01"){
			
			//mostrar mensaje satisfactorio
			cAlert("¿Qu&eacute; desea hacer a continuaci&oacute;n?", 
				   null, 
				   "3", 
				   "irNuevoRegistro()", 
				   "irMenuPrincipal()");
			
		}else{
			
			//mostrar mensaje fallido
			var msg = "";
			msg += "Ocurri&oacute; un error al limpiar los datos de sesion. ";
			msg += "Comun&iacute;quese con el Administrador del Sistema.";
			cAlert(msg, 
				   null, 
				   "0", 
				   null);
			
		}
	});	
	
}

/**
 * Funcion que permite realizar un nuevo registro
 */
function irNuevoRegistro(){
	
	//mostrar modulo de Nuevo Registro de Acta de Celebracion
	fnRegistrarCita();
	//fnCargarContenido("cargarRegistroActa.htm", null, "#contenido");
	
}

/**
 * Funcion que permite ir al Menu principal
 */
function irMenuPrincipal(){
	
	//mostrar Menu Principal
	fnCargarContenido("menuPrincipal.htm", null, "#contenido");
	
}

/**
 * Funcion que permite mostrar el tab de Datos del Paciente y la Cita
 * nroTabActual: Numero de tab que piensa abandonar para ir al tab
 * 				 0: Ningún tab
 * 				 1: Tab Datos del Paciente y Cita
 * 				 2: Tab Vista Previa   
 */
function fnMostrarTabPacienteyCita(nroTabActual){
		
		//guardar bean
		fnGuardarTab(nroTabActual, function(response){
			
			//verificar que se guarde el bean
			if(response == true){
				
				//cargar tab testigos
				fnCargarTab(1);
				
			}else{
				
				//mostrar mensaje de error
				cAlert("Hubo problemas al cargar tab de Datos del Paciente y la Cita, int&eacute;ntelo de nuevo", null, "0", null);
				
			}
			
		});
	
}

/**
 * Funcion que permite mostrar el tab de vista previa
 * nroTabActual: Numero de tab que piensa abandonar para ir al tab de celebracion
 * 				 0: Ningún tab
 * 				 1: Tab Datos del Paciente y la Cita
 * 				 2: Tab Vista Previa
 */
function fnMostrarTabVistaPrevia(nroTabActual){

	//guardar bean
		fnGuardarTab(nroTabActual, function(response){
			//verificar que se guarde el bean
			if(response == true){
				
				fnCargarTab(2);
				
			}else{
				
				//mostrar mensaje de error
				cAlert("Hubo problemas al mostrar Vista Previa, int&eacute;ntelo de nuevo", null, "0", null);
				
			}
			
		}); 

}

/**
 * Funcion que permite guardar los beans asociados a un tab especifico
 */
function fnGuardarTab(nroTab, callback){
	
	//verificar validacion segun tab
	if(nroTab == 0){
		
		//no guarda ningun tab
		callback(true);
		
	}else if(nroTab == 1){
		
		//guardar tab de Datos del Paciente y la Cita
		fnGuardarTabPacienteyCita(function(response){
			callback(response);
		});
        
	}

}

/**
 * Funcion que permite guardar tab de Datos del Paciente y la Cita
 */
function fnGuardarTabPacienteyCita(callback){
	
	//obtener datos de los controles
	//------------------------------
	//paciente
	var cboTipoDocumento01 = $("#cboTipoDocumento01").val();
	var txtNroDocumento01 = $("#txtNroDocumento01").val();
	var txtFeNacimiento = $("#txtFeNacimiento").val();
	var cboListaTipoSexo01 = $("#cboListaTipoSexo01").val();
	var txtApPrimer01 = $("#txtApPrimer01").val();
	var txtApSegundo01 = $("#txtApSegundo01").val();
	var txtPreNomInscrito01 = $("#txtPreNomInscrito01").val();
	var txtDeDomicilio01 = $("#txtDeDomicilio01").val();
	var txtDeTlfCasa01 = $("#txtDeTlfCasa01").val();
	var txtDeTlfOpcional01 = $("#txtDeTlfOpcional01").val();
	var txtCorreoElect01 = $("#txtCorreoElect01").val();
	
	//cita
	var cboListaDepa02 = $("#cboListaDepa02").val();
	var cboListaCentAsis02 = $("#cboListaCentAsis02").val();
	var cboListaEspec02 = $("#cboListaEspec02").val();
	var txtFehoCelebracion = $("#txtFehoCelebracion").val();
	var cboListaTurno02 = $("#cboListaTurno02").val();
	var txaDesMalestar = $("#txaDesMalestar").val();
	
	//preparar parametros
	var parametros = {
    		connect:{
        		url: "guardarTabCitaMedica.htm",
                type: "POST"
    		},
    		data:{
    			cboTipoDocumento01:cboTipoDocumento01,
    			txtNroDocumento01:txtNroDocumento01,
    			txtFeNacimiento:txtFeNacimiento,
    			txtApPrimer01:txtApPrimer01,
    			txtApSegundo01:txtApSegundo01,
    			txtPreNomInscrito01:txtPreNomInscrito01,
    			cboListaTipoSexo01:cboListaTipoSexo01,
    			txtDeDomicilio01:txtDeDomicilio01,
    			txtDeTlfCasa01:txtDeTlfCasa01,
    			txtDeTlfOpcional01:txtDeTlfOpcional01,
    			txtCorreoElect01:txtCorreoElect01,
    			cboListaDepa02:cboListaDepa02,
    			cboListaCentAsis02:cboListaCentAsis02,
    			cboListaEspec02:cboListaEspec02,
    			txtFehoCelebracion:txtFehoCelebracion,
    			cboListaTurno02:cboListaTurno02,
    			txaDesMalestar:txaDesMalestar
    		}
     };
	
	//consultar al controlador
	cRequestAjax(parametros, function(response){
		callback(response);
	});
	
}

/**
 * Funcion que permite cargar un tab especifico, haciendo uso de los botones siguiente y anterior
 */
function fnCargarTab(nroTab){
	
	//los tabs empiezan con 0
	
	//verificar tab
	var arrayTabs = new Array(1);
	if(nroTab == 1){
		
		//definir tabs a deshabilitar
		arrayTabs = [1];
		
		//cargar contenido en tab de Datos del Paciente y la Cita
		fnCargarTabPacienteyCita();
		
	}else if(nroTab == 2){
		
		//definir tabs a desabilitar
		arrayTabs = [0];
		
		//cargar contenido en tab de Vista Previa
		fnCargarTabVistaPrevia();
		
	}
	
	//desabilitar todos los tabs
	$("#tabs").tabs({disabled:arrayTabs});
	
	//habilitar tab especificado
	$("#tabs").tabs({enabled:[2]});
		
	//mostrar tab especificado
	$("#tabs").tabs({active:1});
	
}

/**
 * Funcion que permite cargar tab de contrayente
 */
function fnCargarTabPacienteyCita(){
	 
	//definir parametros
	var parametros = {
			connect:{
	    		url: "cargarTabPacienteyCita.htm",
	            type: "POST",
	            cache: false 
			},
			data:{}
	};
	
	//consultar tab de testigos
	cRequestAjax(parametros, function(response){
		
		//cargar contenido html
		$('#divContentTab1').html(response);

   		//enfocar campo de texto de DNI del paciente
   		$("#cboTipoDocumento01").focus();
   		
	});
	 
}

/**
 * Funcion que permite cargar tab de impresion 
 */
function fnCargarTabVistaPrevia(){

		//limpiar contenido del tab de impresion
		$("#divContentTab2").html("");
		
		//preparar parametros
		var parametros = {
			connect:{
        		url: "cargarTabVistaPrevia.htm",
                type: "POST" 
    		},
			data:{}
		};

		//consultar datos del tab de impresion
	    cRequestAjax(parametros, function(response){
	    	$("#divContentTab2").html(response);
	    });
	
}

/**
 * Funcion que permite mostrar en blank el PDF del acta de celebracion 
 * @param nroActa
 */
function fnMostrarPdf(){
	window.open("actaCelebracionPreview.pdf?acta=1");
	return;
}

