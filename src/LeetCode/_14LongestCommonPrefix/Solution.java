package LeetCode._14LongestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuffer str_temp = new StringBuffer(strs[0]);
        boolean flag = true;


        for (int j = 0; j < str_temp.length(); ++j) {
            for (int i = 0; i < strs.length; ++i) {
                if (str_temp.indexOf(strs[i]) == -1)
                    flag = false;
            }

            if (flag == true)
                return str_temp.toString();
            else
                str_temp.deleteCharAt(str_temp.length());
        }

        return null;

    }
}