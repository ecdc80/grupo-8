package clientes;

import java.util.List;

import mercancia.Producto;



public class Venta extends Producto{
	
	String cliente;
	
	int ID_venta;
	double cantidad_vendida;
	List<Producto> products;
	public Venta(String nom, int cod, double precio, String cliente, int iD_venta, double cantidad_vendida, List<Producto> products) {
		super(nom, cod, precio);
		this.cliente = cliente;
		this.ID_venta = iD_venta;
		this.cantidad_vendida = cantidad_vendida;
		this.products = products;
	}
	
	
	public void AgregarProducto() {
		products.add(new Producto("Salchipapa", 109, 23));
	}
	
}
