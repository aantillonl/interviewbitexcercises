package com.interviewbit.exercises;


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
      val = x;
      left=null;
      right=null;
     }
 }
public class MaxSumPath {
    private int global_max;
    private int findMaxPath(TreeNode node){
        if(node == null){
            return 0;
        }
        int left_sub_tree_max = findMaxPath(node.left);
        int right_sub_tree_max = findMaxPath(node.right);

        int local_max = left_sub_tree_max + node.val + right_sub_tree_max;
        global_max = Math.max(global_max,local_max);

        int max_sub_path_through_root = left_sub_tree_max > right_sub_tree_max ? left_sub_tree_max + node.val : right_sub_tree_max + node.val;
        return max_sub_path_through_root > 0 ? max_sub_path_through_root : 0;
    }
    public int maxPathSum(TreeNode A) {
        this.global_max = Integer.MIN_VALUE;
        findMaxPath(A);
        return this.global_max;
    }

    public int Test(){
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(-100);
        root.right = new TreeNode(-200);
        root.left.right = new TreeNode(-300);
        root.right.left = new TreeNode(-400);

        return maxPathSum(root);
    }
}
