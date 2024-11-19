package ejer1;

public class Raton implements Runnable{
    private String nombre;
    private int tiempoAlimentacion;

    public Raton(String nombre, int tiempoAlimentacion) {
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    private void comer () throws InterruptedException{
        long startTime = System.currentTimeMillis();
        System.out.println("El Raton ha comenzado a alimentarse");
        Thread.sleep(tiempoAlimentacion * 100);
        long endTime = System.currentTimeMillis()-startTime;
        System.out.printf("El Raton %s ha terminado de alimentarse y ha necesitado %s milisegundos \n", nombre, endTime);

    }

    @Override
    public void run() {
        try {
            this.comer();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }





}
