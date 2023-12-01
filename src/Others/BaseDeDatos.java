package Others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.Statement;

public class BaseDeDatos {
	
	public boolean crearUsuario(Usuarios user) {
		boolean result = false;
		String consulta = "";
		Connection conexion = null;
		Statement s = null;
		int filas = 0;

		try {
			conexion = (Connection) DriverManager
					.getConnection(""); // Introduce tu servidor
			s = (Statement) conexion.createStatement();
			consulta = "INSERT INTO usuarios (nombre, password, puntuacion) VALUES ('" + user.getNombre() + "','"
					+ user.getPassword() + "', " + user.getPuntuacion() + ")";
			filas = s.executeUpdate(consulta);
			if (filas > 0) {
				result = true;
			}
			conexion.close();
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean validarUsuario(String user, String password) {
		ArrayList<Usuarios> us = new ArrayList<Usuarios>();
		us = read("SELECT * FROM usuarios where nombre = '" + user + "' and password = '" + password + "' LIMIT 0,1");
		if (us.size() == 0) {
			return false;
		}
		return true;
	}

	public int obtenerIdUsuario(String usuario) {
		try {
			Connection conexion = (Connection) DriverManager
					.getConnection(""); // Introduce tu servidor
			Statement st = (Statement) conexion.createStatement();
			ResultSet rs = (ResultSet) st.executeQuery("SELECT id FROM usuarios WHERE nombre = '" + usuario + "'");

			if (rs.next()) {
				int id = rs.getInt("id");
				conexion.close();
				return id;
			}

			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public boolean comprobarUsuario(String user) {
		ArrayList<Usuarios> us = new ArrayList<Usuarios>();
		us = read("SELECT * FROM usuarios where nombre = '" + user + "'");
		if (us.size() == 0) {
			return false;
		}

		return true;
	}

	public ArrayList<Usuarios> read(String consult) {

		ArrayList<Usuarios> consulta = new ArrayList<>();

		try {
			Connection conexion = (Connection) DriverManager
					.getConnection(""); // Introduce tu servidor
			Statement st = (Statement) conexion.createStatement();
			ResultSet rs = (ResultSet) st.executeQuery(consult);
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				int puntuacion = rs.getInt("puntuacion");
				Usuarios user = new Usuarios();
				user.setNombre(nombre);
				user.setPuntuacion(puntuacion);
				consulta.add(user);
			}
			st.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return consulta;
	}

	public boolean update(Usuarios user) {
		boolean result = false;
		String consulta = "";
		Connection conexion = null;
		Statement s = null;
		try {
			conexion = (Connection) DriverManager
					.getConnection(""); // Introduce tu servidor
			s = (Statement) conexion.createStatement();
			consulta = "UPDATE usuarios SET nombre = '" + user.getNombre() + "', puntuacion = " + user.getPuntuacion()
					+ " WHERE id=" + user.getId();
			result = s.execute(consulta);
			conexion.close();
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public boolean updatePuntuacion(String usuario, int puntuacionTotal) {
		boolean result = false;
		String consulta = "";
		Connection conexion = null;
		Statement s = null;
		try {
			conexion = (Connection) DriverManager
					.getConnection(""); // Introduce tu servidor
			s = (Statement) conexion.createStatement();
			
			ResultSet rs = s.executeQuery("SELECT puntuacion FROM usuarios WHERE nombre='" + usuario + "'");
			int puntuacionActual = 0;
			if (rs.next()) {
				puntuacionActual = rs.getInt("puntuacion");
			}
			if (puntuacionActual > puntuacionTotal) {
				JOptionPane.showMessageDialog(null,
						"TU PUNTUACIÓN ANTERIOR ERA MAYOR. NO SE REALIZARAN CAMBIOS.", "INFO",
						JOptionPane.WARNING_MESSAGE);
			} else {
				
				consulta = "UPDATE usuarios SET puntuacion = " + puntuacionTotal + " WHERE nombre='" + usuario + "'";
				result = s.execute(consulta);
				JOptionPane.showMessageDialog(null, "¡PUNTUACIÓN ACTUALIZADA CON ÉXITO!", "RECORD",
						JOptionPane.INFORMATION_MESSAGE);
			}

			rs.close();
			conexion.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}
}
