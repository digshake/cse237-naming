package naming.example;

public class Throw {
    private Die[] dice;

    public Throw(int numberOfDice) {
        dice = new Die[numberOfDice];
    }

    public int throwDice() {
		int sumOfThrow = 0;
		System.out.print("Roll: ");
		for(int j = 0; j < dice.length; j++) {
		    sumOfThrow += dice[j].roll();
		}
		System.out.println(" Sum: " + sumOfThrow);
		return sumOfThrow;
	}

    public boolean areAllDiceEqual() {
		for(int j = 1; j < dice.length; j++) {
		    if(dice[0] != dice[j]) {
		        return false;
		    }
		}
		return true;
	}
}
