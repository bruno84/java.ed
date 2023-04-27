package java_basico;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class MainEx01TiposEntradaSaida 
{
	private static Scanner scanner = new Scanner( System.in ); 
	
	public static void main(String[] args) 
	{	
		// OBS: Se quiser alterar o padrao do pais (ex: ponto ou virgula para o decimal)
		scanner.useLocale(Locale.US);
		
		// OBS: Sem a linha abaixo, numeros teriam virgula (conforme OS).
		Locale.setDefault(Locale.US);
		
		// OBSERVACOES:
		// Java nao tem tipos primitivos unsigned. 
		
		//-------------------------------------------------------------
		// BYTE
		//-------------------------------------------------------------
		System.out.print("Informe um byte: ");
		byte numByte = scanner.nextByte();
		System.out.println("numByte = " + numByte);
		
		// Converte para string na base 2:
		String strByte1 = Integer.toBinaryString(numByte);
		System.out.println("binary1: " + strByte1);
		
		// Converte para string na base 2, com 8 chars:
		String strByte2 = String.format("%8s", Integer.toBinaryString(numByte) );
		System.out.println("binary2: " + strByte2);
		
		// Converte para string na base 2, com 8 chars, susbtituindo os chars em branco com 0:
		strByte2 = strByte2.replace(' ', '0');
		System.out.println("binary3: " + strByte2);
		
		// Pode-se usar o printf no padrao da linguagem C em vez do println que � mais usado em Java.
		System.out.printf("bytes = %d , min = %d , max = %d \n\n", 
				Byte.BYTES, Byte.MIN_VALUE, Byte.MAX_VALUE);
		
		//-------------------------------------------------------------
		// SHORT
		//-------------------------------------------------------------
		System.out.print("Informe um short: ");
		short numShort = scanner.nextShort();
		System.out.println("numShort = " + numShort);
		System.out.printf("bytes = %d , min = %d , max = %d \n\n", 
				Short.BYTES, Short.MIN_VALUE, Short.MAX_VALUE);
		
		//-------------------------------------------------------------
		// INT
		//-------------------------------------------------------------
		System.out.print("Informe um int: ");
		int numInt = scanner.nextInt();
		System.out.println("numInt = " + numInt);
		System.out.printf("printf = %d \n", numInt);
		
		strByte1 = Integer.toBinaryString(numInt);
		System.out.println("binary1: " + strByte1);
		
		// OBS: FF FF FF FF representa uma palavra de 4 bytes em hexadecimal
		strByte2 = String.format("%32s", Integer.toBinaryString(numInt & 0xFFFFFFFF) );
		System.out.println("binary2: " + strByte2);
		
		strByte2 = strByte2.replace(' ', '0');
		System.out.println("binary3: " + strByte2);
		
		System.out.printf("bytes = %d , min = %d , max = %d \n\n", 
				Integer.BYTES, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		//-------------------------------------------------------------
		// LONG
		//-------------------------------------------------------------
		System.out.print("Informe um long: ");
		long numLong = scanner.nextLong();
		System.out.println("numLong = " + numLong);
		System.out.printf("printf = %d \n", numLong);
		
		System.out.printf("bytes = %d , min = %d , max = %d \n\n", 
				Long.BYTES, Long.MIN_VALUE, Long.MAX_VALUE);
		
		//-------------------------------------------------------------
		// FLOAT
		//-------------------------------------------------------------
		System.out.print("Informe um float: ");
		float numFloat = scanner.nextFloat();
		System.out.println("numFloat = " + numFloat);
		System.out.printf("printf1 = %f \n", numFloat);
		System.out.printf("printf2 = %.2f \n", numFloat);
		System.out.printf("printf3 = %e \n", numFloat);
		
		DecimalFormat df = new DecimalFormat("#.###"); 
		String strFloat = df.format(numFloat); 
		System.out.println("strFloat = " + strFloat); 
		
		System.out.printf("bytes = %d , min = %e , max = %e \n\n", 
				Float.BYTES, Float.MIN_VALUE, Float.MAX_VALUE);

		//-------------------------------------------------------------
		// DOUBLE
		//-------------------------------------------------------------
		System.out.print("Informe um double: ");
		double numDouble = scanner.nextDouble();
		System.out.println("numDouble = " + numDouble);
		
		System.out.printf("bytes = %d , min = %e , max = %e \n\n", 
				Double.BYTES, Double.MIN_VALUE, Double.MAX_VALUE);
		
		scanner.nextLine(); // limpa buffer (enter)
		
		// OBS: range do double: 1.7976931348623157 x 10+308, 4.9406564584124654 x 10-324
		
		//-------------------------------------------------------------
		// CHAR (forma1)
		//-------------------------------------------------------------
		System.out.print("Informe um char1: ");
		char ch = ' ';
		try {
			ch = (char)System.in.read();
			System.out.println("char1 = " + ch);
			System.out.printf("printf = %c \n\n", ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		scanner.nextLine(); // limpa buffer (enter)
		
		//-------------------------------------------------------------
		// CHAR (forma2)
		//-------------------------------------------------------------
		System.out.print("Informe um char2: ");
		ch = scanner.next().charAt(0);
		System.out.println("char2 = " + ch + "\n");
				
		//-------------------------------------------------------------
		// BOOLEAN
		//-------------------------------------------------------------
		System.out.print("Informe um boolean (true ou false): ");
		boolean bool1 = scanner.nextBoolean();
		System.out.println("bool1 = " + bool1);
		System.out.printf("printf = %b \n\n", bool1);		
		
		scanner.nextLine(); // limpa buffer (enter)
		
		//-------------------------------------------------------------
		// STRING (sem espaco)
		//-------------------------------------------------------------
		System.out.print("Informe seu primeiro nome: ");
		String str1 = scanner.next();
		System.out.println("str1 = " + str1);
		System.out.printf("printf = %s \n\n", str1);
		
		scanner.nextLine(); // limpa buffer (enter)
		
		//-------------------------------------------------------------
		// STRING (com espaco)
		//-------------------------------------------------------------
		System.out.print("Informe seu nome completo: ");
		String str2 = scanner.nextLine();
		System.out.println("str2 = " + str2);
		System.out.printf("printf = %s \n\n", str2);
	}

}
