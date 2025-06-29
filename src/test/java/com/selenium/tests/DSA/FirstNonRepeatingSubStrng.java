package com.selenium.tests.DSA;

import java.util.HashSet;

public class FirstNonRepeatingSubStrng {

    public static void main (String[] args) {

        String input = "Hello Boy which is the first non repeating string?";
        nonRepeatingString(input);

    }



    public static void nonRepeatingString(String input){

        int count = 0 ;
        HashSet<String> myNewSet =  new HashSet<>();

        String[] newString  =  input.replaceAll("\\s+", "").split("");

       for(String str : newString){

           if (myNewSet.contains(str)  && count ==0){
               System.out.println("We have found the first repeating character: " + str);
               count++;
           }else if(myNewSet.contains(str)  && count >0){
               System.out.println("The other repeating characters are: " + str);
               count++;
           } else {
               myNewSet.add(str);
           }

       }
    }

}
