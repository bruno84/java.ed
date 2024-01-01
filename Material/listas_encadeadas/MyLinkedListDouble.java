package listas_encadeadas;

/**
 * Objetivo: Lista suplamente encadeada, com generic.
 * @author Bruno Monteiro
 */
public class MyLinkedListDouble <E> implements MyInterfaceList <E>
{
	// Classe Interna Node
	class Node
	{
		// Atributos de Node
        private E data;    
        private Node next; 
        private Node prev;	// novidade
                
        // Construtor de Node
        public Node(E data) 
        {        	
            this.data = data;    
            this.next = null; 
            this.prev = null; 
        }    
    } 
	
	// Atributos de MyLinkedListSingly
    private Node head;    
    private Node tail;
    private int size;
    
    // Construtor de MyLinkedListSingly
	public MyLinkedListDouble() {
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
	            System.out.println("\n Dado: " + p.data + "\n");
	            
	    	    p = p.next;
	        }
	    }
		
		System.out.println("size = " + size + "\n");
	}
	
	
	
	
	public void showReverse()
	{
	    Node p = tail; // novidade
	    
		if(p == null) {
			System.out.println("LISTA VAZIA \n");
		}
		else 
	    {
	        while( p != null )
	        {
	            System.out.println("\n Dado: " + p.data );
	            
	    	    p = p.prev; // novidade
	        }
	    }
		
		System.out.println("size = " + size + "\n");
	}
	
	

	
	
	
	public void addFirst(E dado)
	{
		Node novo = new Node(dado);
	    
		// Anexa elemento NOVO (cuidado com a ordem! Dica: comece atribuindo os campos null)
		if(head == null) {
			head = novo;	// novo será o primeiro elemento
			tail = novo;	// novo será o último elemento
		} 
		else {
			// Anexa
			novo.next = head;
			head.prev = novo; // novidade
			head = novo;
		}
		
		size++;
	}
	
	
	
	

	public void addLast(E dado)
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
	    	novo.prev = tail; // novidade. Lembre-se de começar a anexação pelo novo elemento
	    	tail.next = novo;
	        tail = novo;
	    }
	    
	    size++;
	}

	
	
	
	
	public boolean addAfter(E dado, E criterio)
	{
		// Antecessor
	    Node p = searchNode(criterio);

	    if( p == null )	// Verifica se o criterio existe
	    {
	        System.out.println("Criterio invalido \n");
	        return false;
	    }
	    else
	    {
	        // Novo elemento 
	        Node novo = new Node(dado);

	        // Atualiza tail quando o elemento criterio eh o ultimo
	        if(p.next == null) {
	        	tail = novo;
	        }
	        
	    	// Anexa (dicas: comece atribuindo os campos null)
	        novo.next = p.next;
	        novo.prev = p;		// novidade
	        p.next = novo;
	        
	        // novidade
	        Node frente = novo.next;	// var auxiliar
	        if(frente != null) {		// previne nullpoint quando add no tail
	        	frente.prev = novo;
	        }
		    
		    size++;
		    
		    return true;
	    }
	}
	
	
	public E peekFirst()
	{	
		if( head == null ) {
	        System.out.println("Lista Vazia!!! \n");
	        return null;
	    }
		else {
			return head.data;
		}
	}
	
	
	public E peekLast()
	{
        if (tail == null) {
        	System.out.println("Lista Vazia!!! \n");
            return null;
        }
        else {
            return tail.data;
        }
	}
	

	private Node searchNode(E criterio)
	{
	    Node p = head;		// ponteiro temporario

	    while( p != null )
	    {
	    	/*
	    	 *  OBS: o critério de comparação será aquele 
	    	 *  que foi definido na sua classe-entidade
	    	 *  nos métodos equals() e hashCode().
	    	 *  Se não houver esta definição, um objeto 
	    	 *  será considerado igual se todos os atributos
	    	 *  forem iguais.
	    	 */
	        if( p.data.equals(criterio) ) {
	        	System.out.println();
	            return p;
	        }
	        p = p.next;
	    }
	    
	    return null;
	}

	
	public E search(E criterio)
	{
		Node p = searchNode(criterio);
		
		if(p == null) {
			return null;
		} else {
			return p.data;
		}
	}

	
	
	public E removeFirst()
	{	
		Node p = head;
		E dadoRetorno = null;

		if( head == null ) {
	        System.out.println("Lista Vazia!!! \n");
	    }
		else
		{
			dadoRetorno = p.data;
			
			if (head == tail) 
			{
				System.out.println("Remove unico elemento\n");
                head = null;
                tail = null;
            } 
			else {
				System.out.println("Remove primeiro elemento, mas ha mais outros\n");
                head = head.next;
                head.prev = null; // novidade
			}
			
			p.next = null; // isola elemento removido
			
			size--;
		}

		return dadoRetorno;
	}
	
	
	public E removeLast() 
	{
		E dadoRetorno = null;

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
            	System.out.println("Remove ultimo elemento, mas ha mais outros\n");
        		Node anterior = tail.prev;  // novidade
        		tail.prev = null;			// novidade
                tail = anterior;			
                tail.next = null;
            }
            
            // OBS: nao precisa isolar elemento pois o next do tail é sempre null.
            
            size--;
        }

        return dadoRetorno;
	}
	
	
	
	public E remove(E criterio)
	{
		E dadoRetorno = null;

		if( head == null ) {
	        System.out.println("Lista Vazia!!! \n");
	        return null;
	    }

		Node anterior = null;
		Node removido = searchNode(criterio); // null: criterio nao existe OU criterio esta no 1o elemento
		
		if(removido != null) {
			anterior = removido.prev;  // evita nullpointer
		}
		
		// OBS: vc pode usar a referencia de removido para alterar os IFs abaixo,
		// porem, mantive a mesma estrutura usada na lista simples para facilitar.
		
		if( anterior == null ) 
		{
			if( head.data.equals(criterio) == false )
			{
		        System.out.println("criterio nao existe!!! \n");
		        return null;
			}
			else
			{
				return removeFirst();
			}
		}
		else
		{
			System.out.println("Remove elemento meio ou ultimo \n");
			
			if(removido == tail) 
			{
				return removeLast();
			}
			else 
			{
				System.out.println("Remove meio \n");
				Node frente = removido.next;	// var auxiliar
				
				// se desliga do elemento removido
				anterior.next = frente;		
		        frente.prev = anterior; // novidade
				
				// isola elemento removido
				removido.next = null;
				removido.prev = null;  // novidade
				
				size--;
				
				dadoRetorno = removido.data;
				return dadoRetorno;
			}
		}

	}

	public int getSize() {
		return size;
	}

	
}
