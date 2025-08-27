package java_basico;

public class MainEx02Operadores 
{

	public static void main(String[] args) 
	{
		//--------------------------------------------------------
		// Operadores aritmeticos
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
		// Operadores logicos
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

	    if(pai == mae) {					// CUIDADO! NAO USAR APENAS = 
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
		int r;
		
		r = a & b;
		System.out.println("a     = " + exibirBits(32, a) ); 		// ...00000101
		System.out.println("b     = " + exibirBits(32, b) ); 		// ...00000111
		System.out.println("a & b = " + exibirBits(32, r) + "\n"); 	// ...00000101	AND
		
		r = a | b;
		System.out.println("a     = " + exibirBits(32, a) ); 		// ...00000101
		System.out.println("b     = " + exibirBits(32, b) ); 		// ...00000111 
		System.out.println("a | b = " + exibirBits(32, r) + "\n"); 	// ...00000111	OR
		
		r = a ^ b;
		System.out.println("a     = " + exibirBits(32, a) ); 		// ...00000101
		System.out.println("b     = " + exibirBits(32, b) ); 		// ...00000111
		System.out.println("a ^ b = " + exibirBits(32, r) + "\n"); 	// ...00000010	XOR
		
		r = ~a;
		System.out.println(" a = " + exibirBits(32, a) ); 			// ...00000101
		System.out.println("~a = " + exibirBits(32, r) + "\n"); 	// ...11111010	NOT
		
		
		a = 8; 							
		
		r = a << 1;
		System.out.println("a       = " + exibirBits(32, a) ); 	// ...00001000
		System.out.println("a << 1  = " + exibirBits(32, r) ); 	// ...00010000	Signed Left Shift
		System.out.println(r);									// 16
		System.out.println();
		
		r = a >> 1;
		System.out.println("a       = " + exibirBits(32, a) ); 	// ...00001000
		System.out.println("a >> 1  = " + exibirBits(32, r) ); 	// ...00000100	Signed Right Shift 
		System.out.println(r);									// 4
		System.out.println();	
		
		r = a >>> 1;
		System.out.println("a       = " + exibirBits(32, a) ); 	// ...00001000 
		System.out.println("a >>> 1 = " + exibirBits(32, r) ); 	// ...00000100	Unsigned Right Shift
		System.out.println(r);									// 4
		System.out.println("\n");
		
		
		a = -64; 
		
		r = a << 1;
		System.out.println("a       = " + exibirBits(32, a) );	// 11111111111111111111111111000000
		System.out.println("a << 1  = " + exibirBits(32, r) ); 	// 11111111111111111111111110000000	Signed Left Shift
		System.out.println(r);									// -128
		
		r = a >> 1;
		System.out.println("a       = " + exibirBits(32, a) );	// 11111111111111111111111111000000 
		System.out.println("a >> 1  = " + exibirBits(32, r) );	// 11111111111111111111111111100000	Signed Right Shift 
		System.out.println(r);									// -32
		System.out.println();									// OBS: se entrada negativa, retorna numero negativo, 
																// 		pois conserva o bit mais significativo (sinal)
		
		r = a >>> 1;
		System.out.println("a       = " + exibirBits(32, a) ); 	// 11111111111111111111111111000000 
		System.out.println("a >>> 1 = " + exibirBits(32, r) );	// 01111111111111111111111111100000  Unsigned Right Shift 
		System.out.println(r);									// 2147483616
		System.out.println();									// OBS: se entrada negativa, retorna numero positivo, 
																// 		pois nao conserva o bit mais significativo (sinal) 
				
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
