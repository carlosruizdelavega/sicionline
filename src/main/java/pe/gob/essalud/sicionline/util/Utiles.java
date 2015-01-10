package pe.gob.essalud.sicionline.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pe.gob.essalud.sicionline.bean.TipoDocIdentidadBean;
  
public class Utiles {

	/**
	 * Metodo que permite separar en lineas un parrafo
	 * @param texto
	 * @return
	 */
	public static List<String> separarLineasParrafo(String texto, int anchoLinea) {

		List<String> lines = new ArrayList<String>();
		if (texto.length() > anchoLinea) {

			while (texto.length() > 0) {

				if (texto.length() > anchoLinea) {

					if (texto.substring(0, anchoLinea).charAt(anchoLinea - 1) == ' ') {

						lines.add(texto.substring(0, anchoLinea));
						texto = texto.substring(anchoLinea);

					} else {

						int last = texto.substring(0, anchoLinea).lastIndexOf(
								' ');
						lines.add(texto.substring(0, last));
						texto = texto.substring(last + 1);

					}

				} else {

					lines.add(texto);
					texto = "";

				}

			}

		} else {

			lines.add(texto);

		}

		return lines;

	}
	
	/**
	 * Metodo que permite formatear una fecha de YYYYMMDD a formato largo
	 * @param fecha
	 * @return
	 */
	public static String getFechaLarga(String fecha){
		
		String fechaConvertida = null;
		
		try{

			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			Date date = formatter.parse(fecha);
			Calendar cal= Calendar.getInstance();
		    cal.setTime(date);
			int diaSemana = cal.get(Calendar.DAY_OF_WEEK) - 1;
			
			String[] meses = {"enero", 
							  "febrero", 
							  "marzo", 
							  "abril", 
							  "mayo", 
							  "junio", 
							  "julio", 
							  "agosto", 
							  "setiembre", 
							  "octubre", 
							  "noviembre", 
							  "diciembre"};

			String[] dias = {"domingo", 
							 "lunes", 
							 "martes", 
							 "miercoles", 
							 "jueves", 
							 "viernes", 
							 "sabado"};
			
			String anio = fecha.substring(0, 4);
			String mes = fecha.substring(4, 6);
			String dia = fecha.substring(6, 8);
			fechaConvertida = dias[diaSemana] + " " + dia + " de " + meses[Integer.parseInt(mes)-1] + " del " + anio;
			fechaConvertida = fechaConvertida.toUpperCase();
			
		}catch(Exception ex){
			
			fechaConvertida = null;
			
		}

		return fechaConvertida;
		
	}
	
	/**
	 * Metodo que permite formatear una hora de HH24MMSS a formato de hora largo con AM y PM
	 * @param hora
	 * @return
	 */
	public static String getHoraLarga(String hora){
		
		String horaConvertida = null;
		
		try{

			//recibir hora
			SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
			Date date = formatter.parse(hora);
			
			//dar formato a hora
			formatter = new SimpleDateFormat("hh:mm a");
			horaConvertida = formatter.format(date);

		}catch(Exception ex){
			
			horaConvertida = null;
			
		}

		return horaConvertida;
		
	}
	
	/**
	 * Metodo que devuelve una cadena vacia en caso su valor sea nulo
	 * @param cadena
	 */
	public static String omitirNull(String cadena){
		if(cadena != null){
			return cadena;
		}else{
			return "";
		}
	}
	
	/**
	 * Metodo que permite obtener de una fecha larga, lo correspondiente al formato YYYYMMDD 
	 * @param fechaCompleta
	 * @return
	 */
	public static String obtenerParteFecha(String fechaCompleta){
		String dia = fechaCompleta.substring(0, 2);
		String mes = fechaCompleta.substring(3, 5);
		String anio = fechaCompleta.substring(6, 10);
		return anio + mes + dia;
	}
	
	/**
	 * Metodo que permite obtener de una fecha larga, lo correspondiente al formato HHMMSS 
	 * @param fechaCompleta
	 * @return
	 */
	public static String obtenerParteHora(String fechaCompleta){
		String hrs = fechaCompleta.substring(11, 13);
		String min = fechaCompleta.substring(14, 16);
		return hrs + min + "00";
	}
	/**
	 * Metodo que permite obtener de una fecha larga, lo correspondiente al formato HHMMSS 
	 * @param fechaCompleta
	 * @return
	 */
	public static String obtenerParteHoras(String fechaCompleta){
		String hrs = fechaCompleta.substring(11, 13);
		String min = fechaCompleta.substring(14, 16);
		return hrs + min + "00";
	}
	
	/**
	 * Metodo que permite formatear una fecha en formato YYYYMMDD al formato DD/MM/YYYY 
	 * @param fecha
	 * @return
	 */
	public static String formatearFecha(String fecha){
		String anio = fecha.substring(0, 4);
		String mes = fecha.substring(4, 6);
		String dia = fecha.substring(6, 8);
		return dia + "/" + mes + "/" + anio;
	}
	
	/**
	 * Metodo que permite formatear una hora en formato HHMMSS al formato HH:MM 
	 * @param hora
	 * @return
	 */
	public static String formatearHora(String hora){
		String hrs = hora.substring(0, 2);
		String min = hora.substring(2, 4);
		return hrs + ":" + min;
	}
	
	/**
	 * Metodo que permite formatear una hora en formato HH:MM al formato HH y MM 
	 * @param hora
	 * @return
	 */
	
	public static String soloHora(String hora){
		String hrs = hora.substring(0, 2);
		//String min = hora.substring(2, 4);
		return hrs;
	}
	
	public static String soloMinutos(String hora){
		//String hrs = hora.substring(0, 2);
		String min = hora.substring(2, 4);
		return min;
	}
	
	
	
	/**
	 * Metodo que permite convertir texto a MAYUSCULAS. Adicionalmente limpia espacios vacios iniciales y finales. 
	 * @param texto
	 * @return
	 */
	public static String convertirMayusc(String texto){
		
		//si texto es diferente de null
		if(texto != null){
			
			//si texto es diferente de vacio
			if(!texto.equals("")){
				
				//limpiar espacios e blanco
				texto = texto.trim();
				
				//convertir texto en altas
				texto = texto.toUpperCase();
				
			}
			
		}
		
		//retornar texto convertido
		return texto;

	}
	
	/**
	 * Metodo que permite consultar de una coleccion, la descripcion del tipo de documento
	 * @param listTipoDocumento
	 * @param coTipoDocumento
	 * @return
	 */
	public static String consultarTipoDocumento(List<TipoDocIdentidadBean> listTipoDocumento, 
												String coTipoDocumento){
		
		//definir cadena de retorno
		String deTipoDocumento = "";
		
		//recorrer lista de tipos de documentos
		for (int i = 0; i < listTipoDocumento.size(); i++) {
			
			TipoDocIdentidadBean tipoDocIdentidadBean = listTipoDocumento.get(i);
			if(tipoDocIdentidadBean.getCoTipoDocIdentidad().equals(coTipoDocumento)){
				deTipoDocumento = tipoDocIdentidadBean.getDeDocIdentidad();
			}
			
		}
		
		//retornar cadena de retorno
		return deTipoDocumento;
		
	}
	
	
	
	/**
	 * Metodo main
	 * @param args
	 */
	public static void main(String args[]){
		
		String fecha = formatearFecha("20140819");
		System.out.println("fecha: " + fecha);
		
		String hora = formatearHora("123015");
		System.out.println("hora: " + hora);
		
	}
	
}
