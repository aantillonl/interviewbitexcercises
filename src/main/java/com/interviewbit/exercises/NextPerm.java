package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;

class NextPerm{
    static void swap(ArrayList<Integer> a, int i, int j){
        int tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }

    static void minimize(ArrayList<Integer> a, int start){
        for(int i = start; i < a.size();i++){
            int min_available = i;
            
            for(int j = i; j < a.size(); j++){
                if(a.get(i)>a.get(j)){
                    min_available = j;
                }
            }
            swap(a,i,min_available);
        }
    }
    static ArrayList<Integer> nextPerm(ArrayList<Integer> a){
        int N = a.size();
	    for(int i = N - 1; i >= 0; i--){
	        int prev_greater_index = -1;
	        for(int j = N - 1; j > i; j--){
	            if(a.get(j) > a.get(i)){
	                if (prev_greater_index == -1 ){
	                    prev_greater_index = j;
	                }
	                else{
	                    prev_greater_index = a.get(j) < a.get(prev_greater_index) ? j : prev_greater_index; 
	                }
	            }
	        }
	        if(prev_greater_index > 0){
                swap(a, i, prev_greater_index);
                minimize(a, i+1);
	            return a;
	        }
	    }
	    for(int i = 0; i < (int)(N/2); i++){
	        swap(a, i, N - i - 1);
        }
        return a;
    }

    static ArrayList<Integer> Test(){
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(5,4,7,5,3,2));
        return nextPerm(a);
    }
}