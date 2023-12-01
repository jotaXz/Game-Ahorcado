package Others;

public class Preguntas {
	private int id;
	private String enunciado;
	private String respuesta;
	
	public Preguntas(int id, String enunciado, String respuesta) {
		this.id = id;
		this.enunciado = enunciado;
		this.respuesta = respuesta;
	}
	public Preguntas() {
		this.id = id;
		this.enunciado = enunciado;
		this.respuesta = respuesta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
}
