package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mercancia.ArregloProducto;
import mercancia.Producto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class v1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtCod;
	private JButton btnNewButton;
	private JTextArea txtS;
	private JTextField txtCant;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					v1 frame = new v1();
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
	public v1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Producto ");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtNom = new JTextField();
		txtNom.setBounds(109, 9, 86, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setBounds(10, 46, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		this.txtCod = new JTextField();
		this.txtCod.setBounds(109, 44, 86, 20);
		this.contentPane.add(this.txtCod);
		this.txtCod.setColumns(10);
		
		this.btnNewButton = new JButton("Reportar(Listar)");
		this.btnNewButton.addActionListener(this);
		this.btnNewButton.setBounds(258, 95, 138, 23);
		this.contentPane.add(this.btnNewButton);
		
		this.txtS = new JTextArea();
		this.txtS.setBounds(10, 94, 238, 159);
		this.contentPane.add(this.txtS);
		
		
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Producto tmp = new Producto(LeerNombre(), LeerCodigo());
				inv.Adicionar(tmp);
			}
		});

		btnAdicionar.setBounds(258, 128, 138, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnBuscar = new JButton("Buscar");
	
		btnBuscar.setBounds(258, 161, 138, 23);
		contentPane.add(btnBuscar);
		
		JLabel sad = new JLabel("Cantidad");
		sad.setBounds(223, 12, 45, 13);
		contentPane.add(sad);
		
		JLabel asd = new JLabel("Precio");
		asd.setBounds(223, 47, 45, 13);
		contentPane.add(asd);
		
		txtCant = new JTextField();
		txtCant.setColumns(10);
		txtCant.setBounds(300, 9, 86, 20);
		contentPane.add(txtCant);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(300, 44, 86, 20);
		contentPane.add(txtPrecio);

	}
	
	
	ArregloProducto inv = new ArregloProducto();
	int LeerCodigo() {
		return Integer.parseInt(txtCod.getText());
	}
	String LeerNombre() {
		return txtNom.getText();
	}
	double LeerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	double LeerStock() {
		return Double.parseDouble(txtCant.getText());
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		Listado();
	}
	
	void Listado() {
		txtS.setText("");
		txtS.append("Codigo\tNombre\tNota 1\tNota 2\tPromedio");
		for (int i  = 0 ; i< inv.Tamaño(); i++) {
			txtS.append("\n"+inv.Obtener(i).getCod()+"\t"+ inv.Obtener(i).getNom()+"\t"+ 
					inv.Obtener(i).getPrecio()+"\t"+ inv.Obtener(i).getStock());
		}
	}
}
