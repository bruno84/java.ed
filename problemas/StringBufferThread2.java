package problemas;

public class StringBufferThread2 
{	
	public static void main(String[] args) 
	{
        StringBuffer str = new StringBuffer();

        MinhaThread t1 = new MinhaThread(str, "A");
        MinhaThread t2 = new MinhaThread(str, "B");

        // Inicia as threads
        t1.start();
        t2.start();
        
        try {
        	//Aguarda as threads terminarem para dar continuidade
        	t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        System.out.println(str.length());
    }
}

class MinhaThread extends Thread 
{
    private StringBuffer str;
    private String texto;

    public MinhaThread(StringBuffer strP, String textoP) {
        this.str = strP;
        this.texto = textoP;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            str.append(texto);
        }
    }
}