package StringsExercises;

public class ReverseWord {
    //criar uma função que inverta cada palavra de uma string, mas mantendo a ordem das palavras
    //ex.: "Eu me chamo Felipe" == "uE em omahc epileF"
    public static void main(String[] args) {
        String s = reverseWords("Oi tudo bem com você?");
        System.out.println(s);
    }
    public static String reverseWords(final String original) {
        String[] words = original.split(" ");

        if (words.length == 0) {
            return original;
        }

        String result = "";
        for (int i = 0; i < words.length; i++) {
            String element = words[i];
            for (int j = element.length()-1; j >= 0; j--) {
                char c = element.charAt(j);
                result += c;
            }
            if (i != words.length-1) {
                result += " ";
            }
        }
        return result;
    }
}