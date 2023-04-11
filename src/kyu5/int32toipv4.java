package kyu5;
/*
Criar uma função que receba um int32 e retorne o ip equivalente a esse valor
 */
public class int32toipv4 {  //incompleto
    public static void main(String[] args) {
        String s = longToIP(2154959208L);
        System.out.println(s);
    }
    public static String longToIP(long ip) {
        // Java não tem uint32, então será utilizado long para representar um int32
        if (ip == 0) {
            return "0.0.0.0";
        }

        String binary_str = Long.toBinaryString(ip);

        String[] splited_ip = new String[4];
        for (int i = 0; i < 4; i++) {
            String buffer = "";
            for (int j = 0; j < 8; j++) {
                char c = binary_str.charAt(j);
                buffer += c;
            }
            splited_ip[i] = buffer;
            binary_str = binary_str.replaceFirst(buffer, "");
        }

        String ipv4 = "";
        for (int i = 0; i < splited_ip.length; i++) {
            String str = splited_ip[i];
            long sum = 0;
            int potencia = 0;
            for (int j = str.length()-1; j >= 0; j--) {
                long l = Character.getNumericValue(str.charAt(j));
                if (l == 1) {
                    sum += Math.pow(2, potencia);
                }
                potencia++;
            }
            ipv4 += Long.toString(sum);
            if (i != 3) {
                ipv4 += '.';
            }
        }
        return ipv4;
    }
}
