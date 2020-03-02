package test_15_10_2018;

public class prisonBreak {
public static int prisonLampOn (int n) {
	boolean [] prison = new boolean [n];
	boolean lamp =true;
	int count =0;
	int step =0;
	while (count<n) {
		int indexPrison = (int)(Math.random()*n);
		step++;
		if (indexPrison==0) { // the sofer
			if (prison[indexPrison]==false) {
				prison[indexPrison]=true;
				count++;
			}
				if (lamp== false) {
					count++;
				lamp =true;	
			
			} 
		}// end sofer 
			else { // not the sofer
			if (prison[indexPrison]==false &&lamp== true) {
				lamp=false;
			prison[indexPrison]=true;
			}
			}
			
		}
	
	return step;
}

public static int prisonRandomLamp(int n) {
	int [] enter = new int [n];
	int count = 0;
	boolean lamp;
	int random = (int) Math.random()*2;
	if (random==0) lamp =false;
	else lamp =true;
	int steps=0;
	while (count<n*2) {
		steps++;
		int index = (int)(Math.random()*n);
		if (index==0) {
			if (enter[index]<2) {
				enter[index]++;
				count++;
			}
			if (lamp== true) {
				lamp=false;
				count++;
			}
		}
			else { // not the sofer
				if (enter[index]<2 &&lamp==false) {
					lamp =true; // turn on
					enter[index]++;
				}
			
		}
	}
	return steps;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("The step when the lanmp is on : " + prisonLampOn(100));
System.out.println("The step when the is on is : " + prisonRandomLamp(100));

	}

}
