package com.interviewbit.exercises;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        LongestPath solution = new LongestPath();
        System.out.println(solution.Test());
    }

    public static void print2D(ArrayList<ArrayList<Integer>> mat)
    {
        // Loop through all rows
        for (int i = 0; i < mat.size(); i++){
            // Loop through all elements of current row
            for (int j = 0; j < mat.get(i).size(); j++)
                System.out.print(mat.get(i).get(j) + " ");
            System.out.print("\n");
        }
    }
}
