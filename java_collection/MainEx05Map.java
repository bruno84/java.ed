package java_collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import java_basico.Produto;

/**
 * Map
 * Estrutura em que cada elemento é composto por um par <chave, valor>.
 * Não pode haver repetição de elementos com a mesma chave.
 * @author bruno.monteiro
 */
public class MainEx05Map 
{	
	public static void main(String[] args) 
	{
		/**
		 * HashMap
		 * Tem boa eficiencia, com complexidade O(1).
		 * Permite apenas uma chave null.
		 * Não ordenada. OBS: A ordenação é baseada apenas na ordem natural da chave.
		 */
		System.out.println("HashMap");
		Map<String, Produto> hashMap = new HashMap<String, Produto>();
		hashMap.put("a", new Produto(0, "zero", 0) );
		hashMap.put("b", new Produto(1, "um", 1) );
		hashMap.put("b", new Produto(1111, "ummmmm", 1) );		// Cuidado! Substitui o outro elemento que também tinha chave "b" 
		hashMap.put("d", new Produto(3, "tres", 3) );
		hashMap.put("c", new Produto(2, "dois", 2) );
		hashMap.put(null, new Produto(4, "quatro", 4) );
		
		System.out.println( hashMap );
		System.out.println( hashMap.size() );
		
		System.out.println( hashMap.remove( "b" ) );
		System.out.println( hashMap.size() );
		
		System.out.println( hashMap.keySet() );

		System.out.println("keySet() retorna a coleção de chaves (String): ");
		for(String key: hashMap.keySet() ) { 
            System.out.print( hashMap.get(key) + " ");  
        }
		
		System.out.println("\n");
		
		System.out.println("entrySet() retorna a coleção de objetos Entry: ");
		for (Entry<String, Produto> entry : hashMap.entrySet() ) {
			System.out.print( entry + " ");
		}

		
		/**
		 * LinkedHashMap
		 * Tem boa eficiencia, com complexidade O(1).
		 * Permite apenas uma chave null.
		 * Mantem a ordem de inserção.
		 */
		System.out.println("LinkedHashMap");
		Map<String, Produto> linkedHashMap = new LinkedHashMap<String, Produto>();
		linkedHashMap.put("a", new Produto(0, "zero", 0.0) );
		linkedHashMap.put("b", new Produto(1, "um", 1.1) );
		linkedHashMap.put("b", new Produto(1111, "ummmmm", 1.1) );		// Cuidado! Substitui o outro elemento que também tinha chave "b" 
		linkedHashMap.put("d", new Produto(3, "tres", 3.3) );
		linkedHashMap.put("c", new Produto(2, "dois", 2.2) );
		linkedHashMap.put(null, new Produto(4, "quatro", 4.4) );
		
		System.out.println( linkedHashMap );
		System.out.println( linkedHashMap.size() );
		
		System.out.println( linkedHashMap.remove( "b" ) );
		System.out.println( linkedHashMap.size() );
		
		System.out.println( linkedHashMap.keySet() );

		for(String key: linkedHashMap.keySet() ) { 
            System.out.print( linkedHashMap.get(key) + " ");  
        }
		System.out.println("\n\n");
		
		
		/**
		 * TreeMap
		 * Tem eficiencia média, com complexidade O(log n).
		 * Não permite nenhuma chave null.
		 * Elementos são ordenados (por padrão natural ou por compareTo).
		 */
		System.out.println("TreeMap");
		Map<String, Produto> treeMap = new TreeMap<String, Produto>();
		treeMap.put("a", new Produto(0, "zero", 0.0) );
		treeMap.put("b", new Produto(1, "um", 1.1) );
		treeMap.put("b", new Produto(1111, "ummmmm", 1.1) );		// Cuidado! Substitui o outro elemento que também tinha chave "b" 
		treeMap.put("d", new Produto(3, "tres", 3.3) );
		treeMap.put("c", new Produto(2, "dois", 2.2) );
		// treeMap.put(null, new MyClass(4, "quatro") );	// não pode!
		
		System.out.println( treeMap );
		System.out.println( treeMap.size() );
		
		System.out.println( treeMap.remove( "b" ) );
		System.out.println( treeMap.size() );
		
		System.out.println( treeMap.keySet() );

		for(String key: treeMap.keySet() ) { 
            System.out.print( treeMap.get(key) + " ");  
        }
		System.out.println("\n\n");

	}

}
