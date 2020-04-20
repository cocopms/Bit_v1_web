package com.jse.game;
//CRUD 꼭 해주어야 함
public interface GameService {
	public void add(Game game); //create
	public Game[] list(); //read - list
	public Game detail(Game game); //read - detail
	public int count(); //수 세기
	public void update(Game game); //update
	public void delete(Game game); //delete
	
	public int calculate(); //고유메소드
	public String comval(); //고유메소드
	public String dicecal(); //고유메소드
	public String diceresult(); //고유메소드
	public int sum(); //고유메소드
}