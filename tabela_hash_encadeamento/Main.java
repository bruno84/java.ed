package tabela_hash_encadeamento;

import java_basico.Produto;

public class Main 
{
	public static void main(String[] args) 
	{	
		TabelaHashEncadeada tabela1 = new TabelaHashEncadeada(31);
		
		tabela1.add(46, new Produto(46, "um", 1.1) );
		tabela1.add(71, new Produto(71, "dois", 2.1) );
		tabela1.add(49, new Produto(49, "tres", 3.1) );
		tabela1.add(26, new Produto(26, "quatro", 4.1) );
		tabela1.add(44, new Produto(44, "cinco", 5.1) );
		
		tabela1.show();
		
		System.out.println( "getSize: " + tabela1.getSize() );
		
		System.out.println( "remove: " + tabela1.remove( 26 ) );
		
		System.out.println( "getCapacity: " + tabela1.getCapacity() );

		System.out.println( "getSize: " + tabela1.getSize() );
		
		tabela1.show();
	}

}
