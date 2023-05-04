package tabela_hash_enderecamento;


import java_basico.Produto;

// Tabela Hash com enderecamento aberto
public class TabelaHashEnderecada 
{	
	private int size;
	private int capacity;
	private Produto table[];		// vetor de Produtos
	private float fatorCarga;
	
	// Construtor
	public TabelaHashEnderecada() 
	{
		this.size = 0;
		this.capacity = 31;	//numeros primos reduzem colisoes
		this.table = new Produto[capacity];	
		this.fatorCarga = 0.75f;
	}
	
	// Construtor
	public TabelaHashEnderecada(int capacity, float fatorCarga) 
	{
		this.size = 0;
		this.capacity = capacity;
		this.table = new Produto[capacity];	
		this.fatorCarga = fatorCarga;
	}
	
	
	// METODOS
	
	// Quantidade atual de elementos
	public int getSize() {
		return size;
	}

	// Capacidade de armazenar elementos
	public int getCapacity() {
		return capacity;
	}

	
	// Quanto maior, menor a probabilidade de complexidade O(1)
	public float getFatorCarga() {
		return fatorCarga; // [0.0 .. 1.0]
	} 
	
	
	// Funcao de dispersao
	public int hash(int key) {
		return key % this.capacity;
	}
	
	
	// Expande vetor
	private void resize()
	{
		System.out.println("resize!");
		Produto[] tableOld = table;	
		capacity = proxPrimo( capacity * 2 );
		table = new Produto[capacity];
		size = 0;
		
        for (Produto object : tableOld) {
            if (object != null) {
                add(object.getCodigo(), object);
            }
        }
	}
	
	
	// Obtem número primo
	private static int proxPrimo(int n)
	{
		int primo = n;
		
		while( ehPrimo(primo) == false ) {
			primo++;
		}
		
		return primo;
	}
	
	
	// Verifica se é primo
	public static boolean ehPrimo(int n) 
	{
	    for(int i = 2; i < n; i++) {
	        if(n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	
    // Exibe tabela
    public void show() 
    {
        for (int i=0; i < capacity; i++) 
        {
            System.out.print( table[i] + " ");
        }
        System.out.println("\n");
    }
	
	
	// Adiciona elemento
	public void add(int key, Produto produtoNovo) 
	{
		int hash;
		int tentativa = 0;
        
        // Resize?
        if ( (size/capacity) >= fatorCarga || size == capacity) 
        {
        	resize();
        }
		
        while (tentativa < capacity) 
        {
            hash = ( hash(key) + tentativa ) % capacity;
            Produto object = table[hash];
            
            // se esta disponivel, adiciona
            if ( object == null ) {
                table[hash] = produtoNovo;
                size++;
                return;
            }

            tentativa++;
        }
	}
	

	// Remove elemento
    public Produto remove(int key) 
    {
        int hash;
        int tentativa = 0;
        
        while (tentativa < capacity) 
        {
        	hash = ( hash(key) + tentativa ) % capacity;

        	// se encontrou chave
            if ( table[hash] != null && table[hash].getCodigo() == key ) 
            {
                Produto objeto =  table[hash];  
                table[hash] = null;
                size--;
                return objeto;
            } 

            tentativa++;
        }

        return null;
    }  
	
	
    // Pesquisa elemento
    public Produto search(int key) 
    {
        int hash;
        int tentativa = 0;

        while (tentativa < capacity) 
        {
            hash = ( hash(key) + tentativa ) % capacity;

            if (table[hash] == null) {
                return null;
            }

            if (table[hash].getCodigo() == key) {
                return table[hash];
            }

            tentativa++;
        }

        return null;
    }

}
