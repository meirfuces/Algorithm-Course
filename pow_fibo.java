package algo_BeforeTest;

import java.util.Arrays;

public class pow_fibo {
/**
 *  Complexity: O(logn)
 * @param x
 * @param n
 * @return
 */
	public static int pow (int x, int n) {
		int res = 1;
		while (n!=0) {
			if (n%2==1) //Binary
				res*=x;
			x*=x;
			n=n/2;
		}
		return res;
	}
public static int fibonci (int n) {
		
		int [] []mat = {{1,1},{1,0}};
		int [] [] A = {{1,1},{1,0}};
		n=n-2;
		while (n!=0) {
			if (n%2==1) {
	    	A=multyArr (A,mat);
			}
			mat = multyArr(mat,mat);
			n=n/2;
		}
		return A[0][0];
			
		
	}
	private static int [][] multyArr(int[][] mat, int[][] a) {
		int mat2[][] = {{0,0},{0,0}};

		mat2[0][0] = a[0][0]*mat[0][0]+a[0][1]*mat[1][0];
		mat2[0][1] = a[0][0]*mat[0][1] + a[0][1]*mat[1][1];
		mat2[1][0] = a[1][0]*mat[0][0]+ a[1][1]*mat[1][0];
		mat2[1][1] = a[1][0]*mat[0][1] + a[1][1]*mat[1][1];

		 return mat2;
	
	}
	public static void main(String[] args) {
System.out.println(pow(2, 10));
System.out.println("Fibonachi: " + fibonci(9));
	}

}
