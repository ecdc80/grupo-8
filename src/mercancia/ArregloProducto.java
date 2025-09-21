package mercancia;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.MessageFormat;


public class ArregloProducto{

	private ArrayList<Producto>inventario;
	
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
	
	
	public Producto Buscar (int cod) {
		
		for(int i = 0; i <Tamaño(); i++) {
			if(Obtener(i).getCod()== cod) return Obtener(i);
		}
		return null;
	}
	

	
	public void Eliminar(Producto x ) {
		inventario.remove(x);
	}
}
