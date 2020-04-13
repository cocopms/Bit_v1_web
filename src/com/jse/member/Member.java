package com.jse.member;
import lombok.Data;

@Data
public class Member {
	private String userid, password, name, unique; //ssn = unique
	private int age;
	private double height, weight;
}