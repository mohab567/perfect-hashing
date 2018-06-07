package perfectHashing;

import java.util.ArrayList;

public class Read {

	public static void main(String[] args) {
		ArrayList<Integer> f1 = new ArrayList<Integer>();

		for(int i = 0;i<100000;i+=7){
			f1.add(i);
			
		}
		
		SpaceN2 s = new SpaceN2(f1);
		s.build();
		System.out.println("no of builds "+s.re);
		System.out.println(s.find(70));
		SpaceN s2 = new SpaceN(f1);
		s2.build();
		System.out.println("no of builds "+s2.re);
		System.out.println(s2.find(14));
	}

}
