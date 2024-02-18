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
        String resultMessage;
        UserOptions userOption = UserOptions.getOption(userInput);

        String userChoice = userOption.toString();
        String computerChoice = generatedOption.toString();

        if (userOption == generatedOption) {
            return String.format("You chose %s, the Computer chose %s. ", userChoice, computerChoice)
        } else {

        boolean result = switch (userOption) {
            case ROCK -> generatedOption == UserOptions.SCISSORS;
            case PAPER -> generatedOption == UserOptions.ROCK;
            case SCISSORS -> generatedOption == UserOptions.PAPER;
            default -> throw new IllegalStateException("Unexpected value: " + userOption);
        };

        resultMessage = String.format("You chose %s, the Computer chose %s. ", userChoice, computerChoice)
            + (result ? "You Win!" : "You Lose! Try Again");
        }

        return resultMessage;
    }

    public String play(int userInput) {
        try {
            return checkResult(userInput);
        } catch (IllegalArgumentException err) {
            return err.getMessage();
        }
    }
}