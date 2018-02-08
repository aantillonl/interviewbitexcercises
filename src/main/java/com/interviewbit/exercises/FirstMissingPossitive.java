package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;

class FirstMissingPositive implements ProblemInterface{
    public int firstMissingPositive(ArrayList<Integer> A) {
        int N = A.size();
        int max = 0;
        for(int i = 0; i < N; i++){
            if(A.get(i) < 0){
                A.set(i,0);
            }
            max = Math.max(max,A.get(i));
        }

        for(int i = 0; i < N; i++){
            int index = Math.abs(A.get(i)) - 1;
            if(index >= 0 && index < N){
                if(A.get(index) == 0){
                    A.set(index, (index + 1) * -1);
                }
                else{
                    A.set(index,Math.abs(A.get(index)) * -1);
                }
            }            
        }

        for(int i = 0; i < N; i++){
            if(A.get(i) >= 0){
                return i + 1;
            }
        }
        return max + 1;
    }

    public void Test(){
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1));
        System.out.println(firstMissingPositive(a));
    }
}