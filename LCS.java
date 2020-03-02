import java.util.HashSet;
import java.util.Set;

public class LCS {
	
	/**
	 * Complexity: O(m*n) + O(m+n) = O(m*n)
	 
	 */
	public static int[][] lcs (String A, String B) {
		int [][] mat = new int [A.length()+1][B.length()+1];
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				if (A.charAt(i-1)==B.charAt(j-1)) {
					mat[i][j] = mat[i-1][j-1]+1;
			}		
			else {
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		return mat;
	}
	public static void AllString (String a, String b,int[][]mat, int i, int j,String ans, Set <String> AllString) {
		while (i>0 &&j>0) {
			if (a.charAt(i-1)== b.charAt(j-1)) {
				ans = a.charAt(i-1)+ans;
				i--;
				j--;
			}
				else {
					if (mat[i][j-1]>mat[i-1][j])
						j--;
					else if (mat[i][j-1]<mat[i-1][j])
						i--;
					else {
						AllString(a, b, mat, i-1, j, ans, AllString);
						AllString(a, b, mat, i, j-1, ans, AllString);
						return;
					}
				}
		}
		AllString.add(ans);
	}
	public static void main(String[] args) {
//String A = "abcdsds";
//String B = "abds";
String A = "ZBGCRDE";
String B = "YZGBCZD";
int [][] lcs = lcs(A, B);
Set<String> allSubSequences = new HashSet<String>();//there can be duplicated so Set is chosen

//calculate all subsequences
AllString(A, B, lcs, A.length(), B.length(), "", allSubSequences);
//print all subsequences
System.out.println(allSubSequences);
System.out.println("lcs is : " + lcs[A.length()][lcs[0].length-1] );
	}

}
