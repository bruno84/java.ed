package filas;

public class MainFila 
{
	public static void main(String[] args) 
	{
		int retorno;
		
		//MyInterfaceQueue<Integer> fila1 = new MyQueueArray<Integer>(3);
		MyInterfaceQueue<Integer> fila1 = new MyQueueList<Integer>(3);
		
		try 
		{
			fila1.add(3);
			fila1.add(5);
			fila1.add(7);
			//fila1.add(12); // nao vai dar certo!

			retorno = fila1.peek();
			System.out.println("primeiro elemento = " + retorno);
			
			fila1.show();
			
			retorno = fila1.remove();
			System.out.println("removido = " + retorno);

			retorno = fila1.remove();
			System.out.println("removido = " + retorno);

			retorno = fila1.remove();
			System.out.println("removido = " + retorno);

			//retorno = fila1.remove(); // nao vai dar certo!
			//System.out.println("removido = " + retorno);	
			
			fila1.show();
			
			fila1.isFull();
			
			fila1.isEmpty();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
