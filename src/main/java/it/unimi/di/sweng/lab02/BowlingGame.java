package it.unimi.di.sweng.lab02;

import org.jetbrains.annotations.NotNull;

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
		List<Frame> frames = buildFrames();

		int baseScore = frames.stream().mapToInt(Frame::baseScore).sum();

		int bonus = 0;
		for (int i = 0; i < frames.size() - 1; i++) {
			Frame frame = frames.get(i);
			if (frame.isSpare()) {
				// bonus point from the FIRST roll of the NEXT frame
				bonus += frames.get(i + 1).getRoll1();
			}
			if (frame.isStrike()){
				bonus += frames.get(i + 1).getRoll1();
				bonus += frames.get(i + 1).getRoll2();
			}
		}
		return baseScore + bonus;
	}

	@NotNull
	private List<Frame> buildFrames() {
		List<Frame> frames = new ArrayList<>();
		for(int i = 0; i < rolls.size(); i++){
			if(rolls.get(i) == 10){
				frames.add(new Frame(10, 0));
			} else {
				Frame frame = new Frame(rolls.get(i), rolls.get(i + 1));
				frames.add(frame);
				i++;
			}
		}
		return frames;
	}

}
