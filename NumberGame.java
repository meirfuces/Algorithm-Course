package test_15_10_2018;

import java.util.Arrays;

public class NumberGame {
	public static int[][] BuildMatrix (int[] game) {
		int length = game.length;
		int [][] mat = new int [length][length];
		for (int i = 0; i < mat.length; i++) {
			mat[i][i] = game[i]; //fill the slant of matrix
		}
		
	for (int i = length-2; i>=0; i--) {
		for (int j = i+1; j < mat.length; j++) {
			int x = game[i]-mat[i+1][j];
			int y = game[j]-mat[i][j-1];
			mat [i][j] = (int) (Math.max(x, y));
		}
	} // end for
	printMat(mat);
	return mat;
	}
	public static void printMat (int [][]mat) {
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}
	public static void game (int []game) {
		int i=0, j= game.length-1 , first=0 , second =0,
				firstSum = 0, secondSum = 0;
		int [][]mat = BuildMatrix(game);
		for (int k = 0; k < mat.length/2; k++) {
			if (game[i]-mat[i+1][j]>game[j]-mat[i][j-1]) { //The first choose
		
		firstSum += game [i];
		first = i;
		i++;
			}
			else {
				firstSum += game[j];
				first = j;
				j--;
			}
			
			if (i!=j) { // The second choose
				if (game[i] - mat [i+1][j]> game [j]-mat[i][j-1]) {
					secondSum+= game[i];
					second =i;
					i++;
				}
				else {
					secondSum += game[j];
					second =j;
					j--;
				}
			}  // end if i!=j
			else  { //if (j==0 || i==game.length-1) last time
				second = j;
				secondSum += game[j];
			}
			System.out.println("first <" + game[first]+ ">  second <" + game[second] +"> ");
			
		}
		System.out.println("sum of one is " + firstSum + " sum of the second is " + secondSum);
		System.out.println("The Diff is : " + (firstSum-secondSum));
		}
	
	public static void main(String[] args) {
	int arr[] = {94, 81, 78, 97, 40, 22, 80, 93}; 

		int []arr2 = {50,10,2,5};
game(arr);
System.out.println("******arr 2******");
game(arr2);
	}

}
