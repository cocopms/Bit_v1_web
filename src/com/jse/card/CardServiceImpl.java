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
	public void add(Card card) { // set
		cards[count] = card;
		// 결국 for의 i와 count는 같은 의미
		count++; // 실제 데이터의 개수
	}
	
	@Override
	public Card[] list() {
		// TODO Auto-generated method stub
		return cards;
	}

	@Override
	public Card detail(Card card) {
		// TODO Auto-generated method stub
		return card;
	}
	
	@Override
	public int count() {
		return count;
	}

	@Override
	public void update(Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Card card) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String printCard() {
		Card[] cards = list();
		System.out.println(cards);
		String result = "";
		for (int i = 0; i < 3; ++i) {
			result += String.format("카드모양 : %s, 카드숫자 : %d \n",
					cards[i].getKind(), cards[i].getNumber());
		}
		System.out.println(result);
		return result;
	}


}
