package com.somerton.fairylights.view;

import java.util.Scanner;

import com.somerton.fairylights.Algorithms;
import com.somerton.fairylights.model.Chain;

/**
 * The basic view class.
 *
 */
public class FairyLightDisplay {

	
	/**
	 * Output the current state of the chain.
	 * 
	 * @param chain the chain to display.
	 */
	public void display(Chain chain) {

		System.out.println(chain);

	}

	/**
	 * Simple menu to chose algorithm.
	 * 
	 * @return the algorithm chosen.
	 */
	public Algorithms displayOptions() {

		System.out.println("1 Sequence");
		System.out.println("2 Colour");
		System.out.println("3 Alternate");

		return captureInput();
	}

	private Algorithms captureInput() {

		String choice;
		Scanner sc = new Scanner(System.in);
		Algorithms alg = null;

		do {
			System.out.println("\nChoose ----> ");

			choice = sc.next();

			switch (choice) {

			case "1":
				alg = Algorithms.SEQUENCE;
				break;
			case "2":
				alg = Algorithms.COLOUR;
				break;
			case "3":
				alg = Algorithms.ALTERNATE;
				break;
			default:
				System.out.println("Please select a valid algorithm (1-3)");
			}

		} while (alg == null);

		sc.close();
		return alg;

	}

}
