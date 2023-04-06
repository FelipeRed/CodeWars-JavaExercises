package kyu5;

public class StringIncrementer {
    //fazer uma função que incremente o valor ao final de uma string
    //se não tiver um número no final da string então adiciona-se '1' ao final da string ex.: "abc" == "abc1"
    //0 antes do número devem ser preservados ex.: "abc0043" == "abc0044"
    //se a string for vazia retorna '1'
    public static void main(String[] args) {
        String[] str = {"foobar000", "foo", "foobar001", "foobar99", "foobar099", "", "foo99bar99"};
        for (String s : str) {
            System.out.println(incrementString(s));
        }
    }
    public static String incrementString(String str) {
        if (str.equals("")) {
            return "1";
        }

        char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char c = str.charAt(str.length() - 1);
        boolean isNumber = false;
        //primeiro irei verificar se o último caractere de str é um número ou não
        for (char n : nums) {
            if (c == n) {
                isNumber = true;
                break;
            }
        }

        if (!isNumber) {  //caso não seja um número retorno a concatenação de str + '1'
            return str + '1';
        } else if (c == '0') {  //caso o último número seja um '0' eu vou trocá-lo por '1' e retornar str
            str = str.substring(0, str.length() - 1);
            return str + '1';
        } else {
            //irei percorrer str de trás pra frente procurando a posição do primeiro caractere não númerico
            //e atribui-lo ao valor de first
            int first = 0;
            for (int i = str.length()-1; i>=0; i--) {
                isNumber = false;
                c = str.charAt(i);
                for (char n : nums) {
                    if (c == n) {
                        isNumber = true;
                        break;
                    }
                }
                if (!isNumber) {
                    if (i != 0) {
                        first = i;
                        break;
                    }
                }
            }
            //a partir de first eu irei percorrer str até o final capturando apenas os
            //números para ter qual o final númerico de str (que chamei de strEnd)
            String strEnd = "";
            for (int j = first; j < str.length(); j++) {
                c = str.charAt(j);
                for (char n : nums) {
                    if (c == n) {
                        strEnd += c;
                    }
                }
            }
            if(strEnd.length() > 9) {  //caso o número sejá muito grande para um int
                strEnd = strEnd.substring(strEnd.length()-9);
            }
            //acrescentarei 1 ao final númerico de str que encontrei
            int x = Integer.parseInt(strEnd) + 1;
            String newEnd = Integer.toString(x);

            //para não perder zeros quem venham antes do número (ex.: 0041)
            if (strEnd.length() > newEnd.length()) {
                int y = strEnd.length() - newEnd.length();
                newEnd = strEnd.substring(0, y);
                newEnd += x;
            }


            int z = str.indexOf(strEnd);
            if (str.indexOf(strEnd, z+1) != -1) {  //o if irá verificar se o strEnd acontece
                str = str.substring(0, first+1);            //mais de uma vez na String str
                str += newEnd;
                return str;
            } else {                                //caso não aconteça eu posso usar o método replace
                str = str.replace(strEnd, newEnd);
                return str;
            }
        }
    }
}
