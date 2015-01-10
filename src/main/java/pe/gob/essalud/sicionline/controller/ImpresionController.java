package pe.gob.essalud.sicionline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.essalud.sicionline.bean.AseguradoBean;
import pe.gob.essalud.sicionline.bean.CitaBean;
import pe.gob.essalud.sicionline.service.CitaMedicaService;
import pe.gob.essalud.sicionline.util.Utiles;

@Controller
public class ImpresionController {

	@Autowired
	private CitaMedicaService citaMedicaService;
	
	/**
	 * Metodo que permite limpiar los datos de sesion de la cita medica
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/limpiarDatosCitaMedica.htm")
	public @ResponseBody String limpiarDatosCitaMedica(HttpServletRequest request, 
											   			 HttpServletResponse response,
											   			 HttpSession session) throws Exception{

		//define variable de respuesta
		String resp = "01";
		
		//limpiar datos del Acta de Celebracion
		session.setAttribute("aseguradoBean", null);
		session.setAttribute("citaBean", null);
		
		//retornar respuesta
		return resp;
		
	}	
	
	/**
	 * Metodo que permite registrar cita medica
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/registrarCitaMedica.htm")
	public @ResponseBody String registrarCitaMedica(HttpServletRequest request, 
											   			HttpServletResponse response,
											   			HttpSession session) throws Exception{
		
		CitaBean citaBean = (CitaBean) session.getAttribute("citaBean");

				
		//guardar acta de celebracion
		String resp = citaMedicaService.registrarCitaMedica(citaBean);
	
		//retornar respuesta
		return resp.trim();
		
	}
	

	
	/**
	 * Metodo que permite generar vista previa
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cargarTabVistaPrevia.htm")
	public ModelAndView cargarTabVistaPrevia(HttpServletRequest request, 
										   			  HttpServletResponse response,
										   			  HttpSession session) throws Exception {
		
		AseguradoBean aseguradoBean = (AseguradoBean) session.getAttribute("aseguradoBean");
		CitaBean citaBean = (CitaBean) session.getAttribute("citaBean");	
		
		
		//definir ModelAndView
		ModelAndView mv = new ModelAndView("citaMedica/datosVistaPrevia");
		
		//setear atributos de la vista
		mv.addObject("aseguradoBean", aseguradoBean);
		mv.addObject("citaBean", citaBean);
		
		//
		mv.addObject("deFechaCita", Utiles.getFechaLarga(citaBean.getFecha()));	
		
		//retornar ModelAndView
		return mv;
		
	}	

	

	
	/**
	 * Metodo que permite generar constancia de la cita en PDF
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/actaCelebracionPreview.pdf")
	public ModelAndView generarPDFCita(HttpServletRequest req, 
										   HttpServletResponse res,
										   HttpSession session) throws Exception {
		
		AseguradoBean aseguradoBean = (AseguradoBean) session.getAttribute("aseguradoBean");
		CitaBean citaBean = (CitaBean) session.getAttribute("citaBean");
		
		// retorna objeto ModelAndView
		ModelAndView mv = new ModelAndView("impresionView");
		mv.addObject("aseguradoBean", aseguradoBean);
		mv.addObject("citaBean", citaBean);
		
		//retornar ModelAndView
		return mv;
		
	}	
	
}
