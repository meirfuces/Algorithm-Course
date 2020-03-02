import java.util.Stack;

public class Reactangle {
	
	public static int getMaxArea (int []hist) {
		int max_area= 0;
		int tp;  // To store top of stack 
        int area_with_top=0;
        int i = 0; 
        Stack<Integer> s = new Stack<>(); 
        int n = hist.length;
        while (i < n) 
        {
        	   if (s.empty() || hist[s.peek()] <= hist[i])
        		   s.push(i++);
        	   else {
        		   tp = s.pop();
        	   

               // Calculate the area with hist[tp] stack as smallest bar 
               area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1); 
        	   } //end else
        	   if (max_area<area_with_top)
        	   max_area = area_with_top;
        }
        while (s.empty() == false) 
        { 
            tp =  s.pop();  
      
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1); 
       
            if (max_area < area_with_top) 
                max_area = area_with_top; 
        } 
       
        return max_area; 
	}
	private static int maxArea(int[][] reactAngle) {
		
		int row = reactAngle.length, col = reactAngle[0].length;
		int maxArea = 0;
		int max = 0;
		int [] help = new int [col];
		for (int i = 0; i < row; i++) {
			
		for (int j = 0; j < col; j++) {
		if (reactAngle[i][j] ==1) help[j]++;
		else help[j]=0;
		}
		maxArea = getMaxArea(help);
		if (max<maxArea)
			max = maxArea;
		}
		return max;
	}
	public static void main(String[] args) {
		int [][] ReactAngle = {{1,0,0,0},{1,1,1,0},{1,1,1,0}};
		System.out.println("The max Area is: " + maxArea(ReactAngle));
		
		 int hist[] = { 6, 2, 5, 4, 5, 1, 6 }; //Maximum area is 12
		 System.out.println(getMaxArea(hist));
	}
	

}
