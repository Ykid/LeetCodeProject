package com.david.leetcodeExercise;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * Definition for binary tree
     */
    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    
	public boolean isBalanced(TreeNode root) {
        int[] height = new int[1];
        return checkHelper(root,height);
    }
    
    public boolean checkHelper(TreeNode root,int[] height){
        //base case
        if(root == null){
            height[0]=0;
            return true;
        }
        // recursion
        int[] leftHeight = new int[1];
        int leftH;
        if ( checkHelper(root.left, leftHeight) ){
            leftH = leftHeight[0];
        }else{
            height[0]=-1;
            return false;
        }
        int[] rightHeight = new int[1];
        int rightH;
        if( checkHelper(root.right, rightHeight) ){
            rightH = rightHeight[0];
        }else{
            height[0]=-1;
            return false; 
        }
        
        if ( -1<= leftH-rightH && leftH - rightH <=1){
            height[0] = (leftH>=rightH? leftH : rightH) + 1;
            return true;
        }else{                        
            height[0]=-1;
            return false;
        }
    }
    


}
