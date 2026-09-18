package problemas;

public class DuvidasArrayString {

	public static void main(String[] args) 
	{
		// Em Java, o fim de uma String é determinado pelo tamanho da string, não por um caractere especial.
		String str = "A\0B";
		System.out.println(str);
		System.out.println(str.length());
		
		// Isso também acontece mesmo se for um array de char.
		char[] array = {'A', '\0', 'B'};
		System.out.println(array);
		System.out.println(array.length);
		
		
		// Em Java, um array multidimensional pode ter até 255 dimensões!!! =D
		int multi[][][][][][][][][][] = new int[3][3][3][3][3][3][3][3][3][3]; 		
		
	}
}
