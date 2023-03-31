package StringsExercises;

public class DuplicateEncoder {  //criar uma função que substitua as letras repetidas de uma string por ")" e as que não
                                 //se repetirem por "("
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

        for (int k = 0; k < charRepeat.length; k++) {
            if (charRepeat[k]) {
                result += ')';
            } else {
                result += '(';
            }
        }

        return result;
    }
}

/*
    static String encode(String word){
        word = word.toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean repeat = false;

            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == c && i != j) {
                    repeat = true;
                    break;
                }
            }

            if (repeat) {
                word = word.replace(c, ')');
            } else {
                word = word.replace(c, '(');
            }
        }
        return word;
    }
*/