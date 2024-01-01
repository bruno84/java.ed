package java_diversos;

import java.util.HashSet;
import java.util.Set;

public class EvitarRepeticao 
{	
	static Integer[] limpar(int[] entrada)
	{
		Set<Integer> conjunto = new HashSet<Integer>();
		
		for (int i = 0; i < entrada.length; i++) {
			conjunto.add( entrada[i] );			
		}
				
		Integer[] saida = new Integer[conjunto.size()];
		saida = conjunto.toArray(saida);

		return saida;
	}
	
	public static void main(String[] args) 
	{	
		int vetor1[] = {1, 3, 5, 1, 5};
		Integer[] vetor2 = limpar(vetor1);
		
		for (int i = 0; i < vetor2.length; i++) {
			System.out.println(vetor2[i] + " ");
		}
	}
}