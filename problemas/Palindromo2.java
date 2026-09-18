package problemas;

public class Palindromo2
{
    public static boolean isPalindrome(String s)
    {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");

        int size = s.length();
        System.out.println(size);

        String s1 = s.substring(0, size / 2);
        String s2;
        if(size%2 == 0) {
            s2 = s.substring( (size / 2), size);
        } else {
            s2 = s.substring( (size / 2)+1, size);
        }
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        sb2.reverse();

        System.out.println(sb1);
        System.out.println(sb2);

        if(sb1.compareTo(sb2) == 0) {
            return true;
        } else {
            return false;
        }
    }

    static void main()
    {
        System.out.println( isPalindrome("A man, a plan, a canal: Panama") );
    }
}
