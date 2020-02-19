package naming;

public class Dice {

    public static void main(String[] args) {
        int dicePerRoll = 4;
        int numberOfRolls = 7;

        int[][] diceArray = new int[numberOfRolls][dicePerRoll];
        int[] frequencyOfSums = new int[dicePerRoll * 6 + 1];

        int diceAllTheSameCount = 0;
        for(int i = 0; i < numberOfRolls; i++) {
            int sumOfRoll = 0;
            System.out.print("Roll: ");
            for(int j = 0; j < dicePerRoll; j++) {
                int dieRoll = (int)((Math.random() * 6) + 1);
                diceArray[i][j] = dieRoll;
                sumOfRoll += dieRoll;
                System.out.print(dieRoll + " ");
            }
            System.out.println(" Sum: " + sumOfRoll);

            for(int j = 0; j < dicePerRoll - 1; j++) {
                if(diceArray[i][j] == diceArray[i][j+1]) {
                    diceAllTheSameCount++;
                }
            }
            frequencyOfSums[sumOfRoll]++;
        }
        System.out.println("There were " + diceAllTheSameCount + " yahtzees");

        for(int i = dicePerRoll; i < frequencyOfSums.length; i++) {
            System.out.println("Sum: " + i + " times: " + frequencyOfSums[i]);
        }

    }

}

