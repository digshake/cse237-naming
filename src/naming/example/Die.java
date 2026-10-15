package naming.example;

public class Die {
    private int numberOfSides;

    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public int roll() {
        return (int)(Math.random() * numberOfSides) + 1;
    }
}
