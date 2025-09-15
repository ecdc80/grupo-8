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

public class v1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtCod;
	private JButton btn_Reportar;
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
		txtCod.setBounds(109, 44, 86, 20);
		this.contentPane.add(this.txtCod);
		this.txtCod.setColumns(10);
		
		this.btn_Reportar = new JButton("Reportar");
		btn_Reportar.setBounds(0, 88, 86, 23);
		this.btn_Reportar.addActionListener(this);
		this.contentPane.add(this.btn_Reportar);
		
		
		
		JButton btn_Adicionar = new JButton("Adicionar");
		btn_Adicionar.setBounds(87, 88, 85, 23);
		btn_Adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Producto tmp = new Producto(LeerNombre(), LeerCodigo(),LeerPrecio() ,LeerStock());
				inv.Adicionar(tmp);
			}
		});
		contentPane.add(btn_Adicionar);
		
		JButton btn_Buscar = new JButton("Buscar");
		btn_Buscar.setBounds(182, 88, 86, 23);
		btn_Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					Producto es = inv.Buscar(LeerCodigo());
					if(es != null) {

						txtS.append("Código\tNombre\tNota 1\tNota 2\tPromedio");
						txtS.append("\n"+ es.getCod() + "\t" + es.getNom()+ "\t" + es.getPrecio()+ "\t" + es.getStock());
					}
					else JOptionPane.showMessageDialog(v1.this," Hola");
			}
		});
		contentPane.add(btn_Buscar);
		
		JLabel sad = new JLabel("Cantidad");
		sad.setBounds(223, 12, 45, 13);
		contentPane.add(sad);
		
		JLabel asd = new JLabel("Precio");
		asd.setBounds(223, 47, 45, 13);
		contentPane.add(asd);
		
		txtCant = new JTextField();
		txtCant.setBounds(300, 9, 86, 20);
		txtCant.setColumns(10);
		contentPane.add(txtCant);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(300, 44, 86, 20);
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

	}
	
	
	ArregloProducto inv = new ArregloProducto();
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
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		txtS.setText("");
        try {
            Producto p = inv.Buscar(LeerCodigo());
            if (p != null) {
                p.setNom(LeerNombre());
                p.setPrecio(LeerPrecio());
                JOptionPane.showMessageDialog(this, "Producto modificado");
                Listado();
            } else
                JOptionPane.showMessageDialog(this, "No existe código");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese código y precio válidos");
        }
    }

	public void actionPerformed(ActionEvent e) {
		txtS.setText("");
		Listado();
		txtS.append("\nCantidad de productos " +inv.Tamaño());
	}
	void Listado() {
		txtS.setText("");
		txtS.append("Codigo\tNombre\tPrecio\tstock");
		for (int i  = 0 ; i< inv.Tamaño(); i++) {
			txtS.append("\n"+inv.Obtener(i).getCod()+"\t"+ inv.Obtener(i).getNom()+"\t"+ 
					inv.Obtener(i).getPrecio()+"\t"+ inv.Obtener(i).getStock());
		}	
	}
}


