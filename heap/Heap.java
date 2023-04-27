package heap;

/*
	1. O valor de um nó é maior ou igual ao valor de seus filhos (consequentemente, o maior valor está na raiz);
	2. O Heap é uma árvore binária completa ou quase-completa da esquerda para a direita.
 */
public class Heap 
{
	private int[] array;	
	private int tail;
	private int capacity;
	
	// Construtor
	public Heap() 
	{	
		this.capacity = nodesComplete(3);	// 15
		this.array = new int[capacity];
		this.tail = -1;
	}
	
	// Construtor
	public Heap(int capacity) 
	{	
		this.capacity = capacity;
		this.array = new int[capacity];
		this.tail = -1;
	}
	
	// É vazio?
    public boolean isEmpty() {
        return (tail == -1);
    }
	
    // Retorna a quantidade de nós para que a árvore seja completa, com abase na altura
	public int nodesComplete(int h) {
		return (int) (Math.pow(2,h+1) - 1);
	}
    
	// Retorna altura
	public int height() {
		return (int)(Math.log(array.length) / Math.log(2));
	}

	
    public int left(int index) {
        return (2 * index) + 1;
    }

    
    public int right(int index) {
        return 2 * (index + 1);
    }

    
    public int parent(int index) {
        return (index-1)/2;
    }
    
    // Adiciona elemento. Se maior, vai para a raiz
    public void add(int n) 
    {
        if (tail >= (array.length - 1)) {
        	resize();
        } 

        tail += 1;
        array[tail] = n;
        
        int i = tail;
        while (i > 0 && array[parent(i)] < array[i]) 
        {
        	// swap
            int temp = array[i];
            array[i] = array[parent(i)];
            array[parent(i)] = temp;
            
            i = parent(i);
        }
    }
    
    
    // Cria novo vetor com maior capacidade
    private void resize() 
    {
    	// Faço resize com um nivel a mais
    	int newSize = nodesComplete( height()+1 );
        int[] newArray = new int[newSize];
        
        for (int i = 0; i <= tail; i++) {
            newArray[i] = array[i];
        }
        
        array = newArray;
    }
    
    
    // Remove, e retorna, maior valor, que está na raiz
    public int remove() 
    {
        if ( isEmpty() ) {
        	throw new RuntimeException("Empty");
        }
        
        int value = array[0];
        
        // Substitui a raiz pela ultima folha
        array[0] = array[tail];
        // Reduz a cauda
        tail = tail - 1;

        this.heapify(0);
        
        return value;
    }
    
    
    // Ajusta heap, no caso da nova raiz ser menor que os demais nós
    private void heapify(int index) 
    {
    	// É folha OU É indice inválido? Se sim, está OK
        if (isLeaf(index) || isValidIndex(index)==false) {
        	return;
        }
        
        // ha algum elemento maior? se sim, faz swap e continua
        int indexMax = maxIndex(index, left(index), right(index));
        
        if (indexMax != index) 
        {   
        	//swap
        	int temp = array[index];
            array[index] = array[indexMax];
            array[indexMax] = temp;
            
            heapify(indexMax);
        }
    }
    
    
    private int maxIndex(int index, int left, int right) 
    {
        if ( array[index] > array[left]) 
        {
            if (isValidIndex(right)) {
                if (array[index] < array[right]) {
                    return right;
                }
            }
           
            return index;
        } 
        else 
        {
            if (isValidIndex(right)) {
                if (array[left] < array[right]) {
                    return right;
                }
            } 
            
            return left;
        }
    }

    
    // É índice válido (entre 0 e tail)?
    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }
    
    
    // É folha?
    private boolean isLeaf(int index) {
        return (index > parent(tail) ) && (index <= tail);
    }

    
    // Exibe vetor completo
    public void showArray() 
    {
    	for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
    	System.out.println();
    }
    
    
    // Exibe vetor até a cauda
    public void showHeap() 
    {
    	for (int i = 0; i <= tail; i++) {
			System.out.print(array[i] + " ");
		}
    	System.out.println();
    }
    
	public int getTail() {
		return tail;
	}

	public int getCapacity() {
		return capacity;
	}
}
