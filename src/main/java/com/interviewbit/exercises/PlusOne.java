package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class PlusOne{
    static ArrayList<Integer> AddOne(ArrayList<Integer> A) {
        Stack<Integer> s = new Stack<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean leading_zeros = true;
        for(int i = 0; i < A.size(); i++){
            int val = A.get(i);
            if (val == 0 && leading_zeros){
                continue;
            }
            else{
                leading_zeros = false;
            }

            s.push(val);
        }
        int carry = 1;
        while(! s.empty()){
            int val = s.pop();

            int digit = val + carry <= 9 ? val + carry :0;
            carry = val + carry <= 9 ? 0 : 1;
            result.add(0,digit);
        }
        if(carry > 0){
            result.add(0,1);
        }

        return result;
    }

    static ArrayList<Integer> Test(){
        return AddOne(new ArrayList<Integer>(Arrays.asList(9,0,9)));
    }
}