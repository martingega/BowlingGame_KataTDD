package it.unimi.di.sweng.lab02;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	private int count; // count of rolled down pins
	private List<Integer> rolls = new ArrayList<>();

	public void roll(int pins){
		if(pins > 10 || pins < 0) {
			throw new IllegalArgumentException();
		}
		count += pins;
		rolls.add(pins);
	}

	public int score(){
		return rolls.stream().mapToInt(i -> i).sum();
	}

}
