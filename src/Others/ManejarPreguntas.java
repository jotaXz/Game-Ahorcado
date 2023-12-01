package Others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class ManejarPreguntas {

	private ArrayList<Preguntas> listaPreguntas;
	private Random random;

	public ManejarPreguntas(String tabla) {
		listaPreguntas = new ArrayList<>();
		random = new Random();
		loadPreguntas(tabla);
	
	}

	public Preguntas obtenerPreguntaRandom() {
		if (listaPreguntas.isEmpty()) {
			return null; 
		}
		int indAleatorio = random.nextInt(listaPreguntas.size());
		return listaPreguntas.get(indAleatorio);

	}

	public ArrayList<Preguntas> loadPreguntas(String tabla) {

		ArrayList<Preguntas> listadoPreguntas = new ArrayList<Preguntas>();
		Preguntas p = null;
		try {
			Connection conexion = (Connection) DriverManager
					.getConnection(""); // Introduce tu servidor
			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM " + tabla);
			while (rs.next()) {
				p = new Preguntas();
				p.setId(rs.getInt("id"));
				p.setEnunciado(rs.getString("pregunta"));
				p.setRespuesta(rs.getString("respuesta"));
				listadoPreguntas.add(p);
			}
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listaPreguntas.addAll(listadoPreguntas);

		return listadoPreguntas;
	}

}
