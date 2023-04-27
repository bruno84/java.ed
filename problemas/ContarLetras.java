package problemas;

public class ContarLetras 
{	
	static class Letra 
	{
		char letra;
		int qtd;
		
		@Override
		public String toString() {
			return "Letra [letra=" + letra + ", qtd=" + qtd + "]";
		}
	}
	
	public static void main(String[] args) 
	{
		String palavra = "casa";
		int size = palavra.length();
		
		Letra[] dicionario = new Letra[size];
		int indexDic = 0;
		
		// Percorre palavra
		for (int i = 0; i < size; i++) 
		{
			char letra = palavra.charAt(i);
			
			// Procura no dicionario
			int indexLetra = -1;
			for (int j = 0; j < size; j++) 
			{
				if(dicionario[j] != null && dicionario[j].letra == letra) {
					indexLetra = j;
					break;
				}
			}
			
			if(indexLetra == -1) 
			{
				// Adiciona
				dicionario[indexDic] = new Letra();
				dicionario[indexDic].letra = letra;
				dicionario[indexDic].qtd = 1;
				indexDic++;
			}
			else 
			{
				// Atualiza
				dicionario[indexLetra].qtd++;
			}	
		}
		
		// Resultado:
		for (int i = 0; i < indexDic; i++) {
			System.out.println(dicionario[i]);
		}	
	}
}