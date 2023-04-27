package problemas;

public class SomatorioFatorial 
{	
	static int somatorioRecursivo(int n)
	{
		if(n == 0) {
			return 0;
		}
		else {
			return n + somatorioRecursivo(n-1);
		}
	}
	
	static double fatorialIterativo(int n)
	{
		double fat = 1;
		
		for(int i=1; i<=n; i++)
		{
			fat = fat * i;
		}
		return fat;
	}
	
	public static void main(String[] args) 
	{	
		int n = 5;
		System.out.println( somatorioRecursivo(n) ); 
		System.out.println( fatorialIterativo(n) ); 
	}
}