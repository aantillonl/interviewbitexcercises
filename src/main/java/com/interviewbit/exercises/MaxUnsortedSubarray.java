package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;

class MaxUnsortedSubarray{
    static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int N = A.size();
        if(N == 0){
            return new ArrayList<Integer>(Arrays.asList(-1));
        }
        
        int[] maxs = new int[N];
        int[] mins = new int[N];
        
        int min_until_end, max_so_far;
        min_until_end = A.get(N-1);
        max_so_far = A.get(0);
        for(int i = 0; i < N; i++){
            max_so_far = Math.max(max_so_far, A.get(i));
            min_until_end = Math.min(min_until_end, A.get(N - i - 1));
            maxs[i] = max_so_far;
            mins[N - 1 - i] = min_until_end;
        }

        int l,r;
        l = 0;
        r = N-1;
        while(l < r){
            if(A.get(l) <= mins[l + 1]){
                l++;
            }
            else if(A.get(r) >= maxs[r - 1 ]){
                r--;
            }
            else{
                return new ArrayList<Integer>(Arrays.asList(l,r));
            }
        }
        return new ArrayList<Integer>(Arrays.asList(-1));
    }
    static ArrayList<Integer> Test(){
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList( 1, 3, 2, 4, 5 ));
        return subUnsort(A);
    }
}