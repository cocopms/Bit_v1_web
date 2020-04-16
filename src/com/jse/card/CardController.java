package com.jse.card;
import javax.swing.JOptionPane;
import com.jse.util.Constants;

public class CardController {
	public static void main(String[] args) {
		Card cards = null;
		CardServiceImpl service = new CardServiceImpl();

		while (true) {
			switch (JOptionPane.showInputDialog(Constants.CARD_MENU)) {
			case "0":
				return;
			case "1":
				
				for (int i = 0; i < 3; ++i) {
					cards = new Card();
					String[] value = JOptionPane.showInputDialog(Constants.CARD_INPUT).split(",");
					cards.setKind(value[0]);
					cards.setNumber(Integer.parseInt(value[1]));
					service.add(cards);
				}
				break;
			case "2":
				JOptionPane.showMessageDialog(null, service.printCard());
				break;
			}
		}
	}
}