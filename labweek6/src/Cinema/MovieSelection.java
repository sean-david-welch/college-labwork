package Cinema;

import java.util.Scanner;

public class MovieSelection {
    private final Scanner scanner;
    private MovieOptions selectedMovie;

    public enum MovieOptions { DRAMA, COMEDY, ACTION }

    public MovieSelection(Scanner scanner) {
        this.scanner = scanner;
    }

    public MovieOptions getSelectedMovie() {
        return selectedMovie;
    }

    public void chooseMovieOption(){
        System.out.println("Please choose what film you would like to see:");
        for (MovieOptions options : MovieOptions.values()) {
            System.out.println(options.name());
        }

        boolean isMovieAvailable = false;
        while (!isMovieAvailable) {
            try {
                String input = scanner.nextLine().toUpperCase();
                selectedMovie = MovieOptions.valueOf(input);
                isMovieAvailable = true;
            } catch (IllegalArgumentException err) {
                System.out.println("That's not available! The options are:");
                for (MovieOptions options : MovieOptions.values()) {
                    System.out.println(options.name());
                }
            }
        }
    }
}
