public class GuessingGame {
    private int userGuess;
    private int generatedNumber;
    private boolean result;

    // Getters
    public int getUserGuess(){
        return userGuess;
    }
    public int getGeneratedNumber(){
        return generatedNumber;
    }
    public boolean getResult(){
        return result;
    }

    // Setters
    public void setUserGuess(int userGuess) {
        if (userGuess > 0 && userGuess <= 20) {
            this.userGuess = userGuess;
        } else {
            System.out.println("Invalid Guess, must be greater than 0 and less than 10.");
        }
    }

    public void setGeneratedNumber() {
        this.generatedNumber = (int) (Math.random() * 10) + 1;
    }

    // methods
    public void checkResult() {
        this.result = (this.userGuess == this.generatedNumber);
    }
}
