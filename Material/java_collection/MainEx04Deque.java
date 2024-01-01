package java_collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Deque
 * Adiciona a liberdade de manipular o inicio e o fim da estrutura.
 * @author bruno.monteiro
 */
public class MainEx04Deque 
{
	public static void main(String[] args) 
	{
		/**
		 * LinkedList
		 * Internamente utiliza uma lista duplamente encadeada.
		 * Conserva a ordem de insercao.
		 */
		System.out.println("LinkedList");
        Deque<String> linkedList = new LinkedList<String>(); 
		
        linkedList.add("fim1"); 			// insere no fim
        linkedList.addLast("fim2"); 		// insere no fim
        
        linkedList.addFirst("inicio1"); 	// insere no inicio
        linkedList.addFirst("inicio2"); 	// insere no inicio
        linkedList.addFirst("inicio3"); 	// insere no inicio
        
		System.out.println(linkedList); 
		System.out.println("size: " + linkedList.size()); 
		
		String str = linkedList.peek(); 			// apenas consulta inicio
		System.out.println("inicio: " + str); 		
		
		str = linkedList.peekFirst(); 				// apenas consulta inicio
		System.out.println("inicio: " + str); 		
		
		str = linkedList.peekLast(); 				// apenas consulta fim
		System.out.println("final:  " + str); 		
		System.out.println();	
		
		System.out.println(linkedList); 
		System.out.println("size: " + linkedList.size()); 
		System.out.println();
		
		str = linkedList.remove(); 							// remove do inicio
		System.out.println("removed inicio: " + str); 		
		
		str = linkedList.removeFirst(); 					// remove do inicio
		System.out.println("removed inicio: " + str); 	
		
		str = linkedList.removeLast(); 						// remove do fim
		System.out.println("removed final:  " + str); 	
		
		System.out.println();	
		System.out.println(linkedList); 
		System.out.println("size: " + linkedList.size()); 
		System.out.println();	

	}

}
