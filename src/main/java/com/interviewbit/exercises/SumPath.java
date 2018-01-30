package com.interviewbit.exercises;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

class SumPath{
    static class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }
    static int pathCounter = 0;
    
    static int FindSumPath(SumPath.Node root, int target){
        dfs(root,new ArrayList<Integer>(), target);
        return pathCounter;
    }

    static void dfs(SumPath.Node n, ArrayList<Integer> sum_levels, int target){
        if(n == null){
            return;
        }
        for(int i = 0; i < sum_levels.size();i++){
            if(sum_levels.get(i) + n.value == target){
                pathCounter++;
            }
            sum_levels.set(i,sum_levels.get(i) + n.value);
        }
        
        sum_levels.add(n.value);
        dfs(n.left, sum_levels, target);
        dfs(n.right, sum_levels, target);
        sum_levels.remove(sum_levels.size()-1);
        
        if(target == n.value){
            pathCounter++;
        }        
    }

    static void InOrder(Node node){
        if(node == null){
            return;
        }

        InOrder(node.left);
        System.out.format("%d, ",node.value);
        InOrder(node.right);
    }

    static int Test(){
        Node root = new Node(10);

        root.left = new Node(5);
        root.right = new Node(-3);
        root.left.left = new Node(3);
        root.left.right = new Node(1);
        //root.right.left = new Node(4);
        root.right.right = new Node(11);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        //root.left.right.left = new Node(-1);
        root.left.right.right = new Node(2);
        //root.right.left.left = new Node(3);
        //root.right.left.right = new Node(5);
        //root.right.right.left = new Node(7);
        //root.right.right.right = new Node(9);
        //InOrder(root);
        return FindSumPath(root, 8);

    }
}