package com.jse.game;
import javax.swing.JOptionPane;
import com.jse.util.Calculator;
import com.jse.util.Constants;

public class GameController {
	public static void main(String[] args) {
		Calculator cal = null;
		Game game = null;
		GameService service = new GameServiceImpl();
		while (true) {
			switch (JOptionPane.showInputDialog(Constants.GAME_MENU)) {
			case "0":
				return;
			case "1":
				cal = new Calculator();
				String value1 = JOptionPane.showInputDialog(Constants.GAME_NUMF);
				cal.setNum1(Integer.parseInt(value1));
				String value2 = JOptionPane.showInputDialog(Constants.GAME_NUMT);
				cal.setNum2(Integer.parseInt(value2));
				JOptionPane.showMessageDialog(null, service.calculate());
				break;
			case "2":
				game = new Game();
				String value = JOptionPane.showInputDialog(Constants.GAME_DICE);
				game.setDicenum(Integer.parseInt(value));
				JOptionPane.showMessageDialog(null, service.dicecal());
				JOptionPane.showMessageDialog(null, service.diceresult());
				break;
			case "3":
				JOptionPane.showMessageDialog(null, service.sum());
				break;
			}
		}
	}
}
