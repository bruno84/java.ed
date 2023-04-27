package listas_encadeadas;

public interface MyInterfaceList <E>
{	
    void addFirst(E value);
    void addLast(E value);
    boolean addAfter(E dado, E crit);
    
    E peekFirst();
    E peekLast();
    
    E search(E crit);
    
    E removeFirst();
    E removeLast();
    E remove(E crit); 
    
	void show();			// opcional
	void showReverse();		// opcional
}
