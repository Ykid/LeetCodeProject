package com.david.leetcodeExercise;

public class MedianofTwoSortedArrays {

	public static void main(String[] argv){
		int[] A = {1,2};
		int[] B = {3,4};
		System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(A, B));
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
		int[] AstartEnd = {0,A.length-1};
		int[] BstartEnd = {0,B.length-1};
		int middle;
		if (A.length == 0){
			return handleSimpleCase(B);
		}else if ( B.length == 0){
			return handleSimpleCase(A);
		}
		//middle is not the index, middle -1 is 
		if ((A.length+B.length)%2 == 0 ){
			middle = ( A.length + B.length )/2;
//			System.out.println("even" + middle);
			int middleElmt = getIthElmt(A, B, middle, AstartEnd, BstartEnd);
			int middleElmtNext = getIthElmt(A, B, middle+1, AstartEnd, BstartEnd); 
			System.out.println(middleElmt + " " + middleElmtNext);
			return ( middleElmt + middleElmtNext ) / 2.0;
		}else{

			middle = (A.length + B.length + 1) /2;
//			System.out.println("odd" + middle);
			return getIthElmt(A, B, middle, AstartEnd, BstartEnd);
		}
	    
	}
	
	double handleSimpleCase(int[] A){
		if ( A.length % 2 ==0){
			return (A[A.length/2-1] + A[A.length/2])/2.0;
		}else{
			return A[(A.length+1)/2-1];
		}
	}
	
	public int getIthElmt(int[] A, int[] B, int rank, int[] AstartEnd, int[] BstartEnd){
		int indexA;
		int indexB;
		int lengthA = AstartEnd[1] - AstartEnd[0]+1;
		int lengthB = BstartEnd[1] - BstartEnd[0]+1;
//		System.out.format("rank: %d, Astart:%d, Aend:%d, Bstart:%d, Bend:%d%n",rank,AstartEnd[0], AstartEnd[1], BstartEnd[0],BstartEnd[1]);
		if ( rank == 1){
			return (A[AstartEnd[0]]<=B[BstartEnd[0]]? A[AstartEnd[0]]:B[BstartEnd[0]]);
		}
		if (Math.ceil(rank/2.0) > lengthA ){
			indexA = AstartEnd[1];
			indexB = ( rank - lengthA -1 ) + BstartEnd[0] ;//since the index is starting from 0
		}else if(Math.ceil(rank/2.0) > lengthB) {
			indexB = BstartEnd[1] ;
			indexA = ( rank - lengthB - 1 ) + AstartEnd[0];
		}else{
			indexA = (int)Math.ceil(rank/2.0) + AstartEnd[0] -1;
			indexB = (int)Math.floor(rank/2.0) + BstartEnd[0] -1;
		}
//		System.out.format("Aindex:%d, Bindex: %d%n", indexA, indexB);
//		System.out.format("A[indexA]:%d, B[indexB]:%d%n", A[indexA],B[indexB]);
		if ( A[indexA] > B[indexB]){
			if ( indexB == BstartEnd[1]){
				int elmtInB = indexB - BstartEnd[0] + 1;
				return A[rank - elmtInB + AstartEnd[0] - 1];
			}
			int newRank = rank - ( indexB - BstartEnd[0] + 1 );
			int[] newAstartEnd = { AstartEnd[0] , indexA };
			int[] newBstartEnd = { indexB + 1,BstartEnd[1]};
//			System.out.format("newrank: %d, newAstart:%d, newAend:%d, newBstart:%d, newBend:%d%n",newRank,newAstartEnd[0], newAstartEnd[1], newBstartEnd[0],newBstartEnd[1]);
			return getIthElmt(A, B, newRank, newAstartEnd ,newBstartEnd);
		}else if(A[indexA] < B[indexB]) {
			if ( indexA == AstartEnd[1]){
				int elmtInA = indexA - AstartEnd[0] + 1;
				return B[rank - elmtInA +BstartEnd[0]-1];
			}
			int newRank = rank - (indexA - AstartEnd[0] +1 ); //indexA means how many elements are in from of A[indexA]
			int[] newBstartEnd = { BstartEnd[0] , indexB };
			int[] newAstartEnd = { indexA + 1,AstartEnd[1]};
//			System.out.format("newrank: %d, newAstart:%d, newAend:%d, newBstart:%d, newBend:%d%n",newRank,newAstartEnd[0], newAstartEnd[1], newBstartEnd[0],newBstartEnd[1]);
			return getIthElmt(A, B, newRank, newAstartEnd ,newBstartEnd);
		}else{
			return A[indexA];
		}
	}

}
