package pe.gob.essalud.sicionline.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pe.gob.essalud.sicionline.bean.AseguradoBean;
import pe.gob.essalud.sicionline.bean.CitaBean;
import pe.gob.essalud.sicionline.bean.TipoDocIdentidadBean;
import pe.gob.essalud.sicionline.util.Utiles;

 
@Controller
public class CitaController {
	
	/**
	 * Metodo que permite guardar tab de datos del paciente y la cita
	 * @param request
	 * @param response
	 * @param session 
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("/guardarTabCitaMedica.htm")
	public @ResponseBody Boolean guardarTabCitaMedica(HttpServletRequest request, 
										   	   			HttpServletResponse response, 
										   	   			HttpSession session) throws Exception {
		
		//definir indicador
		Boolean indSave = false;
		
		//obtener datos de los controles
		//------------------------------
		//paciente
		String cboTipoDocumento01 = request.getParameter("cboTipoDocumento01");
		String txtNroDocumento01 = request.getParameter("txtNroDocumento01");
		String txtFeNacimiento = request.getParameter("txtFeNacimiento");
		String txtApPrimer01 = Utiles.convertirMayusc(request.getParameter("txtApPrimer01"));
		String txtApSegundo01 = Utiles.convertirMayusc(request.getParameter("txtApSegundo01"));
		String txtPreNomInscrito01 = Utiles.convertirMayusc(request.getParameter("txtPreNomInscrito01"));
		String cboListaTipoSexo01 = request.getParameter("cboListaTipoSexo01");
		String txtDeDomicilio01 = Utiles.convertirMayusc(request.getParameter("txtDeDomicilio01"));
		String txtDeTlfCasa01 = request.getParameter("txtDeTlfCasa01");
		String txtDeTlfOpcional01 = request.getParameter("txtDeTlfOpcional01");
		String txtCorreoElect01 = request.getParameter("txtCorreoElect01");
		
		//cita
		String cboListaDepa02 = request.getParameter("cboListaDepa02");
		String cboListaCentAsis02 = request.getParameter("cboListaCentAsis02");
		String cboListaEspec02 = request.getParameter("cboListaEspec02");
		String txtFehoCelebracion = request.getParameter("txtFehoCelebracion");
		String cboListaTurno02 = request.getParameter("cboListaTurno02");
		String txaDesMalestar = Utiles.convertirMayusc(request.getParameter("txaDesMalestar"));
		
		//obtener beans de sesion
		AseguradoBean aseguradoBean = (AseguradoBean) session.getAttribute("aseguradoBean");
		CitaBean citaBean = (CitaBean) session.getAttribute("citaBean");

		//actualizar paciente
		if(aseguradoBean == null){
			aseguradoBean = new AseguradoBean();
		}
		
		aseguradoBean.setTiDocumento(cboTipoDocumento01);
		aseguradoBean.setAseguradoDni(txtNroDocumento01);
		aseguradoBean.setAseguradoNombres(txtApPrimer01 + " " + txtApSegundo01 + " " +txtPreNomInscrito01);
		aseguradoBean.setFeNaci(txtFeNacimiento);
		aseguradoBean.setSexo(cboListaTipoSexo01);
		aseguradoBean.setDomicilio(txtDeDomicilio01);
		aseguradoBean.setTelCasa(txtDeTlfCasa01);
		aseguradoBean.setTelOpcional(txtDeTlfOpcional01);
		aseguradoBean.setCorreoElectronico(txtCorreoElect01);
		
		//actualizar cita
		if(citaBean == null){
			citaBean = new CitaBean();
		}
		
		citaBean.setDniAsegurado(txtNroDocumento01);
		citaBean.setDepartamento(cboListaDepa02);
		citaBean.setCentroAsistencial(cboListaCentAsis02);
		citaBean.setEspecialidad(cboListaEspec02);
		citaBean.setFecha(txtFehoCelebracion);
		citaBean.setTurno(cboListaTurno02);
		citaBean.setMalestar(txaDesMalestar);
		
		
			
		//verificar actualizacion de beans
		if(citaBean != null && aseguradoBean !=null){
			
			//asignar valor a indicador
			indSave = true;
			
			//cargar en sesion objetos consultados
			session.setAttribute("aseguradoBean", aseguradoBean);
			session.setAttribute("citaBean", citaBean);
		}
		
		//retornar ModelAndView
		return indSave;

	}
	
	/**
	 * Metodo que permite devolver la pagina inicial de registro de cita medica
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("/cargarRegistroCita.htm")
	public ModelAndView cargarRegistroCita(HttpServletRequest request, 
										   HttpServletResponse response, 
										   HttpSession session) throws Exception {
		
		//definir ModelAndView
		ModelAndView mav = new ModelAndView("citaMedica/inicioCitaMedica");
		
		//retornar ModelAndView
		return mav;

	}
	
	
	/**
	 * Metodo que devuelve la pagina correspondiente al tab de datos del paciente y la cita
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/cargarTabPacienteyCita.htm")
    public ModelAndView cargarTabPacienteyCita(HttpServletRequest request, 
    										 HttpServletResponse response,
    										 HttpSession session) throws Exception {
		
		//obtener objetos de sesion
		List<TipoDocIdentidadBean> listaTipoDocIdentidad = (List<TipoDocIdentidadBean>) session.getAttribute("listaTipoDocIdentidad");
		
		//definir ModelAndView
		ModelAndView mav = new ModelAndView("citaMedica/datosPacienteyCita");
		
		//setear atributos de la vista
		mav.addObject("listaTipoDocIdentidad", listaTipoDocIdentidad);
		
		//retornar ModelAndView
		return mav;

	}	

	
}
