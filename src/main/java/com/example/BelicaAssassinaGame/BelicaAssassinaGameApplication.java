package com.example.BelicaAssassinaGame;

import com.example.BelicaAssassinaGame.keyboard.KeyboardManager;
import com.example.BelicaAssassinaGame.phases.Game;
import com.example.BelicaAssassinaGame.phases.GameOver;
import com.example.BelicaAssassinaGame.phases.Start;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BelicaAssassinaGameApplication {

	public static void Main(String[] args) {

		Start startPhase = new Start();
		Game game = new Game();
		GameOver gameOver = new GameOver();

		KeyboardManager keyboardManager = new KeyboardManager(startPhase);

		startPhase.execute();

		while(true){
			keyboardManager.setActiveHandler(game);
			game.execute();
			keyboardManager.setActiveHandler(gameOver);
			gameOver.execute();
		}
	}
}
