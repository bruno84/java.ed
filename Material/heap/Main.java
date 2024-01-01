package heap;

public class Main 
{
	public static void main(String[] args) 
	{
		try 
		{
			Heap heap1 = new Heap();
			
			heap1.add(10);
			heap1.add(30);
			heap1.add(40);
			heap1.add(50);
			heap1.add(20);
			
			
			heap1.showArray();
			heap1.showHeap();
			
			System.out.println( "isEmpty: " + heap1.isEmpty() );
			
			System.out.println( "getCapacity: " + heap1.getCapacity() );
			
			System.out.println( "getTail: " + heap1.getTail() );
			
			System.out.println( "height: " + heap1.height() );
			
			System.out.println( "nodesComplete: " + heap1.nodesComplete( heap1.height() ) );
			
			System.out.println( "left: " + heap1.left(0) );
			
			System.out.println( "right: " + heap1.right(0) );
			
			System.out.println( "parent: " + heap1.parent(1) );
			
			System.out.println( "remove: " + heap1.remove() );
			
			heap1.showArray();
			heap1.showHeap();
			
			System.out.println( "getTail: " + heap1.getTail() );

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
