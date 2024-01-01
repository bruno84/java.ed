package pilhas;

public class MainPilha 
{

	public static void main(String[] args) 
	{
		int retorno;
		
		//MyInterfaceStack<Integer> pilha1 = new MyStackArray<Integer>(3);
		MyInterfaceStack<Integer> pilha1 = new MyStackList<Integer>(3);
		
		try {
			pilha1.push(3);
			pilha1.push(5);
			pilha1.push(7);
			//pilha1.push(12); // nao vai dar certo!

			retorno = pilha1.peek();
			System.out.println("elemento no topo = " + retorno);
			
			pilha1.show();
			
			retorno = pilha1.pop();
			System.out.println("desempilhado = " + retorno);

			retorno = pilha1.pop();
			System.out.println("desempilhado = " + retorno);

			retorno = pilha1.pop();
			System.out.println("desempilhado = " + retorno);

			//retorno = pilha1.pop(); // nao vai dar certo!
			//System.out.println("desempilhado = " + retorno);	
			
			pilha1.show();
			
			System.out.println("full? " + pilha1.isFull() );
			
			System.out.println("empty? " + pilha1.isEmpty() );
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
