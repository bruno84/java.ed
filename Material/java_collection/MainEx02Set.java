package java_collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java_basico.Produto;

/**
 * Set
 * Interface que serve de base para estruturas que aceitam apenas valores (chaves) unicos.
 * @author bruno.monteiro
 */
public class MainEx02Set 
{
	public static void main(String[] args) 
	{
		/**
		 * HashSet
		 * Internamente utiliza tabela de dispersao (hash table).
		 * Por isso, destaca-se pela eficiencia: Complexidade O(1) para operacoes de add e delete.
		 * Seus elementos nao sao ordenados.
		 */
		System.out.println("HashSet");
		Set<Produto> hashSet = new HashSet<Produto>();
		hashSet.add( new Produto(0, "zero", 0.0) );
		hashSet.add( new Produto(1, "um", 1.1) );
		hashSet.add( new Produto(1, "ummmmmmm", 1.1) );	// Nao sera adicionado pois a chave eh o atributo "inteiro" definido em hashCode() em MyClass. 
		hashSet.add( new Produto(2, "dois", 2.2) );
		hashSet.add( new Produto(3, "tres", 3.3) );
		hashSet.add( new Produto(4, "quatro", 4.4) );
		hashSet.add( new Produto(5, "quatro", 5.5) );	// Sera adicionado, pois quem eh a chave eh o atributo "inteiro".
		
		System.out.println( hashSet );
		System.out.println( hashSet.size() );
		
		System.out.println( hashSet.remove( new Produto(1, "qqcoisa", 1.1) ) );
		System.out.println( hashSet );
		System.out.println( hashSet.size() );
		System.out.println();
		
		
		/**
		 * TreeSet
		 * Internamente utiliza uma estrutura de arvore.
		 * Internamente utiliza a interface SortedSet, que ordena automaticamente os elementos, por isso, tem menor eficiencia com complexidade O(log n).
		 */
		System.out.println("TreeSet");
		Set<Produto> treeSet = new TreeSet<Produto>();		// ATENCAO: Eh preciso sobrescrever o metodo compareTo em MyClass.
		treeSet.add( new Produto(2, "dois", 2.2) );
		treeSet.add( new Produto(0, "zero", 0.0) );
		treeSet.add( new Produto(1, "um", 1.1) );
		treeSet.add( new Produto(1, "ummmmmm", 1.1) );	
		treeSet.add( new Produto(3, "tres", 3.3) );
		treeSet.add( new Produto(4, "quatro", 4.4) );
		treeSet.add( new Produto(5, "quatro", 5.5) );
		
		System.out.println( treeSet );
		System.out.println( treeSet.size() );
		
		System.out.println( treeSet.remove( new Produto(1, "qqcoisa!!!", 1.1) ) );
		System.out.println( treeSet );
		System.out.println( treeSet.size() );
		System.out.println();
		
		
		/**
		 * LinkedHashSet
		 * Tem como diferencial ter boa eficiencia e manter a ordem de insercao, semelhante ao List.
		 */
		System.out.println("LinkedHashSet");
		Set<Produto> linkedHashSet = new LinkedHashSet<Produto>();		
		linkedHashSet.add( new Produto(5, "quatro", 5.5) );		
		linkedHashSet.add( new Produto(4, "quatro", 4.4) );	// Sera adicionado, pois quem eh a chave eh o atributo "inteiro".
		linkedHashSet.add( new Produto(3, "tres", 3.3) );
		linkedHashSet.add( new Produto(2, "dois", 2.2) );
		linkedHashSet.add( new Produto(1, "um", 1.1) );	
		linkedHashSet.add( new Produto(1, "ummmmm", 1.1) );	// Nao sera adicionado, pois ha repeticao da chave "inteiro"
		linkedHashSet.add( new Produto(0, "zero", 0) );
		
		System.out.println( linkedHashSet );				// Preserva a ordem da adição
		System.out.println( linkedHashSet.size() );
		
		System.out.println( linkedHashSet.remove( new Produto(1, "um", 1.1) ) );
		System.out.println( linkedHashSet );
		System.out.println( linkedHashSet.size() );
		System.out.println();
		

	}

}
