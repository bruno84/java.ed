package problemas;

public class LC14_LongestCommonPrefix
{
    public static String longestCommonPrefix(String[] strs)
    {
        int size = strs.length;
        String prefixo = "";

        if (size == 0) {
            return prefixo;
        }

        int c = 0;
        char ch;

        while(true)
        {
            try {
                ch = strs[0].charAt(c);

                for (int s = 1; s < size; s++)
                {
                    if(ch != strs[s].charAt(c)) {
                        return prefixo;
                    }
                }

                prefixo = prefixo + ch;

                c++;
            }
            catch (IndexOutOfBoundsException e) {
                return prefixo;
            }
        }

    }
}
