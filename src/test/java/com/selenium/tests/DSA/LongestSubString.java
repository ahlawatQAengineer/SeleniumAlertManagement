package com.selenium.tests.DSA;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubString {


    public static void main(String [] args){

        String inputString  = "Checking the string for longest Substring";
        String outPutString = repeatingSubString(inputString);
        System.out.println(outPutString);

    }

    public static String repeatingSubString(String input){

        String newString = input.replaceAll("\\s+", "");
        int start = 0, end = 0, maxLength =0, strLength = 0, maxStart = 0;
        strLength = newString.length();
        HashSet<Character> newHashSet = new HashSet<>();

        while (end<strLength){

            char currentChar  =  newString.charAt(end);
           while( newHashSet.contains(currentChar)) {
               newHashSet.remove(newString.charAt(start));
               start++;
           }

            newHashSet.add(newString.charAt(end));

           if((end-start+1)>maxLength){
                maxLength = end-start+1;
                maxStart = start;
           }
            end ++;

        }

        return newString.substring(maxStart, maxStart+maxLength);


    }
}
