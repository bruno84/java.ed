package problemas;

import java.util.Stack;

public class PilhaValidarParenteses 
{
	public static void main(String[] args) 
	{
		System.out.println( isValid( "()") );
		System.out.println( isValid( "(())" ) );
		System.out.println( isValid( "()()" ) );
		System.out.println( isValid( "(A)" ) );
		System.out.println( isValid( "(A)(B)" ) );
		
		System.out.println( isValid( "(" ) );
		System.out.println( isValid( ")(" ) );
		System.out.println( isValid( ")()(" ) );
		System.out.println( isValid( "(A(" ) );
		System.out.println( isValid( "(A)(B" ) );
	}
	
	public static boolean isValid(String s) 
    {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            
            switch( c )
            {
                case '(' : stack.push(c); break;
                
                case ')' : 
                    if(stack.isEmpty()) {
                        return false;
                    } else if(stack.pop() != '(') {
                        return false;
                    }
                    break;
            }
        }
        
        return stack.isEmpty();
    }
}
