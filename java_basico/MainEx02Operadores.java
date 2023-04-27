package java_basico;

public class MainEx02Operadores 
{

	public static void main(String[] args) 
	{
		//--------------------------------------------------------
		// Operadores aritm�ticos
		//--------------------------------------------------------
	    int int1 = 11;
		int int2 = 4;
		int resultInt;
		
		resultInt = int1 + int2;
	    System.out.println("Soma: " + resultInt);
	    
		resultInt = int1 - int2;
		System.out.println("Subtracao: " + resultInt);

		resultInt = int1 * int2;
		System.out.println("Multiplicacao: " + resultInt);

		resultInt = int1 / int2;
		System.out.println("Divisao: " + resultInt);
		
		resultInt = int1 % int2;
		System.out.println("Resto: " + resultInt + "\n");
	    
		
		float float1 = 11;
		float float2 = 4;
		float resultFloat;

		resultFloat = float1 + float2;
		System.out.println("Soma: " + resultFloat);
	    
		resultFloat = float1 - float2;
		System.out.println("Subtracao: " + resultFloat);

		resultFloat = float1 * float2;
		System.out.println("Multiplicacao: " + resultFloat);

		resultFloat = float1 / float2;
		System.out.println("Divisao: " + resultFloat);
		
		// OBS: Diferente de C, eh feito cast interno.
		resultFloat = float1 % float2;		
	    System.out.println("Resto: " + resultFloat + "\t\t Atencao! \n");
	    
		//--------------------------------------------------------
		// Operadores l�gicos
		//--------------------------------------------------------
		boolean A = true; 
		boolean B = false; 
		boolean resultBool;
		
		resultBool = (A || B)  &&  !(A && B);
		//		      V    F         V    F
		//               V 			   !F 		
		//				 V				V 
		//				         V 
	    System.out.println("resultBool: " + resultBool + "\n");
	    
	    
		//--------------------------------------------------------
		// Operadores relacionais
		//--------------------------------------------------------
	    boolean pai = true; // TRUE
	    boolean mae = false; // FALSE

	    if(pai != mae) { 
	    	System.out.println("Diferentes"); 
	    } 

	    if(pai == mae) {					// CUIDADO! N�O USAR APENAS = 
	    	System.out.println("Iguais"); 
	    } 
	        
	    if( !(pai == mae)  ) { 
	    	System.out.println("O operador ! inverte o resultado da expressao"); 
	    } 
	    
	    if(pai == true && mae == false) { 
	    	System.out.println("Com && (E) todos precisam ser TRUE para a expressao ser TRUE"); 
	    } 
	    
	    if(pai == true || mae == false) { 
	    	System.out.println("Com || (OU) somente um precisa ser TRUE para a expressao ser TRUE \n"); 
	    } 
	    

		//--------------------------------------------------------
		// Operadores de bitwise
		//--------------------------------------------------------
		int a = 5; 								// 0101 
		int b = 7; 								// 0111 				
									
		System.out.println("a     = " + exibirBits(4, a) ); 
		System.out.println("b     = " + exibirBits(4, b) ); 
		System.out.println("a | b = " + exibirBits(4, a | b) + "\n"); 	// 0111
		
		System.out.println("a     = " + exibirBits(4, a) ); 
		System.out.println("b     = " + exibirBits(4, b) ); 
		System.out.println("a & b = " + exibirBits(4, a & b) + "\n"); 	// 0101
		
		System.out.println("a     = " + exibirBits(4, a) ); 
		System.out.println("b     = " + exibirBits(4, b) ); 
		System.out.println("a ^ b = " + exibirBits(4, a ^ b) + "\n"); 	// 0010		XOR
		
		System.out.println(" a = " + exibirBits(32,  a) ); 
		System.out.println("~a = " + exibirBits(32, ~a) + "\n"); 		// // 1010
		
		
		int c = 64; 							
		
		System.out.println("c       = " + exibirBits(8, c) ); 		// 01000000 
		System.out.println("c << 1  = " + exibirBits(8, c << 1) ); 	// 10000000		Signed Left Shift
		System.out.println();
		
		System.out.println("c       = " + exibirBits(8, c) ); 		// 01000000 
		System.out.println("c >> 1  = " + exibirBits(8, c >> 1) ); 	// 00100000		Signed Right Shift 
		System.out.println();	
		
		System.out.println("c       = " + exibirBits(8, c) ); 			// 01000000 
		System.out.println("c >>> 1 = " + exibirBits(8, c >>> 1) ); 	// 00100000		Unsigned Right Shift
		System.out.println("\n");
		
		c = -64; 
		
		System.out.println("c       = " + exibirBits(32, c) ); 		// 11111111 11111111 11111111 11000000
		System.out.println("c << 1  = " + exibirBits(32, c << 1) ); 	// 11111111 11111111 11111111 10000000	Signed Left Shift
		System.out.println();
		
		System.out.println("c       = " + exibirBits(32, c) ); 		// 11111111 11111111 11111111 11000000 
		System.out.println("c >> 1  = " + exibirBits(32, c >> 1) ); 	// 11111111 11111111 11111111 11100000	Signed Right Shift 
		System.out.println();
		
		System.out.println("c       = " + exibirBits(32, c) ); 		 // 11111111 11111111 11111111 11000000 
		System.out.println("c >>> 1 = " + exibirBits(32, c >>> 1) ); // 01111111 11111111 11111111 11100000  Unsigned Right Shift 
		System.out.println();
		
		// ATENCAO: NAO EXISTE <<<	Unsigned Left Shift = Signed Left Shift
				
	}

	static String exibirBits(int bytes, int palavra)
	{
		String str = "";
		str = String.format("%"+bytes+"s", Integer.toBinaryString(palavra) );		
		str = str.replace(' ', '0');
		return str;
	}

	
	
}
