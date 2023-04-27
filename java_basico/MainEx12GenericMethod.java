package java_basico;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Objetivo: exemplificar algumas das principais utilizacoes de Generic em metodos.
 */
public class MainEx12GenericMethod 
{
	// Este metodo permite receber um objeto de qualquer classe.
	// OBS: embora para este uso simples, seja possivel usar Object em vez de Generic,
	// 		outros cenarios sao impeditivos com Object.
	public static void printObject(Object myObj) 
	{
		System.out.println(myObj + " ");
	}
	
	
	// Este metodo permite receber um objeto de qualquer classe, porem usando Generic.
	// OBS: <T> eh normalmente utilizado quando se referir a apenas um objeto.
	public static <T> void printGeneric(T myObj) 
	{
		System.out.println(myObj + " ");
	}
	
	
	// Este metodo permite receber uma lista de qualquer classe.
	// OBS: <E> eh normalmente utilizado quando se referir ao tipo dos elementos de uma colecao.
	public static <E> void printListGeneric(List<E> myList) 
	{
		for(E element : myList) {
			System.out.print(element + " ");
		}
		System.out.println("\n");
	}
	
	
	
    // Este metodo permite receber receber uma lista de uma classe que extende outra classe.
	public static <E extends Comparable<E>> void printListGenericSorted(List<E> myList) 
	{
		Collections.sort(myList);
		
		for(E element : myList) {
			System.out.print(element + " ");
		}
		System.out.println("\n");
	}
    
	
	// Este metodo permite receber uma lista de classes filhas de Number.
	// OBS: este recurso de Generic baseado em heranca eh chamado de "Wildcard".
	// OBS: Number eh classe pai de Integer e Double.
	// OBS: Nao confunda "?" com "T" e "E". 
	//		"T" e "E" sao semelhantes e sao usados para representar o tipo.
	//		"?" eh usado apenas em Wildcard e representa as possiveis classes filhas da classe pai.
    private static double somaWildcard(List<? extends Number> list)
    {
        double soma = 0.0;
        
        for (Number n : list) {
            soma = soma + n.doubleValue();
        }
 
        return soma;
    }
    
    

	public static void main(String[] args) 
	{
		// public static void printObject(Object myObj)  
		System.out.println("-----------------------------------");
		System.out.println("printObject");
		System.out.println("-----------------------------------");
		printObject(100);
		printObject(100.1);
		printObject('X');
		printObject(new Produto(99, "noventa e nove", 99.9));
		System.out.println();
		
		
		// public static <T> void printGeneric(T myObj)  
		System.out.println("-----------------------------------");
		System.out.println("printGeneric");
		System.out.println("-----------------------------------");
		printGeneric(100);
		printGeneric(100.1);
		printGeneric('X');
		printGeneric(new Produto(99, "noventa e nove", 99.9));
		System.out.println();
		
		
		// public static <E> void printListGeneric(List<E> myList) 
		System.out.println("-----------------------------------");
		System.out.println("printListGeneric");
		System.out.println("-----------------------------------");
		System.out.println("listInteger:");
		List<Integer> listInteger = Arrays.asList(4, 5, 6, 7);
		printListGeneric(listInteger);

		System.out.println("listDouble:");
		List<Double> listDouble = Arrays.asList(4.1, 5.1, 6.1, 7.1);	
		printListGeneric(listDouble);

		System.out.println("listCharacter:");		
		List<Character> listChar = Arrays.asList('O', 'L', 'A');	
		printListGeneric(listChar);
		
		System.out.println("listMyClass:");
		List<Produto> listMyClass = Arrays.asList( new Produto(3, "p3", 3.3), new Produto(1, "p1", 1.1), new Produto(2, "p2", 2.2) );
		printListGeneric(listMyClass);
		
		
        // public static <E extends Comparable<E>> void printListGenericSorted(List<E> myList) 
		System.out.println("-----------------------------------");
		System.out.println("printListGenericSorted");
		System.out.println("-----------------------------------");
		printListGenericSorted(listMyClass);
        
        
		// private static double somaWildcard(List<? extends Number> list)
		System.out.println("-----------------------------------");
		System.out.println("somaWildcard");
		System.out.println("-----------------------------------");
        System.out.println("Soma (Integer):\t " + somaWildcard(listInteger));	// 22.0
        System.out.println("Soma (Double):\t "  + somaWildcard(listDouble));	// 22.4
	}
	

}
