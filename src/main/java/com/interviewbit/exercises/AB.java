package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AB{
    static ArrayList<Integer> ab(final List<Integer> A) {
        long N = A.size();
        long sum_N = N * (N + 1)/2;
        long sum_of_squares_N = N * (N + 1) * (2*N + 1)/6;
        long sum_of_squares_A = 0;
        long sum_A = 0;

        for(int i = 0; i < N; i++){
            sum_A += A.get(i);
            sum_of_squares_A += Math.pow(A.get(i), 2);
        }

        long a =((long) sum_of_squares_N - sum_of_squares_A - (long)Math.pow(sum_N - sum_A, 2)) / (2*(sum_N - sum_A));

        long B = sum_N - sum_A + a;

        return new ArrayList<Integer>(Arrays.asList((int)a, (int)B));
    }

    static ArrayList<Integer> MissingAndRepeating(final List<Integer> A) {
        int a,b;
        a=b=-1;
        int N = A.size();
        boolean[] memo = new boolean[N];
        for(int i = 0; i < N; i++){
            int value = A.get(i);
            if(memo[value-1]==true){
                a = value;
            }
            else{
                memo[value-1] = true;
            }           
        }

        for(int i = 0; i<N;i++){
            if(memo[i] == false){
                b = i+1;
            }
        }

        return new ArrayList<Integer>(Arrays.asList(a,b));
    }
    static ArrayList<Integer> Test(){
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 1, 2, 5, 3));
        return MissingAndRepeating(A);
    }
}