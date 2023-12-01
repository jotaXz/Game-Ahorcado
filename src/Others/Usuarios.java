package Others;

public class Usuarios {
	
	protected int id;
	protected String nombre;
	protected String password;
	protected int puntuacion;
	
	public String toString() {
		return "Nombre: " + this.nombre + "   ||    Puntuación: " + this.puntuacion + " puntos";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
}
