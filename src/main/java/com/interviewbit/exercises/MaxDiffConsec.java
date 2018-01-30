package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.ListenerNotFoundException;

class MaxDiffConsec{
    static int maxDiffConsec(final List<Integer> A){
        if(A.size()<2){
            return 0;
        }
        int max_element, min_element;
        max_element = min_element = A.get(0);
        int N = A.size();

        for(int i = 1; i < N; i++){
            max_element = Math.max(max_element, A.get(i));
            min_element = Math.min(min_element, A.get(i));
        }

        double bucket_size = (double)(max_element - min_element)/(N-1);
        int[] bucket_mins = new int[N-1];
        int[] bucket_maxs = new int[N-1];

        for(int i = 0; i < N; i++){
            int val = A.get(i);
            if(val == min_element ||val == max_element){
                continue;
            }
            int bucket_index = (int)((val - min_element) / bucket_size);
            if(bucket_mins[bucket_index] == 0){
                bucket_mins[bucket_index] = val;
            }
            else{
                bucket_mins[bucket_index] = Math.min(val, bucket_mins[bucket_index]);
            }

            bucket_maxs[bucket_index] = Math.max(val, bucket_maxs[bucket_index]);
        }

        int max_gap = (int)Math.ceil(bucket_size);

        for(int i = 1; i < bucket_maxs.length; i++){
            if(bucket_mins[i] == 0 && !(i == bucket_maxs.length-1)){
                continue;
            }
            int prev_bucket = i-1;
            while( prev_bucket >= 0 && bucket_maxs[prev_bucket] == 0){
                prev_bucket--;
            }
            int bucket_min = bucket_mins[i] != 0 ? bucket_mins[i] : max_element;
            int bucket_max = prev_bucket >= 0 ? bucket_maxs[prev_bucket] : min_element;
            max_gap = Math.max(max_gap,bucket_min - bucket_max);
        }
        return max_gap;
    }

    static int Test(){
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 10, 21, 33, 45));
        return maxDiffConsec(A);
    }
}