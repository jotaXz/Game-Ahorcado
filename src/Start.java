import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Others.BaseDeDatos;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Start extends JFrame {

	private JFrame Cuadro;
	private JRadioButton tickProgramacion;
	private JRadioButton tickAleatorio;
	private ButtonGroup buttonGroup;
	private static String tipoDeTablaSeleccionada;

	public static String obtenerTipoDeTablaSeleccionada() {
		return tipoDeTablaSeleccionada;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.Cuadro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public Start() {
		initialize();
		Cuadro.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Cuadro = new JFrame();
		Cuadro.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Cuadro.setFocusTraversalPolicyProvider(true);
		Cuadro.setType(Type.POPUP);
		Cuadro.setTitle("                            IFP DAW 2023");
		Cuadro.setResizable(false);
		Cuadro.setIconImage(Toolkit.getDefaultToolkit().getImage(Start.class.getResource("/Imagenes/github_icon.png")));
		Cuadro.setBackground(new Color(255, 255, 255));
		Cuadro.setBounds(100, 100, 376, 515);
		Cuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Cuadro.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("JUEGO DEL AHORCADO");
		lblNewLabel.setFont(new Font("Cascadia Code", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(33, 24, 282, 32);
		Cuadro.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");

		lblNewLabel_1.setBounds(33, 80, 282, 246);

		ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/AhorcadoNivelStart.png"));
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel_1.getWidth(),
				lblNewLabel_1.getHeight(), Image.SCALE_DEFAULT));

		lblNewLabel_1.setIcon((img));
		Cuadro.getContentPane().add(lblNewLabel_1);

		JButton botonEmpezar = new JButton("Empezar");
		botonEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tickAleatorio.isSelected()) {
					tipoDeTablaSeleccionada = "palabras";
					JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
					currentFrame.dispose();

					JuegoInicio ji = new JuegoInicio();

					ji.setVisible(true);
					ji.iniciarPreguntas("palabras");

				} else if (tickProgramacion.isSelected()) {
					tipoDeTablaSeleccionada = "preguntas_programacion";
					JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
					currentFrame.dispose();

					JuegoInicio ji = new JuegoInicio();

					ji.setVisible(true);
					ji.iniciarPreguntas("preguntas_programacion");

				} else {
					JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR UNA OPCIÓN", "ERROR",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		botonEmpezar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonEmpezar.setBounds(33, 358, 123, 32);
		Cuadro.getContentPane().add(botonEmpezar);

		JButton botonRecord = new JButton("TOP 10");
		botonRecord.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				currentFrame.dispose();
				ListarPuntuaciones listar = new ListarPuntuaciones(currentFrame);
				listar.setVisible(true);

			}
		});
		botonRecord.setBounds(197, 358, 118, 32);
		Cuadro.getContentPane().add(botonRecord);

		tickProgramacion = new JRadioButton("PREGUNTAS SOBRE PROGRAMACIÓN");
		tickProgramacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		tickProgramacion.setBounds(33, 410, 282, 23);
		Cuadro.getContentPane().add(tickProgramacion);

		tickAleatorio = new JRadioButton("PREGUNTAS ALEATORIAS");
		tickAleatorio.setFont(new Font("Tahoma", Font.BOLD, 13));
		tickAleatorio.setBounds(33, 436, 282, 23);
		Cuadro.getContentPane().add(tickAleatorio);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(tickProgramacion);
		buttonGroup.add(tickAleatorio);

		tickProgramacion.setSelected(false);
		tickAleatorio.setSelected(false);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 59, 22);
		Cuadro.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("README");
		menuBar.add(mnNewMenu);

		JMenuItem etiqueInfoMenu = new JMenuItem("INFO");
		mnNewMenu.add(etiqueInfoMenu);
		etiqueInfoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Primer proyecto desarrollado por juandev@2023!!\n                            Version 1.0",
						"INFO", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
