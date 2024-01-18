package it.unimi.di.sweng.lab02;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	private int count; // count of rolled down pins
	private final List<Integer> rolls = new ArrayList<>();

	public void roll(int pins){
		if(pins > 10 || pins < 0) {
			throw new IllegalArgumentException();
		}
		count += pins;
		rolls.add(pins);
	}

	public int score(){
		int baseScore = rolls.stream().mapToInt(i -> i).sum();
		int bonus = 0;
		for (int i = 2; i < rolls.size(); i+=2){
			if (rolls.get(i - 1) + rolls.get(i - 2) == 10)
				bonus += rolls.get(i);
		}
		return baseScore + bonus;
	}

}
