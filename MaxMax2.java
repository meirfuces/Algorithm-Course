import java.util.Arrays;
import java.util.Stack;

class Node{
	Stack<Integer> st;
	int num;
	public Node (int num) {
		this.num = num;
		st = new Stack<Integer>();
	}
}
public class MaxMax2 {
	public static int Maxmax (Node []arr, int low, int high) {
		if (low < high) {
			int index = 0;
			int mid = (high+low)/2;
			int i = Maxmax(arr, low, mid);
			int j = Maxmax(arr, mid+1, high);
			if (arr[i].num>arr[j].num) {
				arr[i].st.push(arr[j].num);
				return i;
			}
			else {
				arr[j].st.push(arr[i].num);
				index = j;
				return j;
			}
			
		}
		return low;
	}
	public static void main(String[] args) {
		int []arr = new int [8];
		for (int i = 0; i < arr.length; i++) {
			 arr[i] = (int)(Math.random() * 50) + 1; 
		}
		System.out.println("arr is: " +Arrays.toString(arr));
		Node [] arrNode = new Node [arr.length];
		for (int i = 0; i < arr.length; i++) {
			arrNode[i] = new Node(arr[i]);
		}
		int index = Maxmax(arrNode, 0, arr.length-1);
		int max2 = arrNode[index].st.pop();
	
		while (!(arrNode[index].st.empty())) {
			int temp = arrNode[index].st.pop();
			if (temp>max2)
				max2= temp;
		}
		
System.out.println("the Max 1 is: " + arrNode[index].num + " Max 2 Is: " + max2);
	}

}
