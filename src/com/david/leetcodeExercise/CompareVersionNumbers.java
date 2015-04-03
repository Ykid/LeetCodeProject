package com.david.leetcodeExercise;


public class CompareVersionNumbers {
	
	public int compareVersion(String version1,String version2){
		String[] versionsOne = version1.split("\\.");
		String[] versionsTwo = version2.split("\\.");
		int length1 = versionsOne.length;
		int length2 = versionsTwo.length;
		// the lengths might be different.
		int compareLength = length1>length2?length1:length2;
		for ( int i =0; i<compareLength; i++){
			String subversion1;
			if(i>=length1)  subversion1="0";
			else subversion1=versionsOne[i];
			String subversion2;
			if(i>=length2) subversion2="0";
			else subversion2=versionsTwo[i];
			int result = compareHelper(subversion1, subversion2);
			if(result!=0) return result;
		}
		return 0;
	}
	
	private int compareHelper(String version1, String version2){
		int v1 = Integer.parseInt(version1);
		int v2 = Integer.parseInt(version2);
		if ( v1 > v2) return 1;
		else if ( v1 < v2) return -1;
		else return 0;
	}
}
