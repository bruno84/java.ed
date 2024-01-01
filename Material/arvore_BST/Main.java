package arvore_BST;

public class Main 
{

	public static void main(String[] args) 
	{
		BST arvore1 = new BST();

		arvore1.add(10);
		arvore1.add(40);
		arvore1.add(30);
		arvore1.add(50);
		arvore1.add(20);
		
		arvore1.print();
		
		arvore1.printInOrder();
		
		System.out.println( "min: " + arvore1.min().key );
		
		System.out.println( "max: " + arvore1.max().key );
		
		System.out.println( "height: " + arvore1.height() );
		
		System.out.println( "nodesComplete: " + arvore1.nodesComplete( arvore1.height() ) );
		
		System.out.println( "successor: " + arvore1.successor( arvore1.search(30) ).key );
		
		System.out.println( "predecessor: " + arvore1.predecessor( arvore1.search(30) ).key );
		
		System.out.println( "search: " + arvore1.search(30).key );
		
		System.out.println( "getSize: " + arvore1.getSize() );
		
		System.out.println( "remove: " + arvore1.remove(30).key );
		
		System.out.println( "getSize: " + arvore1.getSize() );
		
		arvore1.printInOrder();
	}

}
