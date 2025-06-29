package com.selenium.tests.DSA;

public class GetNumberLength {


    public static void main(String[] args){


       int numberOfDigits =  getStringLength(45453);
       System.out.println("The number of digits is: "+numberOfDigits);




    }


    public static int getStringLength(int num){

        int leng = String.valueOf(num).length();
        System.out.println(leng);
        int temp =  num;
        int count = 0;


        if(num ==0) return 1;


        while(temp != 0){
            temp /= 10;
            count++;

        }
    return count;

    }



}
