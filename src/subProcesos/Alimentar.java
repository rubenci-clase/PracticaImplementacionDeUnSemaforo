package subProcesos;

public class Alimentar {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        alimentarSecuencial();
        alimentarEnParalelo();

    }

    private static void alimentarSecuencial() {
        new Raton("raton1", 4).run();
        new Raton("raton1", 8).run();
    }
    
    private static void alimentarEnParalelo(){
        Raton raton1 = new Raton("raton1", 4);
        Raton raton2 = new Raton("raton1", 8);

        Thread hilo1 = new Thread(raton1::run);
        Thread hilo2 = new Thread(raton2::run);
        
        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
