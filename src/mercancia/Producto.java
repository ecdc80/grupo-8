package mercancia;

public class Producto {
	String nom;
	int cod;
	double precio, stock;
	
	
	
	public Producto(String nom, int cod, double precio, double stock) {
		super();
		this.nom = nom;
		this.cod = cod;
		this.precio = precio;
		this.stock = stock;
	}
	
	public Producto(String nom, int cod) {
		super();
		this.nom = nom;
		this.cod = cod;
		this.precio = 1;
		this.stock = 0;
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
