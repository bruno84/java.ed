package java_basico;

import java.util.Scanner;

public class MainEx08Matrizes 
{
	private static Scanner in = new Scanner( System.in );
	
	public static void main(String[] args) 
	{
		int linhas = 2;
		int colunas = 3;
		
		int matriz[][] = new int[linhas][colunas]; 				// declaracao
		
		//int matriz[][] = { {1, 2, 3}, {4, 5, 6} };			// inicializacao
		
		System.out.println("\n Atribuicao direta...");
		matriz[0][0] = 10;    // Atribuicao direta 
		matriz[0][1] = 20;    // Atribuicao direta 
		matriz[0][2] = 30;    // Atribuicao direta 
		
		System.out.println("\n Imprimindo um por um...");
		System.out.println( matriz[0][0] );  	// Sera impresso 10
		System.out.println( matriz[0][1] );  	// Sera impresso 20
		System.out.println( matriz[0][2] );		// Sera impresso 30
		
		System.out.println("\n Imprimindo com loop...");
		exibirMatriz(matriz);
		
		
		System.out.println("\n\n Atribuicao pelo teclado...");
		
		System.out.print("Elemento 0: ");
		matriz[0][0] = in.nextInt();	// Atribuicao por dispositivo de entrada 
		
		System.out.print("Elemento 1: ");
		matriz[0][1] = in.nextInt();	// Atribuicao por dispositivo de entrada 
		
		System.out.println("\n Imprimindo com loop...");
		exibirMatriz(matriz);
		
		
		System.out.println("\n\n Atribuicao com loop...");
		for (int l=0; l<linhas; l++) 
			for (int c=0; c<colunas; c++) {
				matriz[l][c] = l + c;
		}
		
		System.out.println("\n Imprimindo com loop...");
		exibirMatriz(matriz);	
	}
	
	
	private static void exibirMatriz(int[][] m) 
	{
		int linhas = m.length;
		System.out.println("linhas = " + linhas);
		
		int colunas = m[0].length;
		System.out.println("colunas = " + colunas);
				
		for (int l=0; l<linhas; l++) 
		{
			System.out.println();
			
			for (int c=0; c<colunas; c++) {
				System.out.print(m[l][c] + "\t");
			}
		}
	}
	
	

}
