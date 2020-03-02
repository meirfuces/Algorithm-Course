import java.util.Arrays;

public class LIS {
	/**
	 * dynamic programming of LIS - get the sequence
	 * Complexity: O(n^2)
	 */
	public static int LiS (int []arr) {
		int [] t = new int [arr.length];
		int lis =1;
		t[0] = arr[0];
		for (int i = 0; i < t.length; i++) {
		int index = binarySearch(t,arr[i],0,lis-1 );
		t[index] = arr[i];
		if (index==lis) lis++;
		}
		return lis;
	}

	private static int binarySearch(int[] t, int num, int start, int end) {
		if (t[start]>num) return start;
		if (t[end]<num) return end+1;
		if (start  == end) return start;
		int mid = (start+end)/2;
		if (num<t[mid]) 
			return binarySearch(t, num, start, mid);
		else // (num>t[mid])
			return binarySearch(t, num, mid+1, end);
	}
	/**
	 * dynamic programming of LIS - get the String
	 * Complexity: 	O(n*(n+logn) = O(n^2+nlogn) = O(n^2)
	 */
	public static int[] LongestLisString (int []arr){
	
		int [][] mat = new int [arr.length][arr.length];
		mat[0][0] = arr[0];
		int lis =1;
		for (int i = 0; i < mat.length; i++) {
			int index = binarySearchString(mat, lis,arr[i]);
			for (int j = 0; j < index; j++) {
				mat[index][j] =mat[index-1][j];
			}
			mat[index][index] = arr[i];
			if (index == lis) lis ++;
		}
		int[] ans = new int [lis];
		for (int i = 0; i < lis; i++) {
			ans [i]=mat[lis-1][i];
		}
		
		return ans;
	}

	private static int binarySearchString(int[][] mat, int end, int v) {
		if(v > mat[end-1][end-1]) return end;
		if(v < mat[0][0]) return 0;
		int high = end, low = 0;
		while(low <= high) {
			if(low == high)return low;
			int mid = (low + high)/2;
			if(mat[mid][mid] == v) return mid;
			if(mat[mid][mid] > v) high = mid;
			else low = mid+1;
		}
		return -1;
	
	}
	public static int lisWithK(int []arr, int k) {
		int [] ans = LongestLisString(arr);
		int lis =0;
		for (int i = 1; i < ans.length-1; i++) {
			int sum = Math.abs(ans[i]-ans[i+1]);
			

			if (sum==k) lis++;
		}
		return lis;
	}

	private int sumK(int[] temp, int i, int j) {
		
		return 0;
	}

	public static void main(String[] args) {
		int arr[] = {0, 8, 4, 12, 2, 2, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int arr2 [] = {1,11,2,10,4,5,2,1};
		System.out.println("Lis is : " + LiS(arr));
		int []StringAns = LongestLisString(arr);
		System.out.println("String is: " + Arrays.toString(StringAns));
		System.out.println("With K" + lisWithK(arr2, 3));
	}

}
