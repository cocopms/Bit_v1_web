package com.jse.algorithm;

public class Gugudan {
	public static void main(String[] args) {
		System.out.println(":::구구단:::");
		for (int i = 1; i < 10; ++i) {
			for (int j = 2; j < 6; ++j) {
				System.out.print(String.format("%d * %d = %d \t", j, i, i * j));
			} // 계속 반복되는 건 계속 for문을 중첩해서 진행하면 된다
			System.out.println();
		} // 유사 : "시계" / // 가로와 세로는 바꿀 수 있다...
		
		System.out.println();
		for (int i = 1; i < 10; ++i) {
			for (int j = 6; j < 10; ++j) {
				System.out.print(String.format("%d * %d = %d \t", j, i, i * j));
			} // 계속 반복되는 건 계속 for문을 중첩해서 진행하면 된다
			System.out.println();
		} 
	}
}