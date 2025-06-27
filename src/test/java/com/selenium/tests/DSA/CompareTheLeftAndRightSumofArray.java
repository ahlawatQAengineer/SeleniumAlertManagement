package com.selenium.tests.DSA;

public class CompareTheLeftAndRightSumofArray {


    public static void main (String[] args){

        int[] arr= {2,3,5,7,1,2,8,3,2,2};
        int[] simpleArray = {1,2,1,2,1};

        leftAndRightSum(arr);

        pivotIndexUsingSum(arr);
    }


    public static void leftAndRightSum(int [] inputArray){
        int len = inputArray.length;
        int newElement  = 0;

        for (int i = 0; i<len; i++){ //0
            int leftSum = 0;
            int rightSum = 0;

            for(int j = 0; j<len; j++){
                newElement = inputArray[j];

                if(j<i){
                    leftSum +=  newElement;
                }else if(j>i){
                    rightSum += newElement;
                } else if (j==i) {
                    continue;
                }
            }

            System.out.println("The left sum of the index " +i+ " is " +leftSum);
            System.out.println("The right sum of the index " +i+ " is " +rightSum);

            if(leftSum == rightSum){
                System.out.println("We have found a pivot index at --> " +i +"\n\n" );
            }else{
                System.out.println("The current index " +i+ " is not a pivot index" +"\n");
            }
        }
    }


    public static void pivotIndexUsingSum(int [] inputArray){
        int len = inputArray.length;
        int totalSum = 0;
       int  leftSumm = 0;
        int rightSumm = 0;

        for (int i : inputArray){
            totalSum += i;
        }
        System.out.println("Printing the total sum of the array " + totalSum);
        for (int j =0; j<len; j++){
             rightSumm = totalSum-leftSumm-inputArray[j];
             if (leftSumm==rightSumm){
                 System.out.println("We have found a pivot element at " + j + " with leftSum : " +leftSumm+ " and right sum : " + rightSumm );
             }
             leftSumm+=inputArray[j];

        }
    }



}
