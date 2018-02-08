package com.interviewbit.exercises;

import java.util.Stack;

class BinaryEncode implements ProblemInterface{
    public String findDigitsInBinary(int A) {
        StringBuilder sb = new StringBuilder();
        
        while(A > 0){
            sb.append(A % 2 > 0 ? '1' : '0');
            A = A >> 1;
        }
        return sb.reverse().toString();
    }

    public void Test(){
        retur
    }
}