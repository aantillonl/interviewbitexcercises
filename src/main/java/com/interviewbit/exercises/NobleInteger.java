package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class NobleInteger{
    static int nobleInteger(ArrayList<Integer> A){
        Collections.sort(A);
       
        int N = A.size();
        int[] nums_greater_than = new int[N];
        int[] duplicates = new int[N];
        
        for(int i = N - 2; i >= 0; i--){
            duplicates[i] = A.get(i) == A.get(i+1) ? duplicates[i + 1] + 1 : 0;
            nums_greater_than[i] = A.get(i) < A.get(i+1) ? nums_greater_than[i + 1] + 1 + duplicates[i + 1]:  nums_greater_than[i + 1];

            if(A.get(i) == nums_greater_than[i]){
                return 1;
            }
        }
        return -1;
    }

    static int Test(){
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList( -4, -2, 0, -1, -6 ));
        return nobleInteger(A);
    }
}