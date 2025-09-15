package mercancia;

import java.util.ArrayList;


public class ArregloProducto {
	private ArrayList<Producto>producto;
	
	public ArregloProducto() {
		producto = new ArrayList<Producto>();
		
	}
	
	public void Adicionar( Producto x ) {
		producto.add(x);
	}
	
	public int Tamaño() {
		return producto.size();
	}
	
	public Producto Obtener(int x) {
		return producto.get(x);
	}
	
	
	public Producto Buscar (int cod) {
		for(int i = 0; i <Tamaño(); i++) {
			if(Obtener(i).getCod()== cod) return Obtener(i);
		}
		return null;
	}
	
	public void Eliminar(Producto x ) {
		producto.remove(x);
	}
}
