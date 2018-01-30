package com.interviewbit.exercises;

class BinRep{
    static String binRep(double A){
        
        if(A <= 0 || A >= 1)
            return "Error";
        
        StringBuilder bin = new StringBuilder();

        bin.append(".");
        while(A > 0){
            if(bin.length() >= 32){
                return "Error";
            }                
            A = 2*A;
            if(A >= 1){
                bin.append("1");
                A--;
            }
            else{
                bin.append("0");
            }         
        }
        return bin.toString();
    }
    static String Test(){
        return binRep(0.9998779296875);
    }
}