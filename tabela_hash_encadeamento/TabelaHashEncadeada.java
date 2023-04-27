package tabela_hash_encadeamento;

import java.util.ArrayList;
import java_basico.Produto;

//Tabela Hash com encadeamento externo
public class TabelaHashEncadeada
{
	private int size;
	private int capacity;
	private ArrayList<Produto> tableList[];		// vetor de listas
	
	@SuppressWarnings("unchecked")
	public TabelaHashEncadeada() 
	{
		this.size = 0;
		this.capacity = 31;	//numeros primos reduzem colisoes
		this.tableList = new ArrayList[capacity];	
	}
	
	@SuppressWarnings("unchecked")
	public TabelaHashEncadeada(int capacity) 
	{
		this.size = 0;
		this.capacity = capacity;
		this.tableList = new ArrayList[capacity];	
	}
	
	
	// Funcao de dispersao
	public int hash(int key) {
		return key % this.capacity;
	}
	
	
	public void add(int key, Produto produtoNovo) 
	{
		int hash = hash(key);
		ArrayList<Produto> list = tableList[hash];
		
        if (list == null) 
        {
        	// indice hash caiu em uma posicao que ainda nao tinha lista
        	list = new ArrayList<Produto>();
        	list.add( produtoNovo );
            tableList[hash] = list;
        } 
        else 
        {
        	// indice hash caiu em uma posicao que ja existe lista
            for (int i = 0; i < list.size(); i++) 
            {
            	// Se ha repericao de chave: substitui
                if (list.get(i).getCodigo() == key) {
                    list.set(i, produtoNovo);
                    return;
                }
            }
            // Se ha chave eh inedita: adiciona
            list.add(produtoNovo);
        } 
        
        size++;
	}
	
	
    public Produto remove(int key) 
    {
        int hash = hash(key);
        ArrayList<Produto> list = tableList[hash];
        Produto atual = null;
        
        for (int i = 0; i < list.size(); i++) 
        {
        	atual = list.get(i);
        	
            if (atual.getCodigo() == key) {
                list.remove(i);
                size--;
                return atual;
            }
        }
        
        return null;
    }  
	
	
    public Produto search(int key) 
    {
        int hash = hash(key);
        ArrayList<Produto> list = tableList[hash];
        
        if ( list == null || list.isEmpty() ) {
        	return null;
        }
        
        for (Produto object : list) 
        {
            if (object.getCodigo() == key) {
                return object;
            }
        }
        
        return null;
    }

    
    public void show() 
    {
        for (int i=0; i < capacity; i++) 
        {
            ArrayList<Produto> list = tableList[i];
            
            if ( list != null && list.isEmpty()==false ) 
            {
                for (Produto object : list) 
                {
                    System.out.print( object + " ");
                }
            }
        }
        System.out.println("\n");
    }
    
    
	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	} 
}
