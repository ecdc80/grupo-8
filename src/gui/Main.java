package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mercancia.ArregloProducto;
import mercancia.Producto;

import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("unused")
public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCod;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	
	
	
	
	
	ArregloProducto inven = new ArregloProducto("");
	
	private JTextArea txtS;
	private JComboBox<String> find_ComboBox;
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Productos");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Añadir / Modificar");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Eliminar");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Stock");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Modificar Stock");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 11, 378, 147);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					Producto producto_cod;
					ArregloProducto productos_encontrados;
					String item = CurrentItem();
					
					if(item == "Código" ) {
						try {
							producto_cod = inven.Buscar(LeerCodigo());
							if(producto_cod == null)JOptionPane.showMessageDialog(btnNewButton, "Código no encontrado");
							else {
								Header();
								txtS.append("\n"+producto_cod.getCod()+"\t"+ producto_cod.getNom()+"\t"+producto_cod.getPrecio()+"\t"+ producto_cod.getStock());
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(btnNewButton, "No es un código valido");
						}
					}
					else if (item == "Nombre" ){
						try {
							productos_encontrados = inven.Buscar(LeerNombre() ,inven);
							Listado(productos_encontrados);
						}
						catch (Exception e3) {
							JOptionPane.showMessageDialog(btnNewButton, "No se encuentra el nombre");
						}
						
					}
					else throw new IllegalArgumentException("Unexpected value: " + CurrentItem());
				}
				
		});
		btnNewButton.setBounds(92, 208, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reportar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Listado(inven);
			}
		});
		
		btnNewButton_1.setBounds(310, 194, 89, 23);
		contentPane.add(btnNewButton_1);
		
		txtCod = new JTextField();
		txtCod.setBounds(92, 177, 86, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		find_ComboBox = new JComboBox<String> ();
		find_ComboBox.setMaximumRowCount(2);
		find_ComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Código", "Nombre"}));
		find_ComboBox.setSelectedIndex(0);
		find_ComboBox.setBounds(10, 176, 72, 21);
		contentPane.add(find_ComboBox);
		
		JButton C_Item = new JButton("C_Item");
		C_Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(C_Item, CurrentItem());
			}
		});
		C_Item.setBounds(215, 195, 85, 21);
		contentPane.add(C_Item);
		
		
		
		
	}
	void Header() {
		txtS.setText("");
		txtS.append("Codigo\tNombre\tPrecio\tstock");
		
	}
	String CurrentItem() {
		return  find_ComboBox.getSelectedItem().toString();
	}
	
	void Listado(ArregloProducto inv) {
		Header();
		for (int i  = 0 ; i< inv.Tamaño(); i++) {
			txtS.append("\n"+inv.Obtener(i).getCod()+"\t"+ inv.Obtener(i).getNom()+"\t"+inv.Obtener(i).getPrecio()+"\t"+ inv.Obtener(i).getStock());
		}
		txtS.append("\n \n \nCantidad de productos " +inv.Tamaño());
		txtS.append("\n" + CurrentItem() );
	}
	
	int LeerCodigo() {
		return Integer.parseInt(txtCod.getText());
	}
	String LeerNombre() {
		return txtCod.getText();
	}
	private ArrayList<Producto>inicial = new ArrayList<Producto>();
	
}
