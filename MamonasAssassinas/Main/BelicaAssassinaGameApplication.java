package Main;


import Main.keyboard.KeyboardManager;
import Main.phases.Game;
import Main.phases.GameOver;
import Main.phases.Start;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BelicaAssassinaGameApplication {

	public static void main(String[] args) {
		Start startPhase = new Start();
		Game game = new Game();
		GameOver gameOver = new GameOver();

		KeyboardManager keyboardManager = new KeyboardManager(startPhase);

		startPhase.execute();

		boolean running = true;

		while(running){
			keyboardManager.setActiveHandler(game);
			game.execute();
			keyboardManager.setActiveHandler(gameOver);
			gameOver.execute();
		}
	}
}
