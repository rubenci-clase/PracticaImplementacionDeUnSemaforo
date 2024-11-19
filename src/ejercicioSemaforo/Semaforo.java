package ejercicioSemaforo;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Semaforo {

    static class Tarea implements Runnable {
        private String nombre;
        private Semaphore semaforo;
        public RecursoCompartido r;

        Random random = new Random();

        public Tarea(String nombre, Semaphore semaforo, RecursoCompartido r) {
            this.nombre = nombre;
            this.semaforo = semaforo;
            this.r=r;
        }

    	public void restar() {
    		long startTime = System.currentTimeMillis();
    		
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		int restar = random.nextInt(1,10);
    		r.restarCantidad(restar, this.nombre, startTime);
    	}
        
        @Override
        public void run() {
            try {
                semaforo.acquire(); // Solicita un permiso

                this.restar();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Siempre liberamos el permiso en el bloque finally
                semaforo.release();
            }
        }
        

    }
}