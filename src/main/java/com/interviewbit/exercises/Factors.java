package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Stack;

class Factors implements ProblemInterface {
    public ArrayList<Integer> solve(Integer A){
        ArrayList<Integer> factors = new ArrayList<Integer>();
        Stack<Integer> cofactors = new Stack<Integer>();
        for(int i = 1; i <=Math.sqrt(A); i++){
            if(A % i == 0){
                factors.add(i);
                if(i != Math.sqrt(A)){
                    cofactors.push(A/i);
                }
            }            
        }

        while(!cofactors.empty()){
            factors.add(cofactors.pop());
        }
        return factors;
    }

    public void Test(){
        ArrayList<Integer> res = solve(85463);
        for(int i = 0; i < res.size();i++){
            System.out.printf("%d, ",res.get(i));
        }
    }
}
