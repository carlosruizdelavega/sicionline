package pe.gob.essalud.sicionline.bean;

import org.springframework.stereotype.Component;

@Component
public class ResultadoBean {

	private String coStatus = null;
	private String deStatus = null;
	private String deStatusD = null;
	private Object resultado = null;
	private String numeroActaCelebra;
	private String indDml = null;

	public String getCoStatus() {
		return coStatus;
	}

	public String getNumeroActaCelebra() {
		return numeroActaCelebra;
	}

	public void setNumeroActaCelebra(String numeroActaCelebra) {
		this.numeroActaCelebra = numeroActaCelebra;
	}

	public void setCoStatus(String coStatus) {
		this.coStatus = coStatus;
	}

	public String getDeStatus() {
		return deStatus;
	}

	public void setDeStatus(String deStatus) {
		this.deStatus = deStatus;
	}

	public Object getResultado() {
		return resultado;
	}

	public void setResultado(Object resultado) {
		this.resultado = resultado;
	}

	public String getDeStatusD() {
		return deStatusD;
	}

	public void setDeStatusD(String deStatusD) {
		this.deStatusD = deStatusD;
	}

	public String getIndDml() {
		return indDml;
	}

	public void setIndDml(String indDml) {
		this.indDml = indDml;
	}

}
