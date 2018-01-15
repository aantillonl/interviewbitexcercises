package com.interviewbit.exercises;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaxRectangle {
    static int FindMaxRectangle(ArrayList<ArrayList<Integer>> A) {      
        int M = A.size(); // Rows
        int N = A.get(0).size(); // Columns
        int max_area = 0;

        // Loop through rows
        for(int i = 0; i < M; i++){
            // Loop through cols
            // Check for top left and bottom right corners (vertical growth)
            int consecutiveOnes = 0;
            for(int j = 0; j < N; j++){
                if(A.get(i).get(j) == 1){
                    consecutiveOnes++;
                }
                else{
                    consecutiveOnes = 0;
                }
                
                A.get(i).set(j, consecutiveOnes);
            }
        }
        

        // Add up rows to boxes
        for(int i = 0; i < N; i++){
            Stack<Integer> widths = new Stack<Integer>();
            widths.push(1);
            int h = 0;
            for(int j = 0; j < M; j++){
                int row_length = A.get(j).get(i);
                if(row_length == 0) {
                    h = 0;
                    continue;
                }
                
                h++;
                while(row_length < widths.peek()){
                    widths.pop();
                }
                max_area = Math.max(row_length, Math.min(widths.peek(),row_length)*h);
            }
        }
        return max_area;
    }

    // Driver method
    public static int Test() 
    {
        ArrayList<Integer> r1 = new ArrayList<Integer>(Arrays.asList(1,1,1));
        ArrayList<Integer> r2 = new ArrayList<Integer>(Arrays.asList(0,1,1));
        ArrayList<Integer> r3 = new ArrayList<Integer>(Arrays.asList(1,0,0));
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>(Arrays.asList(r1,r2,r3));

        return FindMaxRectangle(A);      
    }
}
