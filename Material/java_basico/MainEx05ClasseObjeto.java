package java_basico;

public class MainEx05ClasseObjeto 
{
	public static void main(String[] args) 
	{
		Produto obj1 = new Produto();
		Produto obj2 = new Produto(2, "Arroz", 6);
		Produto obj3 = new Produto(3, "Feijao", 10);

		System.out.println( obj1.toString() );
		System.out.println( obj2.toString() );
		System.out.println( obj3 );
		System.out.println();
				
		obj1.setCodigo(10);
		obj1.setNome("Alice");
		
		System.out.println( obj1.getCodigo() );
		System.out.println( obj1.getNome() );
		System.out.println();
		
		// Passagem de parametro: sempre por valor.
		// STACK: eh a copia do valor que esta na stack. OK.
		// HEAP: com a copia do valor da referancia do objeto (que fica na stack), acessamos o objeto na heap.
		
		int num = 10;
		System.out.println("antes  =   " + num );
		System.out.println("antes  =   " + obj1 );
		
		change(num, obj1);
		
		System.out.println("depois =   " + num ); 	// 10
		System.out.println("depois =   " + obj1 );	// Alice, 1000
	}


	public static void change(int myNum, Produto myObject)
	{
		myNum = 1000;
		myObject.setCodigo(1000);
		System.out.println("dentro =   " + myNum );
		System.out.println("dentro =   " + myObject );
	}
	
	
}
