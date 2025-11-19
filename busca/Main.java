package busca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import busca.BuscaBinariaArvore.Node;

public class Main 
{
	public static void main(String[] args)
	{
	    int vi = 1;		// valor mínimo
	    int vf = 100_000_000;	// valor máximo
		int size = vf - vi + 1;
		Integer key = 9_000_000;
		boolean flagShow = false;
		
		System.out.println("size: " + size);
		
		System.out.println("Entrada Vetor: ");
		//Integer[] array = gerarVetorAleatorio(vi, vf);
		Integer[] array = gerarVetorCrescente(vi, vf);
		
		System.out.println("Entrada Arvore: ");
		BuscaBinariaArvore<Integer> arvore1 = new BuscaBinariaArvore<Integer>();
		gerarArvoreAleatoria(arvore1, vi, vf);
		
		if( flagShow ) exibirVetor(array);
		if( flagShow ) arvore1.print();
		
		System.out.println("\n BuscaLinear processando ... ");
		long t1 = System.currentTimeMillis();
		int result = BuscaLinearVetor.buscaLinear( key, array);
		long t2 = System.currentTimeMillis();
		System.out.println("result = " + result);
		System.out.println("BuscaLinear  tempo: " + (t2-t1) + " ms");
		
		System.out.println("\n BuscaBinariaVetor processando ... ");
		t1 = System.currentTimeMillis();
		result = BuscaBinariaVetor.buscaBinaria( key, array);
		t2 = System.currentTimeMillis();
		System.out.println("result = " + result);
		System.out.println("BuscaBinaria  tempo: " + (t2-t1) + " ms");
		
		System.out.println("\n BuscaBinariaArvore processando ... ");
		t1 = System.currentTimeMillis();
		Node node = arvore1.search( key );
		t2 = System.currentTimeMillis();
		System.out.println("result = " + node.key);
		System.out.println("BuscaBinaria  tempo: " + (t2-t1) + " ms");
		
		
		
	}
	
	
	private static Integer[] gerarVetorCrescente(int vi, int vf)
	{
		int size = vf - vi + 1;
		Integer[] array = new Integer[size];
  
        List<Integer> list = new ArrayList<Integer>();  
        
        for (int i = vi; i <= vf; i++) {
            list.add(i); 
        }   
                
        // list para array  
        for (int i = 0; i < size; i++) {  
        	array[i] = list.get(i);
        } 

	    return array;
	}
	
	private static Integer[] gerarVetorAleatorio(int vi, int vf)
	{
		int size = vf - vi + 1;
		Integer[] array = new Integer[size];
  
        List<Integer> list = new ArrayList<Integer>();  
        
        for (int i = vi; i <= vf; i++) {
            list.add(i); 
        }  
          
        // embaralhar  
        Collections.shuffle(list);  
                
        // list para array  
        for (int i = 0; i < size; i++) {  
        	array[i] = list.get(i);
        } 

	    return array;
	}
	
	
	private static void gerarArvoreAleatoria(BuscaBinariaArvore arvore, int vi, int vf)
	{
		int size = vf - vi + 1;
        List<Integer> list = new ArrayList<Integer>();  
        
        for (int i = vi; i <= vf; i++) {
            list.add(i); 
        }  
          
        // embaralhar  
        Collections.shuffle(list);  
                
        // list para array  
        for (int i = 0; i < size; i++) {  
        	arvore.add(list.get(i));
        } 
	}
	
	
	private static void exibirVetor(Integer vet[]) 
	{
		for (int i=0; i<vet.length; i++) {
			System.out.print(vet[i] + " ");
		}
		System.out.println("\n");
	}
	
}
