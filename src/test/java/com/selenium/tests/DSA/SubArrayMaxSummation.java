package com.selenium.tests.DSA;

public class SubArrayMaxSummation {


    //find the maximum  of two consecutive elements
    //go for array[i] + array[i+1]
    //

    public static void main(String[] args){

        int [] myArray = {2, 4, 2, 4, 1, 6, 3, 6, 2, 7, 7, 5, 6, 7, 2,5,3,8,5};

        getSummationOdAdjacentPointer(myArray);
    }


    public static void getSummationOdAdjacentPointer(int[] input ){
        int a = 0;
        int b= 0;
        int currentSum  = 0;
        int finalSum = 0;

        for(int i = 0; i<(input.length-1); i++){
            a = input[i];
            b = input[i+1];
            currentSum  =  a+b;

            if(currentSum > finalSum){
                finalSum = currentSum;
            }
        }
        System.out.println("The final sum is " +finalSum);

    }


}
