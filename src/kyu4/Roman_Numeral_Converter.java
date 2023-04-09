package kyu4;

public class Roman_Numeral_Converter {
    public static void main(String[] args) {
        int x = 40;
        System.out.println("ToRoman(" + x + "): " + toRoman(x));
        String y = "XXIII";
        System.out.println("FromRoman(" + y + "): " + fromRoman(y));
    }
    public static String toRoman(int n) {
        String strRomanNumber = "";
        int[] divisores = {1000, 500, 100, 50, 10, 5, 1};
        char[] caracteres = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

        for (int i = 0; i < divisores.length; i++) {
            int resto = n % divisores[i];
            boolean menor = false;
            if (n/divisores[i] > 0) {
                if ((n >= 900 && n < 1000) || (n >= 90 && n < 100) || (n == 9)) {
                    strRomanNumber += caracteres[i+1];
                    strRomanNumber += caracteres[i-1];
                    n -= divisores[i-1] - divisores[i+1];
                } else {
                    int x = n/divisores[i];
                    if (x > 3) {
                        menor = true;
                        x = 1;
                    }
                    for (int j = 0; j < x; j++) {
                        strRomanNumber += caracteres[i];
                    }
                    if (menor) {
                        strRomanNumber += caracteres[i-1];
                    }
                    n = resto;
                }
            }
        }
        return strRomanNumber;
    }

    public static int fromRoman(String romanNumeral) {
        romanNumeral = romanNumeral.toUpperCase();
        char[][] romanChars = {{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}};

        if (romanNumeral.length() == 1) {
            for (int i = 0; i < romanChars.length; i++) {
                if (romanChars[i][0] == romanNumeral.charAt(0)) {
                    return romanChars[i][1];
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < romanNumeral.length(); i++) {
            char c1 = romanNumeral.charAt(i);
            int x = 0;
            for (int j = 0; j < romanChars.length; j++) {
                if (c1 == romanChars[j][0]) {
                    x = romanChars[j][1];
                }
            }
            //caso não seja o último caratere irei comparar c1 com c2
            if (i < romanNumeral.length() - 1) {
                char c2 = romanNumeral.charAt(i+1);
                int y = 0;
                for (int j = 0; j < romanChars.length; j++) {
                    if (c2 == romanChars[j][0]) {
                        y = romanChars[j][1];
                    }
                }
                if (x >= y) {
                    sum += x;
                } else {
                    sum += y - x;
                    i++;
                }
            } else {
                sum += x;
            }
        }
        return sum;
    }
}
