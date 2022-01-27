package _67AddBinary;

class Solution_fail {
    public String addBinary(String a, String b) {

        int cnt = 0;
        int a_decimal = 0;
        int b_decimal = 0;
        int sum_decimal = 0;

        StringBuilder sum_sb = new StringBuilder();

        if(a.equals("0")&&b.equals("0"))
            return "0";

        for(int i = 0; i < a.length(); i++){
            a_decimal += Math.pow(2,a.length()-i-1) * ((int)a.charAt(i)-48);
        }

        for(int i = 0; i < b.length(); i++){
            b_decimal += Math.pow(2,b.length()-i-1) * ((int)b.charAt(i)-48);
        }

        sum_decimal = a_decimal + b_decimal;

        while(sum_decimal > 0){
            sum_sb.append(sum_decimal % 2);
            sum_decimal = sum_decimal / 2;

        }

        return sum_sb.reverse().toString();
    }
}