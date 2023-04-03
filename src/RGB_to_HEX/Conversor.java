package RGB_to_HEX;

import java.util.ArrayList;

public class Conversor {  //criar uma função que recebe o código RGB em decimal e retornal em Hexadecimal com 6 letras
    public static void main(String[] args) {
        String hex = rgb(111, 222, 117);
        System.out.println(hex);
    }
    public static String rgb(int r, int g, int b) {
        int[] rgb = {r, g, b};
        Object[] hex = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F'};
        ArrayList<Integer> valores = new ArrayList<>();

        for (int i = 0; i < rgb.length; i++) {
            int n = rgb[i];
            if (n < 0) {
                n = 0;
            } else if (n > 255) {
                n = 255;
            }
            int resto = n % 16;
            int result = n / 16;
            valores.add(result);
            valores.add(resto);
        }

        String str = "";
        for (int j = 0; j < valores.size(); j++) {
            int x = valores.get(j);
            str += hex[x];
        }
        return str;
    }
}
