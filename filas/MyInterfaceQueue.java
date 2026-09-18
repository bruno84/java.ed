package filas;

import java_basico.MyExceptionUnchecked;

public interface MyInterfaceQueue <T>
{
    void add(T number) throws MyExceptionUnchecked;
    T remove() throws MyExceptionUnchecked;
    
    T peek() throws MyExceptionUnchecked;	// consulta o início (primeiro elemento)
    
    boolean isEmpty();
    boolean isFull();
    
    void show(); // opcional e auxiliar
}
