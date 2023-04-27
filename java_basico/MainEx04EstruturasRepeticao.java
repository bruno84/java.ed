package java_basico;

import java.util.Scanner;

public class MainEx04EstruturasRepeticao 
{
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		System.out.print("Qual o valor inicial: "); 
		int vi = in.nextInt(); 
	    System.out.print("Qual o valor final: "); 
	    int vf = in.nextInt();
	 
	    
	    System.out.println("\n\n WHILE - CONTADOR"); 
	 	int cont = vi;
	 
	    while( cont <= vf ) 
	    {      
	        System.out.print(" " + cont); 
	        cont++; 
	    } 
	    
	    
	    System.out.println("\n\n DO-WHILE - CONTADOR"); 
	    cont = vi;
	    
	    do 
	    {
	    	System.out.print(" " + cont); 
	        cont++; 
	    } 
	    while( cont <= vf );
	    
	    
	    System.out.println("\n\n FOR - CONTADOR");
	    for(cont = vi; cont <= vf; cont++)
	    {
	    	System.out.print(" " + cont); 
	    }
	    
	    System.out.print("\n" + cont + "\n"); 
	}

}
