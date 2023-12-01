
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Identificador instancia;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textPassword;
	private JTextField textPasswordConfirm;
	private JLabel etiquetaTitulo;
	private JLabel etiquetaNombre;
	private JLabel etiquetaPassword;
	private JLabel etiquetaPasswordConfirm;
	private JButton botonRegistro;
	private JFrame startFrame;


	/**
	 * Create the frame.
	 */

	public static Identificador obtenerInstancia() {
        if (instancia == null) {
            instancia = new Identificador();
        }
        return instancia;
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
	
	public Registro() {
		
		setResizable(false);
		setTitle("           IFP DAW 2023");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registro.class.getResource("/Imagenes/github_icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		etiquetaTitulo = new JLabel("REGISTRO");
		etiquetaTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setBounds(68, 11, 145, 34);
		contentPane.add(etiquetaTitulo);

		etiquetaNombre = new JLabel("Nombre:");
		etiquetaNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaNombre.setBounds(42, 56, 60, 20);
		contentPane.add(etiquetaNombre);

		textNombre = new JTextField();
		textNombre.setBounds(42, 87, 200, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		etiquetaPassword = new JLabel("Contraseña:");
		etiquetaPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaPassword.setBounds(42, 118, 78, 20);
		contentPane.add(etiquetaPassword);

		etiquetaPasswordConfirm = new JLabel("Confiramar contraseña:");
		etiquetaPasswordConfirm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaPasswordConfirm.setBounds(42, 180, 134, 20);
		contentPane.add(etiquetaPasswordConfirm);

		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(42, 149, 200, 20);
		contentPane.add(textPassword);

		textPasswordConfirm = new JTextField();
		textPasswordConfirm.setColumns(10);
		textPasswordConfirm.setBounds(42, 211, 200, 20);
		contentPane.add(textPasswordConfirm);

		botonRegistro = new JButton("REGISTRARSE");
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoNombre = textNombre.getText();
				String textoPassword = textPassword.getText();
				String textoPasswordC = textPasswordConfirm.getText();
				BaseDeDatos baseDeDatos = new BaseDeDatos();
				Usuarios user = new Usuarios();
				user.setNombre(textoNombre);

				if (baseDeDatos.comprobarUsuario(textoNombre)) {
					JOptionPane.showMessageDialog(null, "USUARIO EXISTENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
					textNombre.setText("");
					textNombre.requestFocus();
				} else if (textoPassword.equals(textoPasswordC)) {
					user.setPassword(textoPassword);

					if (baseDeDatos.crearUsuario(user)) {
						JOptionPane.showMessageDialog(null, "REGISTRO COMPLETADO", "INGRESASTE",
								JOptionPane.INFORMATION_MESSAGE);

						Identificador identificador = Identificador.obtenerInstancia();

						String users = textNombre.getText();
						actualizarPuntuacion(identificador.getPuntuacionTotal(), users);
						
						dispose();
						ListarPuntuaciones listar = new ListarPuntuaciones(startFrame);
						listar.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Error al crear usuario", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS DEBEN SER IGUALES", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					textPassword.setText("");
					textPasswordConfirm.setText("");
					textPassword.requestFocus();
				}

			}
		});
		botonRegistro.setBounds(42, 253, 106, 23);
		contentPane.add(botonRegistro);

		JButton botonAtras = new JButton("ATRAS");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Identificador iden = new Identificador();
				iden.setVisible(true);
			}
		});
		botonAtras.setBounds(158, 253, 84, 23);
		contentPane.add(botonAtras);
		
		setLocationRelativeTo(null);
	}

}
