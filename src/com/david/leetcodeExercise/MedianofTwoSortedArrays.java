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
		int Astart = AstartEnd[0];
		int Aend = AstartEnd[1];
		int Bstart = BstartEnd[0];
		int Bend = BstartEnd[1];
		int lengthA = Aend - Astart+1;
		int lengthB = Bend - Bstart+1;
//		System.out.format("rank: %d, Astart:%d, Aend:%d, Bstart:%d, Bend:%d%n",rank,Astart, Aend, Bstart,Bend);
		if ( rank == 1){
			return (A[Astart]<=B[Bstart]? A[Astart]:B[Bstart]);
		}
		if (Math.ceil(rank/2.0) > lengthA ){
			indexA = Aend;
			indexB = ( rank - lengthA -1 ) + Bstart ;//since the index is starting from 0
		}else if(Math.ceil(rank/2.0) > lengthB) {
			indexB = Bend ;
			indexA = ( rank - lengthB - 1 ) + Astart;
		}else{
			indexA = (int)Math.ceil(rank/2.0) + Astart -1;
			indexB = (int)Math.floor(rank/2.0) + Bstart -1;
		}
//		System.out.format("Aindex:%d, Bindex: %d%n", indexA, indexB);
//		System.out.format("A[indexA]:%d, B[indexB]:%d%n", A[indexA],B[indexB]);
		if ( A[indexA] > B[indexB]){
			if ( indexB == Bend){
				int elmtInB = indexB - Bstart + 1;
				return A[rank - elmtInB + Astart - 1];
			}
			int newRank = rank - ( indexB - Bstart + 1 );
			int[] newAstartEnd = { Astart , indexA };
			int[] newBstartEnd = { indexB + 1,Bend};
//			System.out.format("newrank: %d, newAstart:%d, newAend:%d, newBstart:%d, newBend:%d%n",newRank,newAstart, newAend, newBstart,newBend);
			return getIthElmt(A, B, newRank, newAstartEnd ,newBstartEnd);
		}else if(A[indexA] < B[indexB]) {
			if ( indexA == Aend){
				int elmtInA = indexA - Astart + 1;
				return B[rank - elmtInA +Bstart-1];
			}
			int newRank = rank - (indexA - Astart +1 ); //indexA means how many elements are in from of A[indexA]
			int[] newBstartEnd = { Bstart , indexB };
			int[] newAstartEnd = { indexA + 1,Aend};
//			System.out.format("newrank: %d, newAstart:%d, newAend:%d, newBstart:%d, newBend:%d%n",newRank,newAstart, newAend, newBstart,newBend);
			return getIthElmt(A, B, newRank, newAstartEnd ,newBstartEnd);
		}else{
			return A[indexA];
		}
	}

}
