package com.interviewbit.exercises.validparentheses;

import java.util.Stack;

public class Solution {
    /* public int longestValidParentheses(String A) {
        int pairCounter,openParentheses,maxSubstringLen;
        pairCounter = maxSubstringLen = openParentheses = 0;
        for (int i = 0; i < A.length(); i++){
            char c = A.charAt(i);        
            if(c == '('){
                openParentheses ++;
            }
            if(c == ')'){
                if(openParentheses > 0){
                    pairCounter++;
                    openParentheses --;
                }
                else{
                    maxSubstringLen = Math.max(maxSubstringLen, pairCounter*2);
                    pairCounter = 0;
                }
            }
        }
        if(openParentheses == 0){
            maxSubstringLen = Math.max(maxSubstringLen, pairCounter*2);
        }
        return Math.max(maxSubstringLen, pairCounter*2);        
    } */

    public int longestValidParentheses(String A){
        Stack<Integer> s = new Stack<Integer>();
        s.push(-1);
        int max_len = 0;
        for(int i = 0; i < A.length(); i++){
            char c = A.charAt(i);
            if(c=='('){
                s.push(i);
            }
            if(c==')'){
                s.pop();
                if(!s.empty()){
                    int cur_len = i - s.peek();
                    max_len = Math.max(max_len, cur_len);
                }
                else{
                    s.push(i);
                }
            }
        }
        return max_len;
    }
}
