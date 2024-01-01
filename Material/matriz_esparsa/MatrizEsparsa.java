package matriz_esparsa;

public class MatrizEsparsa 
{

	public static void show(Object[][] m) 
	{
		int linhas = m.length;
		int colunas = m[0].length;
				
		for (int l=0; l<linhas; l++) 
		{
			System.out.println();
			
			for (int c=0; c<colunas; c++) {
				System.out.print(m[l][c] + "\t");
			}
		}
	}
	
	public static <T extends Number> boolean isSparse(T[][] m)
	{
		int linhas = m.length;
		int colunas = m[0].length;
		int size = linhas * colunas;
		int count = 0;
				
		for (int l=0; l<linhas; l++) 
		{
			for (int c=0; c<colunas; c++) 
			{
				if( m[l][c] == null ) {
					count++;
				} else if ( m[l][c] == (Number) 0 ) {
					count++;
				}
			}
		}
		
		System.out.println("count = " + count);
		
		if(count > (size/2) ) {
			return true;
		} else {
			return false;
		}
	}
	
	// TODO incompleto
	
}
