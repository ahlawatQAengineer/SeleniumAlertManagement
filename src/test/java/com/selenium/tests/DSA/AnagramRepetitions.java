package com.selenium.tests.DSA;

import java.sql.Array;
import java.util.Arrays;

public class AnagramRepetitions {

    public static void main(String [] args){

        String s  = "cbaebabacd";
        String p = "acb";
        findAnagrams(s,p);

    }


    public static void findAnagrams (String a, String b){

        int count  = 0;
        String[] inputString = a.split("");
        String [] anaGramString = b.split("");
        Arrays.sort(anaGramString);
        System.out.println("My anagram string is " + Arrays.toString(anaGramString));
        String[] newArray = new String[3];

        for (int i = 1; i<((inputString.length)-1); i++ ){

            newArray[0] =inputString[i-1];
            newArray[1] = inputString[i];
            newArray[2] = inputString[i+1];
            Arrays.sort(newArray);
            System.out.println(Arrays.toString(newArray));

            if (Arrays.equals(newArray, anaGramString)){
                count++;
                System.out.println("Found the anagram String. Hurray! " +count);
            }
        }

    }

}
