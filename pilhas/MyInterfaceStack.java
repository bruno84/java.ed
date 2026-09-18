package pilhas;

import java_basico.MyExceptionUnchecked;

public interface MyInterfaceStack <T>
{
    void push(T number) throws MyExceptionUnchecked; 	// empilhar
    T pop() throws MyExceptionUnchecked;					// desempilhar
    
    T peek() throws MyExceptionUnchecked;				// consultar (topo)
    
    boolean isEmpty();
    boolean isFull();
    
    void show();	// opcional e auxiliar
}
