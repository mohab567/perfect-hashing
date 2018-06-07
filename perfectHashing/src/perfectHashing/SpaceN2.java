package perfectHashing;

import java.util.ArrayList;

public class SpaceN2 {
	public int[] hashTable; 
	public ArrayList<Integer> toHash=new ArrayList<Integer>();
	long a;
	long b;
	int p = 2147483647;
	int m;
	int re;
	SpaceN2(ArrayList<Integer> toHash){
		this.toHash=toHash;
		
	}
	SpaceN2(){
		

	}
	public void build() {
		re++;
		m=(int) Math.pow(toHash.size(), 2);
		hashTable=new int[m];
		generateNew();
		for(int i =0;i<toHash.size();i++){
			int hashedIndx=g(toHash.get(i));
			if(hashTable[hashedIndx]==0 || hashTable[hashedIndx]==toHash.get(i)){
				hashTable[hashedIndx]=toHash.get(i);
			}else{
				build();
				break;
			}
		}
		
	}
	private void generateNew() {
		a=(int) Math.floor(Math.random() * (p))+1;
		b=(int) Math.floor(Math.random() * (p))+1;
	}
	public int g(int i) {
		
		return (int)((a*i+b)%p)%m;
	}
	boolean find(int i){
		return hashTable[g(i)]==i;
	}
	int finds(int i){
		return hashTable[g(i)];
	}

}
