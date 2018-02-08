package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ClearMatrix implements ProblemInterface {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int M = a.size();
	    int N = a.get(0).size();
	    boolean row_0_has_zeros = false;
	    boolean col_0_has_zeros = false;
	    
	    for(int i = 0; i < N; i++){
	        if(a.get(0).get(i) == 0){
	            row_0_has_zeros = true;
	            break;
	        }
	    }
	    
	    for(int i = 0; i < M; i++){
	        if(a.get(i).get(0) == 0){
	            col_0_has_zeros = true;
	            break;
	        }
	    }
	    
	    for(int i = 1; i < M; i++){
	        for(int j = 1; j < N; j++){
	            if(a.get(i).get(j) == 0){
	                a.get(0).set(j, 0);
	                a.get(i).set(0, 0);
	            }
	        }
	    }
	    
        for(int i = 1; i < M; i++){
            for(int j = 1; j < N; j++){
                if(a.get(0).get(j) == 0 || a.get(i).get(0) == 0){
                    a.get(i).set(j,0);
                }
            }
        }
	    if(col_0_has_zeros){
	        for(int i = 0; i < M; i++){
	            a.get(i).set(0,0);
	        }
	    }
	    if(row_0_has_zeros){
	        for(int i = 0; i < N; i++){
	            a.get(0).set(i,0);
	        }
	    }  
    }

    public void Test(){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < r;i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int j = 0; j < c; j++){
                row.add(sc.nextInt());
            }
        }
        setZeroes(a);   
        for(int i = 0; i < r;i++){
            for(int j = 0; j < c; j++){
                System.out.print(a.get(i).get(j));
                if(j == a.get(0).size() - 1){
                    System.out.printf("%n");
                }
            }
        }
        sc.close();
    }
}