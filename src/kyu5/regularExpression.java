package kyu5;
/*
Criar uma função que retorne se um input respeita a seguinte regra:
    - não pode ser vazio "";
    - pode ter letras latinas (maiúsculas ou minúsculas);
    - pode ter digitos de zero a nove;
    - não pode ter espaços ou caracteres especiais.
 */
public class regularExpression {
    public static void main(String[] args) {
        String s = "texo_ teste&";
        System.out.println(alphanumeric(s));
    }
    public static boolean alphanumeric(String s){
        return s.matches("[a-zA-Z0-9]+");
    }
}
