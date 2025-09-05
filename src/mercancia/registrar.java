package mercancia;

public class registrar {
private String nombre;
private int cod ;
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getCod() {
	return cod;
}
public void setCod(int cod) {
	this.cod = cod;
}
public registrar(String nombre, int cod) {
	this.nombre = nombre;
	this.cod = cod;
}

}
