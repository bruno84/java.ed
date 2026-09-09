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
		 * Não ordenada.
		 */
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("HashMap");
		System.out.println("-----------------------------------------------------------------------------------------");
		Map<String, Produto> hashMap = new HashMap<String, Produto>();
		hashMap.put("a", new Produto(0, "zero", 0) );
		hashMap.put("b", new Produto(1, "um", 1) );
		hashMap.put("b", new Produto(1111, "um2", 1) ); // Cuidado! Substitui elemento com chave "b"
		hashMap.put("d", new Produto(3, "tres", 3) );
		hashMap.put("c", new Produto(2, "dois", 2) );
		hashMap.put(null, new Produto(4, "quatro", 4) );

		System.out.println( hashMap.size() );
		System.out.println( hashMap );

		System.out.println( hashMap.remove( "b" ) );
		System.out.println( hashMap.size() );

		System.out.println("\n keySet() retorna a coleção de chaves (String): ");
		for(String key: hashMap.keySet() ) {
			System.out.print( hashMap.get(key) + " ");
		}

		System.out.println("\n entrySet() retorna a coleção de objetos Entry: ");
		for (Entry<String, Produto> entry : hashMap.entrySet() ) {
			System.out.print( entry + " ");
		}

		/**
		 * LinkedHashMap
		 * Tem boa eficiencia, com complexidade O(1).
		 * Permite apenas uma chave null.
		 * Mantem a ordem de inserção.
		 */
		System.out.println("\n\n-------------------------------------------------------------------------------------");
		System.out.println("LinkedHashMap");
		System.out.println("-----------------------------------------------------------------------------------------");
		Map<String, Produto> linkedHashMap = new LinkedHashMap<String, Produto>();
		linkedHashMap.put("a", new Produto(0, "zero", 0.0) );
		linkedHashMap.put("b", new Produto(1, "um", 1.1) );
		linkedHashMap.put("b", new Produto(1111, "u2", 1.1) ); // Cuidado! Substitui elemento com chave "b"
		linkedHashMap.put("d", new Produto(3, "tres", 3.3) );
		linkedHashMap.put("c", new Produto(2, "dois", 2.2) );
		linkedHashMap.put(null, new Produto(4, "quatro", 4.4) );

		System.out.println( linkedHashMap.size() );
		System.out.println( linkedHashMap );

		System.out.println( linkedHashMap.remove( "b" ) );

		System.out.println( linkedHashMap.size() );
		System.out.println( linkedHashMap );

		/**
		 * TreeMap
		 * Tem eficiencia média, com complexidade O(log n).
		 * Não permite nenhuma chave null.
		 * Elementos são ordenados (por padrão natural ou por compareTo).
		 */
		System.out.println("\n\n-------------------------------------------------------------------------------------");
		System.out.println("TreeMap");
		System.out.println("-----------------------------------------------------------------------------------------");
		Map<String, Produto> treeMap = new TreeMap<String, Produto>();
		treeMap.put("a", new Produto(0, "zero", 0.0) );
		treeMap.put("b", new Produto(1, "um", 1.1) );
		treeMap.put("b", new Produto(1111, "um2", 1.1) ); // Cuidado! Substitui elemento com chave "b"
		treeMap.put("d", new Produto(3, "tres", 3.3) );
		treeMap.put("c", new Produto(2, "dois", 2.2) );
		// treeMap.put(null, new MyClass(4, "quatro") );	// não pode!

		System.out.println( linkedHashMap.size() );
		System.out.println( linkedHashMap );

		System.out.println( linkedHashMap.remove( "b" ) );

		System.out.println( linkedHashMap.size() );
		System.out.println( linkedHashMap );
	}

}
