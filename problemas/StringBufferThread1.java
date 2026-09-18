package problemas;

/*
Exemplo do consumo de uma String por duas threads.
OBS: usa-se lambda para especificar o metodo run() de Runnable (entrada do construtor de Thread).
OBS: troque StringBuffer (thread-safe) por StringBuilder para ver a consequencia.
 */
public class StringBufferThread1 
{
	public static void main(String[] args) 
	{
        StringBuffer buffer = new StringBuffer();
        //StringBuilder buffer = new StringBuilder(); // Resultado imprevisível

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                buffer.append("A");
                //System.out.println("A");
                //A linha acima deixa a thread lenta, dando ilusão de sincronismo mesmo com StringBuilder
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                buffer.append("B");
                //System.out.println("B");
                //A linha acima deixa a thread lenta, dando ilusão de sincronismo mesmo com StringBuilder
            }
        });

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

        System.out.println(buffer.length());
    }
}