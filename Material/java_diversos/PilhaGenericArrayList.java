package java_diversos;

import java.util.ArrayList;
import java.util.List;

public class PilhaGenericArrayList 
{
	static class Pilha <E>
	{
		private List<E> lista = new ArrayList<E>();
		
		public void empilhar(E elem) {
			lista.add(elem);
		}
		
		public E desempilhar() {
			int last = lista.size()-1;
			if(last < 0) { 
				return null;
			} else {
				return (E) lista.remove(last);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		Pilha<Integer> pilhaInteger = new Pilha<Integer>();
		pilhaInteger.empilhar(1);
		pilhaInteger.empilhar(2);
		System.out.println( "pilhaInteger.desempilhar(): " + pilhaInteger.desempilhar() );
	}
}