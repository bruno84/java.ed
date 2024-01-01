package pilhas;

import java_basico.MyException;

public class MyStackArray <T> implements MyInterfaceStack <T>
{
	private int sizeMax;
	private Object[] array;
	private int top;
	
	
	public MyStackArray(int size) {
		this.top = -1;
		this.sizeMax = size;
		this.array = new Object[size];
	}

	
	public void push(T valor) throws MyException	
	{
		System.out.println("\nEmpilhar...\n");

	    if( isFull() ) {
	        throw new MyException("\nERRO: pilha cheia [valor="+valor+"]!!!\n" );
	    }

	    top = top + 1;
	    array[ top ] = valor;
	}

	
	@SuppressWarnings("unchecked")
	public T pop() throws MyException
	{
		System.out.println("\nDesempilhar...\n");

	    if( isEmpty() ) {
	        throw new MyException( "\nERRO: pilha vazia!!!\n" );
	    }

        T retorno = (T) array[ top ];
        top = top - 1;

	    return retorno;
	}

	
	@SuppressWarnings("unchecked")
	public T peek() throws MyException
	{
		System.out.println("\nConsultar o Topo...\n");

	    if( isEmpty() ) {
	        throw new MyException( "\nERRO: pilha vazia!!!\n" );
	    }
	    
	    T retorno = (T) array[ top ];

	    return retorno;
	}
	

	public boolean isFull()
	{
	    if( top == sizeMax-1) {
	        return true;
	    }
	    else { 
	    	return false;
	    }
	}
	
	
	public boolean isEmpty()
	{
	    if( top == -1) {
	        return true;
	    }
	    else { 
	    	return false;
	    }
	}
	
	
	public void show()
	{
	    int i;

		System.out.println("\nExibindo...\n");
		
	    for(i=0; i <= top; i++) {
	        System.out.println("posicao " + i + " = " + array[i] + "\n");
	    }
		System.out.println("topo index = " + top + "\n");
	}
	
}
