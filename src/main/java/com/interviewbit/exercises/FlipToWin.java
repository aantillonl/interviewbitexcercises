/*
    From Cracking the coding interview
    Bit manipulation
*/
package com.interviewbit.exercises;

import java.util.Stack;

class FlipToWin implements ProblemInterface{

    public int solve(int a){
        int flipped_index = -1;

        int longest = 0;
        int subseq = 0;
        int i = 0;
        while(a > 0){
            if(a % 2 > 0){
                subseq ++;
            }
            else{
                longest = Math.max(longest, subseq);
                subseq = i - flipped_index;
                flipped_index = i;
            }
            i++;
            a = a >> 1;
        }
        longest = Math.max(longest, subseq);
        return longest;
    }

    public int solvev2(int a){
        int prev_subseq = 0;
        int cur_subseq = 0;
        int longest = 0;
        while(a > 0){
            if(a % 2  > 0){
                cur_subseq++;
            }
            else{
                prev_subseq = cur_subseq;
                cur_subseq = 0;
            }
            longest = Math.max(longest,cur_subseq + prev_subseq + 1);
            a >>>= 1;
        }
        return longest;
    }
    public void Test(){
        System.out.println(solvev2(1743));
    }
}
