package java_basico;

import java.util.Scanner;

public class MainEx07Vetores 
{
	private static Scanner in = new Scanner( System.in );
	
	public static void main(String[] args) 
	{
		int size = 5;
		int vetor[] = new int[size]; 				// declaracao
		
		//int vetor[] = {10, 20, 30, 40, 50};		// inicializacao
		
		System.out.println("\n Atribuicao direta...");
		vetor[0] = 10;    // Atribuicao direta 
		vetor[1] = 20;    // Atribuicao direta 
		vetor[2] = 30;    // Atribuicao direta 
		
		System.out.println("\n Imprimindo um por um...");
		System.out.println( vetor[0] );  	// Sera impresso 10
		System.out.println( vetor[1] );  	// Sera impresso 20
		System.out.println( vetor[2] );		// Sera impresso 30
		
		System.out.println("size = " + size);
				
		System.out.println("\n Imprimindo com loop...");
		exibirVetor(vetor);
		
		
		System.out.println("\n\n Atribuicao pelo teclado...");
		
		System.out.print("Elemento 0: ");
		vetor[0] = in.nextInt();	// Atribuicao por dispositivo de entrada 
		
		System.out.print("Elemento 1: ");
		vetor[1] = in.nextInt();	// Atribuicao por dispositivo de entrada 
		
		System.out.println("\n Imprimindo com loop...");
		exibirVetor(vetor);
		
		
		System.out.println("\n\n Atribuicao com loop...");
		for (int i=0; i<size; i++) {
			vetor[i] = i;
		}
		
		System.out.println("\n Imprimindo com loop...");
		exibirVetor(vetor);	
		
		
		System.out.println("\n ATENCAO: Copiar de vetor???");
		int vetorCopia[] = vetor;
		
		System.out.println(vetor);
		System.out.println(vetorCopia);
		
		vetorCopia[0] = 9999; 
		
		System.out.println("\n Imprimindo com loop... vetor");
		exibirVetor(vetor);
		
		System.out.println("\n Imprimindo com loop... vetorCopia");
		exibirVetor(vetorCopia);
	}

	
	private static void exibirVetor(int[] v) 
	{
		int size = v.length;
		
		for (int i=0; i<size; i++) {
			System.out.print(v[i] + " ");
		}
	}
	

}
