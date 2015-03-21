package com.david.leetcodeExercise;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        int[] anotherNums = new int[size];
        for ( int i = 0; i< size; i++){
            anotherNums[(i+k) % size] = nums[i];
        }
        for ( int i = 0; i<size;i++){
        	nums[i] = anotherNums[i];
        }
        nums = anotherNums;
    }
}
