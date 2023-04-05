package Encryption;

public class AlternatingSplit {
    //fazer uma função que criptografe uma string concatenado todas as letras em posições ímpares com todas as letras
    //em posições pares por N vezes
    //ex.: ("012345" N=1) == "135024"
    //também fazer uma função que faça o processo inverso
    public static void main(String[] args) {
        String x = encrypt("012345", 2);  //resultado esperado: "304152"
        String y = decrypt("s eT ashi tist!", 2);  //resultado esperado: This is a test!
        System.out.println(x);
        System.out.println(y);
    }
    public static String encrypt(String text, final int n) {
        if (text == "") {
            return text;
        }

        for (int i = 0; i < n; i++) {
            String result = "";
            boolean evens = false;
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < text.length(); k++) {
                    if ((k % 2 != 0) && !evens) {
                        char c = text.charAt(k);
                        result += c;
                    } else if ((k % 2 == 0) && evens) {
                        char c = text.charAt(k);
                        result += c;
                    }
                }
                evens = true;
            }
            text = result;
        }
        return text;
    }

    public static String decrypt(String encryptedText, final int n) {
        if (encryptedText == "") {
            return encryptedText;
        }

        for (int i = 0; i < n; i++) {
            String result = "";
            int j = 0;
            int half = encryptedText.length()/2;
            while (j < encryptedText.length()/2) {
                char c = encryptedText.charAt(half);
                result += c;
                c = encryptedText.charAt(j);
                result += c;
                half++;
                j++;
            }
            if (encryptedText.length() % 2 != 0) {
                result += encryptedText.charAt(encryptedText.length()-1);
            }
            encryptedText = result;
        }
        return encryptedText;
    }
}
