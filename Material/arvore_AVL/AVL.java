package arvore_AVL;

//AVL = Adelson Velskii e Landis (autores).
//AVL = BST balanceada.
//Balanceada = altura das sub-árvores (esquerda e direita) não pode ser maior que |1|.
public class AVL 
{
	// Classe que representa cada nó da árvore
	class Node
	{   
		// Atributos
	    int key;
	    Node left;		// filho da esquerda
	    Node right;		// filho da direita
	    int height;		// altura
	    
	    // Construtor
	    Node(int v) 
	    {
	        this.key = v;
	        this.left = null;
	        this.right = null;
	        this.height = 0;
	    }
	}
	
	// Atributos da árvore
    private Node root;			// raiz: primeiro nó da árvore
    private int size;
    
    
    // CONSTRUTOR:
    
    public AVL() {
    	this.root = null;
    	this.size = 0;
    }
    
    //---------------------------------------------------------------
    // MÉTODOS da AVL
    //---------------------------------------------------------------
    
    // calcular Fator de Balanceamento
    // positivo: pendente a esquerda
    // negativo: pendente a direita
	public int calcularFB() {
		return calcularFB(root);
	}
	// Recursivo
	public int calcularFB(Node node) 
	{
		if (node == null) {
			return 0;
		}
		return  height(node.left) - height(node.right);
	}
    

	// Rotação esquerda simples
	private Node res(Node x) 
	{
		Node y = x.right;
		Node z = y.left;

		y.left = x;
		x.right = z;

		x.height = height(x);
		y.height = height(y);
		
		return y;
	}
	
	
	// Rotação direita simples
	public Node rds(Node y) 
	{
		Node x = y.left;
		Node z = x.right;

		x.right = y;
		y.left = z;

		y.height = height(y);
		x.height = height(x);

		return x;
	}
	
	
    private Node verificarBalanceamento(Node node) 
    {
		// 1. Atualiza altura do nó pai do nó inserido
		node.height = height(node);
		
		// 2. Obtenha o fator de balanceamento deste nó para verificar se ele se tornou desbalanceado
		int fb = calcularFB(node);
		int fbSubArvEsq = calcularFB(node.left);
		int fbSubArvDir = calcularFB(node.right);

		// Se desbalanceado, são 4 casos a serem analisados

		// Rotação direita simples
		if (fb > 1 && fbSubArvEsq >= 0) {
			node = rds(node);
		}

		// Rotação esquerda simples
		if (fb < -1 && fbSubArvDir <= 0) {
			node = res(node);
		}

		// Rotação dupla direita
		if (fb > 1 && fbSubArvEsq < 0) {
			node.left = res(node.left);
			node = rds(node);
		}

		// Rotação dupla esquerda
		if (fb < -1 && fbSubArvDir > 0) {
			node.right = rds(node.right);
			node = res(node);
		}
		
		return node;
	}
    
    
    //---------------------------------------------------------------
    // MÉTODOS da BST
    //---------------------------------------------------------------
    
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
        return 1 + Math.max(height(node.left), height(node.right));
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
		System.out.println(root.key + "(" + root.height + ")");
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

		System.out.println(node.key + "(" + node.height + ")");
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
        


    // Adiciona novo nó
	public void add(int chave) {
		size++;
		root = add(root, chave);
	}
	// Recursivo
	private Node add(Node node, int chave) 
	{
		if (node == null) {
			return new Node(chave);
		}
		else if (chave < node.key ) {
			node.left = add(node.left, chave);
		} 
		else if (chave > node.key) {
			node.right = add(node.right, chave);
		} 
		else {
			return node; 
		}
		
		node = verificarBalanceamento(node);
		
		return node;
	}
    
    
	// Remove nó
	public boolean remove(int pkey) 
	{
    	Node node = search(pkey);
    	
    	if(node == null) {
    		return false;
    	} 
    	else {
    		size--;
    		root = remove(node, pkey);
    		return true;
    	}
	}
	// Recursivo
	private Node remove(Node node, int pkey) 
	{
		// achou o nó a remover

		// caso 1: nó sem filhos 
		if (node.left == null && node.right == null) {
			node = null;
		}
		// caso 2: nó só tem filho à direita 
		else if (node.left == null) {
			Node temp = node;
			node = temp.right;
			temp = null;
		}
		// caso 2: só tem filho à esquerda 
		else if (node.right == null) {
			Node temp = node;
			node = temp.left;
			temp = null;
		}
		else {
			// Nó com 2 filhos: pegue o sucessor do percurso em ordem Menor chave a esquerda

			Node temp = min(node.right);
			node.key = temp.key;
			temp.key = pkey;

			node.right = remove(node.right, temp.key);
		}

		if (node == null) {
			return node;
		}
		
		node = verificarBalanceamento(node);
		
		return node;
	}

    
}
