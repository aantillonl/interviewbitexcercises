package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxAbsDiff {
    static int maxArr(ArrayList<Integer> A) {
        int N = A.size();
        int max_f = 0;
        int max_Ai_min_i, min_Ai_plus_i;
        max_Ai_min_i = A.get(0) - 1;
        min_Ai_plus_i = A.get(0) + 1;
        for(int i = 1; i < N; i++){
            int cur_Ai_min_i = A.get(i) - (i + 1);
            int cur_Ai_plus_i = A.get(i) + (i + 1);
            int f = 0;
            if(cur_Ai_min_i < max_Ai_min_i){
                f = max_Ai_min_i - cur_Ai_min_i;
            }
            if(cur_Ai_plus_i > min_Ai_plus_i){
                f = Math.max(f,cur_Ai_plus_i - min_Ai_plus_i);
            }
            max_Ai_min_i = Math.max(cur_Ai_min_i, max_Ai_min_i);
            min_Ai_plus_i = Math.min(min_Ai_plus_i, cur_Ai_plus_i);

            max_f = Math.max(max_f,f);
        }
        return max_f;
    }

    static int maxArrV2(ArrayList<Integer> A){
        int f_max = 0;
        int N = A.size();
        int max_i, max_j;
        max_i = max_j = 0;
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                int f = Math.abs(A.get(i)-A.get(j)) + Math.abs(i - j);
                if(f_max < f){
                    f_max = f;
                    max_i = i;
                    max_j = j;
                }
            }
        }
        System.out.format("i = %d, j = %d%n",max_i + 1,max_j + 1);
        return f_max;
    }

    static int Test(){
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(81, 73, 53, 64, 90, 23, 66, 12, 66, 94));
        return maxArr(A);
    }
}