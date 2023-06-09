package kyu7;

public class DontGiveMeFive {
    //criar uma função que conte quantos números dentro de um intervalo não possuem '5'
    //ex. de números não considerados: 5, 15, 50, 51, 52
    public static void main(String[] args) {
        int n = dispensarCincos(1, 55);
        System.out.println(n);
    }
    public static int dispensarCincos(int inicio, int fim) {
        int counter = 0;
        for (int i = inicio; i <= fim; i++) {
            String s = String.valueOf(i);
            if (s.contains("5")) {
                counter++;
            }
        }
        return counter;
    }
}
