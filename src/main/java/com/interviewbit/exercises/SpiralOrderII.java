package com.interviewbit.exercises;

import java.util.ArrayList;

class SpiralOrderII{
    static ArrayList<ArrayList<Integer>> build(int A){
        int N = A*A;
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < A; i++){
            result.add(new ArrayList<Integer>());
            for(int j = 0; j < A; j++){
                result.get(i).add(0);
            }
        }
        
        int counter = 1;
        int i,j;
        i = j = 0;
        boolean goingUp, goingDown, goingLeft, goingRight;
        goingUp = goingDown = goingLeft = false;
        goingRight = true;
        int cur_layer = 0;
        while(counter <= N){
            result.get(i).set(j,counter);
            counter++;
            
            if(goingRight){
                // if im in the last of the row
                if(j == A - cur_layer - 1){
                    goingRight = false;
                    goingDown = true;
                    i++;
                }
                else{
                    j++;
                }
            }
            else if(goingDown){
                //if im in the last of the col
                if(i == A - cur_layer - 1){
                    goingDown = false;
                    goingLeft = true;
                    j--;
                }
                else{
                    i++;
                }
            }
            else if(goingLeft){
                // if im at the last of the row
                if(j == cur_layer){
                    goingLeft = false;
                    goingUp = true;
                    i--;
                }
                else{
                    j--;
                }
            }
            else if(goingUp){
                // if im in the last of the col
                if(i == cur_layer + 1){
                    goingUp = false;
                    goingRight = true;
                    j++;
                    cur_layer++;
                }
                else{
                    i--;
                }
            }
        }
        return result;
    }

    static ArrayList<ArrayList<Integer>> Test(){
        return build(21);
    }
}
            