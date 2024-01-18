package it.unimi.di.sweng.lab02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


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

}
