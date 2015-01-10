package pe.gob.essalud.sicionline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.essalud.sicionline.bean.ResultadoBean;
import pe.gob.essalud.sicionline.bean.UsuarioBean;

@Controller
public class UsuarioController {

	private static final Logger log = Logger.getLogger(UsuarioController.class);

	@Autowired
	ResultadoBean resultadoBean;

	/**
	 * Metodo que devuelve el contenedor o pagina principal, en donde se cargaran 
	 * todas las paginas via ajax 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/contenedor.htm")
    public ModelAndView mostrarContenedor(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ModelAndView mv = new ModelAndView("contenedor/contenedor");
        return mv;
    }
	
	/**
	 * Metodo que devuelve la pagina correspondiente al menu principal
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/menuPrincipal.htm")
    public ModelAndView mostrarInicioSis(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ModelAndView mv = new ModelAndView("menuPrincipal/menuPrincipal");
        return mv;
    }
	
	/**
	 * Metodo que permite cargar pagina de logeo de usuarios
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login.htm")
    public ModelAndView mostrarLogin(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ModelAndView mv = new ModelAndView("login/login");
        return mv;
    }
	
	/**
	 * Metodo que permite obtener acceso al sistema
	 * @param req
	 * @param res
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/obtenerAccesoSistema.htm", method = RequestMethod.POST)
    public @ResponseBody
    ResultadoBean obtenerAccesoSistema(HttpServletRequest req, HttpServletResponse res, HttpSession session) {
		
            String coUsuario = req.getParameter("coUsuario") == null ? "" : req.getParameter("coUsuario");
            String coPassw = req.getParameter("paUsuario") == null ? "" : req.getParameter("paUsuario");
                        
            if(coUsuario.equalsIgnoreCase(coPassw)) {
            	session.setAttribute("coUsuario", coUsuario);
    			session.setAttribute("datUsuario",coUsuario); 
    			resultadoBean.setCoStatus("00");
    			log.info("Login Success");
            }else{
    			resultadoBean.setCoStatus("01");
    			resultadoBean.setDeStatus("El usuario no se encuentra registrado");
    			log.info("Login Failure");
            }

            return resultadoBean;

    }
	
	/**
	 * Metodo que permite cerrar sesion del sistema
	 * @param req
	 * @param res
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/cerrarSesion.htm", method = RequestMethod.POST)
	public @ResponseBody
    String cerrarSesion(HttpServletRequest req, HttpServletResponse res, HttpSession session) {
		log.info("Ingresa a metodo cerrarSesion");
		
		String usuario = (String) session.getAttribute("coUsuario") == null ? "" : (String) session.getAttribute("coUsuario");
		String mensaje = "";
		
		if (usuario.equals("")) {
			mensaje = "Su sesion ha expirado. Por favor cierre el navegador e ingrese nuevamente.";
		}else{
			UsuarioBean usuarioBean = new UsuarioBean();
			usuarioBean.setNuDni(usuario);
			usuarioBean.setIpUsuario(req.getRemoteAddr());
			usuarioBean.setTiIdentificacion(0);
						
			mensaje = "OK";
		}
		return mensaje;
	}

}
