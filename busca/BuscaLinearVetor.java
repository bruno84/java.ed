package busca;

public class BuscaLinearVetor 
{	
	static <E> int buscaLinear(E chave, E vetor[])
	{
		for(int i=0; i<vetor.length; i++) 
		{
			if(vetor[i].equals(chave)) {
				return i;
			}
		}
		return -1;
	}
}
