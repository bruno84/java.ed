package busca;

public class BuscaBinariaVetor 
{	
	static <E extends Comparable<E>> int buscaBinaria(E chave, E vetor[])
	{
		int meio, ini = 0;
		int fim = vetor.length-1;
		int comp = 0;
		
		while (ini <= fim)
		{
			meio = (ini + fim) / 2;
			comp = chave.compareTo(vetor[meio]);
			
			if(comp == 0) {
				return meio;
			}
			if (comp == -1) {
				fim = meio - 1;
			}
			if(comp == 1) {
				ini = meio + 1;
			} 
		}
		return -1;
	}
	

}
