package pe.gob.essalud.sicionline.util;

import org.apache.log4j.Logger;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
 
/**
 * Clase interna que captura los eventos generados en la creacion del documento
 * 
 * @author csantos
 * 
 */
public class PdfDocumentEventAlt  extends PdfPageEventHelper {
 
	// define log
	@SuppressWarnings("unused")
	private static final Logger log =  Logger.getLogger(PdfDocumentEventAlt.class);

	/**
	 * Metodo que se ejecuta cuando se abre el documento
	 */
	public void onOpenDocument(PdfWriter writer, Document document) {
		// implementation
	}

	/**
	 * Metodo que se ejecuta cuando llegamos al final de una pagina
	 */
	public void onStartPage(PdfWriter writer, Document document) {

	}

	/**
	 * Metodo que se ejecuta cuando llegamos al final de una pagina
	 */
	public void onEndPage(PdfWriter writer, Document document) {
		// implementation
	}

	/**
	 * Metodo que se ejecuta cuando se cierra el documento
	 */
	public void onCloseDocument(PdfWriter writer, Document document) {
		// implementation
	}

}