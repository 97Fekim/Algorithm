package LeetCode._67AddBinary;

import java.math.BigInteger;

public class Solution {
    public String addBinary(String a, String b) {

        BigInteger bigIntegerA = new BigInteger(a, 2);
        BigInteger bigIntegerB = new BigInteger(b, 2);

        return bigIntegerA.add(bigIntegerB).toString(2);

    }
}
