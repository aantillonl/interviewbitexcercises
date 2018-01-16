package com.interviewbit.exercises;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaxRectangle {
    static int FindMaxRectangle(List<ArrayList<Integer>> A){
        
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
        
        Stack<ArrayList<Integer>> s = new Stack<ArrayList<Integer>>();
        
        // Add up rows to boxes
        for(int i = 0; i < N; i++){
            int width, height;
            width = height = 0;
            ArrayList<Integer> prev_level_data;
            for(int j = 0; j < M; j++){
                int next_width = A.get(j).get(i);
                if(next_width == width){
                    height++;
                }
                else if(next_width > width){
                    if(width > 0){
                        s.push(new ArrayList<Integer>(Arrays.asList(width, height)));    
                    }
                    width = next_width;
                    height = 1;
                }
                
                else if(next_width < width){
                    while(!s.empty() && s.peek().get(0) >= next_width){
                       prev_level_data = s.pop();   
                       width = prev_level_data.get(0);
                       height = prev_level_data.get(1) + height;
                       max_area = Math.max(max_area, width*height); 
                    }
                    height++;
                    width = next_width;
                }
                
                max_area = Math.max(max_area, width * height);
                
            }
            while(!s.empty()){
               prev_level_data = s.pop();   
               width = prev_level_data.get(0);
               height = prev_level_data.get(1) + height;
               max_area = Math.max(max_area, width*height); 
            }
        }
        return max_area;
    }
    static int Test(){
        List<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1)));
        //                                                                       ^
        return FindMaxRectangle(A);
    }
}