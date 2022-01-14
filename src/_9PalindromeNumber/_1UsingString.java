package _9PalindromeNumber;

public class _1UsingString
{
    public boolean isPalindrome(int x)
    {
        String strOrigin = Integer.toString(x);
        StringBuffer temp = new StringBuffer(strOrigin);
        temp.reverse();
        String strCompare = temp.toString();

        System.out.println(strOrigin);
        System.out.println(strCompare);

        if(strOrigin.equals(strCompare))
            return true;
        else
            return false;
    }
}
