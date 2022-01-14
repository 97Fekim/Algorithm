package com.company;
import _1TwoSum.*;
import _2AddTwoList.*;
import _9PalindromeNumber.*;

public class Main
{
    public static void main(String[] args)
    {
        _1UsingString sol = new _1UsingString();

        long start = System.nanoTime();

        System.out.println(sol.isPalindrome2(123321));

        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");
    }
}