package ordenacao;

import java.util.List;

// BST = Binary Search Tree
// Árvore Binária de Pesquisa
public class ArvoreBST<E extends Comparable<E>>
{
	// Classe que representa cada nó da árvore
	class Node
	{    
		// Atributos
	    E key;
	    Node left;		// filho da esquerda
	    Node right;		// filho da direita
	    
	    // Construtor
	    Node(E pkey) {
	        this.key = pkey;
	        this.left = null;
	        this.right = null;
	    }
	}
	
	// Atributos da árvore
    private Node root;			// raiz: primeiro nó da árvore
    private int size;
    
    // Construtor
    public ArvoreBST() {
    	this.root = null;
    	this.size = 0;
    }
    
    // MÉTODOS:
    
    // Retorna quantidade de nós
	public int getSize() {
		return size;
	}
	
    // É vazia?
    public boolean isEmpty() {
        return root == null;
    }	
		
    
    // Adiciona novo nó
    public void add(E newKey) 
    {   
    	size++;
    	
        if ( isEmpty() ) {
        	root = new Node(newKey);
        	return;
        } 
 
        Node p = root;
            
        while ( p != null ) 
        {
            if (newKey.compareTo(p.key) == -1) 
            {
                if (p.left == null) { 
                    Node newNode = new Node(newKey);
                    p.left = newNode;
                    return;
                }  
                p = p.left;
            } 
            else 
            {
                if (p.right == null) {
                    Node newNode = new Node(newKey);
                    p.right = newNode;
                    return;
                }
                p = p.right;
            }
        } //while
    }
    
    
    // Retorna referencia para o nó pesquisado
    public Node search(E pkey) 
    {    
        Node p = root;
        int comp = 0;    
        
        while (p != null) 
        {   
        	comp = pkey.compareTo(p.key);
            if (comp == 0) {
            	return p;
            }
            if (comp == -1) {
            	p = p.left;
            }
            if (comp == +1) {
            	p = p.right;
            }
        }
        
        return null;
    }

  
    // Exibe elementos em largura
	public void print() 
	{
		System.out.println(root.key);
		String tab = "  ";
		print(root.left,  tab, true);
		print(root.right, tab, false);
		System.out.println();
	}
	// Recursivo
	private void print(Node node, String tab, boolean isEsq) 
	{
		if (node == null)
			return;

		if (isEsq) {
			System.out.print(tab + "E:");
			tab += "|  ";
		} else {
			System.out.print(tab + "D:");
			tab += "   ";
		}

		System.out.println(node.key);
		print(node.left,  tab, true);
		print(node.right, tab, false);
	}
    
    
    // Exibe elementos ordenados
    public void printInOrder() {
    	printInOrder( root );
        System.out.println();
    }
    // Recursivo
    private void printInOrder(Node node) 
    {
        if (node != null) {
        	printInOrder(node.left);
            System.out.print(node.key + " ");
            printInOrder(node.right);
        }
    }

    
    // Exibe elementos ordenados
    public void sortList(List lista) {
    	sortList( root, lista );
    }
    private void sortList(Node node, List lista) 
    {
        if (node != null) {
        	sortList(node.left, lista);
            lista.add(node.key);
            sortList(node.right, lista);
        }
    }
    
}
