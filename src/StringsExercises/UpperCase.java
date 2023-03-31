package StringsExercises;

public class UpperCase {  //criar uma função que transforme a primeira letra de cada palavra de uma String em maiúscula
    public static void main(String[] args) {
        String frase = "esta é uma frase teste."; //resultado esperado: "Esta É Uma Frase Teste."
        frase = captalizeWords(frase);
        System.out.println(frase);
    }
    public static String captalizeWords(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || str.charAt(i-1) == ' ') {
                result += Character.toUpperCase(str.charAt(i));
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }
}
