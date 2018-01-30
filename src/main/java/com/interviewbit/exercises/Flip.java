package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;

class Flip{
    static ArrayList<Integer> flip(String A) {
        int N = A.length();
        int[] zeros_at_index = new int[N];
        int zeros = 0;
        for(int i = 0; i < N; i++){
            if(Character.getNumericValue(A.charAt(i)) == 0){
                zeros++;
            }
            zeros_at_index[i] = zeros;
        }
        int L,R;
        L = R = -1;
        int i,j,k;
        i = 0;
        j = 0;
        k = N-1;

        int max_zeros = 0;
        while(j <= k){
            int zeros_before_i = i > 0 ? zeros_at_index[i - 1] : 0;
            int zeros_from_i_to_j = zeros_at_index[j] - zeros_before_i;
            int ones_from_i_to_j = j - i + 1 - zeros_from_i_to_j;
            int total_zeros_from_i_to_j = zeros_from_i_to_j - ones_from_i_to_j;
            
            
            if(total_zeros_from_i_to_j < 0){
                i = j + 1;
                j = i;
            }
            else{
                if(total_zeros_from_i_to_j > max_zeros){
                    max_zeros = total_zeros_from_i_to_j;
                    L = i;
                    R = j;
                }   
                j++;
            }
        }
        if(L >= 0 && R >= 0){
            return new ArrayList<Integer>(Arrays.asList(L + 1,R + 1));
        }
        else{
            return new ArrayList<Integer>();
        }
    }

    static ArrayList<Integer> Test(){
        String A = "1101";
        return flip(A);
    }
}