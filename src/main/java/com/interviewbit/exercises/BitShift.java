package com.interviewbit.exercises;

class BitShift{
    static int CopyBits(int N, int M,int i, int j){
        for(int k = 0; i + k <= j;k++){
            int mask = ~(1 << i + k);
            N = N & mask;
            int val = (M & (1 << k)) > 0 ? 1: 0;
            N = N | (val << i + k);
        }
        return N;
    }

    static int Test(){
        int N = 1024;
        int M = 19;
        return CopyBits(N, M, 2, 6);
        //output: 1100
    }
}