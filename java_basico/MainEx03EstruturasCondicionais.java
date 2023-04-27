package java_basico;

import java.util.Scanner;

public class MainEx03EstruturasCondicionais 
{
	private static Scanner in = new Scanner(System.in);
			
	public static void main(String[] args) 
	{
	    System.out.print("Qual a media? "); 
	    float media = in.nextFloat(); 
	 
	    // IF SIMPLES
	    if(media >= 7) {
	    	System.out.println("Aprovado");
	    }
	    else {
	    	System.out.println("Recuperacao ou Reprovado?");
	    }

	    System.out.println("");
	    
	    
	    // IF SIMPLES. OBS: else eh opcional
	    if(media >= 7) {
	    	System.out.println("Aprovado");
		}
	    System.out.println("");
	    
	    
	    // IF COMPOSTO
	    if(media >= 7) { 
	    	System.out.println("Aprovado"); 
	    } 
	    else 
	    {
	    	System.out.println("Recuperacao ou Reprovado?");
	    	
	        if(media >= 3.5) {
	        	System.out.println("Recuperacao"); 
		    } 
		    else { 
		    	System.out.println("Reprovado");  
		    }
	    }
	    System.out.println("");
	    
	    
	    // IF COMPOSTO COMPACTO
	    if(media >= 7) { 
	    	System.out.println("Aprovado"); 
	    } 
	    else if(media >= 3.5) {
	        System.out.println("Recuperacao"); 
	    } 
		else { 
		    System.out.println("Reprovado");  
		}   
	    System.out.println("");
	    
	    
	    // OPERADOR CONDICIONAL TERNARIO
	    String str = (media >= 7) ? "Aprovado" : "Recuperacao ou Reprovado";
	    System.out.println("str = " + str + "\n");
	    
	    
	    // SWITCH-CASE
	    System.out.print("Digite um numero da sorte: "); 
	    int numero = in.nextInt(); 

	    switch ( numero )
	    {
	       case   4 : 
	       case  13 : 
		   case  17 : System.out.println("Dizem que 4, 13 e 17 dao azar  \n"); 
		   			  break;
	       
		   case   7 : System.out.println("Dizem que 7 da sorte \n");
		   			  System.out.println("Mas nao acredito nessas coisas! \n"); 
		   			  break;
	       
		   default : System.out.println("Nao sei nada sobre esse numero \n");
	                 break;
	    }  
	    
	    
	 	// SWITCH-CASE	OBS: com string funciona a partir do Java 7.
	    System.out.print("Digite um nome: "); 
	    str = in.next(); 
	    
	    switch ( str )
	    {
	       case "Bruno" : System.out.println("Bonito nome!"); break;
	       case "Tiago" : System.out.println("Nome muito comum!"); break;
		   default : System.out.println("Nao sei nada sobre esse nome \n"); break;
	    }  
	    
	}

}
