package problemas;

import filas.MyInterfaceQueue;
import filas.MyQueueArray;

public class FilaDistanciaCidades 
{

	public static void main(String[] args) 
	{
		// FILA
		MyInterfaceQueue<Integer> fila = new MyQueueArray<Integer>(6);
	    
		// ENTRADA:
		int qtdCidades = 6;
		
		int cidades[][] = { {0,	3,	0,	0,	0,	0},
					 	    {0,	0,	1,	0,	0,	0},
					 	    {0,	0,	0,	0,	1,	0},
					 	    {0,	0,	2,	0,	1,	0},
					 	    {1,	0,	0,	0,	0,	0},
					 	    {0,	1,	0,	0,	0,	0} };
				 	    
		int cidadeInicial = 3; 
		
		// SAIDA:
		int distancias[] = new int[qtdCidades];
		
		for (int j = 0; j < qtdCidades; ++j) {
			distancias[j] = -1;
		}
		
		distancias[cidadeInicial] = 0;
				
		fila.add(cidadeInicial);
	
		int cidadeAtual, distancia;
		
		// Enquanto fila não for vazia
		while ( fila.isEmpty() == false ) 
		{
			cidadeAtual = fila.remove();
			
			// Percorrer cidades
			for (int cidadeVisitada = 0; cidadeVisitada < qtdCidades; cidadeVisitada++) 
			{
				distancia = cidades[cidadeAtual][cidadeVisitada];
				
				if (distancia > 0 && distancias[cidadeVisitada] == -1) 
				{
					distancias[cidadeVisitada] = distancias[cidadeAtual] + distancia;

					fila.add( cidadeVisitada );
				}
			}
		}

		System.out.println("\nDistancias: ");
		for (int i=0; i < qtdCidades; ++i) {
			System.out.println( distancias[i] + " ");
		}

	}

}
