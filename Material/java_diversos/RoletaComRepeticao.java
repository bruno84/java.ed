package java_diversos;

import java.util.Random;

public class RoletaComRepeticao 
{

	public static void main(String[] args) 
	{
		int[] array = roletaComRepeticao(11, 20);
		
		for (int i = 0; i < array.length; i++) {
			System.out.println( array[i] );
		}
	}
	
	public static int[] roletaComRepeticao(int vi, int vf)
	{
		int size = vf - vi + 1;
		int[] result = new int[size];
           
        for (int i = 0; i < size; i++) {  
        	Random random = new Random() ;
            int randomNumber = random.nextInt(vf + 1 - vi) + vi;
            result[i] = randomNumber;
        } 

	    return result;
	}
}
