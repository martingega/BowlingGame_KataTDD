package it.unimi.di.sweng.lab02;

public class BowlingGame {

	private int count; // count of rolled down pins

	public void roll(int pins){
		count += pins;
	}

	public int score(){
		return count;
	}

}
