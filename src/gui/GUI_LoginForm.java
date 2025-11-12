package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class GUI_LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_LoginForm frame = new GUI_LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(178, 193, 90, 17);
		contentPane.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContraseña.setBounds(178, 234, 89, 13);
		contentPane.add(lblContraseña);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(291, 194, 96, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(291, 233, 96, 19);
		contentPane.add(txtContraseña);
		txtContraseña.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(260, 307, 85, 21);
		contentPane.add(btnLogin);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon("C:\\Users\\arnel\\Downloads\\Miguelito_Logo.png"));
		lblIcon.setBounds(78, 10, 384, 319);
		contentPane.add(lblIcon);

	}
}
