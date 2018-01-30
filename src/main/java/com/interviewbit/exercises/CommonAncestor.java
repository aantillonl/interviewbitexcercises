package com.interviewbit.exercises;

class CommonAncestor{    
    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    static int findPathToN(Node n, Node target, int path_vector, int depth){
        if(n == null){
            return -1;
        }
        // Explore left
        int left_path;
        left_path = findPathToN(n.left, target, path_vector, depth + 1);
        if(left_path != -1){
            return left_path;
        }
        
        // Visit
        if(n == target){
            return path_vector;
        }
        // Explore right
        int right_path;
        right_path = findPathToN(n.right, target, (path_vector ^ (1 << depth)), depth);
        
        if(right_path != -1){
            return right_path;
        }
        return -1;
    }

    static Node FindCommonAncestor(Node n1, Node n2, Node root){
        int pathToN1 = findPathToN(root, n1, 0, 0);
        int pathToN2 = findPathToN(root, n2, 0, 0);

        int i = 0;
        Node anc = root;
        
        while(((1<<i) & pathToN1) == ((1<<i) & pathToN2) && (anc != n1 && anc != n2)){
            anc = ((1<<i) & pathToN1) == 0 ? anc.left:anc.right;
            i++;
        }

        return anc;
    }

    static int Test(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.left.left = new Node(7);

        return FindCommonAncestor(root.left.left.left, root.left.right.left, root).value;
    }
}