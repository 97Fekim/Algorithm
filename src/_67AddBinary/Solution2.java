package _67AddBinary;

public class Solution2 {
    public String addBinary(String a, String b) {

        StringBuffer sb = new StringBuffer();

        int current_a = a.length()-1;
        int current_b = b.length()-1;
        int carry = 0;

        while(current_a >= 0 || current_b >= 0){
            int sum = carry;

            if(current_a >= 0)
                sum += a.charAt(current_a) - '0';
            if(current_b >= 0)
                sum += b.charAt(current_b) - '0';

            sb.insert(0,sum%2);
            carry = sum/2;
        }

        if(carry != 0)
            sb.insert(0,carry);

        return sb.toString();

    }
}
