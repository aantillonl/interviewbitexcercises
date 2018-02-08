package com.interviewbit.exercises;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RepeatedNumber implements ProblemInterface{
    // DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
        int N = a.size();
        int can_2, can_1;
        int ctr_1, ctr_2;
        can_1 = can_2 = ctr_1 = ctr_2 = 0;
        
        for(int i = 0; i < N ; i++){
            int val = a.get(i);
            if((val == can_1 || ctr_1 == 0) && val != can_2){
                can_1 = val;
                ctr_1 ++;
            }
            else if((val == can_2 || ctr_2 == 0) && val != can_1){
                can_2 = val;
                ctr_2 ++;
            }
            else{
                ctr_1 --;
                ctr_2 --;
            }
        }

        ctr_2 = ctr_1 = 0;
        for(int i = 0; i < N; i++){
            int val = a.get(i);
            if(val == can_1){
                ctr_1++;
            }
            else if(val == can_2){
                ctr_2++;
            }
        }
        if(ctr_2 > N/3){
            return can_2;
        }
        else if(ctr_1 > N/3){
            return can_1;
        }
        else{
            return -1;
        }
    }
   
    public void Test(){
        try{
            Scanner inFile = new Scanner(new FileInputStream("data.txt")); 

            int T = inFile.nextInt();
            ArrayList<Integer> A = new ArrayList<Integer>();

            for(int i = 0; i < T; i++){
                A.add(inFile.nextInt());
            }
            System.out.println(repeatedNumber(A));
            inFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File data.txt was not found!"); 
        }        
       
    }    
}
