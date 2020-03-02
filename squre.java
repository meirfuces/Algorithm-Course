package test_15_10_2018;

import java.util.Arrays;

public class squre {
	public static int []  initMAt (int [][]squre, int k) {
		int [][] help =new int [squre.length][squre[0].length];
		for (int i=0; i<help.length;i++) {
			help[i][0] = squre [i][0];
			help[0][i] = squre[0][i];
	}
		int maxSqure= 0;
		int countK =0;
		for (int i = 1; i < help.length; i++) {
			for (int j = 1; j < help.length; j++) {
				if (squre[i][j]==1) {
					help [i][j] = min3(help[i-1][j-1],help[i-1][j],help [i][j-1])+1;
				if (help[i][j]>maxSqure) maxSqure = help[i][j];
				if (help[i][j]>=k) countK++;
				}
				}
		}
		System.out.println();
		for (int i = 0; i < help.length; i++) {
			System.out.println(Arrays.toString(help[i]));
		}
		int [] arr= new int [2];
		arr[0] = maxSqure*maxSqure;
		arr[1] = countK;
		return arr;
	}
	private static int min3(int i, int j, int k) {
		int min = Math.min(i, j);
		if (min<k) return min;
		else 
			return k;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int [][]squre = {{0,0,1,0,1},{0,1,1,1,1},{1,1,1,1,0},{0,1,1,1,1},{0,0,1,1,1}};
for (int i = 0; i < squre.length; i++) {
	System.out.println(Arrays.toString(squre[i]));
}
int []arr = initMAt(squre, 2);
System.out.println("The max is " + arr[0] + " and sum of TatMatix is " +arr[1]);
//System.out.println(initMAt(squre));
	}

}
