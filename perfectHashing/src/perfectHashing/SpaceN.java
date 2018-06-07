package perfectHashing;

import java.util.ArrayList;

public class SpaceN {
	SpaceN2[] hashTable; 
	ArrayList<Integer> toHash;
	long a;
	long b;
	int p = 2147483647;
	int m;
	int re=0;
	int sq=0;
	SpaceN(ArrayList<Integer> toHash){
		this.toHash=toHash;
	}
	
	public void build() {
		sq=0;
		re++;
		m=2*toHash.size();
		hashTable=new SpaceN2[m];
		generateNew();
		for(int i =0;i<toHash.size();i++){
			int hashedIndx=g(toHash.get(i));
			if(hashTable[hashedIndx]==null){
				hashTable[hashedIndx]=new SpaceN2();
				hashTable[hashedIndx].toHash.add(toHash.get(i));
				
			}else {
				hashTable[hashedIndx].toHash.add(toHash.get(i));
				
			}
			}
		for(int i =0;i<m;i++){
			if(hashTable[i]!=null){
				sq+=Math.pow(hashTable[i].toHash.size(),2);
			}
		}
		if(sq>4*m){
			this.build();
		}
		else{
			for(int i =0;i<m;i++){
				if(hashTable[i]!=null){
					hashTable[i].build();
				}
			}
		}
		}
	
	public boolean find(int i ){
		if(hashTable[g(i)]==null){
			return false;
		}
		return hashTable[g(i)].finds(i)==i;
	}
	public int finds(int i ){
		if(hashTable[g(i)]==null){
			return 0;
		}
		return hashTable[g(i)].finds(i);
	}
	private void generateNew() {
		a=(int) Math.floor(Math.random() * (m))+1;
		b=(int) Math.floor(Math.random() * (m))+1;
	}
	public int g(int i) {
		
		return (int)((a*i+b)%p)%m;
	}
}
