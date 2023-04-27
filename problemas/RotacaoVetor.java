package problemas;

public class RotacaoVetor 
{	
	public static void main(String[] args) 
	{
		int vetor1[] = {1, 2, 3, 4, 5};
		int x = 1;
		
		int size = vetor1.length;
		int[] vetor2 = new int[size];
		int j=0;
		
		for (int i = 0; i < size; i++) 
		{
			j = (i+x) % size;
			vetor2[i] = vetor1[j];
		}
		
		for (int i = 0; i < size; i++) {
			System.out.print(vetor2[i] + " ");
		}
	}
}