package java_basico;

public class MainEx06Recursividade 
{
	private static final int TIME = 1000;
	
	public static void main(String[] args) 
	{
		System.out.println("\n REGRESSIVIDADE EX1 \n");
		regressiva(4); 
		
		System.out.println("\n REGRESSIVIDADE EX2 \n");
		double fat = fatorial(5);
		System.out.println("Fatorial = " + fat );
	}

	private static void regressiva(int n)
	{
	     if (n == 0) // Condicao de parada
	     {
	         System.out.println("PAROU!");
	     }
	     else
	     {
	    	 sleep(TIME);
	         System.out.printf("Empilhando... %d \n", n);
	         
	         regressiva(n-1);   // chamada recursiva
	         
		     sleep(TIME);
		     System.out.printf("Desempilhando... %d \n", n);
	     }
	}
	
	
	private static double fatorial(int n)
	{
	    double fat;

	    if(n == 0)
	    {
	    	System.out.println("PAROU!");
	        fat = 1;
	    }
	    else
	    {
	    	sleep(TIME);
	    	System.out.printf("Empilhando... %d \n", n);
	    	
	        fat = n * fatorial(n-1);
	        
	        sleep(TIME);
	        System.out.printf("Desempilhando... %d \n", n);
	        System.out.printf("fat = %f \n", fat);
	    }

	    return fat;
	}
	
	
	private static void sleep(int ms)
	{
		try { 
			Thread.sleep(ms); 
		} catch (InterruptedException ex) {}
	}
	
}
