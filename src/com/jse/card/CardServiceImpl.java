package com.jse.card;

public class CardServiceImpl implements CardService {
	private Card[] cards;
	// cardbox = new Card[3][10]; 3장짜리 10개묶음
	// cardcontainer = new Card[3][10][100];
	private int count;

	public CardServiceImpl() {
		cards = new Card[3];
		count = 0;
	}
	@Override
	public void setCards(Card[] cards) {
		this.cards = cards;
	}
	@Override
	public Card[] getCards() {
		return cards;
	}
	@Override
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public int getCount() {
		return count;
	}
	@Override
	public void add(Card card) { // set
		cards[count] = card;
		// 결국 for의 i와 count는 같은 의미
		count++; // 실제 데이터의 개수
	}
	@Override
	public String printCard() {
		Card[] cards = getCards();
		String result = "";
		for (int i = 0; i < 3; ++i) {
			result += String.format("카드모양 : %s, 카드숫자 : %d \n", cards[i].getKind(), cards[i].getNumber());
		}
		return result;
	}
}
