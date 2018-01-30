package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MaxDiff{
    
    static class CustComparrator implements Comparator<Integer>{
        private List<Integer> original_values;
        CustComparrator(List<Integer> original_values){
            this.original_values = original_values;
        }
        public int compare(Integer a, Integer b){
            return this.original_values.get(a) - this.original_values.get(b);
        }
    }

    static int maxDistance(List<Integer> A){
        int N = A.size();
        ArrayList<Integer> indexes = new ArrayList<Integer>(N);
        for(int i = 0; i < N; i++){
            indexes.add(i);
        }

        Collections.sort(indexes, new CustComparrator(A));

        int min_i = indexes.get(0);
        int max_diff = -1;
        for(int i = 0; i < N; i++){
            max_diff = Math.max(max_diff, indexes.get(i) - min_i);
            min_i = Math.min(min_i, indexes.get(i));
        }
        return max_diff;
    }

    static int Test(){
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(0));

        return maxDistance(A);
    }
}