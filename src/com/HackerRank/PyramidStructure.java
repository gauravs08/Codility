package com.HackerRank;
import java.util.Scanner;


public class PyramidStructure {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StairCase(6);
	}

	private static void StairCase(int n) {

		for (int i = 1; i <= n; i++) {
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
