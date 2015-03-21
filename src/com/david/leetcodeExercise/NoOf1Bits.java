package com.david.leetcodeExercise;

public class NoOf1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int hammingWeight(int n) {
		int count = 0;
		for (int i =0; i < 32; i ++){
			count += n&1;
			n= n>>>1;
		}	
		return count;
	}
}
