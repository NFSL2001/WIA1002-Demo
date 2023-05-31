package w10;

public class Q2 {
    public static void main(String[] args) {
        for(String str: permuteString("abc"))
        System.out.println(str);
    }

    public static int factorial(int i){
        // base case
        if (i == 1 || i == 0)
            return 1;
        return i * factorial(i - 1);
    }

    public static String[] permuteString(String str) {
        // base case
        if (str.length() == 1)
            return new String[] {str};
        
        int totalPerms = factorial(str.length());
        String[] allPerms = new String[totalPerms];
        int allPermsIndex = 0;
        for (int i=0; i < str.length(); i++) {
            char chr = str.charAt(i);
            //remove character at index i
            String substr = new StringBuilder(str).deleteCharAt(i).toString();
            String[] permStrings = permuteString(substr);
            for (String perm : permStrings) {
                allPerms[allPermsIndex] = chr + perm;
                allPermsIndex += 1;
            }
        }

        return allPerms;
    }

    /* Sample ans */
    // public static void permuteString(String beginningString, String endingString) {
    //     if (endingString.length() <= 1)
    //         System.out.println(beginningString + endingString);
    //     else
    //         for (int i = 0; i < endingString.length(); i++) {
    //             // remove character at index i
    //             String newString = endingString.substring(0, i) + endingString.substring(i + 1);
    //             permuteString(beginningString + endingString.charAt(i), newString);
    //         }
    // }
}
