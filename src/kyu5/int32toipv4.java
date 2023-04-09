package kyu5;

public class int32toipv4 {  //incompleto
    public static void main(String[] args) {
//        String s = longToIP("128.32.10.1");
//        System.out.println(s);
    }
    public static String longToIP(long ip) {
        // Java doesn't have uint32, so here we use long to represent int32
        String s = Long.toString(ip);
        String[] ip_splited = s.split(".");

        for (int i = 0; i < ip_splited.length; i++) {
            String binary = binary_converter(ip_splited[i]);
            ip_splited[i] = binary;
        }

        long sum = 0;
        for (int i = 0; i < ip_splited.length; i++) {
            String str = ip_splited[i];
            for (int j = str.length()-1; j >= 0; j++) {
                long l = Character.getNumericValue(str.charAt(j));
                sum += Math.pow((l*2),i);
            }
        }

        return Long.toString(sum);
    }
    public static String binary_converter(String str) {
        long l_buffer = Long.parseLong(str);
        String binary = "";
        while (l_buffer >= 2) {
            long resto = l_buffer % 2;
            l_buffer = l_buffer / 2;
            binary += resto;
        }
        binary += l_buffer;

        String bin = new StringBuilder(binary).reverse().toString();
        if (bin.length() < 8) {
            int n = 8 - bin.length();
            String zeroes = "";
            for (int i = 0; i < n; i++) {
                zeroes += '0';
            }
            bin = zeroes + bin;
        }
        return bin;
    }
}
