package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GUI_Modificar_Eliminar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtCod;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GUI_Modificar_Eliminar dialog = new GUI_Modificar_Eliminar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Custom renderer class for the header
	class CustomHeaderRenderer extends JLabel implements TableCellRenderer {
	    public CustomHeaderRenderer() {
	        setFont(new Font("Arial", Font.BOLD, 14));
	        setForeground(Color.BLUE);
	        setHorizontalAlignment(JLabel.CENTER);
	        setBorder(BorderFactory.createEtchedBorder());
	        setOpaque(true);
	    }
	    
	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        setText(value.toString());
	        return this;
	    }
	}

	/**
	 * Create the dialog.
	 */
	public GUI_Modificar_Eliminar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 153, 356, 85);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"123", "TV", "34.5", "2"},
				{null, null, null, null},
			},
			new String[] {
				"Codigo", "Nombre", "Precio", "Stock"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JLabel lblNewLabel = new JLabel("Codigo: ");
		lblNewLabel.setBounds(37, 20, 45, 13);
		contentPanel.add(lblNewLabel);
		
		txtCod = new JTextField();
		txtCod.setBounds(89, 17, 96, 19);
		contentPanel.add(txtCod);
		txtCod.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(195, 16, 85, 21);
		contentPanel.add(btnBuscar);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(40, 83, 45, 13);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Precio");
		lblNewLabel_1_1.setBounds(140, 83, 45, 13);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stock");
		lblNewLabel_2.setBounds(229, 83, 45, 13);
		contentPanel.add(lblNewLabel_2);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(306, 122, 85, 21);
		contentPanel.add(btnModificar);
		
		textField = new JTextField();
		textField.setBounds(10, 106, 96, 19);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(125, 106, 70, 19);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(217, 106, 70, 19);
		contentPanel.add(textField_2);
		table.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
	}
}
