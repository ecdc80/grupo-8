package mercancia;

import java.util.ArrayList;



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
	
	public Boolean BuscarCodigo (int cod) {
		for(int i = 0; i <Tamaño(); i++) {
			if(Obtener(i).getCod()== cod) return true;
		}
		return false;
	}
	
	public void Eliminar(Producto x ) {
		inventario.remove(x);
	}
}
