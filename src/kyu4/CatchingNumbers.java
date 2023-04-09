package kyu4;
/*
    Fazer uma função que dado um input N retorne 0 se o input não for "interessante", 1 se (N+1 ou N+2) for
    "interessante", e 2 se N for "interessante".
    N sempre será maior que 0 e menor que 1.000.000.

    REGRA PARA SER INTERESSANTE
    Deve ter 3 dígitos ou mais e um ou mais os itens a seguir:
        - ser um número seguido por apenas zeros (1000, 900)
        - ter todos os dígitos iguais (111, 2222)
        - ter os dígitos crescentes (123, 7890)  ==> zeros vindos depois de 9 são válidos aqui
        - dígitos decrescentes (765, 3210)
        - palíndromos (121, 11311)
        - ser igual a um dos números fornecidos dentro do array int[] awesomePhrases
     */

public class CatchingNumbers {
    public static int iteration = 0;
    public static void main(String[] args) {
        int i = isInteresting(1335, new int[]{1337, 256});
        System.out.println(i);
    }
    public static int isInteresting(int number, int[] awesomePhrases) {
        String n = Integer.toString(number);

        if (number < 98) {
            iteration = 0;
            return 0;
        } else if (number < 100) {  //98 + 2 se torna um número interessante
            return 1;
        }

        int awesomeArray = checar_awesomeArray(number, awesomePhrases);
        boolean numeroRedondo = checar_numeroRedondo(n);
        boolean todosIguais = checar_todosIguais(n);
        boolean crescente = checar_crescente(n);
        boolean decrescente = checar_decrescente(n);
        boolean palindromo = checar_palindromo(n);

        if (numeroRedondo || todosIguais || crescente || decrescente || palindromo || awesomeArray == 2) {
            iteration = 0;
            return 2;
        } else if (awesomeArray == 1){
            return 1;
        } else {
            //se esta for a primeira interação, verificar se N+1 ou N+2 são interessantes
            if (iteration == 0) {
                iteration++;  //para controlar a recursividade
                for (int i = 0; i < 2; i++) {
                    number++;
                    int a = isInteresting(number, awesomePhrases);
                    if (a != 0) {
                        iteration = 0;
                        return 1;
                    }
                }
            }
            return 0;
        }
    }
    public static int checar_awesomeArray(int number, int[] awesomePhrases) {
        for (int num : awesomePhrases) {
            if (num == number) {
                return 2;
            } else if (num == number+1 || num == number+2) {
                return 1;
            }
        }
        return 0;
    }
    public static boolean checar_numeroRedondo(String str) {
        int condicao = 0;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '0') {
                condicao += 1;
                break;
            }
        }
        if (condicao == 0) {
            return true;
        }
        return false;
    }
    public static boolean checar_todosIguais(String str) {
        int condicao = 0;
        int x = Character.getNumericValue(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            int y = Character.getNumericValue(str.charAt(i));
            if (x != y) {
                condicao += 1;
                break;
            }
        }
        if (condicao == 0) {
            return true;
        }
        return false;
    }
    public static boolean checar_crescente(String str) {
        int condicao = 0;
        for (int i = 0; i < str.length()-1; i++) {
            int x = Character.getNumericValue(str.charAt(i));
            int y = Character.getNumericValue(str.charAt(i+1));
            if (y != x + 1) {
                if (!(y == 0 && x == 9)) {  //890 é valido pela regra do exercício
                    condicao += 1;
                    break;
                }
            }
        }
        if (condicao == 0) {
            return true;
        }
        return false;
    }
    public static boolean checar_decrescente(String str) {
        int condicao = 0;
        for (int i = 0; i < str.length()-1; i++) {
            int x = Character.getNumericValue(str.charAt(i));
            int y = Character.getNumericValue(str.charAt(i+1));
            if (y != x-1) {
                condicao += 1;
                break;
            }
        }
        if (condicao == 0) {
            return true;
        }
        return false;
    }
    public static boolean checar_palindromo(String str) {
        String str_inversa = "";
        for (int i = str.length()-1; i >= 0; i--) {
            char c = str.charAt(i);
            str_inversa += c;
        }
        return str.equals(str_inversa);
    }
}
