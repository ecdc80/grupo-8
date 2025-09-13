package mercancia;

public class Producto {
	int cod;
	String nom;
	double precio, stock;
	
	public Producto(int cod, String nom, double precio, double stock) {
		super();
		this.cod = cod;
		this.nom = nom;
		this.precio = precio;
		this.stock = stock;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
