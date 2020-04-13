package com.jse.game;

import java.util.Random;
import com.jse.util.Calculator;

public class GameServiceImpl implements GameService {
	private Calculator cal;
	private Random rd;
	private Game game;

	public GameServiceImpl() {
		rd = new Random();
		cal = new Calculator();
		game = new Game();
	}

	public int calculate() {
		return cal.getNum1() + cal.getNum2();
	}

	public String comval() {
		int dicenum = rd.nextInt(6) + 1;
		String comval = "";
		comval = (dicenum == 1) ? "홀" : "짝";
		comval = (dicenum == 3) ? "홀" : "짝";
		comval = (dicenum == 5) ? "홀" : "짝";
		return comval;
	}

	public String dicecal() {
		int num = rd.nextInt(6) + 1;
		String result = "";
		if (num == 1) {
			result = "홀";
		} else if (num == 2) {
			result = "짝";
		} else if (num == 3) {
			result = "홀";
		} else if (num == 4) {
			result = "짝";
		} else if (num == 5) {
			result = "홀";
		} else {
			result = "짝";
		}
		return result;
	}

public String diceresult() {
	int a = game.getUserval();
	int b = game.getComval();
	String result = "";
	result = (a == b) ? "맞음" : "틀림" ;
	return result;
}

	public int sum() {
		int sum = 0;
		for (int i = 1; i <= 5; ++i) {
			System.out.println(i);
			sum += i;
		}
		return sum;
	}
}