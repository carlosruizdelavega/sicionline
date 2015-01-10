package pe.gob.essalud.sicionline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.essalud.sicionline.bean.CitaBean;
import pe.gob.essalud.sicionline.dao.CitaMedicaDao;
import pe.gob.essalud.sicionline.service.CitaMedicaService;

@Service
public class CitaMedicaServiceImpl implements CitaMedicaService {
	
	@Autowired
	private CitaMedicaDao citaMedicaDao;
	
	/**
	 * Metodo que permite registrar cita medica
	 */
	public String registrarCitaMedica(CitaBean citaBean) {
		
		return citaMedicaDao.registrarCitaMedica(citaBean);

	}

}
