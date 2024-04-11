/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string,
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        int i = 0;
        String ans = "";
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == i) {
                ans = ans + ch;
            } else {
                if (ch == 32) {
                    ans = ans + ch;
                }
            }
            i++;
        }
        return ans;
    }
}