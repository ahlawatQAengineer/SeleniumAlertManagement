package com.selenium.tests.DSA;

import java.sql.Array;

public class WorkWithArmStrongNumber {

    public static void main(String[] args){

        int inputNum = 153;

       boolean myBool =  armStrongNumber(inputNum);
       System.out.println(myBool);

    }


    public static boolean armStrongNumber(int num){

        String numStr = String.valueOf(num);
        int len =  numStr.length();
        int [] digits = new int[len];
        double cubeSum = 0;

        for(int i=0; i<len; i++ ){
            digits[i] =  Character.getNumericValue(numStr.charAt(i));

            System.out.print(digits[i]);
            double cube = Math.pow(digits[i], 3);
            System.out.println("   The cube of the number is: " +cube);

            cubeSum += cube;


        }
        System.out.println(cubeSum);

        if (cubeSum == num){

            return true;
        }else{

            return false;
        }

    }


}
