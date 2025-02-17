package naming.example;

public class Dice {

    public static void main(String[] args) {
        int dicePerThrow = 4;
        int numberOfThrows = 7;

        int[][] throwTable = new int[numberOfThrows][dicePerThrow];
        int[] frequencyOfSums = new int[dicePerThrow * 6  - dicePerThrow];
        
        int allDiceEqualCounter = playDiceGame(throwTable, frequencyOfSums);
        System.out.println("There were " + allDiceEqualCounter + " yahtzees");

        for(int i = 0; i < frequencyOfSums.length; i++) {
            System.out.println("Sum: " + i + " times: " + frequencyOfSums[i]);
        }
    }

	private static int playDiceGame(int[][] throwTable, int[] frequencyOfSums) {
		int allDiceEqualCounter = 0;
		for(int i = 0; i < throwTable.length; i++) {
        	int sumOfThrow = throwDice(throwTable, i);
        	frequencyOfSums[sumOfThrow]++;
        	
            boolean allDiceEqual = areAllDiceEqual(throwTable, i);
            if(allDiceEqual) {
            	allDiceEqualCounter++;
            }           
        }
		return allDiceEqualCounter;
	}

	private static boolean areAllDiceEqual(int[][] throwTable, int throwNumber) {
		for(int j = 1; j < throwTable[0].length; j++) {
		    if(throwTable[throwNumber][0] != throwTable[throwNumber][j]) {
		        return false;
		    }
		}
		return true;
	}

	private static int throwDice(int[][] throwTable, int throwNumber) {
		int sumOfThrow = 0;
		System.out.print("Roll: ");
		for(int j = 0; j < throwTable[0].length; j++) {
		    sumOfThrow += rollDie(throwTable, throwNumber, j);
		}
		System.out.println(" Sum: " + sumOfThrow);
		return sumOfThrow;
	}

	private static int rollDie(int[][] throwTable, int throwNumber, int dieNumber) {
		int dieRoll = (int)(Math.random() * 6) + 1;
		throwTable[throwNumber][dieNumber] = dieRoll;
		System.out.print(dieRoll + " ");
		return dieRoll;
	}

}
