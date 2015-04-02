package com.david.leetcodeExercise;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	/**
	 * Given numRows, generate the first numRows of Pascal's triangle.

	For example, given numRows = 5,
	Return
	
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
	
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangle instance = new PascalTriangle();
		
		List<List<Integer>> answer = instance.generate(20);
		for (List<Integer> line:answer){
			for (int i:line){
				System.out.print(" "+ i);
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> generate(int numRows){
		if (numRows<0) return null;
		else if(numRows == 0) return new ArrayList<>();
		else{
			List<List<Integer>> answer = new ArrayList<>();
			List<Integer> initial = new ArrayList<>() ;
			initial.add(1);
			answer.add(initial);
			List<Integer> prev = initial;
			List<Integer> cur;
			if ( numRows >= 2){
				for (int i = 2; i<=numRows ; i++ ){
					cur = new ArrayList<>();
					for (int j=0;j<i;j++){
						//print
						int item = 0;
						if(j-1>=0) item+=prev.get(j-1);
						//the prev array is of leng i-1, so the last index is i-2
						if(j<=i-2) item+=prev.get(j);
						cur.add(item);
					}
					answer.add(cur);
					prev = cur;
				}
			}
			return answer;
		}
	}
}
