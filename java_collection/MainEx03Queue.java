package java_collection;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Queue
 * Interface que embasa estruturas de fila. 
 * Permite elementos com repeticao de chaves.
 * Facilita a insersao de elementos no fim e a remocao/acesso de elementos no inicio da fila.
 * @author bruno.monteiro
 */
public class MainEx03Queue 
{	
	public static void main(String[] args) 
	{
		/**
		 * LinkedList
		 * Internamente utiliza uma lista duplamente encadeada.
		 * Conserva a ordem de insercao.
		 * OBS: aceita elementos null.
		 */
		System.out.println("LinkedList");
        Queue<String> linkedList = new LinkedList<String>();
		
        linkedList.add("zzz"); 		// insere no fim
        linkedList.add("aaa"); 		// insere no fim
        linkedList.add("ttt"); 		// insere no fim
        linkedList.add("ttt"); 		// insere no fim	permite repeticao
        linkedList.add("bbb"); 		// insere no fim
        linkedList.add(null); 		// insere no fim
        linkedList.add("ccc"); 		// insere no fim
        
		System.out.println(linkedList); 
		System.out.println("size: " + linkedList.size()); 
		
		String str = linkedList.peek(); 			// apenas consulta inicio
		System.out.println("inicio: " + str); 		// zzz
		
		str = linkedList.remove(); 					// remove do inicio
		System.out.println("removed: " + str); 		// zzz
		
		System.out.println(linkedList); 
		System.out.println("size: " + linkedList.size()); 
		System.out.println();	
		
		
		/**
		 * PriorityQueue
		 * Nao aceita elementos null.
		 * Como nao foi definida prioridades (em compareTo), a estrutra usa a ordem padrao, diferente de LinkedList que mantem a ordem de insersao.
		 */
		System.out.println("PriorityQueue");
        Queue<String> priorityQueue = new PriorityQueue<String>(); 
		
        priorityQueue.add("e"); 		// insere no fim
        priorityQueue.add("a"); 		// insere no fim
        priorityQueue.add("b"); 		// insere no fim
        priorityQueue.add("e"); 		// insere no fim // permite repeticao
        priorityQueue.add("d"); 		// insere no fim 
        priorityQueue.add("c"); 		// insere no fim 
                
        /*
        OBS: a exibi��o (ou itera��o) dos elementos n�o condiz com a ordem com que ser�o removidos.
		Portanto, apesar de estarem desordenados internamente, no momento da remo��o, SIM, vai ser respeitada a ordena��o natural.
        */
		System.out.println(priorityQueue); 
		System.out.println("size: " + priorityQueue.size()); 
		
		str = priorityQueue.peek(); 				// apenas consulta inicio
		System.out.println("peek (inicio): " + str); 		
		System.out.println(priorityQueue);			// nao altera nada
		
		str = priorityQueue.remove();
		System.out.println("remove: " + str); 	//a
		
		str = priorityQueue.remove();
		System.out.println("remove: " + str);	//b
		
		str = priorityQueue.remove();
		System.out.println("remove: " + str);	//c
		
		str = priorityQueue.remove();
		System.out.println("remove: " + str);	//d
		
		System.out.println(priorityQueue); 
		System.out.println("size: " + priorityQueue.size()); 
	}

}
