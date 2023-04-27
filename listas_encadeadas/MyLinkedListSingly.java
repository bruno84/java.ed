package listas_encadeadas;

/**
 * Objetivo: Lista simplesmente encadeada
 * Observacao: implementacao com generic.
 * @author Bruno Monteiro
 */
public class MyLinkedListSingly <T> implements MyInterfaceList <T>
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
	
	// Atributos de MyLinkedListSingly
    private Node head;
    private Node tail;
    private int size;
    
    // Construtor de MyLinkedListSingly
	public MyLinkedListSingly() {
		head = null;
		tail = null;
		size = 0;
	}

	
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
	            System.out.println("\n");
	            System.out.println("Dado: " + p.data );
	            System.out.println("\n");
	            p = p.next;
	        }
	    }
		
		System.out.println("size = " + size + "\n");
	}
	
	public void showReverse()
	{
		System.out.println("Ops! Esta é uma lista simplesmente encadeada. \n");
		System.out.println("size = " + size + "\n");
	}

	
	
	
	
	public void addFirst(T dado)
	{
		Node novo = new Node(dado);
	    
		// Anexa elemento NOVO 
		// cuidado com a ordem! Dica: comece atribuindo os atributos null.
		
		if(head == null) {
			head = novo;	// novo será o primeiro elemento
			tail = novo;	// novo será o último elemento
		} 
		else {
			// Anexa
			novo.next = head;
			head = novo;
		}
		
		size++;
	}
	
	public void addLast(T dado)
	{		 
	    Node novo = new Node(dado);    

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

	
	public boolean addAfter(T dado, T criterio)
	{
		// Antecessor
	    Node p = searchNode(criterio);

	    if( p == null )	{    // Verifica se o criterio existe
	        System.out.println("Criterio invalido \n");
	        return false;
	    }
	    else
	    {
	        // Novo elemento 
	        Node novo = new Node(dado);

	        // Atualiza tail quando o elemento critério é o último
	        if(p.next == null) {
	        	tail = novo;
	        }
	        
	    	// Anexa (dicas: comece atribuindo os campos null)
	        novo.next = p.next;
		    p.next = novo;
		    
		    size++;
		    return true;
	    }
	}
	
	
	public T peekFirst()
	{	
		if( head == null ) {
	        System.out.println("Lista Vazia!!! \n");
	        return null;
	    }
		else {
			return head.data;
		}
	}
	
	
	public T peekLast()
	{
        if (tail == null) {
        	System.out.println("Lista Vazia!!! \n");
            return null;
        }
        else {
            return tail.data;
        }
	}
	

	private Node searchNode(T criterio)
	{
	    Node p = head;		// ponteiro temporario

	    while( p != null )
	    {
	        if( p.data.equals(criterio) ) {
	            return p;
	        }
	        p = p.next;
	    }
	    
	    return null;
	}

	
	public T search(T criterio)
	{
		Node p = searchNode(criterio);
		
		if(p == null) {
			return null;
		} else {
			return p.data;
		}
	}

	
	
	public T removeFirst()
	{	
		Node p = head;
		T dadoRetorno = null;

		if( head == null ) {
	        System.out.println("Lista Vazia!!! \n");
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
	
	
	public T removeLast()
	{
		T dadoRetorno = null;

        if (tail == null) {
        	System.out.println("Lista Vazia!!! \n");
            return null;
        }
        else 
        {
            dadoRetorno = tail.data;
            
            if (head == tail) 
            {
            	System.out.println("Remove unico elemento\n");
            	head = null;
            	tail = null;
            } 
            else 
            {
            	System.out.println("Remove ultimo elemento, mas há mais outros\n");
        		Node p = head;
        		// Procuro o penultimo elemento
                while (p.next != tail) {
                	p = p.next;
                }
                                
                tail = p;
                tail.next = null;
            }
            
            // OBS: nao precisa isolar elemento pois o next do tail é sempre null.
            
            size--;
        }

        return dadoRetorno;
	}
	

	private Node searchBefore(T criterio)
	{
	    Node p = head; 	   			// ponteiro temporario
		Node anterior = null;	   	// ponteiro anterior

	    while (p != null)
	    {
	    	anterior = p;
	        p = p.next;
	        
	        if (p != null && p.data.equals(criterio) ) {
	           return anterior;
	        }
	    }
	    
	    return null;
	}
	
	
	public T remove(T criterio)
	{	
		Node anterior = null;
		Node removido = null;

		if( head == null ) {
	        System.out.println("Lista Vazia!!! \n");
	        return null;
	    }

		anterior = searchBefore(criterio); // null: ID não existe OU ID está no 1o elemento

		if( anterior == null ) 
		{
			if( head.data.equals(criterio) == false )
			{
		        System.out.println("criterio nao existe!!! \n");
		        return null;
			}
			else
			{
				// Caso: elemento a ser removido esta no inicio
				return removeFirst();
			}
		}
		else
		{
			System.out.println("Remove elemento meio ou ultimo \n");
			
			removido = anterior.next;

			if(removido == tail) {
				System.out.println("Remove ultimo \n");
				return removeLast();
			}
			else {
				System.out.println("Remove meio \n");
				anterior.next = removido.next;	// se desliga do elemento removido
		        removido.next = null;			// isola elemento removido
		        size--;
		        
				return removido.data;
			}
		}
	}

	public int getSize() {
		return size;
	}	
	
}
