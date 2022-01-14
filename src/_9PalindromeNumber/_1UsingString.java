package _9PalindromeNumber;

public class _1UsingString
{
    /* String과 StringBuffer를 이용한 구현 */
    public boolean isPalindrome1(int x)
    {
        String strOrigin = Integer.toString(x);
        StringBuffer temp = new StringBuffer(strOrigin);
        temp.reverse();
        String strCompare = temp.toString();

        return strOrigin.equals(strCompare);
    }

    /* 나누기, 나머지 연산을 이용한 구현 */
    public boolean isPalindrome2(int x)
    {
        int n = x;
        int r;
        int temp = 0;

        while(n > 0)
        {
            r = n % 10;
            temp = temp*10 + r;
            n = n / 10;
        }
        return (x == temp);
    }
}
