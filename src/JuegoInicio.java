
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import Others.ManejarPreguntas;
import Others.Preguntas;
import Others.Usuarios;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.Toolkit;

public class JuegoInicio extends JFrame {

	private JTextField textTexto;
	private ManejarPreguntas manejarPreguntasP;
	private ManejarPreguntas manejarPreguntasA;
	private JLabel etiquetaPregunta;
	private ArrayList<JTextField> cajasDeLetras;
	private JLayeredPane layeredPalabra;
	private String respuestaActual;
	private JLabel etiquetaImagen;
	private int contadorCoincidencias = 0;
	private int puntuacion = 100;
	private int puntuacionTotal = 0;
	private Set<Character> letrasIntroducidas = new HashSet<>();
	private Identificador identificador;
	private JLabel etiquetaPuntos_Totales;
	private JLabel etiquetaPuntos_Ronda;
	private String tipoDeTabla;

	/**
	 * Create the application.
	 */
	public JuegoInicio() {
		setTitle("                                    IFP DAW 2023");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JuegoInicio.class.getResource("/Imagenes/github_icon.png")));
		this.tipoDeTabla = Start.obtenerTipoDeTablaSeleccionada();
		this.identificador = Identificador.obtenerInstancia();
		manejarPreguntasA = new ManejarPreguntas("palabras");
		manejarPreguntasP = new ManejarPreguntas("preguntas_programacion");
		initialize();
		letrasIntroducidas = new HashSet<>();
	}

	public void manejarPreguntasA() {
		this.manejarPreguntasA = new ManejarPreguntas("palabras");
	}

	public void manejarPreguntasP() {
		this.manejarPreguntasP = new ManejarPreguntas("preguntas_programacion");
	}

	public void actualizarEtiquetaPuntos() {
		etiquetaPuntos_Ronda.setText("Puntos: " + puntuacion);
		etiquetaPuntos_Totales.setText("Puntos Totales: " + puntuacionTotal);
	}

	public JuegoInicio(Identificador identificador) {
		this.identificador = identificador;

	}

	public void setPuntuacionTotalEnJuego(int puntuacionTotal) {
		this.puntuacionTotal = puntuacionTotal;
	}

	public int restarPuntos(int cantidad) {
		puntuacion -= cantidad;
		if (puntuacion < 0) {
			puntuacion = 0;
		}
		return puntuacion;
	}

	private void mostrarLetrasEnCajas(String palabra) {

		layeredPalabra.removeAll();
		cajasDeLetras.clear();

		char[] letras = palabra.toCharArray();

		int anchoTotal = letras.length * 30;

		int x = (layeredPalabra.getWidth() - anchoTotal) / 2;

		for (char letra : letras) {
			JLayeredPane capaLetra = new JLayeredPane();
			capaLetra.setBounds(x, 0, 30, 30);

			JTextField caja = new JTextField(String.valueOf("_"));
			caja.setEditable(false);
			caja.setHorizontalAlignment(JTextField.CENTER);
			caja.setBounds(0, 0, 30, 30);

			Font boldFont = new Font(caja.getFont().getName(), Font.BOLD, caja.getFont().getSize());
			caja.setFont(boldFont);

			capaLetra.add(caja, JLayeredPane.DEFAULT_LAYER);

			layeredPalabra.add(capaLetra, JLayeredPane.DEFAULT_LAYER);

			cajasDeLetras.add(caja);

			x += 30;
		}

		layeredPalabra.validate();
		layeredPalabra.repaint();
	}

	public void iniciarPreguntas(String tabla) {

		Preguntas pregunta;

		if (tipoDeTabla != null) {
			if (tipoDeTabla.equalsIgnoreCase("palabras")) {
				pregunta = manejarPreguntasA.obtenerPreguntaRandom();
			} else if (tipoDeTabla.equalsIgnoreCase("preguntas_programacion")) {
				pregunta = manejarPreguntasP.obtenerPreguntaRandom();
			} else {
				System.out.println("Tabla no reconocida");
				return;
			}
		} else {
			System.out.println("tipoDeTabla es null. Revisar");
			return;
		}

		if (pregunta != null) {
			String enunciado = pregunta.getEnunciado();
			String respuesta = pregunta.getRespuesta();
			if (enunciado.length() > 60) {
				int ultimoEspacio = enunciado.lastIndexOf(' ', 60);
				if (ultimoEspacio != -1) {
					enunciado = enunciado.substring(0, ultimoEspacio) + "<br><center>"
							+ enunciado.substring(ultimoEspacio + 1) + "<center>";
				}
			}
			etiquetaPregunta.setText("<html><div style='text-align: center;'>" + enunciado + "</div></html>");
			respuestaActual = respuesta.toUpperCase();
			mostrarLetrasEnCajas(respuesta.toUpperCase());

		} else {
			JOptionPane.showMessageDialog(null, "NO SE HA PODIDO GENERAR LA PREGUNTA", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizarImagen(String rutaImagen) {

		etiquetaImagen.setBounds(75, 70, 260, 246);
		ImageIcon icon = new ImageIcon(getClass().getResource(rutaImagen));
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(etiquetaImagen.getWidth(),
				etiquetaImagen.getHeight(), Image.SCALE_DEFAULT));
		etiquetaImagen.setIcon((img));
		getContentPane().add(etiquetaImagen);

		getContentPane().validate();
		getContentPane().repaint();
	}

	public void reiniciarJuego() {
		letrasIntroducidas.clear();

		for (JTextField caja : cajasDeLetras) {
			caja.setText("");
		}
	}

	public void comprobarRespuesta() {
		String comprobar = textTexto.getText();

		if (comprobar.isEmpty()) {
			JOptionPane.showMessageDialog(null, "             TEXTO VACÍO", "INFO", JOptionPane.INFORMATION_MESSAGE);
			return;

		}
		char letraIntroducida = comprobar.toLowerCase().charAt(0);
		if (letrasIntroducidas.contains(letraIntroducida)) {
			JOptionPane.showMessageDialog(null, "Ya has introducido la letra '" + letraIntroducida + "' antes.", "INFO",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		letrasIntroducidas.add(letraIntroducida);

		char[] letrasIngresadas = comprobar.toUpperCase().toCharArray();
		char[] letrasRespuesta = respuestaActual.toUpperCase().toCharArray();

		boolean coincidenciaEncontrada = false;

		System.out.println(respuestaActual); // ****************************************

		for (int i = 0; i < letrasRespuesta.length; i++) {
			char letraRespuesta = letrasRespuesta[i];

			for (char letraIngresada : letrasIngresadas) {
				if (letraIngresada == letraRespuesta) {
					coincidenciaEncontrada = true;
					JTextField caja = cajasDeLetras.get(i);
					caja.setText(String.valueOf(letraRespuesta));
				}
			}
		}

		if (!coincidenciaEncontrada) {
			contadorCoincidencias++;
			restarPuntos(15);
			actualizarImagen("/Imagenes/AhorcadoNivel" + contadorCoincidencias + ".png");
			textTexto.requestFocus();

			if (contadorCoincidencias == 6) {
				actualizarImagen("/Imagenes/AhorcadoNivel6.png");
				JOptionPane.showMessageDialog(null, "TU PUNTUACIÓN HA SIDO DE: " + puntuacion + "puntos.", "PUNTUACIÓN",
						JOptionPane.INFORMATION_MESSAGE);

				puntuacionTotal += puntuacion;
				contadorCoincidencias = 0;
				puntuacion = 100;

				identificador.setPuntuacionTotal(puntuacionTotal);

				Usuarios usuario = new Usuarios();
				usuario.setPuntuacion(puntuacionTotal);
				reiniciarJuego();
				JOptionPane.showMessageDialog(null, "TU PUNTUACIÓN TOTAL ES DE: " + puntuacionTotal + "puntos.",
						"PUNTUACIÓN", JOptionPane.INFORMATION_MESSAGE);
				dispose();

				Identificador st = new Identificador();
				st.setVisible(true);
			}

		} else {

			boolean todasAdivinadas = true;
			for (char letraRespuesta : letrasRespuesta) {
				boolean letraAdivinada = false;
				for (JTextField caja : cajasDeLetras) {
					if (caja.getText().equalsIgnoreCase(String.valueOf(letraRespuesta))) {
						letraAdivinada = true;
						break;
					}
				}
				if (!letraAdivinada) {
					todasAdivinadas = false;
					break;
				}
			}
			if (todasAdivinadas) {
				JOptionPane.showMessageDialog(null, "LA PUNTUACIÓN DE ESTA RONDA HA SIDO: " + puntuacion + "puntos.",
						"PUNTUACIÓN", JOptionPane.INFORMATION_MESSAGE);
				puntuacionTotal += puntuacion;
				puntuacion = 100;

				reiniciarJuego();
				iniciarPreguntas(tipoDeTabla);
			}
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBounds(100, 100, 422, 618);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("JUEGO DEL AHORCADO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cascadia Code", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(53, 27, 282, 32);
		getContentPane().add(lblNewLabel);

		etiquetaImagen = new JLabel("");
		etiquetaImagen.setBounds(75, 70, 260, 246);
		ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/AhorcadoNivelStart.png"));
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(etiquetaImagen.getWidth(),
				etiquetaImagen.getHeight(), Image.SCALE_DEFAULT));

		etiquetaImagen.setIcon((img));
		getContentPane().add(etiquetaImagen);

		JButton botonComprobar = new JButton("COMPROBAR");
		botonComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				comprobarRespuesta();
				textTexto.setText("");
				textTexto.requestFocus();
				actualizarEtiquetaPuntos();
			}
		});
		botonComprobar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonComprobar.setBounds(35, 481, 132, 37);
		getContentPane().add(botonComprobar);

		textTexto = new JTextField();
		textTexto.setHorizontalAlignment(SwingConstants.CENTER);
		textTexto.setBounds(35, 438, 132, 32);
		getContentPane().add(textTexto);
		textTexto.setColumns(1);

		((PlainDocument) textTexto.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
					throws BadLocationException {
				// Limita la longitud del texto a 1
				if (fb.getDocument().getLength() + string.length() <= 1) {
					super.insertString(fb, offset, string, attr);
				}
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
				// Limita la longitud del texto a 1
				if (fb.getDocument().getLength() + text.length() - length <= 1) {
					super.replace(fb, offset, length, text, attrs);
				}
			}
		});

		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Start st = new Start();
				st.main(null);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAtras.setBounds(227, 529, 144, 37);
		getContentPane().add(btnAtras);

		etiquetaPregunta = new JLabel("<html><body style='width: 274px'></body></html>");
		etiquetaPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaPregunta.setBounds(35, 371, 330, 56);
		getContentPane().add(etiquetaPregunta);

		layeredPalabra = new JLayeredPane();
		layeredPalabra.setFont(new Font("Tahoma", Font.BOLD, 14));
		layeredPalabra.setBounds(10, 337, 386, 37);
		getContentPane().add(layeredPalabra);

		etiquetaPuntos_Totales = new JLabel("Puntos Totales: 0");
		etiquetaPuntos_Totales.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaPuntos_Totales.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaPuntos_Totales.setBounds(192, 481, 173, 37);
		getContentPane().add(etiquetaPuntos_Totales);

		etiquetaPuntos_Ronda = new JLabel("Puntos: 100");
		etiquetaPuntos_Ronda.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaPuntos_Ronda.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaPuntos_Ronda.setBounds(192, 434, 155, 37);
		getContentPane().add(etiquetaPuntos_Ronda);

		cajasDeLetras = new ArrayList<>();
		
		setLocationRelativeTo(null);

	}
}
