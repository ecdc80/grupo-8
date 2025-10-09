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
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GUI_Añadir extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtCod;
	private JTextField txtCant;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Añadir frame = new GUI_Añadir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	ArregloProducto inv = new ArregloProducto();
	/**
	 * Create the frame.
	 */
	public GUI_Añadir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 326);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Productos");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Inventario");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtNom = new JTextField();
		txtNom.setBounds(77, 9, 86, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setBounds(10, 46, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		this.txtCod = new JTextField();
		txtCod.setBounds(77, 39, 86, 20);
		this.contentPane.add(this.txtCod);
		this.txtCod.setColumns(10);
		
		
		
		JButton btn_Adicionar = new JButton("Añadir");
		btn_Adicionar.setBounds(351, 23, 85, 23);
		btn_Adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					txtS.append("\nCantidad de productos " +inv.Tamaño());
					Producto tmp = new Producto(LeerNombre(), LeerCodigo(),LeerPrecio() ,LeerStock());
					inv.Adicionar(tmp);

				}catch(Exception e2) {
					
				}

		}
	});
		contentPane.add(btn_Adicionar);
		
		JLabel sad = new JLabel("Cantidad");
		sad.setBounds(182, 12, 45, 13);
		contentPane.add(sad);
		
		JLabel asd = new JLabel("Precio");
		asd.setBounds(182, 47, 45, 13);
		contentPane.add(asd);
		
		txtCant = new JTextField();
		txtCant.setBounds(237, 9, 86, 20);
		txtCant.setColumns(10);
		contentPane.add(txtCant);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(237, 44, 86, 20);
		txtPrecio.setColumns(10);
		contentPane.add(txtPrecio);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 121, 416, 120);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		JButton btn_Modificar = new JButton("Modificar");
		btn_Modificar.setEnabled(false);
		btn_Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtS.setText("");
		        try {
		            Producto p = inv.Buscar(LeerCodigo());
		            if (p != null) {
		                p.setNom(LeerNombre());
		                p.setPrecio(LeerPrecio());
		                p.setStock(LeerStock());
		                JOptionPane.showMessageDialog(GUI_Añadir.this, "Producto modificado");
		                Listado();
		            } else
		                JOptionPane.showMessageDialog(GUI_Añadir.this, "No existe código");
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(GUI_Añadir.this, "Ingrese código y precio válidos");
		        }
			}
		});
			
		btn_Modificar.setBounds(347, 55, 89, 23);
		contentPane.add(btn_Modificar);
	}
	
	
	private JScrollPane scrollPane;
	private JTextArea txtS;
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
	void Listado() {
		txtS.setText("");
		txtS.append("Codigo\tNombre\tPrecio\tstock");
		for (int i  = 0 ; i< inv.Tamaño(); i++) {
			txtS.append("\n"+inv.Obtener(i).getCod()+"\t"+ inv.Obtener(i).getNom()+"\t"+ 
					inv.Obtener(i).getPrecio()+"\t"+ inv.Obtener(i).getStock());
		}	
	}
	public void actionPerformed(ActionEvent e) {
	}
}


