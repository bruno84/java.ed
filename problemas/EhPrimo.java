package problemas;

public class EhPrimo 
{

	public static void main(String[] args) 
	{
		
		System.out.println( proxPrimo(38) );
		
	}
	
	public static int proxPrimo(int n)
	{
		int primo = n;
		
		while( ehPrimo(primo) == false ) {
			primo++;
		}
		
		return primo;
	}
	
	public static boolean ehPrimo(int n) 
	{
	    for(int i = 2; i < n; i++) {
	        if(n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}

}
