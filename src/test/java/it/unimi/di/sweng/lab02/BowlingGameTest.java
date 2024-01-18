package it.unimi.di.sweng.lab02;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class BowlingGameTest {

	private BowlingGame game = new BowlingGame();

	@Test
	void worstGame() {

		rollZeros(20);
		int score = game.score();
		assertThat(score).isEqualTo(0);
	}

	@Test
	void onePinDown() {

		game.roll(1);
		rollZeros(19);
		int score = game.score();
		assertThat(score).isEqualTo(1);
	}

	@Test
	void tooLargeRoll(){
		assertThatThrownBy(() -> game.roll(11))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void negativeNumberRoll(){
		assertThatThrownBy(() -> game.roll(-1))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void spareTest() {

		roll(5, 5, 1);
		rollZeros(17);
		int score = game.score();
		assertThat(score).isEqualTo(12);
	}

	@Test
	void nonSpareTest() {
		// first frame not a spare
		game.roll(0);
		game.roll(5);
		// second frame not a spare
		game.roll(5);
		game.roll(1);
		rollZeros(16);
		int score = game.score();
		assertThat(score).isEqualTo(11);
	}

	private void rollZeros(int numberOfRolls) {
		for (int i = 0; i < numberOfRolls; i++) {
			game.roll(0);
		}
	}

	private void roll(int... pinsArray) {
		for (int pins : pinsArray) {
			game.roll(pins);
		}
	}

}
