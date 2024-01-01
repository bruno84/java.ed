package pilhas;

import java_basico.MyException;

/**
 * Objetivo: Pilha sobre Lista simplesmente encadeada
 * Observacao: implementacao com generic.
 * @author Bruno Monteiro
 */
public class MyStackList <T> implements MyInterfaceStack <T>
{
	// Classe Interna Node
	class Node
	{
		// Atributos de Node
        T data;    
        Node next;    
                
        // Construtor de Node
        public Node(T data) 
        {        	
            this.data = data;    
            this.next = null;
        }    
    } 
	
	// Atributos 
    private Node head;
    private Node tail;
    private long size;
    private long capacity;
    
    // Construtor
	public MyStackList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.capacity = -1;
	}
	
	// Construtor
	public MyStackList(long capacity) {
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.capacity = capacity;
	}


	public long getSize() {
		return size;
	}

	public long getCapacity() {
		return capacity;
	}

	@Override
	public void push(T dado) throws MyException 
	{
		// Adiciona no inicio
	    Node novo = new Node(dado);    

	    if( isFull() ) {
	    	throw new MyException("Cheio!");
	    }
	    
	    // verifica se lista está vazia
	    if( head == null ) { 
	        head = novo;       	// novo será o primeiro elemento
	        tail = novo;		// novo será o último elemento
	    }
	    else
	    {
			// Anexa
	    	tail.next = novo;
	        tail = novo;
	    }
	    
	    size++;
		
	}


	@Override
	public T pop() throws MyException 
	{
		// Remove no inicio
		Node p = head;
		T dadoRetorno = null;

		if( isEmpty() ) {
		    throw new MyException("Vazio!");
	    }
		else
		{
			dadoRetorno = head.data;
			
			if (head == tail) 
			{
				System.out.println("Remove unico elemento\n");
                head = null;
                tail = null;
            } 
			else {
				System.out.println("Remove primeiro elemento, mas há mais outros\n");
                head = head.next;
			}
			
			p.next = null; // isola elemento removido
			
			size--;
		}

		return dadoRetorno;
	}


	@Override
	public T peek() throws MyException 
	{
		// Consulta no inicio
		if( head == null ) {
	        System.out.println("Lista Vazia!!! \n");
	        return null;
	    }
		else {
			return head.data;
		}
	}


	@Override
	public boolean isEmpty() 
	{
		return (head == null);
	}


	@Override
	public boolean isFull() 
	{
		if(capacity == -1) {
			return false;
		} 
		else 
		{
			if(size == capacity) {
				return true;
			}
			else {
				return false;
			}
		}

	}


	@Override
	public void show() 
	{
	    Node p = head;

		if(p == null) {
			System.out.println("LISTA VAZIA \n");
		}
		else 
	    {
	        while( p != null )
	        {
	            System.out.println("Dado: " + p.data );
	            p = p.next;
	        }
	    }
		
		System.out.println("size = " + size + "\n");
	}	
	
}
