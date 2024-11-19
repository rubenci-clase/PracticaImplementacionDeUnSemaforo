package ejercicioSemaforo;

public class RecursoCompartido {

	public int cantidad;
	
	public RecursoCompartido(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public synchronized void restarCantidad(int recursoEliminado, String nombre, long startTime) {
		cantidad -= recursoEliminado;
		long endTime = System.currentTimeMillis()-startTime;
		System.out.print("\n" + nombre + " Cantidad restada:" + recursoEliminado + " cantidad total:" + cantidad + " Tiempo tardado:" + endTime);
	}
	
	public synchronized int getCantidad() {
		return cantidad;
	}
}
