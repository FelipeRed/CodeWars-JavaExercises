package StringsExercises;

public class CammelCaseConverter {
    public static void main(String[] args) {
        String str = toCamelCase("the_Stealth_Warrior");
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
    public static String toCamelCase2(String s) {
        String[] words = s.split("[-_]");
        for (int i = 1; i < words.length; i++) {
            char c = words[i].charAt(0);
            char upperChar = Character.toUpperCase(c);
            words[i].replaceFirst(c, upperChar);
        }
    }
}
