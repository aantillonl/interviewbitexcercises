package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LongestPath{
    private int longestPath;
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        longestPath = 0;
        List<Integer>[] graph = new LinkedList[N];
        int root = 0;
        for (int i = 0; i < N; i++){
            int parent = A.get(i);
            // if is not root
            if(parent != -1){
                // add child
                if(graph[parent] == null){
                    graph[parent] = new LinkedList<Integer>();
                }
                graph[parent].add(i);
            }
            else{
                root = i;
            }            
        }
        ExploreDepth(graph, root);
        return longestPath;
    }
    
    private int ExploreDepth(List<Integer>[] graph, int node){

        Stack<Integer> s = new Stack<Integer>();

        while(!s.empty()){
                // Pop a vertex from stack and print it
                node = s.pop();
        }

        List<Integer> children = graph[node];
        if(children == null || children.size() == 0){
            return 0;
        }
        else{
            int max_dist = 0;            
            for(int i = 0; i < children.size();i++){
                int dist = ExploreDepth(graph, children.get(i)) + 1;
                this.longestPath = Math.max(dist + max_dist, this.longestPath);
                max_dist = Math.max(dist, max_dist);
            }
            return max_dist;
        }        
    }

    public int Test(){
        int[] A = {-1, 0, 0, 1, 0, 4, 5, 5, 5, 6, 8, 7, 10, 2, 2, 1, 12, 6, 13, 1, 16, 1, 2, 14, 5, 7, 13, 18, 26, 24, 16, 3, 21, 7, 3, 0, 32, 13, 19, 13, 1, 25, 38, 32, 3, 41, 13, 6, 14, 12, 38, 20, 13, 19, 5, 4, 22, 9, 21, 9, 55, 53, 61, 0, 55, 27, 20, 11, 51, 50, 48, 53, 42, 9, 48, 17, 38, 27, 0, 36, 51, 26, 33, 5, 22, 67, 15, 78, 28, 65, 69, 14, 24, 28, 9, 27, 18, 59, 28, 40};
        return solve(A);
    }
}