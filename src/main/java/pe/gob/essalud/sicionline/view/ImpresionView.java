package pe.gob.essalud.sicionline.view;

import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import pe.gob.essalud.sicionline.bean.AseguradoBean;
import pe.gob.essalud.sicionline.bean.CitaBean;
import pe.gob.essalud.sicionline.util.PdfDocumentEventAlt;
import pe.gob.essalud.sicionline.util.PdfUtil;

//import com.barcode.rbarcode.Bc;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ImpresionView extends AbstractPdfView  {
 
	// definir log
	private static final Logger log = Logger.getLogger(ImpresionView.class);
	
	// definir invocaciones globales
	PdfUtil pdfUtil = new PdfUtil();
	PdfDocumentEventAlt pdfDocEvent = new PdfDocumentEventAlt();

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
									Document document, 
									PdfWriter writer, 
									HttpServletRequest request,
									HttpServletResponse response) throws Exception { 

		//configurar codificacion de caracteres
		response.setContentType("text/html;charset=ISO-8859-1");
		
		// recibir datos
		AseguradoBean aseguradoBean  = (AseguradoBean) model.get("aseguradoBean");
		CitaBean citaBean  = (CitaBean) model.get("citaBean");
		
		// capturar eventos de generacion del documento
		writer.setPageEvent(pdfDocEvent);
		
		// definir propiedades del papel
		//document.setPageSize(PageSize.A4.rotate());
		
		// crear nueva hoja
		document.newPage();
		
		// crear contenido de la cabecera del documento
		setPdfHeader(document, citaBean);

		// crear contenido del cuerpo del documento
		setPdfBody(document, aseguradoBean, citaBean);
		
		// crear contenido del pie del documento
		setPdfFooter(document);
		
	}

	/**
	 * Metodo que permite crear el contenido de la cabecera del documento
	 * 
	 * @param document
	 */
	public void setPdfHeader(Document document, CitaBean citaBean) {

		try {

			// definir logo reniec
			URL urlLogoReniec = getClass().getResource("/images/logoessalud.png");
			Image logoReniec = Image.getInstance(urlLogoReniec);
			
			// definir codigo de barras
			String codigo = "0000011111";
			logger.info("codigo del numero de barras:"+codigo);
			
			//Image codeBarras = Image.getInstance((new Bc(codigo)).getImage());
			
			URL urlCodeBarras = getClass().getResource("/images/barCode.jpg");
			Image codeBarras = Image.getInstance(urlCodeBarras);

			// crear tabla
			PdfPTable tab = PdfUtil.creaTabla(9, PdfCell.NO_BORDER, 100, new float[]{20f, 20f, 20f, 21f, 18f, 21f, 20f, 20f, 20f}, PdfCell.ALIGN_CENTER);
			
			//definir tablas internas
			//------------------------------------------------------------------------------------
			// tabla 01
			PdfPTable tab1 = PdfUtil.creaTabla(1, PdfCell.NO_BORDER, 100, new float[]{100f}, PdfCell.ALIGN_CENTER);
			PdfUtil.creaCell(tab1, "", PdfUtil.FONT1_B_14, PdfUtil.NON_BORDER, PdfCell.ALIGN_LEFT, PdfCell.ALIGN_BASELINE, PdfUtil.HEIGHT_20, PdfUtil.BLANCO, 1, 1);

			// tabla 02
			PdfPTable tab2 = PdfUtil.creaTabla(1, PdfCell.NO_BORDER, 100, new float[]{100f}, PdfCell.ALIGN_CENTER);
			PdfUtil.creaCell(tab2, logoReniec, PdfUtil.NON_BORDER, PdfCell.ALIGN_LEFT, PdfCell.ALIGN_BASELINE, PdfUtil.HEIGHT_20, PdfUtil.BLANCO, 1, 1);
			
			// tabla 03
			PdfPTable tab3 = PdfUtil.creaTabla(1, PdfCell.NO_BORDER, 100, new float[]{100f}, PdfCell.ALIGN_CENTER);
			PdfUtil.creaCell(tab3, "CONSTANCIA DE CITA", PdfUtil.FONT1_B_11, PdfUtil.NON_BORDER, PdfCell.ALIGN_CENTER, PdfCell.ALIGN_MIDDLE, PdfUtil.HEIGHT_20, PdfUtil.BLANCO, 1, 1);
			
			// tabla 04
			PdfPTable tab4 = PdfUtil.creaTabla(3, PdfCell.NO_BORDER, 100, new float[]{13f, 70f, 37f}, PdfCell.ALIGN_CENTER);
			PdfUtil.creaCell(tab4, "", PdfUtil.FONT1_B_11, PdfUtil.NON_BORDER, PdfCell.ALIGN_LEFT, PdfCell.ALIGN_BASELINE, PdfUtil.HEIGHT_8, PdfUtil.BLANCO, 3, 1);
			PdfUtil.creaCell(tab4, "", PdfUtil.FONT1_B_11, PdfUtil.NON_BORDER, PdfCell.ALIGN_LEFT, PdfCell.ALIGN_BASELINE, PdfUtil.HEIGHT_20, PdfUtil.BLANCO, 1, 1);
			PdfUtil.creaCell(tab4, codeBarras, PdfUtil.NON_BORDER, PdfCell.ALIGN_LEFT, PdfCell.ALIGN_BASELINE, PdfUtil.HEIGHT_20, PdfUtil.BLANCO, 1, 1);
			PdfUtil.creaCell(tab4, "", PdfUtil.FONT1_B_11, PdfUtil.NON_BORDER, PdfCell.ALIGN_LEFT, PdfCell.ALIGN_BASELINE, PdfUtil.HEIGHT_20, PdfUtil.BLANCO, 1, 1);
			
			//cargar tablas internas
			//------------------------------------------------------------------------------------
			// definir 1ra fila
			PdfUtil.creaCell(tab, tab4, PdfUtil.NON_BORDER, PdfCell.ALIGN_LEFT, PdfCell.ALIGN_BASELINE, PdfUtil.HEIGHT_20, PdfUtil.BLANCO, 4, 1);
			PdfUtil.creaCell(tab, tab2, PdfUtil.NON_BORDER, PdfCell.ALIGN_LEFT, PdfCell.ALIGN_BASELINE, PdfUtil.HEIGHT_55, PdfUtil.BLANCO, 1, 1);
			PdfUtil.creaCell(tab, tab1, PdfUtil.NON_BORDER, PdfCell.ALIGN_LEFT, PdfCell.ALIGN_BASELINE, PdfUtil.HEIGHT_20, PdfUtil.BLANCO, 4, 1);
			
			// definir 2da fila
			PdfUtil.creaCell(tab, tab3, PdfUtil.NON_BORDER, PdfCell.ALIGN_LEFT, PdfCell.ALIGN_BASELINE, PdfUtil.HEIGHT_20, PdfUtil.BLANCO, 9, 1);
			
			// agregar tabla al documento
			document.add(tab);

		} catch (Exception e) {

			// mostrar mensaje de error
			log.error("setPdfHeader: " + e);

		}

	}

	/**
	 * Metodo que permite crear el contenido del cuerpo del documento
	 * 
	 * @param document
	 * @param muestras
	 */
	public void setPdfBody(Document document, 
			AseguradoBean aseguradoBean, 
			CitaBean citaBean) {

		try {
			
			// tabla de espacio
			//------------------------------------------------------------------------------------
			PdfPTable tab0 = PdfUtil.creaTabla(1, PdfCell.NO_BORDER, 100, new float[]{240f}, PdfCell.ALIGN_CENTER);
			PdfUtil.creaCell(tab0, "", PdfUtil.FONT1_B_7, PdfUtil.NON_BORDER, PdfCell.ALIGN_LEFT, PdfCell.ALIGN_BASELINE, PdfUtil.HEIGHT_14, PdfUtil.BLANCO, 1, 1);
			document.add(tab0);
			
			// tabla 01
			//------------------------------------------------------------------------------------
			PdfPTable tab = PdfUtil.creaTabla(2, PdfCell.NO_BORDER, 100, new float[]{40f, 40f}, PdfCell.ALIGN_CENTER);
		
	        // cabecera
	        String[][] datosRow00 = {
	        						{"Datos", "1", "1", PdfUtil.GRAY3, PdfCell.ALIGN_CENTER + ""}, 
	        						{"Detalle", "1", "1", PdfUtil.GRAY3, PdfCell.ALIGN_CENTER + ""}
	        					};
			PdfUtil.creaRow(tab, datosRow00, PdfUtil.BORDER_F, PdfUtil.FONT1_B_11, PdfUtil.HEIGHT_18);
			
        	// documento de identidad
	        String[][] datosRow01 = {
		        						{"Documento de Identidad", "1", "1", PdfUtil.BLANCO, PdfCell.ALIGN_LEFT + ""}, 
		        						{aseguradoBean.getAseguradoDni(), "1", "1", PdfUtil.BLANCO, PdfCell.ALIGN_LEFT + ""}
		        					};
	        PdfUtil.creaRow(tab, datosRow01, PdfUtil.BORDER_F, PdfUtil.FONT1_N_11, PdfUtil.HEIGHT_18);
	        
        	// primer apellido
	        String[][] datosRow02 = {
		        						{"Apellidos y Nombres", "1", "1", PdfUtil.BLANCO, PdfCell.ALIGN_LEFT + ""}, 
		        						{aseguradoBean.getAseguradoNombres(), "1", "1", PdfUtil.BLANCO, PdfCell.ALIGN_LEFT + ""}
		        					};
	        PdfUtil.creaRow(tab, datosRow02, PdfUtil.BORDER_F, PdfUtil.FONT1_N_11, PdfUtil.HEIGHT_18);

        	// segundo apellido
	        String[][] datosRow03 = {
		        						{"Centro Asistencial", "1", "1", PdfUtil.BLANCO, PdfCell.ALIGN_LEFT + ""}, 
		        						{citaBean.getCentroAsistencial(), "1", "1", PdfUtil.BLANCO, PdfCell.ALIGN_LEFT + ""}
		        					};
	        PdfUtil.creaRow(tab, datosRow03, PdfUtil.BORDER_F, PdfUtil.FONT1_N_11, PdfUtil.HEIGHT_18);
	        
        	// pre nombres
	        String[][] datosRow04 = {
		        						{"Especialidad", "1", "1", PdfUtil.BLANCO, PdfCell.ALIGN_LEFT + ""}, 
		        						{citaBean.getEspecialidad(), "1", "1", PdfUtil.BLANCO, PdfCell.ALIGN_LEFT + ""}
		        					};
	        PdfUtil.creaRow(tab, datosRow04, PdfUtil.BORDER_F, PdfUtil.FONT1_N_11, PdfUtil.HEIGHT_18);
	        
        	// estado civil
	        String[][] datosRow05 = {
		        						{"Fecha de la cita", "1", "1", PdfUtil.BLANCO, PdfCell.ALIGN_LEFT + ""}, 
		        						{citaBean.getFecha(), "1", "1", PdfUtil.BLANCO, PdfCell.ALIGN_LEFT + ""}
		        					};
	        PdfUtil.creaRow(tab, datosRow05, PdfUtil.BORDER_F, PdfUtil.FONT1_N_11, PdfUtil.HEIGHT_18);
	        
        	// edad
	        String[][] datosRow06 = {
		        						{"Turno", "1", "1", PdfUtil.BLANCO, PdfCell.ALIGN_LEFT + ""}, 
		        						{citaBean.getTurno(), "1", "1", PdfUtil.BLANCO, PdfCell.ALIGN_LEFT + ""}
		        					};
	        PdfUtil.creaRow(tab, datosRow06, PdfUtil.BORDER_F, PdfUtil.FONT1_N_11, PdfUtil.HEIGHT_18);
	        
	        // carga tabla a documento
	        PdfPTable tabTotal = PdfUtil.creaTabla(2, PdfCell.NO_BORDER, 100, new float[]{6f, 108f}, PdfCell.ALIGN_CENTER);
	        PdfUtil.creaCell(tabTotal, "", PdfUtil.FONT1_N_7, PdfUtil.NON_BORDER, PdfCell.ALIGN_LEFT, PdfCell.ALIGN_BASELINE, PdfUtil.HEIGHT_14, PdfUtil.BLANCO, 1, 1);
	        PdfUtil.creaCell(tabTotal, tab, PdfUtil.NON_BORDER, PdfCell.ALIGN_LEFT, PdfCell.ALIGN_BASELINE, PdfUtil.HEIGHT_14, PdfUtil.BLANCO, 1, 1);
	        PdfUtil.creaCell(tabTotal, "", PdfUtil.FONT1_N_7, PdfUtil.NON_BORDER, PdfCell.ALIGN_LEFT, PdfCell.ALIGN_BASELINE, PdfUtil.HEIGHT_14, PdfUtil.BLANCO, 1, 1);
	        document.add(tabTotal);
			//------------------------------------------------------------------------------------

		} catch (Exception e) {
			
			// mostrar mensaje de error
			log.error("setPdfBodyRn: " + e);
			
		}

	}		

	
	/**
	 * Metodo que permite crear contenido del pie del documento
	 * @param document
	 * @param muestras
	 */
	private void setPdfFooter(Document document) {

/*		try {
			
			
		} catch (Exception e) {

			// mostrar mensaje de error
			log.error("setPdfHeader: " + e);

		}*/
		
	}	
	
}
