package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSubArray{
    static int maxSubArray(final List<Integer> A) {
        int N = A.size();
        
        int max_sum = 0;
        // Build memory
        int[] memo = new int[N];
        for(int i = 0; i < N; i++){
            for(int j = i ; j >= 0; j--){
                int cur_sum;
                if(i == j){
                    cur_sum = A.get(j);
                }
                else{
                    cur_sum = memo[j + 1] + A.get(j);
                }
               
                max_sum = Math.max(cur_sum, max_sum);
                memo[j] = cur_sum;
            }   
        }
        return max_sum;
    }

    static int maxSubArrayGreedy(final List<Integer> A) {
        int N = A.size();
        
        int[] sum_memo, reverse_sum_memo;
        sum_memo = new int[N + 1];
        reverse_sum_memo = new int[N + 1];
        sum_memo[0] = 0;
        reverse_sum_memo[0] = 0;
        

        for(int i = 1; i <= N; i++){
            // Contains the sum before and after ith element
            sum_memo[i] = sum_memo[i - 1] + A.get(i - 1);
            reverse_sum_memo[i] = reverse_sum_memo[i - 1] + A.get(N - i);
        }

        int i,j,k,l;
        i = 0;
        j = i;
        k = j + 1;
        l = N - 1;

        while(k <= l){
            int sub_array_i_j = sum_memo[N] - sum_memo[i] - reverse_sum_memo[N - j - 1];
            int sub_array_k_l = sum_memo[N] - sum_memo[k] - reverse_sum_memo[N - l - 1];
            if(sub_array_i_j <= 0){
                i = k;
                j = i ;
                k = j + 1;
                continue;
            }
            if(sub_array_k_l <= 0){
                l = j;
                j = i + 1;
                k = j + 1;     
                continue;           
            }
            k++;
            j++;
        }

        return sum_memo[N] - sum_memo[i] - reverse_sum_memo[N - l - 1];

    }
    static int Test(){
        return maxSubArrayGreedy(new ArrayList<Integer>(Arrays.asList(-2, -3, 4, -1, -2, 1, 5, -3)));
    }
}