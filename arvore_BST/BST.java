package arvore_BST;

// BST = Binary Search Tree
// Árvore Binária de Pesquisa
public class BST 
{
	// Classe que representa cada nó da árvore
	class Node
	{    
		// Atributos
	    int value;
	    Node left;		// filho da esquerda
	    Node right;		// filho da direita
	    Node parent;	// pai
	    
	    // Construtor
	    Node(int v) 
	    {
	        this.value = v;
	        this.left = null;
	        this.right = null;
	        this.parent = null;
	    }
	}
	
	// Atributos da árvore
    private Node root;			// raiz: primeiro nó da árvore
    private int size;
    
    
    // É vazia?
    public boolean isEmpty() 
    {
        return root == null;
    }
	
    
    // Adiciona novo nó
    public void add(int newValue) 
    {   
    	size++;
    	
        if ( isEmpty() ) 
        {
        	root = new Node(newValue);
        } 
        else 
        {
            Node p = root;
                
            while ( p != null ) 
            {
                if (newValue < p.value) 
                {
                    if (p.left == null) 
                    { 
                        Node newNode = new Node(newValue);
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
                        Node newNode = new Node(newValue);
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
    public Node remove(int key) 
    {
    	Node node = search(key);
    	
    	if(node == null) {
    		return null;
    	} 
    	else {
    		size--;
    		return remove(node);
    	}
    }
    
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
                if (node.value < node.parent.value) {
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
                if (node.value < node.parent.value) {
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
                if (node.value < node.parent.value) {
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
            node.value = successor.value;
            // Executo novamente a remoção para deletar o sucessor que está duplicado (que será caso 1 ou 2)
            remove(successor);
        }
        
        return node;
    }

    

    // Retorna referencia para o nó pesquisado
    public Node search(int key) 
    {    
        Node p = root;
            
        while (p != null) 
        {   
            if (p.value == key) {
            	return p;
            }
            
            if (key < p.value) {
            	p = p.left;
            }
            
            if (key > p.value) {
            	p = p.right;
            }
        }
            
        return null;
    }
    
    
    // Exibe elementos ordenados
    public void sortInOrder() {
        sortInOrder( root );
        System.out.println();
    }
    // Recursivo
    private void sortInOrder(Node node) 
    {
        if (node != null) {
            sortInOrder(node.left);
            System.out.print(node.value + " ");
            sortInOrder(node.right);
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
                
            while (p != null && p.value < node.value) {
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
            
            while (p != null && p.value > node.value) {
                p = p.parent;
            }
            
            return p;
        }
    }


	public int getSize() {
		return size;
	}
    
}
