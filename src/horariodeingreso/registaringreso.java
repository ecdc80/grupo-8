package horariodeingreso;

public class registaringreso {
	private double monto;
    private String descripcion;
    private int Dia ,fecha ;
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getDia() {
		return Dia;
	}
	public void setDia(int dia) {
		Dia = dia;
	}
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	public registaringreso(double monto, String descripcion, int dia, int fecha) {
		super();
		this.monto = monto;
		this.descripcion = descripcion;
		Dia = dia;
		this.fecha = fecha;
	}
    
}


    


