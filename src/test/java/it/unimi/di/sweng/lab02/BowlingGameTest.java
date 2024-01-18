package it.unimi.di.sweng.lab02;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class BowlingGameTest {

	@Test
	void worstGame() {

		BowlingGame game = new BowlingGame();
		for (int i = 0; i < 20; i++) {
			game.roll(0);
		}
		int score = game.score();
		assertThat(score).isEqualTo(0);
	}

	@Test
	void onePinDown() {

		BowlingGame game = new BowlingGame();
		game.roll(1);
		for (int i = 0; i < 19; i++) {
			game.roll(0);
		}
		int score = game.score();
		assertThat(score).isEqualTo(1);
	}

	@Test
	void tooLargeRoll(){
		BowlingGame game = new BowlingGame();
		assertThatThrownBy(() -> game.roll(11))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void negativeNumberRoll(){
		BowlingGame game = new BowlingGame();
		assertThatThrownBy(() -> game.roll(-1))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void spareTest() {

		BowlingGame game = new BowlingGame();
		game.roll(5);
		game.roll(5);
		game.roll(1);
		for (int i = 0; i < 17; i++) {
			game.roll(0);
		}
		int score = game.score();
		assertThat(score).isEqualTo(12);
	}

	@Test
	void nonSpareTest() {
		BowlingGame game = new BowlingGame();
		// first frame not a spare
		game.roll(0);
		game.roll(5);
		// second frame not a spare
		game.roll(5);
		game.roll(1);
		for (int i = 0; i < 16; i++) {
			game.roll(0);
		}
		int score = game.score();
		assertThat(score).isEqualTo(11);
	}

}
