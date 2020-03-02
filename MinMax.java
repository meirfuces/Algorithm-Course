package algoritem;

import java.util.Arrays;

public class MinMax {
	/**
	 * 
	 *	Complexity: 3n/2 - 2 
	 */
	public static void minMax(int []arr){
		int min,max;

		if (arr[0]>arr[1]) {
			min= arr[1];
			max= arr[0];
		}
		else {
			min=arr[0];
			max =arr[1];
		}
		for (int i=2; i<arr.length-1; i+=2) {
			if (arr[i]>arr[i+1]) {
				if (arr[i]>max)
					max = arr[i];
				if (arr[i+1]<min)
					min = arr[i+1];
			}
			else { // arr[i]<arr[i+1]
				if (arr[i+1]>max)
					max= arr[i+1];
				if(arr[i]<min)
					min =arr[i];
			}
		} //end for
		if (arr.length %2 == 1) {
			if (arr[arr.length-1]>max) {
				if (arr[arr.length-1]>max)
					max = arr[arr.length-1];
			}
			else if (arr[arr.length-1]<min)
				min =arr[arr.length-1];
		}
		System.out.println("the min is: " + min +" max is" +max);
	}
public static void main(String[] args) {
		
		//create array
		int[] arr = GenerateArray(10);
		//find minmax - algorithm5
		minMax(arr);
}
private static int[] GenerateArray(int n) {
	int[] arr = new int[n];
	for (int i = 0; i < arr.length; i++) {
		arr[i] = (int)(Math.random()*1000);
	}
	System.out.println(Arrays.toString(arr));
	return arr;
}
	}
