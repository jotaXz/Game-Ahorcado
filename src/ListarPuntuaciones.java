
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Others.BaseDeDatos;
import Others.Usuarios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Toolkit;

public class ListarPuntuaciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame startFrame;
	
	public static void mostrarInfo(JTextArea textA) {
		BaseDeDatos puntuaciones = new BaseDeDatos();
		ArrayList<Usuarios> puntos = puntuaciones.read("SELECT * FROM usuarios ORDER BY puntuacion DESC LIMIT 10");

		if (puntos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista vacía","INFO", JOptionPane.INFORMATION_MESSAGE);
		} else {
			StringBuilder puntuacion = new StringBuilder();
			for (int i = 0; i < puntos.size(); i++) {
				 puntuacion.append("TOP ").append(i + 1).append(":  ").append(puntos.get(i)).append("\n");
			}
			textA.setText(puntuacion.toString());
		}
	}
	

	public ListarPuntuaciones(JFrame startFrame) {
		setTitle("                                         IFP DAW 2023");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarPuntuaciones.class.getResource("/Imagenes/github_icon.png")));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.startFrame = startFrame;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("TOP JUGADORES MUNDIALES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(94, 22, 220, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 50, 414, 200);
		contentPane.add(scrollPane);

		mostrarInfo(textArea);

		JButton btnNewButton = new JButton("ATRAS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Start st = new Start();
				st.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(134, 261, 150, 35);
		contentPane.add(btnNewButton);
		
		setLocationRelativeTo(null);
	}
}
