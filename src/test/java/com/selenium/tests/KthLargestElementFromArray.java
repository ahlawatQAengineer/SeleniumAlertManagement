package com.selenium.tests;

import java.util.Arrays;

public class KthLargestElementFromArray {



    //find the nth largest element of the array without sorting


public  static void  main(String[] args){
    int Nth  = 4;
    int[] newArray = {87, 12, 55, 93, 2, 71, 38, 99, 4, 60, 15, 82, 29, 5, 70, 41, 96, 18, 33, 65};

    findTheNthHighestElement(newArray, Nth);

}


public static void findTheNthHighestElement(int [] input , int n){
    int nthLargest =0;
    int l =  input.length;

     Arrays.sort(input);
     nthLargest = input[l-n];
     System.out.println("The nth largest element is " + nthLargest);
}

public static void sortRandomArray(int []  input){



}

}
