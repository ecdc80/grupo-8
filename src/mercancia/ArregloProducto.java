package mercancia;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.MessageFormat;


public class ArregloProducto{

	private ArrayList<Producto> inventario;
	
	public ArregloProducto(String x) {
		this.inventario = new ArrayList<Producto>();
		inventario.add(new Producto("Laptop Reza", 1000001, 15.1, 3));
		inventario.add(new Producto("Laptop SK", 1000002, 25.7, 1.5));
		inventario.add(new Producto("Laptop Logica", 1000003, 41.4, 22));
		inventario.add(new Producto("Pantalla USA", 1000004, 65.9, 200));
		
	}
	public ArregloProducto() {
		this.inventario = new ArrayList<Producto>();
		
	}
	
	public void Adicionar( Producto x ) {
		inventario.add(x);
	}
	
	public int Tamaño() {
		return inventario.size();
	}
	
	public Producto Obtener(int x) {
		return inventario.get(x);
	}
	
	//Método Buscar (Sobrecarga +2)
	public Producto Buscar (int cod) {
		for(int i = 0; i <Tamaño(); i++) {
			if(Obtener(i).getCod()== cod) return Obtener(i);
		}
		return null;
	}
	
	public Producto Buscar (String nom) {
		String message = MessageFormat.format("{0}", nom);
		Pattern pattern = Pattern.compile(message, Pattern.CASE_INSENSITIVE);
		for(int i = 0; i <Tamaño(); i++) {
			Matcher matcher = pattern.matcher(Obtener(i).getNom());
			if(matcher.find()) return Obtener(i);
		}
		return null;
	}
	
	public ArregloProducto Buscar (String nom,ArregloProducto reference) {
		
		ArregloProducto Coincidencias_P = new ArregloProducto();
		
		String searchTerm = nom;
		String regex = "\\b" + Pattern.quote(searchTerm) + "\\b";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		
		for(int i = 0; i < reference.Tamaño(); i++) {
			Matcher matcher = pattern.matcher(reference.Obtener(i).getNom());
			if(matcher.find()) Coincidencias_P.Adicionar(reference.Obtener(i));
		}
		if( Coincidencias_P.Tamaño() > 0) return Coincidencias_P;
		return null;
	}
	

	public ArrayList<Producto> getInventario() {
		return inventario;
	}
	public void setInventario(ArrayList<Producto> inventario) {
		this.inventario = inventario;
	}
	//Método Eliminar
	public void Eliminar(Producto x ) {
		inventario.remove(x);
	}
}
