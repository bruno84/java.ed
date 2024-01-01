package java_basico;

/*
 * Objetivo: exemplificar utilizacao de Generic em classe.
 */
public class MainEx13GenericClass 
{
	// Esta classe (Pilha) vai ser capaz de manipular objetos da classe "E",
	// informada na instanciacao de Pilha.
	static class Pilha <E>
	{
		private int max;
		private int topo;
		private E[] array;
		
		@SuppressWarnings("unchecked")
		public Pilha(int max)
		{
			this.max = max;
			topo = -1;
			array = (E[]) new Object[max];
		}
		
		public void empilhar(E elem) throws Error
		{
			if( topo < max-1 ) {
				topo = topo + 1;
				array[topo] = elem;
			}
			else {
				throw new Error();
			}
		}
		
		public E desempilhar() throws Error
		{
			E valor;
			
			if( topo >= 0 ) {
				valor = array[topo];
				topo = topo - 1;
			}
			else {
				throw new Error();
			}
			
			return valor;
		}
	}
	
	
	public static void main(String[] args) 
	{
		// class Pilha<E>
		Pilha<Integer> pilhaInteger = new Pilha<Integer>(5);
		Pilha<String>  pilhaString  = new Pilha<String>(5);

		pilhaInteger.empilhar(1);
		pilhaInteger.empilhar(2);
		pilhaInteger.empilhar(3);
		System.out.println( "pilhaInteger.desempilhar(): " + pilhaInteger.desempilhar() );
		
		pilhaString.empilhar("um");
		pilhaString.empilhar("dois");
		pilhaString.empilhar("tres");
		System.out.println( "pilhaString.desempilhar(): " + pilhaString.desempilhar() );
	}

}
