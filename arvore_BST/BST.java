package arvore_BST;

// BST = Binary Search Tree
// Árvore Binária de Pesquisa
public class BST 
{
	// Classe que representa cada nó da árvore
	class Node
	{    
		// Atributos
	    int key;
	    Node left;		// filho da esquerda
	    Node right;		// filho da direita
	    Node parent;	// pai
	    
	    // Construtor
	    Node(int pkey) 
	    {
	        this.key = pkey;
	        this.left = null;
	        this.right = null;
	        this.parent = null;
	    }
	}
	
	// Atributos da árvore
    private Node root;			// raiz: primeiro nó da árvore
    private int size;
    
    
    // Construtor
    public BST() {
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
	
    
    // Quantidade de nós para que a árvore seja completa
	public int nodesComplete(int h) {
		return (int) (Math.pow(2,h+1) - 1);
	}
	
	
    // Retorna altura
    public int height() {
        return height(root);
    }
    // Recursiva
    private int height(Node node) 
    {
        if(node == null) {
        	return -1;
        }
        else return 1 + Math.max(height(node.left), height(node.right));
    }
	
    
    // Retorna referencia para o nó pesquisado
    public Node search(int pkey) 
    {    
        Node p = root;
            
        while (p != null) 
        {   
            if (p.key == pkey) {
            	return p;
            }
            
            if (pkey < p.key) {
            	p = p.left;
            }
            
            if (pkey > p.key) {
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
    
    
    // Retorna menor elemento
    public Node min() 
    {
        if (isEmpty()) {
        	return null;
        }
        return min(root);
    }
    // Recursivo
    private Node min(Node node) 
    {
        if (node.left == null) {
        	return node;
        }
        else {
        	return min(node.left);
        }
    }

    
    // Retorna maior elemento
    public Node max() 
    {
        if (isEmpty()) {
        	return null;
        }
        return max(root);
    }
    // Recursivo
    private Node max(Node node) 
    {
        if (node.right == null) {
        	return node;
        }
        else {
        	return max(node.right);
        }
    }
        
    
    // Retorna valor próximo, em ordem
    public Node successor(Node node) 
    {
        if (node == null) {
        	return null;
        }
            
        if (node.right != null) {
            return min(node.right);
        }
        else 
        {
            Node p = node.parent;
                
            while (p != null && p.key < node.key) {
                p = p.parent;
            }
                
            return p;
        }
    }
    
    
    // Retorna valor anterior, em ordem
    public Node predecessor(Node node) 
    {
        if (node == null) {
        	return null;
        }
        
        if (node.left != null) {
            return max(node.left);
        }
        else 
        {
            Node p = node.parent;
            
            while (p != null && p.key > node.key) {
                p = p.parent;
            }
            
            return p;
        }
    }


    // Adiciona novo nó
    public void add(int newKey) 
    {   
    	size++;
    	
        if ( isEmpty() ) 
        {
        	root = new Node(newKey);
        } 
        else 
        {
            Node p = root;
                
            while ( p != null ) 
            {
                if (newKey < p.key) 
                {
                    if (p.left == null) 
                    { 
                        Node newNode = new Node(newKey);
                        p.left = newNode;
                        newNode.parent = p;
                        return;
                    }
                        
                    p = p.left;
                } 
                else 
                {
                    if (p.right == null) 
                    {
                        Node newNode = new Node(newKey);
                        p.right = newNode;
                        newNode.parent = p;
                        return;
                    }
                    
                    p = p.right;
                }
            } //while
        }  
    }
    
    
    // Remove um nó
    public Node remove(int pkey) 
    {
    	Node node = search(pkey);
    	
    	if(node == null) {
    		return null;
    	} 
    	else {
    		size--;
    		return remove(node);
    	}
    }
    // Recursivo
    private Node remove(Node node) 
    {
        if (node.left == null && node.right == null) 
        {
        	// caso 1: nó é folha.
        	
            if (node == root) 
            {
            	// É a raiz
                root = null;
            }
            else 
            {
            	// Pai aponta para null (esquerda ou direita, conforme chave)
                if (node.key < node.parent.key) {
                    node.parent.left = null;
                }
                else {
                    node.parent.right = null;
                }
            }
        } 
        else if (node.left != null && node.right == null) 
        {
            // caso 2: tem apenas filho da esquerda
        	
            if (node == root)  
            {
            	// É raiz
                root = node.left;
                root.parent = null;
            } 
            else 
            {
            	// Neto passa a ter avô como pai
                node.left.parent = node.parent;
                
                // Avô aponta para neto (esquerda ou direita, conforme chave)
                if (node.key < node.parent.key) {
                    node.parent.left = node.left;
                }
                else {
                    node.parent.right = node.left;
                }
            }
        } 
        else if (node.left == null && node.right != null) 
        {
        	// caso 2: tem apenas filho da direita
        	
            if (node == this.root) 
            {
            	// É raiz
                this.root = node.right;
                this.root.parent = null;
            } 
            else 
            {
            	// Neto passa a ter avô como pai
                node.right.parent = node.parent;
                
                // Avô aponta para neto (esquerda ou direita, conforme chave)
                if (node.key < node.parent.key) {
                    node.parent.left = node.right;
                }
                else {
                    node.parent.right = node.right;
                }
            }
        } 
        else 
        {
            // caso 3: tem dois filhos
        	// O nó a ser removido recebe o valor do sucessor
            Node successor = successor(node);
            node.key = successor.key;
            // Executo novamente a remoção para deletar o sucessor que está duplicado (que será caso 1 ou 2)
            remove(successor);
        }
        
        return node;
    }
    
}
