package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.List;

class BSTSequence{
    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }
    static List<ArrayList<Integer>> FindSequences(Node n){
        if(n == null){
            return null;
        }
        List<ArrayList<Integer>> leftSTSeq = FindSequences(n.left);
        List<ArrayList<Integer>> rightSTSeq = FindSequences(n.right);
        
        for
    }
}