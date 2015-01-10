package pe.gob.essalud.sicionline.dao.impl;


import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.gob.essalud.sicionline.bean.CitaBean;
import pe.gob.essalud.sicionline.dao.CitaMedicaDao;
 
@Repository
public class CitaMedicaDaoImpl implements CitaMedicaDao {

	// define log
	private static final Logger log = Logger.getLogger(CitaMedicaDaoImpl.class);
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	/**
	 * Metodo que permite registrar cita medica
	 **/
	public String registrarCitaMedica(CitaBean citaBean) {
		
//		//definir objeto a retornar
//		String dato = "0";
//
//		try {
//
//			// definir query
//			String sql = "INSERT INTO CITA\r\n" + 
//					"  (IDCITA,\r\n" + 
//					"   IDPROGRAMACION,\r\n" + 
//					"   ASEGURADO_DNI,\r\n" + 
//					"   IDHORARIOS,\r\n" + 
//					"   ESTADO,\r\n" + 
//					"   IDUSER_CREA,\r\n" + 
//					"   F_CREATE)\r\n" + 
//					"VALUES\r\n" + 
//					"  (SEC_CITA.NEXTVAL, 89, ?, 1, 1, '44380447', SYSDATE)";
//
//			// ejecutar query
//			int val = jdbcTemplate.update(sql, citaBean.getDniAsegurado());
//			log.info(val);
//
//			// verificar respuesta
//			if (val > 0) {
//				dato = "1";
//			}
//
//		} catch (Exception e) {
//			log.error("registrarCitaMedica: " + e);
//
//		}
		
		// retornar objeto
		return "1";
		
	}

	
}
