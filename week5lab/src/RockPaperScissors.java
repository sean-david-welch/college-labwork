public class RockPaperScissors {

    private final UserOptions generatedOption;

    public RockPaperScissors() {
        int option = (int) (Math.random() * 3) + 1;
        this.generatedOption = UserOptions.getOption(option);
    }

    public enum UserOptions {
        ROCK(1), PAPER(2), SCISSORS(3);

        private final int value;

        UserOptions(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }

        public static UserOptions getOption(int value) {
            for (UserOptions option : UserOptions.values()) {
                if (option.getValue() == value) return option;
            }
            throw new IllegalArgumentException("Invalid option: " + value + "please choose from either 1, 2 or 3");
        }
    }

    public String checkResult(int userInput) {
        UserOptions userOption = UserOptions.getOption(userInput);
        if (userOption == generatedOption) return "It's a tie!";

        return switch (userOption) {
            case ROCK -> (generatedOption == UserOptions.SCISSORS) ? "You Win!" : "You Lose! Try Again";
            case PAPER -> (generatedOption == UserOptions.ROCK) ? "You Win!" : "You Lose! Try Again";
            case SCISSORS -> (generatedOption == UserOptions.PAPER) ? "You Win!" : "You Lose! Try Again";
            default -> throw new IllegalStateException("Unexpected value: " + userOption);
        };
    }

    public String play(int userInput) {
        try {
            return checkResult(userInput);
        } catch (IllegalArgumentException err) {
            return err.getMessage();
        }
    }
}