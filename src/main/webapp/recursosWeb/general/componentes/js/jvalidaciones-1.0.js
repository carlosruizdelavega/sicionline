/**
 * Funcion que no permite ingresar a un campo de texto caracteres no numericos.
 * @param objeto: referencia al objeto input[type=text], sobre el cual ha sido llamada la funcion
 * @returns {Boolean}
 */

function fnValidarNumero(objeto){
    var patron = /^\d*$/;
    if (!patron.test(objeto.value)) {
        //objeto.value="";
        objeto.focus();
        return false;
    }
    return true;
}

/**
 * Funcion que permite validar texto ingresado
 * @param objeto
 * @returns {Boolean}
 */
function fnValidarTexto(objeto){
    var patron = /^[a-zA-Z����������������������'\s]+$/;
    if (!patron .test(objeto.value)) {
        objeto.value="";
        objeto.focus();
        return false;
    }
    return true;
}

/**
 * Funcion que permite convertir texto en mayusculas
 * @param objeto
 */
function fnEnMayusculas(objeto) {
	objeto.value = objeto.value.toUpperCase();
}

/**
 * Funcion que evita pegar Crtl + v(V) en un campo de texto
 */
function fnOmitirCtrlV(event){
	
	//detectar cuando se presione Ctrl + v(V)
	if(event.ctrlKey && (event.which == 86 || event.which == 118)){
		//detener la accion 
		event.preventDefault();
	}
	
}

/**
 * Funcion que evita dar click derecho en un campo de texto
 */
function fnOmitirClickDerecho(event){
	
	//detectar al dar click derecho con el mouse
	if (event.which == 3){
		//detener la accion
		event.preventDefault();
		//alert("CLick derecho desabilitado");
		cAlert("Click derecho est� desabilitado", null, "0", null);
	}
	
}

/**
 * Funcion que permite definir los caracteres permitidos en un campo de texto
 * @param event
 * @param permitidos
 * @returns {Boolean}
 */
function fnRestringirCaracteres(event){

	//recibir parametros
	var permitidos = event.data.perm;
	var nombreFuncion = event.data.func;
	
	//definir teclas especiales permitidas
	/*   0 = (codigo which correspondiente a las teclas: tab, end, home, arrow left, arrow right, delete)
	 *  13 = intro			(incluida)
	 *   8 = backspace		(incluida)
	 *  32 = space			(incluida)******   
	 *   9 = tab		  	(incluida con which = 0)
	 *  35 = end			(incluida con which = 0, el codigo 35 coincide con caracter #)
	 *  36 = home			(incluida con which = 0, el codigo 36 coincide con caracter $)
	 *  37 = arrow left		(incluida con which = 0, el codigo 37 coincide con caracter %)
	 *  39 = arrow right	(incluida con which = 0, el codigo 39 coincide con caracter ')
	 *  46 = delete			(incluida con which = 0, el codigo 46 coincide con caracter .)
	*/
	var teclas_especiales = [0, 13, 8];
 
	// obtener tecla pulsada 
	var evento = event || window.event;
	//var codigoCaracter = evento.charCode || evento.keyCode;
	var codigoCaracter = evento.which;
	//alert("codigoCaracter: " + codigoCaracter);
	var caracter = String.fromCharCode(codigoCaracter);
 
	// verificar teclas especiales
	var tecla_especial = false;
	for(var i in teclas_especiales) {
		if(codigoCaracter == teclas_especiales[i]){
			tecla_especial = true;
			break;
		}
	}

	// verificar si la tecla pulsada se encuentra en los caracteres permitidos
	if(permitidos.indexOf(caracter) != -1 || tecla_especial){
	  
		if(codigoCaracter == 13){

			//detener la accion 
			event.preventDefault();
			//ejecutar funcion
			if(nombreFuncion != null){
				eval(nombreFuncion);
			}			
		  
		}else{
		  
			//escribir caracter
			return true;
		  
		}
	  
	}else{

		//detener la accion 
		event.preventDefault();

	}

}


/**
 * funcion que limpia controles de un div especifico
 * @param idContenedor
 */
function fnLimpiarControles(idContenedor){
	
	// leer todas las etiquetas input del formulario   
	$("#" + idContenedor + ", #" + idContenedor + "Doc").find("input").each(function() { 
		switch(this.type) {         
			case 'password': 
			case 'text': 
			case 'hidden': 
				$(this).val('');
				break;
			case 'checkbox':
			case 'radio':
				this.checked = false;
			}
		});
	
	// leer todas las etiquetas select del formulario  
	$('#'+idContenedor+'').find('select').each(function() {       
		$("#" + this.id + " option[value=00]").prop("selected", true);
	});
	
	// leer todas las etiquetas textarea del formulario   
	$('#'+idContenedor+'').find('textarea').each(function(){    
		$(this).val('');   
	});
	
}

/**
 * Funcion que permite limpiar los controles de un contenedor
 * @param idContenedor
 * @param idElementExcept
 */
function fnLimpiarControlesExcept(idContenedor, idElementExcept){
	
	// leer todas las etiquetas input de un contenedor   
	$("#" + idContenedor).find("input").each(function() { 
		switch(this.type) {         
			case "password": 
			case "text": 
			case "hidden": 
				if(this.id != idElementExcept){
					$(this).val("");
				}
				break;
			case "checkbox":
			case "radio":
				if(this.id != idElementExcept){
					this.checked = false;
				}
		}
	});
	
	// leer todas las etiquetas select de un contenedor
	$("#" + idContenedor).find("select").each(function(){
		if(this.id != idElementExcept){
			$("#" + this.id + " option[value=00]").prop("selected", true);
		}
	});
	
	// leer todas las etiquetas textarea de un contenedor   
	$("#" + idContenedor).find("textarea").each(function(){
		if(this.id != idElementExcept){
			$(this).val("");
		}
	});
	
}

/***
 * Funcion que valida la pulsacion del enter
 * 
 * @param e
 * @returns {Boolean}
 */


/*function fnCheckEnter(e){ //e is event object passed from function invocation
    var characterCode  //literal character code will be stored in this variable
    
    if(e && e.which){ //if which property of event object is supported (NN4)
    e = e
    characterCode = e.which //character code is contained in NN4's which property
    }
    else{
    e = event
    characterCode = e.keyCode //character code is contained in IE's keyCode property
    }
    
    if(characterCode == 13){ //if generated character code is equal to ascii 13 (if enter key)
        return true
    }
    else{
        return false
    }
}*/
