package matriz_esparsa;

public class Main {

	public static void main(String[] args) 
	{		
		Double matriz[][] = { {null, 0.0  , 1.0 , 0.0 } , {0.0 , 2.0 , 0.0, 3.0} , {4.0, 0.0, null, 5.0} }; 
		MatrizEsparsa.show(matriz);	
		System.out.println( MatrizEsparsa.isSparse(matriz) );	
	}


}
