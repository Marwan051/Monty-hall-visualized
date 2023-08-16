package mp;

import java.util.HashMap;

public class Main {

	
	public static void main(String[] args) {
		int losstowinratio[] = {0,0};//array for the results (first value is losses the second is wins)
		startgame(1000,500,3,losstowinratio);//running the simulation
		System.out.println("Losses: "+losstowinratio[0]+"\nWins: "+losstowinratio[1]);//printing the results
		
	}
	
	
	
	/*
	 * we take number of times to run the simulation,number of doors,what mode to try it in(no change,change,chose randomly) and an array to keep track of the results
	 */
	public static void startgame(int num,int dnum,int mode,int losstowinratio[]) {
		HashMap<Integer,Integer> game = new HashMap<Integer,Integer>(); // make the hashmap for the 3 simulated values
		int choice = 0;
		for(int i = 0;i<num;i++) {
		for(int j =0;j<dnum;j++) {
			game.put(j+1, 0);
		}
		game.replace((int) (Math.random()*dnum)+1, 1); //add the winning value
		choice = (int) ((Math.random()*dnum)+1);//choose a random value to simulate first choice
		
		switch(mode) {
		case 1: //no change case
			if(game.get(choice)==1) {
				losstowinratio[1]++;
			}else {
				losstowinratio[0]++;
			}
			break;
		case 2: // always change case
			if(game.get(choice)==1) {
				losstowinratio[0]++;
			}else {
				losstowinratio[1]++;
			}
			break;
		case 3://control case(random changing or no changing)
			int ranchoice = (int) (Math.random()*2+1);
			if(ranchoice==1) {
				if(game.get(choice)==1) {
					losstowinratio[1]++;
				}else {
					losstowinratio[0]++;
				}
			}else {
				if(game.get(choice)==1) {
					losstowinratio[0]++;
				}else {
					losstowinratio[1]++;
				}
			}
			break;
		}
		
		}
	}
	

	
	
}
