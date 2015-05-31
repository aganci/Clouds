package com.aganci.gametemplate;

import java.util.Random;

public class RandomNumberGenerator {
	private static Random rand = new Random();

	public static int getRandIntBetween(int lowerBound, int upperBound) {
		return rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
	}

	public static int getRandInt(int upperBound) {
		return rand.nextInt(upperBound);
	}
}