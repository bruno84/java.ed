package java_basico;

public class MainEx09Strings 
{	
	public static void main(String[] args) 
	{
		/*
		 * Observacao1: Strings em Java sao suportados internamente por array de char. 
		 * Da mesma forma que arrays sao imutaveis, Strings tambem sao. 
		 * Portanto, sempre que uma String eh alterada, uma nova String eh criada.
		 * 
		 * Observacao2: Os metodos que produzem alteracao na string devem usar atribuicao.
		 */
		String str1 = "Bruna";
		System.out.println(str1.getBytes());
		str1 = "Bruno";
		System.out.println(str1.getBytes());
		
		System.out.println(str1.length());
		
		System.out.println(str1.charAt(0));
		
		System.out.println(str1.indexOf("ru", 0) ); // primeira ocorrencia, a partir de i (-->)
		
		System.out.println(str1.lastIndexOf("o", str1.length() ) ); // ultima ocorrencia, a partir de j (<--)
		
		System.out.println(str1.substring(1, 4)); // i , j-1 index
		
		System.out.println( str1.compareTo("Ana") ); 	// 1
		System.out.println( str1.compareTo("Bruno") );	// 0
		System.out.println( str1.compareTo("Carlos") ); //-1
		
		System.out.println( str1.equals("Ana") );
		
		System.out.println( str1.toLowerCase() );
		
		System.out.println( str1.toUpperCase() );
		
		str1 = "  B r u n o  ";
		System.out.println( str1 ); 
		str1 = str1.trim();				// nao remove no meio
		System.out.println( str1 );  
		
		System.out.println( str1.replace(" ", "") );
				
		str1 = str1.concat(" Monteiro");
		System.out.println( str1 );
		
		String[] parts = str1.split(" ");
		for (int i = 0; i < parts.length; i++) {
			System.out.print("["+parts[i]+"] ");
		}
		System.out.println("\n");
		
		/*
		 * StringBuffer eh uma classe semelhante a String, porem eh mutavel.
		 * Eh indicado para cenarios com muitas alteracoes, devido ganho de eficiencia.
		 * Os metodos que produzem alteracao na string nao precisam de atribuicao.
		 */
		StringBuffer sb1 = new StringBuffer("Bruno");
		System.out.println(sb1.hashCode());
		System.out.println(sb1.length());
		
		sb1.append(" Monteiro");
		System.out.println(sb1.hashCode());
		System.out.println(sb1.length());

		System.out.println( sb1.insert(5, " de Sousa") );
		
		System.out.println( sb1.delete(5, 7) );
				
		System.out.println(sb1.reverse());
				
		System.out.println( sb1.delete(0, sb1.length()) ); // deleta tudo
		System.out.println( sb1.append("Bruno") );
		
		System.out.println( sb1.replace(2, 3, "e") ); // nao confundir com o replace de String

		
	}

}
