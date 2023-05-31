package w10;


public class Q1 {
    public static void main(String[] args) {
        System.out.println(substituteAI("flabbergasted"));
        System.out.println(substituteAI("Astronaut"));
    }

    public static String substituteAI(String str){
        if (str.length() == 0) return str;
        if (str.charAt(0) == 'a')
            str = 'i' + substituteAI(str.substring(1));
        else
            str = str.charAt(0) + substituteAI(str.substring(1));
        return str;
    }
}