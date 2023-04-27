package java_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * Exemplos da interface da Collection: List
 * Permite implementar estruturas lineares, que pode haver elementos repetidos.
 * @author bruno.monteiro
 */
public class MainEx01List 
{
	public static void main(String[] args) 
	{
		/**
		 * ArrayList: implementa List
		 * Elementos sao armazenados de forma adjacente na memoria. 
		 * Ele preserva a ordem das adicoes.
		 * Facilita a manipulacao, porem eh mais lento que array, pois novas instancias sao criadas/clonadas quando requer mais capacidade.
		 * Capacidade: size+50%
		 */
        System.out.println("ArrayList");
        // OBS: definir a capacidade eh opcional, mas aumenta a eficiencia. 
        List<String> list1 = new ArrayList<String>(10);
        list1.add(0, "zero"); 		// index 0
        list1.add(1, "um"); 		// index 1
        list1.add("dois"); 			// no final
        list1.add("tres"); 			// no final
        list1.add("quatro"); 		// no final
        System.out.println("size = " + list1.size());
        System.out.println(list1); 
        
        String str = list1.remove(1); 	
        boolean bool = list1.remove("tres"); 
        System.out.println("remove(1): " + str); 	// dois
        System.out.println("remove: " + bool); 	// true
        System.out.println(list1); 
         
        System.out.println("get(0): " + list1.get(0) ); // zero 
  
        list1.set(0, "novo"); 				// Substitui no indice informado
        list1.add("novo");					// ArrayList permite duplicatas
        System.out.println(list1); 
        
        int index = list1.indexOf("novo");	// Obtem indice do conteudo informado (primeira ocorrencia)
        System.out.println(index);
        list1.set(index, "novissimo"); 
        System.out.println(list1); 
        
        List<String> list2 = new ArrayList<String>(); 
        
        list2.add("ZERO"); 
        list2.add("UM"); 
        list2.add("DOIS"); 
        
        list1.addAll(2, list2); 	// Adiciona list2 no index 2
        System.out.println(list1); 
        System.out.println();
       
        // Ordena a lista. Se primitivo considera a natureza do tipo.
        // Se objeto deve-se sobrescrever o metodo compareTo.
        Collections.sort(list1);	
        
        for(String string : list1) {
			System.out.println(string);
		}
        System.out.println();
        
        
		/**
		 * LinckedList: implementa List 
		 * Elementos Nao sao armazenados de forma adjacente na memoria. 
		 * Internamente eh uma lista duplamente encadeada.
		 * Melhor eficiencia em: add, remove (elementos no meio, se comparado com ArrayList)
		 * Pior eficiencia em: acessar um elemento, pois nao eh indexado.
		 */
        System.out.println("LinkedList");
        List<String> linkedList = new LinkedList<String>();
        linkedList.add("zero"); 			
        linkedList.add("um");
        linkedList.add("dois");		// adicionados ao final	
        System.out.println(linkedList); 
        System.out.println();
                
		/**
		 * Vector: implementa List
		 * Muito parecida com ArrayList.
		 * Diferencas: thread-safe; capacidade eh size+100%
		 */
        System.out.println("Vector");
        List<String> vector = new Vector<String>(); 
        vector.add("zero"); 		
        vector.add("um"); 		
        vector.add("dois");
        System.out.println(vector); 
        System.out.println();
        
        
		/**
		 * Stack: estende Vector
		 * Adiciona novos metodos para se comportar como uma pilha.
		 */
        System.out.println("Stack");
        Stack<String> stack = new Stack<String>(); 
        stack.add("zero"); 		
        stack.add("um"); 		
        stack.add("dois"); 	
        System.out.println(stack); 
        System.out.println(stack.peek()); // consulta elemento do topo
        System.out.println(stack); 
        str = stack.pop();
        System.out.println("removido: " + str);  // remove elemento do topo
        System.out.println(stack);
	}

}
