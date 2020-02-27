package com.analysishtml.demo11.service;

import java.util.Scanner;

public class Niu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
        int[] array = new int[t];
        for (int x = 0; x <= t - 1; x++){
            array[x] = sc.nextInt();
        }

        int m = 0;
        for (int i=0;i<t-1; i++){
            if (array[i] == array[i+1])
                continue;
            if (array[i] > array[i+1]){
                continue;
            } else {
                m = i+1;

            }
        }
    }
}
