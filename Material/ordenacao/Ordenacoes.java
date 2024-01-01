package ordenacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ordenacoes 
{

	public static void main(String[] args)
	{
	    int vi = 1;		// valor mínimo
	    int vf = 100;	// valor máximo
		int size = vf - vi + 1;
		boolean flagShow = true;
	    
		System.out.println("size: " + size);
		
		System.out.println("Entrada: ");
		int[] array = roletaSemRepeticao(vi, vf);
		if( flagShow ) show(array);
		
		int[] arrayCopy = Arrays.copyOf(array, size);
		System.out.println("\nbubbleSort processando ... ");
		long t1 = System.currentTimeMillis();
		bubbleSort(arrayCopy);
		long t2 = System.currentTimeMillis();
		System.out.println("bubbleSort tempo: " + (t2-t1) + " ms");
		System.out.println("bubbleSort saida: ");
		if( flagShow ) show(arrayCopy);
		
		arrayCopy = Arrays.copyOf(array, size);
		System.out.println("\nbubbleSortOtimiz processando ... ");
		t1 = System.currentTimeMillis();
		bubbleSortOtimiz(arrayCopy);
		t2 = System.currentTimeMillis();
		System.out.println("bubbleSortOtimiz tempo: " + (t2-t1) + " ms");
		System.out.println("bubbleSortOtimiz saida: ");
		if( flagShow ) show(arrayCopy);
		
		arrayCopy = Arrays.copyOf(array, size);
		System.out.println("\nselectSort processando ... ");
		t1 = System.currentTimeMillis();
		selectSort(arrayCopy);
		t2 = System.currentTimeMillis();
		System.out.println("selectSort tempo: " + (t2-t1) + " ms");
		System.out.println("selectSort saida: ");
		if( flagShow ) show(arrayCopy);
		
		arrayCopy = Arrays.copyOf(array, size);		
		System.out.println("\ninsertSort processando ... ");
		t1 = System.currentTimeMillis();
		insertSort(arrayCopy);
		t2 = System.currentTimeMillis();
		System.out.println("insertSort tempo: " + (t2-t1) + " ms");
		System.out.println("insertSort saida: ");
		if( flagShow ) show(arrayCopy);
		
		arrayCopy = Arrays.copyOf(array, size);		
		System.out.println("\nquickSort processando ... ");
		t1 = System.currentTimeMillis();
		quickSort(arrayCopy, 0, size-1);
		t2 = System.currentTimeMillis();
		System.out.println("quickSort tempo: " + (t2-t1) + " ms");
		System.out.println("quickSort saida: ");
		if( flagShow ) show(arrayCopy);
		
		arrayCopy = Arrays.copyOf(array, size);		
		System.out.println("\nshellSort processando ... ");
		t1 = System.currentTimeMillis();
		shellSort(arrayCopy);
		t2 = System.currentTimeMillis();
		System.out.println("shellSort tempo: " + (t2-t1) + " ms");
		System.out.println("shellSort saida: ");
		if( flagShow ) show(arrayCopy);
	}
	
	
	private static void bubbleSort(int vet[])
	{
	    int temp;
	    int size = vet.length;
	    
	    // LOOP EXTERNO
	    for(int i=0; i < size-1; i++) 
	    {	    	
	        // LOOP INTERNO
	        for(int j=0; j < size-1; j++) 
	        {  
	            // swap
	            if( vet[j] > vet[j+1] ) 
	            {
	                temp = vet[j];
	                vet[j] = vet[j+1];
	                vet[j+1] = temp;
	            }
	        }
	    }
	}
	
	
	private static void bubbleSortOtimiz(int vet[])
	{
	    int temp;
	    int size = vet.length;
	    boolean flagDesordem = true;
	    
	    // LOOP EXTERNO
	    for(int i=0; i < size-1 && flagDesordem; i++) 
	    {
	    	flagDesordem = false;
	    	
	        // LOOP INTERNO
	        for(int j=0; j < size-1; j++) 
	        {   
	            // swap
	            if( vet[j] > vet[j+1] ) 
	            {
	                temp = vet[j];
	                vet[j] = vet[j+1];
	                vet[j+1] = temp;
	                flagDesordem = true;
	            }
	        }
	    }
	}
	
	
	private static void selectSort(int vet[])
	{
	    int menor, temp;
	    int size = vet.length;
	    
	    // LOOP EXTERNO: Varre todo o conjunto
	    for (int i = 0; i < size-1; i++)
	    {			
	        menor = i;

	        // Varre subsequencia em busca do menor numero
	        for (int j = (i+1); j < size; j++)
	        {
	            if(vet[j] < vet[menor])
	            {
	                menor = j;
	            }
	        }

	        // Se houver um numero menor, faz o swap
	        if (i != menor)
	        {
	            temp = vet[i];
	            vet[i] = vet[menor];
	            vet[menor] = temp;
	        }
	    }
	}
	
	
	private static void insertSort(int vet[]) 
	{
	    int j, eleito;
	    int size = vet.length;
	    
	    // LOOP EXTERNO
	    for (int i = 1; i < size; i++)
	    {	    	
	        eleito = vet[i];
	        j = i - 1;

	        while ( (j>=0) && (eleito < vet[j]) ) 
	        {
	            vet[j+1] = vet[j];
	            j--;
	        }
	        vet[j+1] = eleito;
	    }
	}
	
	
	private static void quickSort(int vet[], int iniVet, int fimVet)
	{
	    int i , j , pivo , aux;

	    i = iniVet;
	    j = fimVet;
	  	pivo = vet[(iniVet + fimVet) /  2];
	    
	    while(i < j)
	    {
	        while(vet[i] < pivo)
	        {
	            i = i + 1;
	       	}
	       	while(vet[j] > pivo)
	        {
	            j = j - 1;
	        }

	        // swap
	       	if (i <= j)
	        {
	            aux  = vet[i];
	       		vet[i] = vet[j];
	       		vet[j] = aux;
	       		i = i + 1;
	       		j = j - 1;
	       	}
	    }
	    if (j > iniVet)
	    {
	        quickSort(vet, iniVet, j);    // porção inicial
	     }
	    if (i < fimVet)
	    {
	        quickSort(vet, i, fimVet);    // porção final
	    }
	}
	
	
	private static void shellSort(int vet[]) 
	{
	    int i, j, value;
	    int h = 1;
	    int size = vet.length;
	    
	    while(h < size) {
	        h = 3*h+1;
	    }
	    
	    while (h > 0) 
		{
	        for(i = h; i < size; i++) 
			{
	            value = vet[i];
	            j = i;
	            while (j > h-1 && value <= vet[j - h]) {
	                vet[j] = vet[j - h];
	                j = j - h;
	            }
	            vet[j] = value;
	        }
	        h = h/3;
	    }
	}	
	
	
	private static int[] roletaSemRepeticao(int vi, int vf)
	{
		int size = vf - vi + 1;
		int[] array = new int[size];
  
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
	
	
	private static void show(int vet[]) 
	{
		for (int i=0; i<vet.length; i++) {
			System.out.print(vet[i] + " ");
		}
		System.out.println("\n");
	}

}
