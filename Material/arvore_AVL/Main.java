package arvore_AVL;

public class Main 
{

	public static void main(String[] args) 
	{
		AVL arvore1 = new AVL();

		arvore1.add(10);
		arvore1.add(5);
		arvore1.add(2);
		arvore1.add(40);
		arvore1.add(30);
		arvore1.add(50);
		arvore1.add(20);
		
		arvore1.print();
		
		arvore1.printInOrder();
		
		System.out.println( "calcularFB: " + arvore1.calcularFB());
		
		System.out.println( "min: " + arvore1.min().key );
		
		System.out.println( "max: " + arvore1.max().key );
		
		System.out.println( "height: " + arvore1.height() );
		
		System.out.println( "nodesComplete: " + arvore1.nodesComplete( arvore1.height() ) );
				
		System.out.println( "search: " + arvore1.search(30).key );
		
		System.out.println( "getSize: " + arvore1.getSize() );
		
		System.out.println( "remove: " + arvore1.remove(30) );
		
		System.out.println( "getSize: " + arvore1.getSize() );
		
		System.out.println( "calcularFB: " + arvore1.calcularFB());
		
		arvore1.print();
		
		arvore1.printInOrder();
	}

}
