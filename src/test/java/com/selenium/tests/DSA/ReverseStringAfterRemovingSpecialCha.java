package com.selenium.tests.DSA;


import java.util.Arrays;

public class ReverseStringAfterRemovingSpecialCha {


    public static void main (String[] argrs){

      String  inputString  = "MyGoodFriend";

      String inputString2 = "My Old Friend";

        reverseTheString(inputString);

        String outputString  = reverseWordsInAString(inputString2);
        System.out.println(outputString);
    }



    public static void reverseTheString(String input){

        int len = input.length();
        char [] newCharArray =  input.toCharArray();
        for (int i = 0; i <len/2; i++){
            char tempArray  = newCharArray[i];
             newCharArray[i] = newCharArray[(len-i)-1];
            newCharArray[(len-i)-1] = tempArray;

        }

        System.out.println(Arrays.toString(newCharArray));

    }



    public static String reverseWordsInAString(String input){

        String[] newStringArray =  input.split("\\s+");
        int l = newStringArray.length;
        for (int j= 0; j< ((newStringArray.length)/2); j++){

            String tempString  =  newStringArray[j];
            newStringArray[j] = newStringArray[(l-j)-1];
            newStringArray[(l-j)-1] = tempString;
        }

        return Arrays.toString(newStringArray);
    }




}
