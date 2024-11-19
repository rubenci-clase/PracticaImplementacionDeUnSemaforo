package ejercicioSemaforo;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import ejercicioSemaforo.Semaforo.Tarea;

public class Principal {
	
	static int total = 1000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
    	Scanner entrada = new Scanner(System.in);
    	RecursoCompartido r = new RecursoCompartido(1000);
    	
    	System.out.println("Introduce el numero de hilos simultaneos");
    	int hilosSimultaneos = entrada.nextInt();
    	
    	System.out.println("Introduce el numero de hilos totales");
    	int cantidadDeHilos = entrada.nextInt();
    	
	    Semaphore semaforo = new Semaphore(hilosSimultaneos); // Inicializamos el semáforo
    	
    	Thread [] listaHilos = new Thread[cantidadDeHilos];
        
        for (int i = 0; i < cantidadDeHilos; i++) {
        	listaHilos[i]  = new Thread(new Tarea("Hilo " + i, semaforo, r));
        }
        
        for (int j = 0; j < cantidadDeHilos; j++) {
        	listaHilos[j].start();
        }

	}
	


}
