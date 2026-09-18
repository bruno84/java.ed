package problemas;

import java.util.HashMap;
import java.util.Map;

public class ContarLetrasMap
{
	public static void main(String[] args) 
	{
		// Entrada:
		String palavra = "casacaiada";

		// Inicializa dicionario:
		int size = palavra.length();
		Map<Character, Integer> dicionario = new HashMap(size);

		// Percorre palavra
		for (int i = 0; i < size; i++) 
		{
			char letra = palavra.charAt(i);

			dicionario.put(letra, dicionario.getOrDefault(letra, 0) + 1);
		}
		
		// Resultado:
		for (Map.Entry<Character, Integer> entry : dicionario.entrySet()) {
			System.out.println(entry);
		}	
	}
}