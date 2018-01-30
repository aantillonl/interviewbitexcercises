package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.ListenerNotFoundException;

class LocalInversions{
    static class CustComparrator implements Comparator<Integer>{
        private ArrayList<Integer> original_values;
        CustComparrator(ArrayList<Integer> original_values){
            this.original_values = original_values;
        }
        public int compare(Integer a, Integer b){
            return this.original_values.get(b) - this.original_values.get(a) ;
        }
    }

    static boolean isIdealPermutation(int[] A) {
        ArrayList<Integer> A_s = new ArrayList<Integer>();
        
        for(int i = 0; i < A.length; i++)
            A_s.add(A[i]);
        
        ArrayList<Integer> indexes = new ArrayList<Integer>();
            for(int i = 0; i < A.length; i++)
                indexes.add(i);
        Collections.sort(indexes,new CustComparrator(A_s));
        
        int globalInvs = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j < A.length; j++){
                if(A[i] > A[j])
                    globalInvs++;
            }
        }
        int localInvs = 0;
        for(int i = 0; i < A.length - 1; i++){
            if(A[i] > A[i+1])
                localInvs++;
        }
        return localInvs == globalInvs;
    }        

    static boolean isIdealPermutation2(int[] A) {
        int N = A.length;
        int[] min_after_index = new int[N];
        min_after_index[N-1] = N;
        for(int i = N -2; i >= 0; i--){
            min_after_index[i] = Math.min(min_after_index[i+1], A[i + 1]);
        }

        for(int i = N - 2; i >= 0; i--){
            if(A[i]> min_after_index[i+1]){
                return false;
            }
        }
        return true;
    }

    static boolean Test(){
        int[] data = new int[] {1,2,0};
        return isIdealPermutation2(data);
    }
}

