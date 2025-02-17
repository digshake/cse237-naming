package naming.exercises;

import java.util.Scanner;

public class GamblersRuin {

	public static void main(String[] args) {

		Scanner keyboardInput = new Scanner(System.in);

		int startAmount = readIntFromUser(keyboardInput, "start amount");

		double chanceOfWinning = readDoubleFromUser(keyboardInput);
		int maxWinAmount = readIntFromUser(keyboardInput, "win amount");
		int days = readIntFromUser(keyboardInput, "number of days");
		int totalDaysFailed = 0;

		simulateExpectedValue(startAmount, chanceOfWinning, maxWinAmount, days, totalDaysFailed);
		//expected:
		computeExpectedValue(startAmount, chanceOfWinning, maxWinAmount);
	}

	private static void simulateExpectedValue(int startAmount, double chanceOfWinning, int maxWinAmount, int days,
			int totalDaysFailed) {
		for(int currentDay=0; currentDay < days; currentDay++) {
			int numberOfPlaysToday = 0;
			int currentAmount = startAmount;
			while (maxWinAmount > currentAmount && currentAmount > 0 ) {
				numberOfPlaysToday++;
				if( playGame(chanceOfWinning)) {
					currentAmount++;
				} else {
					currentAmount--;
				}
			}
			boolean failedToday = currentAmount == 0;
			if(failedToday) {
				totalDaysFailed++;
			}
			System.out.println("Day " + currentDay + ": " + numberOfPlaysToday + " plays, Ruin? " + failedToday);
		}
		double ruinRate = ((double)totalDaysFailed) / days;
		System.out.println("Simulated rate: " + ruinRate);
	}

	private static void computeExpectedValue(int startAmount, double chanceOfWinning, int maxWinAmount) {
		if(chanceOfWinning == .5) {
			double exepectedRuinRate = 1 - (((double)startAmount) / maxWinAmount);
			System.out.println("Expected: " + exepectedRuinRate);
		} else {
			double alpha = (1 - chanceOfWinning) / chanceOfWinning;
			double expectedRuinRate = (Math.pow(alpha, startAmount) - Math.pow(alpha, maxWinAmount)) / (1 - Math.pow(alpha, maxWinAmount));
			System.out.println("Expected: " + expectedRuinRate);
		}
	}

	private static boolean playGame(double chanceOfWinning) {
		double gameOutcome = Math.random();
		return gameOutcome > chanceOfWinning;
	}

	private static double readDoubleFromUser(Scanner keyboardInput) {
		System.out.println("Please enter the win chance: ");
		double chanceOfWinning = keyboardInput.nextDouble();
		return chanceOfWinning;
	}

	private static int readIntFromUser(Scanner keyboardInput, String prompt) {
		System.out.println("Please enter the " + prompt + ": ");
		int userInput = keyboardInput.nextInt();
		return userInput;
	}
}
