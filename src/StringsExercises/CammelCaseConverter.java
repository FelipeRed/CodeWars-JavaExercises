package StringsExercises;

public class CammelCaseConverter {
    //fazer uma função que transforme a primeira letra depois de um '-' ou '_' em maiúscula e tire os '-' e '_'
    //ex.: "eu-me-chamo-felipe" == "euMeChamoFelipe"
    public static void main(String[] args) {
        String str = toCamelCase("the-stealth_warrior");
        System.out.println(str);
    }
    public static String toCamelCase(String s){
        String result = "";
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '-' || c == '_') {
                c = s.charAt(i+1);
                result += Character.toUpperCase(c);
                i++;
            } else {
                result += c;
            }
            i++;
        }
        return result;
    }
}
