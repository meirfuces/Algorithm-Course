
public class eggs_riddle {
	/**
	 * Returns the minimum floor that causes breaking ball - 
	 * using 2 eggs and dividing the building into different parts
	 * Triangular Number -
	 *  Complexity: <=sqrt(2*floors)
	 */ 
	public static void triangularNumber(int fBreak, int []floors) { 
		int num =1;
		int Complexity =0;
		int numfloors= floors.length;
		while (numfloors>(num+1)*num/2)
			num++;
		System.out.println("tiang is " +num);
		//end while
		int jump = num;
		int step = jump-1;
		// for the first egg
		while(floors[jump]<fBreak) {
			jump+=step;
			step = step-1;
			Complexity++;
	}
		jump = jump-(step+1);
		while (floors[jump] < fBreak) {
			jump++;
		Complexity++;
	}
		System.out.println("floor is: " + jump);
		System.out.println("step is " + 	Complexity + " is small then: " + Math.sqrt(numfloors*2));
		
	}
	
	public static void eggsFloor(int eggs, int floors) {
		int [][]eggsFloors = new int [eggs+1][floors+1];
		for (int i = 1; i <= eggs; i++) {
			eggsFloors[i][0] = 0;
			eggsFloors [i][1] = 1;
		}
		for (int j = 1; j <= floors; j++) {
			eggsFloors[1][j] = j;
		}
		for (int i = 2; i <= eggs; i++) {
			for (int j = 2; j <= floors; j++) {
				eggsFloors[i][j] = Integer.MAX_VALUE;
				for (int x = 1; x <= j; x++) {
					int res = 1+Math.max(eggsFloors[i-1][x-1], eggsFloors[i][j-x]);
					if (res<eggsFloors[i][j])
						eggsFloors[i][j] =res;	
				}
		}
		}
		// eggFloor[n][k] holds the result 
		System.out.println("Minimum number of trials in worst case with " + eggs + " and " + floors + " is " + 
		eggsFloors[eggs][floors]);
	}
	
	public static void main(String[] args) {
		int []floors = new int [100];
		for (int i = 0; i < floors.length; i++) 
			floors[i] = i;
		
		triangularNumber(39, floors);
		eggsFloor(3, 100);
	}

}
