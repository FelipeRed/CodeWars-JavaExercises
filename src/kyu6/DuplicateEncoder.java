package kyu6;

public class DuplicateEncoder {
    //criar uma função que substitua as letras repetidas de uma string por ")" e as que não se repetirem por "("
    //ex.: "Alfabeto((" == ")(()(((())"
    public static void main(String[] args) {
        String code = encode("Sabado)");
        System.out.println(code);
    }
    static String encode(String word){
        word = word.toUpperCase();
        String result = "";
        boolean[] charRepeat = new boolean[word.length()];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == c && i != j) {
                    charRepeat[i] = true;
                    break;
                } else {
                    charRepeat[i] = false;
                }
            }
        }

        for (boolean bool : charRepeat) {
            if (bool) {
                result += ')';
            } else {
                result += '(';
            }
        }

        return result;
    }
}
