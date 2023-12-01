
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Others.BaseDeDatos;
import Others.Usuarios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Identificador extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Identificador instancia;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textPassword;
	private JLabel etiquetaTitulo;
	private JLabel etiqueta1;
	private JLabel etiqueta2;
	private JButton botonIniSesion;
	private JButton botonRegistro;
	private int puntuacionTotal;
	final JFrame self = this;

	/**
	 * Create the frame.
	 */
	
	public static Identificador obtenerInstancia() {
        if (instancia == null) {
            instancia = new Identificador();
        }
        return instancia;
    }

	public Identificador(int puntuacionTotal) {
		this.puntuacionTotal = puntuacionTotal;
	}

	public void setPuntuacionTotal(int puntuacionTotal) {	
		this.puntuacionTotal = puntuacionTotal;	
	}

	public int getPuntuacionTotal() {
		return puntuacionTotal;
	}

	public void actualizarPuntuacion(int puntuacionTotal, String usuario) {
		BaseDeDatos baseDeDatos = new BaseDeDatos();
		int idUsuario = baseDeDatos.obtenerIdUsuario(usuario);
		if (idUsuario != -1) {
			Usuarios usuarioObj = new Usuarios();
			usuarioObj.setId(idUsuario);
			usuarioObj.setNombre(usuario);
			usuarioObj.setPuntuacion(puntuacionTotal);

			baseDeDatos.updatePuntuacion(usuario, puntuacionTotal);
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo obtener el ID del usuario", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public Identificador() {
		setTitle("                                     IFP DAW 2023");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Identificador.class.getResource("/Imagenes/github_icon.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		etiquetaTitulo = new JLabel("REGISTRO DE PUNTUACIÓN");
		etiquetaTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setBounds(90, 30, 235, 31);
		contentPane.add(etiquetaTitulo);

		etiqueta1 = new JLabel("Usuario:");
		etiqueta1.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiqueta1.setBounds(67, 91, 62, 24);
		contentPane.add(etiqueta1);

		etiqueta2 = new JLabel("Contraseña:");
		etiqueta2.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiqueta2.setBounds(67, 115, 74, 24);
		contentPane.add(etiqueta2);

		textUsuario = new JTextField();
		textUsuario.setBounds(196, 93, 120, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);

		textPassword = new JPasswordField();
		textPassword.setBounds(196, 117, 120, 20);
		contentPane.add(textPassword);

		botonIniSesion = new JButton("Iniciar sesión");
		botonIniSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BaseDeDatos baseDeDatos = new BaseDeDatos();
				String usuario = textUsuario.getText();
				String pw = textPassword.getText();
				if (baseDeDatos.validarUsuario(usuario, pw)) {
					int idUsuario = baseDeDatos.obtenerIdUsuario(usuario);

					if (idUsuario != -1) {

						Usuarios usuarioObj = new Usuarios();
						usuarioObj.setNombre(usuario);

						Identificador identificador = Identificador.obtenerInstancia();

						String user = textUsuario.getText();
						actualizarPuntuacion(identificador.getPuntuacionTotal(), user);

						textUsuario.setText("");
						textPassword.setText("");
						
						ListarPuntuaciones a = new ListarPuntuaciones(self);
						dispose();
						a.setVisible(true);
						
					} else {
						JOptionPane.showMessageDialog(null, "No se pudo obtener el ID del usuario", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				} else if (textUsuario.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El valor del usuario esta vacío", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					textUsuario.requestFocus();
				} else if (textPassword.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El valor de la contraseña esta vacío", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					textPassword.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					textUsuario.setText("");
					textPassword.setText("");
					textUsuario.requestFocus();
				}

			}

		});
		
		botonIniSesion.setBounds(67, 173, 114, 23);
		contentPane.add(botonIniSesion);

		botonRegistro = new JButton("Registrarse");
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Registro registro = new Registro();
				registro.setVisible(true);

			}
		});
		botonRegistro.setBounds(209, 173, 107, 23);
		contentPane.add(botonRegistro);
		
		setLocationRelativeTo(null);
	}
	
}
