package ordenacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ordenacoes 
{	
	private static boolean flagShow = true;
	
	public static void main(String[] args)
	{
	    int vi = 1;		// valor mínimo
	    int vf = 8;	// valor máximo
		int size = vf - vi + 1;
	    
		System.out.println("size: " + size);
		
		System.out.println("Entrada: ");
		int[] array = gerarAleatorioSemRepeticao(vi, vf);
		//int[] array = gerarOrdenado(vi, vf);
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
		System.out.println("\n bubbleSortOtimiz processando ... ");
		t1 = System.currentTimeMillis();
		bubbleSortOtimiz(arrayCopy);
		t2 = System.currentTimeMillis();
		System.out.println("bubbleSortOtimiz tempo: " + (t2-t1) + " ms");
		System.out.println("bubbleSortOtimiz saida: ");
		if( flagShow ) show(arrayCopy);
		
		arrayCopy = Arrays.copyOf(array, size);
		System.out.println("\n selectSort processando ... ");
		t1 = System.currentTimeMillis();
		selectSort(arrayCopy);
		t2 = System.currentTimeMillis();
		System.out.println("selectSort tempo: " + (t2-t1) + " ms");
		System.out.println("selectSort saida: ");
		if( flagShow ) show(arrayCopy);
		
		arrayCopy = Arrays.copyOf(array, size);		
		System.out.println("\n insertSort processando ... ");
		t1 = System.currentTimeMillis();
		insertSort(arrayCopy);
		t2 = System.currentTimeMillis();
		System.out.println("insertSort tempo: " + (t2-t1) + " ms");
		System.out.println("insertSort saida: ");
		if( flagShow ) show(arrayCopy);
				
		arrayCopy = Arrays.copyOf(array, size);		
		System.out.println("\n shellSort processando ... ");
		t1 = System.currentTimeMillis();
		shellSort(arrayCopy);
		t2 = System.currentTimeMillis();
		System.out.println("shellSort tempo: " + (t2-t1) + " ms");
		System.out.println("shellSort saida: ");
		if( flagShow ) show(arrayCopy);
		
		arrayCopy = Arrays.copyOf(array, size);		
		System.out.println("\n quickSort processando ... ");
		t1 = System.currentTimeMillis();
		quickSort(arrayCopy, 0, size-1);
		t2 = System.currentTimeMillis();
		System.out.println("quickSort tempo: " + (t2-t1) + " ms");
		System.out.println("quickSort saida: ");
		if( flagShow ) show(arrayCopy);
		
		arrayCopy = Arrays.copyOf(array, size);		
		System.out.println("\n mergeSort processando ... ");
		t1 = System.currentTimeMillis();
		mergeSort(arrayCopy);
		t2 = System.currentTimeMillis();
		System.out.println("mergeSort tempo: " + (t2-t1) + " ms");
		System.out.println("mergeSort saida: ");
		if( flagShow ) show(arrayCopy);
		
		arrayCopy = Arrays.copyOf(array, size);		
		System.out.println("\n heapSort processando ... ");
		t1 = System.currentTimeMillis();
		heapSort(arrayCopy);
		t2 = System.currentTimeMillis();
		System.out.println("heapSort tempo: " + (t2-t1) + " ms");
		System.out.println("heapSort saida: ");
		if( flagShow ) show(arrayCopy);
		
		arrayCopy = Arrays.copyOf(array, size);		
		System.out.println("\n arvoreBST processando ... ");
		t1 = System.currentTimeMillis();
		arvoreBST(arrayCopy);
		t2 = System.currentTimeMillis();
		System.out.println("arvoreBST tempo: " + (t2-t1) + " ms");
		System.out.println("arvoreBST saida: ");
		if( flagShow ) show(arrayCopy);
		
	}
	
	
	private static void bubbleSort(int array[])
	{
	    int temp;
	    int size = array.length;
	    
	    // LOOP EXTERNO
	    for(int i=0; i < size-1; i++) 
	    { 
	    	if( flagShow ) System.out.println("LOOP EXTERNO");
	        // LOOP INTERNO
	        for(int p=0; p < size-1; p++) 
	        {  
	            // swap
	            if( array[p] > array[p+1] ) 
	            {
	                temp = array[p];
	                array[p] = array[p+1];
	                array[p+1] = temp;
	            }
	            
	            if( flagShow ) show(array);
	        }
	    }
	}
	
	
	private static void bubbleSortOtimiz(int array[])
	{
	    int temp;
	    int size = array.length;
	    boolean flagDesordem = true;
	    
	    // LOOP EXTERNO
	    for(int i=0; i < (size-1) && flagDesordem; i++) 
	    {
	    	if( flagShow ) System.out.println("LOOP EXTERNO");
	    	flagDesordem = false;
	    	
	        // LOOP INTERNO
	        for(int j=0; j < size-1; j++) 
	        { 
	            // swap
	            if( array[j] > array[j+1] ) 
	            {
	                temp = array[j];
	                array[j] = array[j+1];
	                array[j+1] = temp;
	                flagDesordem = true;
	            }
	            if( flagShow ) show(array);
	        }
	    }
	}
	
	
	private static void selectSort(int array[])
	{
	    int menor, temp;
	    int size = array.length;
	    
	    // LOOP EXTERNO: Varre todo o conjunto
	    for (int p = 0; p < size-1; p++)
	    {
	    	if( flagShow ) System.out.println("LOOP EXTERNO");
	        menor = p;

	        // Varre subsequencia em busca do menor numero
	        for (int i = (p+1); i < size; i++)
	        {
	            if(array[i] < array[menor]){
	                menor = i;
	            }
	        }

	        // Se houver um numero menor, faz o swap
	        if (p != menor) {
	            temp = array[p];
	            array[p] = array[menor];
	            array[menor] = temp;
	        }
	        
	        if( flagShow ) show(array);
	    }
	}
	
	
	private static void insertSort(int array[]) 
	{
	    int j, valorPivo;
	    int size = array.length;
	    
	    // LOOP EXTERNO
	    for (int i = 1; i < size; i++)
	    {	    
	    	if( flagShow ) System.out.println("LOOP EXTERNO");
	    	if( flagShow ) show(array);
	    	
	        valorPivo = array[i];
	        j = i - 1;
	        
	        while( (j>=0) && (valorPivo < array[j]) ) 
	        {
	            array[j+1] = array[j];
	            j--;
	            if( flagShow ) show(array);
	        }
	        array[j+1] = valorPivo;
	    }
	}
	
	
	
	private static void shellSort(int array[]) 
	{
	    int h = 1;
	    int size = array.length;
	    
        while (h < size / 3) {
            h = 3 * h + 1;
        }
	    
	    if( flagShow ) System.out.println("H max = " + h);
	    
	    while (h > 0) 
		{
	    	if( flagShow ) System.out.println("H = " + h);
	    	
            for (int i = h; i < size; i++) 
            {
            	int vPivo = array[i];
                int j = i;

                // Move elementos array[j-h] que são maiores que vPivo
                while (j >= h && array[j - h] > vPivo) {
                	array[j] = array[j - h];
                    j = j - h;
                }

                array[j] = vPivo;
                
                if( flagShow ) show(array);
            }
            
            h = (h - 1) / 3;
	    }
	}	
	
	
	private static void quickSort(int array[], int iniVet, int fimVet)
	{
	    int i , j , pivo , aux;

	    i = iniVet;
	    j = fimVet;
	  	pivo = array[(iniVet + fimVet) /  2];
	    
	  	if( flagShow ) System.out.println("LOOP EXTERNO");
	  	if( flagShow ) System.out.println("pivo=" + pivo + " i="+i + " j="+j);
	  	
	    while(i < j)
	    {
	        while(array[i] < pivo){
	            i = i + 1;
	       	}
	       	while(array[j] > pivo){
	            j = j - 1;
	        }

	        // swap
	       	if (i <= j) {
	            aux  = array[i];
	       		array[i] = array[j];
	       		array[j] = aux;
	       		i = i + 1;
	       		j = j - 1;
	       	}
	       	if( flagShow ) show(array);
	    }
	    if (j > iniVet) {
	        quickSort(array, iniVet, j);    // porção inicial
	     }
	    if (i < fimVet) {
	        quickSort(array, i, fimVet);    // porção final
	    }
	}
	

    private static void mergeSort(int[] arrayInteiro) 
    {
    	int size = arrayInteiro.length;
    	
        if (size <= 1) {
            return; // para de dividir!
        }

        // Divide o array em duas metades
        int meio = size / 2;
        int[] array1 = new int[meio];
        int[] array2 = new int[arrayInteiro.length - meio];

        for (int i = 0; i < meio; i++) {
            array1[i] = arrayInteiro[i];
        }
        for (int i=0, j = meio; j < size; i++, j++) {
            array2[i] = arrayInteiro[j];
        }

        // Ordena recursivamente cada metade
        mergeSort(array1);
        mergeSort(array2);

        // Mescla as duas metades ordenadas
        merge(arrayInteiro, array1, array2);
    }
	
    // Merge dos dois subarrays ordenados em um só
    private static void merge(int[] arrayInteiro, int[] array1, int[] array2) 
    {
    	if( flagShow ) System.out.println("merge");
    	if( flagShow ) show(array1);
    	if( flagShow ) show(array2);
    	
        int i = 0, j = 0, k = 0;
        int size1 = array1.length;
        int size2 = array2.length;
        
        // Percorre pelo menos um dos arrays até o final
        while (i < size1 && j < size2) 
        {
        	// ordenação é feita aqui: 
        	// compara os primeiros elementos do array1 com os primeiros elementos do array2, atualizando o arrayPrincipal com os menores valores de cada
        	// metáfora: ordenar duas pilhas de cartas
            if (array1[i] <= array2[j]) {
                arrayInteiro[k] = array1[i];
                k++; 
                i++;
            } else {
                arrayInteiro[k] = array2[j];
                k++; 
                j++;
            }
        }

        // Se algum array (1 ou 2) não foi percorrido até o final, copia o restante dos elementos
        while (i < size1) {
            arrayInteiro[k] = array1[i];
            k++; 
            i++;
        }
        while (j < size2) {
            arrayInteiro[k] = array2[j];
            k++; 
            j++;
        }
        
    	if( flagShow ) show(arrayInteiro);
    }

	
    private static void heapSort(int[] array) 
    {
    	/*
    	 	Raiz: 			índice = 0
    	 	Pai: 			índice = i
			Filho esquerdo: índice = 2*i + 1
			Filho direito:  índice = 2*i + 2
			
			Nós folhas: índice >= size/2
			(exemplo: size=10, então, índices das folhas: 5, 6, 7, 8, 9)
			
			Portanto, o último nó com filhos (que não é folha): índice = (size/2) - 1
			(exemplo: size=10, então, último nó não-folha: 4)
			
    	 */
        int size = array.length;

        if( flagShow ) System.out.println("Entrada (size="+size+"): ");
        if( flagShow ) show(array);
        
        // Construir o heap máximo
        // Altera a ordem dos elementos do array com as regras da estrutura heap
        
        // último nó com filhos (que não é folha): (size/2) - 1
        for (int i = (size/2)-1; i >= 0; i--) {
            heapify(array, size, i);
        }

        if( flagShow ) System.out.println("heapify: ");
        if( flagShow ) show(array);
        
        // Extrair elementos do heap
        for (int i = size-1; i > 0; i--) 
        {
            // Move a raiz (index=0), que é o maior elemento, para o fim
        	// OBS: não é importante o valor que foi movido de "i" para "0", 
        	// pois o heap vai sofrer heapify a seguir.
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Após alterar o array, chama novamente o heapify:
            // size: decrementado, excluindo o elemento que era raiz (maior) e que foi movida para o fim
            // nó pai: faz o ajuste a partir da nova raiz
            heapify(array, i, 0);
            if( flagShow ) show(array);
        }
    }

    // heapify: ajusta o heap para garante que a subárvore do pai (i) seja maior que os filhos
    private static void heapify(int[] array, int size, int i) 
    {
        int maior = i;          	// inicializa maior como raiz
        int esquerda = 2*i + 1; 	// filho esquerdo
        int direita  = 2*i + 2;  	// filho direito

        // Verifica se filho da esquerdo ou direita é maior que o pai
        if (esquerda < size && array[esquerda] > array[maior]) {
            maior = esquerda;
        }
        if (direita < size && array[direita] > array[maior]) {
            maior = direita;
        }

        // Se maior foi alterado, faz swap
        if (maior != i) 
        {
            int temp = array[i];
            array[i] = array[maior];
            array[maior] = temp;

            // Recursivamente aplica heapify na subárvore afetada
            // Até que não haja mais filhos maiores do que seus pais
            heapify(array, size, maior);
        }
    }

    
    
	private static void arvoreBST(int[] array)
	{   		
		ArvoreBST<Integer> arvore = new ArvoreBST<Integer>();
		
        // Add cada elemento do array na BST  
        for (int i = 0; i < array.length; i++) {
        	arvore.add( array[i] );
        } 
                
        // Add cada elemento da BST em List
        List<Integer> lista = new ArrayList<Integer>();
        arvore.sortList( lista );
                
        // Add cada elemento da List de volta no array
        for (int i = 0; i < array.length; i++) {
        	array[i] = lista.get(i);
        }
	}
		
    
    
	
	private static int[] gerarAleatorioSemRepeticao(int vi, int vf)
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
	
	
	private static int[] gerarOrdenado(int vi, int vf)
	{
		int size = vf - vi + 1;
		int[] array = new int[size];
  
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
	
	
	private static void show(int vet[]) 
	{
		for (int i=0; i<vet.length; i++) {
			System.out.print(vet[i] + "\t");
		}
		System.out.println("\n");
	}

}
