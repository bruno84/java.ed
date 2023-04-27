package java_diversos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoletaSemRepeticao 
{

	public static void main(String[] args) 
	{
		int[] array = roletaSemRepeticao(11, 20);
		
		for (int i = 0; i < array.length; i++) {
			System.out.println( array[i] );
		}
		
	}
	
	public static int[] roletaSemRepeticao(int vi, int vf)
	{
		int size = vf - vi + 1;
		int[] result = new int[size];
  
        List<Integer> numeros = new ArrayList<Integer>();  
        
        for (int i = vi; i <= vf; i++) {
            numeros.add(i); 
        }  
          
        // embaralhar  
        Collections.shuffle(numeros);  
          
        // aleatorios  
        for (int i = 0; i < size; i++) {  
        	result[i] = numeros.get(i);
        } 

	    return result;
	}
}
