package mercancia;

import java.util.Random;

public class Producto {
	private String nom;
	private int cod;
	private double precio, stock;
	
	Random r = new Random();
	int min = 1000000;
    int max = 2000000;
	private int tmpCod = r.nextInt((max - min) + 1) + min;
    
	//Configuracion con todos los parametros
	public Producto (String nom, int cod, double precio, double stock) {
		this.nom = nom;
		this.cod = cod;
		this.precio = precio;
		this.stock = stock;
	}
	
	//Configuracion sin stock
	public Producto(String nom, int cod, double precio) {
		super();
		this.nom = nom;
		this.cod = cod;
		this.precio = precio;
		this.stock = 0;
	}
	
	//Configuración sin código
	//El rango de codigo va entre 1 y 2 millones para separarlo de otras futuras categorias
	public Producto(String nom, double precio, double stock) {
		this.nom = nom;
		this.cod = tmpCod;
		this.precio = precio;
		this.stock = stock;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}

	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
		this.stock = stock;
	}


	public void IngresoStock(double cantidad ) {
		this.stock += cantidad;
	}
	
	public void SalidaStock(double cantidad ) {
		this.stock -= cantidad;
	}
}
