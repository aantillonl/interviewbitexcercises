package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class BuildOrder{
    static String FindBuildOrder(String projects, String[] d_proj_names, String[] d_dep_names){
        String[] projectNamesArray = projects.split(", ");
        ArrayList<String> order = new ArrayList<String>();
        int M = projectNamesArray.length;
        HashMap<String,Integer> project_indexes = new HashMap<String,Integer>();

        for(int i = 0; i < M; i++){
            project_indexes.put(projectNamesArray[i], i);
        }

        int[][] graph = new int[M][M];
        
        for(int i = 0; i < d_proj_names.length; i++){
            int p_index = project_indexes.get(d_proj_names[i]);
            int d_index = project_indexes.get(d_dep_names[i]);
            graph[p_index][d_index] = 1;
        }

        int built = 0;
        int cur_proj = 0;
        int cur_dep = 0;
        Stack<int[]> s = new Stack<int[]>();
        while(cur_proj < M){
            
            if(((1 << cur_proj) & built) > 0){
                cur_proj ++;
                cur_dep = 0;
                continue;
            }
            long visited = 0;
            while(cur_dep < M){

                if((visited & (1 << cur_proj)) > 0){
                    return "Error";
                }
                if( ((built & 1<<cur_dep) == 0) && graph[cur_proj][cur_dep] == 1){
                    s.push(new int[]{cur_proj, cur_dep});
                    visited = visited + (1<<cur_proj);
                    cur_proj = cur_dep;
                    cur_dep = 0;
                    continue;
                }
                cur_dep++;
            }
            built = built ^ (1 << cur_proj);
            order.add(projectNamesArray[cur_proj]);
            if(! s.empty()){
                int[] prev_proj_info = s.pop();
                cur_proj = prev_proj_info[0];
                cur_dep =  prev_proj_info[1];
            } 
            
        }
        return order.toString();
    }

    static String Test(){
        String projects = "a, b, c, d, e, f";
        String[] d_proj_names = {"d","b","d", "a", "c"};
        String[] d_dep_names = {"a","f","b", "f", "d"};
        return FindBuildOrder(projects, d_proj_names, d_dep_names); 
    }
}