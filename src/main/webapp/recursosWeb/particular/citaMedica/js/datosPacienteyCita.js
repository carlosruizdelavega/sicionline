/**
 * Funcion que permite ejecutar las operaciones especificadas, cuando se ha cargado completamente el DOM
 */
$(document).ready(function(){

	//manejador de evento para el clic derecho (contextmenu)
	$(document).on('contextmenu',function(e){
	    //evitamos que aparezca el menu predeterminado del navegador
	    e.preventDefault();
	});
	
	//ini: definir componente fecha		
	//-- definir variables globales
	var monthNamesShort = [ "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic" ];
	var dayNames = [ "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" ];
	var dayNamesMin = [ "Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab" ];		
	//-- configurar componente de fecha y hora		
	$("#txtFehoCelebracion").datepicker({
	      changeMonth: true,
	      changeYear: true,
	      monthNamesShort: monthNamesShort, 
	      dayNames: dayNames, 
	      dayNamesMin: dayNamesMin,	
	      dateFormat: "dd/mm/yy",
	     //timeFormat: "HH:mm",
	      //timeText: "Tiempo",
		 //hourText: "Hora",
		  //minuteText: "Minuto",
		  //currentText: 'Ahora',
		  //closeText: 'Aceptar' 
	    });
	
	$("#txtFeNacimiento").datepicker({
	      changeMonth: true,
	      changeYear: true,
	      monthNamesShort: monthNamesShort, 
	      dayNames: dayNames, 
	      dayNamesMin: dayNamesMin,	
	      dateFormat: "dd/mm/yy",
	     //timeFormat: "HH:mm",
	      //timeText: "Tiempo",
		 //hourText: "Hora",
		  //minuteText: "Minuto",
		  //currentText: 'Ahora',
		  //closeText: 'Aceptar' 
	    });
	
	//fin: definir componente fecha

});