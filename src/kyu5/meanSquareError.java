package kyu5;

import java.util.Arrays;
/*
Criar uma função que receba dois arrays de tamanhos iguais, compare todos os itens de mesma posição, e retorne a soma
das comparações ao quadrado e divido pelo número de elementos do array.
 */
public class meanSquareError {
    public static void main(String[] args) {
        int[] a1 = {10, 20, 10, 2};
        int[] a2 = {10, 25, 5, -2};
        System.out.println("Solução sem criar um terceiro array: " + solution1(a1, a2));
        System.out.println("Solução criando um terceiro array: " + solution2(a1, a2));
    }
    public static double solution1(int[] arr1, int[] arr2) {
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum += Math.pow((arr1[i] - arr2[i]), 2);
        }
        return (double) sum / arr1.length;
    }
    public static double solution2(int[] arr1, int[] arr2) {
        double[] arr3 = new double[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] += Math.pow((arr1[i] - arr2[i]), 2);
        }
        return Arrays.stream(arr3).sum() / arr1.length;
    }
}
