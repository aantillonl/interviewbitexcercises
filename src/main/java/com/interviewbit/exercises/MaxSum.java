package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;

class MaxSum{
    static ArrayList<Integer> FindMaxSum(ArrayList<Integer> A){
        int i, j;
        i = j = 0;
        int N = A.size();
        long sum = 0;
        long max_sum = -1;
        int i_max, j_max;
        i_max = j_max = -1;
        while(i < N && j < N){
            int value = A.get(j);
            if(value < 0){
                j++;
                i = j;
                sum = 0;
            }
            else{
                sum += value;
                if(sum > max_sum || ((sum == max_sum) && ((j - i) > (j_max - i_max)))){
                    i_max = i;
                    j_max = j;
                    max_sum = sum;
                }
                j++;
            }
        }
        if(i_max < 0 || j_max < 0){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int k = i_max; k <= j_max; k++){
            result.add(A.get(k));
        }
        return result;
    }

    static ArrayList<Integer> Test(){
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368));
        return FindMaxSum(A);
    }
}
