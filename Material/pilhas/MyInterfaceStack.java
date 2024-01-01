package pilhas;

import java_basico.MyException;

public interface MyInterfaceStack <T>
{
    void push(T number) throws MyException; 	// empilhar
    T pop() throws MyException;					// desempilhar
    
    T peek() throws MyException;				// consultar (topo)
    
    boolean isEmpty();
    boolean isFull();
    
    void show();	// opcional e auxiliar
}
