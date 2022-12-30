package BelicaAssassinaGame;

import BelicaAssassinaGame.keyboard.KeyboardManager;
import BelicaAssassinaGame.phases.Game;
import BelicaAssassinaGame.phases.GameOver;
import BelicaAssassinaGame.phases.Start;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BelicaAssassinaGameApplication {

	public static void main(String[] args) {
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
