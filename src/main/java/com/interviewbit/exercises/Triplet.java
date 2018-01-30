package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Triplet{
    static int triplet(ArrayList<String> A){
        int N = A.size();
        if(N < 3)
            return -1;
        
        Double a, b;
        a =  Double.valueOf(A.get(0));
        b = Double.valueOf(A.get(1));
        
        for(int i = 2; i < N; i++){
            Double a_i = Double.valueOf(A.get(i));
            if(1 < (a+b+a_i) && (a+b+a_i) < 2){
                return 1;
            }
            else if (a_i <= a){
                b = a;
                a = a_i;
            }
            else if(a_i <= b){
                b = a_i;
            }
        }
        return 0;
    }

    static int triplet2(ArrayList<String> A){
        Collections.sort(A);
        double a =  Double.valueOf(A.get(0));
        double b =  Double.valueOf(A.get(1));
        double c =  Double.valueOf(A.get(2));
        if(1 < (a+b+c) && (a+b+c) < 2){
            return 1;
        }
        return 0;
    }

    static int Test(){
        ArrayList<String> A = new ArrayList<String>(Arrays.asList("0.297657", "0.420048", "0.053365", "0.437979", "0.375614", "0.264731", "0.060393", "0.197118", "0.203301", "0.128168"));
        return triplet(A);
    }
}