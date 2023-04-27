package problemas;

public class ContarPalavras 
{
	static class Palavra
	{
	    String palavra = "";
	    int cont = 0;
	}
	
	public static void main(String[] args) 
	{
	    // Entrada de dados:
		String frase = "bola casa bola";	
	    
		// Separar e contar palavras:
	    String[] arrayPalavras = frase.split(" ");
	    int sizePalavras = arrayPalavras.length;
	    System.out.println("sizePalavras = " + sizePalavras);
	    
	    // Inicializo dicionario
	    Palavra dicionario[] = new Palavra[sizePalavras];
	    for(int i=0; i < sizePalavras; i++) {
	    	dicionario[i] = new Palavra();
	    }
	    
	    // Variaveis de controle
	    boolean flagExiste = false;
	    int iExiste=0;	// indice da palavra encontrada
	    int iNova=0;	// indice da palavra nova
	    
	    // PERCORRER CADA PALAVRA DA FRASE:
	    for(int p=0; p < sizePalavras; p++)
	    {
	    	// Palavra atual
	    	String palavra = arrayPalavras[p];
	    	
            // PROCURAR NA ESTRUTURA SE JA EXISTE palavra
            flagExiste = false;
            
            for(iExiste=0; iExiste<sizePalavras; iExiste++)
            {
                if( dicionario[iExiste].palavra.equals(palavra) == true ) 
                {
                    flagExiste = true;
                    break;
                }
            }

            if(flagExiste == true)
            {
                // Incrementar o cont
                dicionario[iExiste].cont++;
            }
            else
            {
                // Palavra nova, ent�o adiciona	
            	dicionario[iNova].palavra = palavra;
                dicionario[iNova].cont = 1;
                iNova++;
            }
	    }

	    // Imprimir a lista desordenada
	    for(int i=0; i<iNova; i++) {
	        System.out.println(dicionario[i].palavra + " : " + dicionario[i].cont);
	    }

	    // Organizar a lista

	    // Imprimir a lista ordenada
	}

}
