package naming.example;

public class DiceSimulation {

	private Throw[] throwTable;
	private int[] frequencyOfSums;

	public DiceSimulation(int dicePerThrow, int numberOfThrows) {
		this.throwTable = new Throw[numberOfThrows];
		for(Throw t : throwTable) {
			t = new Throw(dicePerThrow);
		}
		this.frequencyOfSums = new int[dicePerThrow * 6  - dicePerThrow];
	}

	private int playDiceGame() {
		int allDiceEqualCounter = 0;
		for(int i = 0; i < throwTable.length; i++) {
        	int sumOfThrow = throwTable[i].throwDice();
        	frequencyOfSums[sumOfThrow]++;
        	
            boolean allDiceEqual = throwTable[i].areAllDiceEqual();
            if(allDiceEqual) {
            	allDiceEqualCounter++;
            }           
        }
		return allDiceEqualCounter;
	}

	private void printFrequencies() {
		for(int i = 0; i < frequencyOfSums.length; i++) {
            System.out.println("Sum: " + i + " times: " + frequencyOfSums[i]);
        }
	}

	public static void main(String[] args) {
        DiceSimulation simulation = new DiceSimulation(4, 7);
        int allDiceEqualCounter = simulation.playDiceGame();
        System.out.println("There were " + allDiceEqualCounter + " yahtzees");
		simulation.printFrequencies();
    }

}
