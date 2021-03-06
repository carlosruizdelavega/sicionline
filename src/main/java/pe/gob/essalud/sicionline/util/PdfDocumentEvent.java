package pe.gob.essalud.sicionline.util;
 
import org.apache.log4j.Logger;



import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Clase interna que captura los eventos generados en la creacion del documento
 * @author csantos
 *
 */
public class PdfDocumentEvent extends PdfPageEventHelper {
	
	//define log
	private static final Logger log = Logger.getLogger(PdfDocumentEvent.class);
	
    /**
     * Metodo que se ejecuta cuando se abre el documento
     */
    public void onOpenDocument(PdfWriter writer, Document document) {
    	//implementation
        }
 
        /**
     * Metodo que se ejecuta cuando llegamos al final de una pagina
     */
    public void onStartPage(PdfWriter writer, Document document) {
    	//implementation  
    	
    	
    	
    	
    	
    	
    }
    
    /**
     * Metodo que se ejecuta cuando llegamos al final de una pagina
     */
    public void onEndPage(PdfWriter writer, Document document) {
    	
    	//carga paginado
        	cargaPaginado(writer, document);        	
        	
        }
 
        /**
     * Metodo que se ejecuta cuando se cierra el documento
     */
    public void onCloseDocument(PdfWriter writer, Document document) {
    	//implementation
    }
    
    /**
     * Metodo que carga paginado
     */
    private void cargaPaginado(PdfWriter writer, Document document){

        try {

        	//define rectangulo
        	Rectangle rect = new Rectangle(36, 54, 559, 788);
        	
        	//define Font
        	Font fuente = new Font(Font.HELVETICA, 8, Font.BOLDITALIC);
        	
        	//obtiene valores
        	PdfContentByte bytes = writer.getDirectContent();
        	int alineacion = Element.ALIGN_RIGHT;
        	Phrase frase = new Phrase("Pagina " + writer.getPageNumber(), fuente);
        	float x = rect.getRight();
        	float y = rect.getLeft();
        	float rotacion = 0;
        	
        	//carga rectangulo
        	ColumnText.showTextAligned(bytes, alineacion, frase, x, y-20, rotacion);
      	
        } catch (Exception ex) {
        	log.error("Error: " + ex);
        }
        
    }
    
}