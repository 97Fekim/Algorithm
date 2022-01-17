package _13RomanToInteger;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger
{
    public int romanToInt(String s)
    {
        HashMap<Character, Integer> map_c = new HashMap<Character, Integer>();
        HashMap<String, Integer> map_s = new HashMap<String, Integer>();

        int sum = 0;
        char temp[] = new char[2];

        map_c.put('I', 1);
        map_c.put('V', 5);
        map_c.put('X', 10);
        map_c.put('L', 50);
        map_c.put('C', 100);
        map_c.put('D', 500);
        map_c.put('M', 1000);

        map_s.put("IV", 4);
        map_s.put("IX", 9);
        map_s.put("XL", 40);
        map_s.put("XC", 90);
        map_s.put("CD", 400);
        map_s.put("CM", 900);

        if(s.length() == 1)
            sum += map_c.get(s.charAt(0));
        else
        {
            for(int i= 0; i < s.length(); ++i)
            {
                if(i < s.length()-1)
                {
                    temp[0] = s.charAt(i);
                    temp[1] = s.charAt(i+1);
                }

                String temp_new = new String(temp);

                if(map_s.containsKey(temp_new))
                {
                    sum+= map_s.get(temp_new);
                    i++;
                    temp[0] = ' ';
                    temp[1] = ' ';
                }
                else
                    sum += map_c.get((s.charAt(i)));

            }
        }


        return sum;
    }
}
