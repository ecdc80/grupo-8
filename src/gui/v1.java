package gui;

import java.awt.EventQueue;
import java.awt.HeadlessException;

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

public class v1 extends JFrame implements ActionListener {

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
					v1 frame = new v1();
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
	public v1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Producto ");
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
		
		
		
		JButton btn_Adicionar = new JButton("Adicionar");
		btn_Adicionar.setBounds(93, 88, 85, 23);
		btn_Adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String nombre = LeerNombre();
					JOptionPane.showMessageDialog(v1.this, "${nombre}");
					Producto tmp = new Producto(LeerNombre(), LeerCodigo(),LeerPrecio() ,LeerStock());
					inv.Adicionar(tmp);

			}
		});
		contentPane.add(btn_Adicionar);
		
		JButton btn_Buscar = new JButton("Buscar");
		btn_Buscar.setBounds(182, 88, 86, 23);
		btn_Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

						Producto es = inv.Buscar(LeerNombre());
						if(es != null) {
							txtS.setText("");
							txtS.append("Código\tNombre\tPrecio \tStock");
							txtS.append("\n"+ es.getCod() + "\t" + es.getNom()+ "\t" + es.getPrecio()+ "\t" + es.getStock());
						}
						else JOptionPane.showMessageDialog(v1.this," Hola");
					
			}
		});
		contentPane.add(btn_Buscar);
		
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
		
		JButton btn_Eliminar = new JButton("Eliminar");
		btn_Eliminar.setBounds(259, 88, 91, 23);
		btn_Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto es=inv.Buscar(LeerCodigo());
				if(es != null) inv.Eliminar(es);
				else JOptionPane.showMessageDialog(v1.this, "No se registro producto ");
			}
		});
		contentPane.add(btn_Eliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 416, 120);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		JButton btn_Modificar = new JButton("Modificar");
		btn_Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtS.setText("");
		        try {
		            Producto p = inv.Buscar(LeerCodigo());
		            if (p != null) {
		                p.setNom(LeerNombre());
		                p.setPrecio(LeerPrecio());
		                JOptionPane.showMessageDialog(v1.this, "Producto modificado");
		                Listado();
		            } else
		                JOptionPane.showMessageDialog(v1.this, "No existe código");
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(v1.this, "Ingrese código y precio válidos");
		        }
			}
		});
		btn_Modificar.setBounds(345, 88, 89, 23);
		contentPane.add(btn_Modificar);
		
		JButton btn_Reportar = new JButton("Reportar");
		btn_Reportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtS.setText("");
				Listado();
				txtS.append("\nCantidad de productos " +inv.Tamaño());
			}
		});
		btn_Reportar.setBounds(10, 89, 85, 21);
		contentPane.add(btn_Reportar);
		
		JButton btn_Cantidad = new JButton("Modificar Cantidad");
		btn_Cantidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stock st = new Stock();
				st.setVisible(true);
			}
		});
		btn_Cantidad.setBounds(345, 8, 117, 21);
		contentPane.add(btn_Cantidad);
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


