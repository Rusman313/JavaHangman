import java.util.Scanner;

class Prompter {
    Scanner scan = new Scanner(System.in);// instantiate scanner as a variable scan
    private static Game game;// private variable that is an instance of our game.

    public Prompter(Game game) {// it requires a game.
        Prompter.game = game;// private variable game is now set that equal to the argument that came in
    }

    // method that will prompt fora guess, and it will return whether or not the
    // guess was correct.
    public boolean promptForGuess() throws IllegalArgumentException {
        
        boolean isHit = false;// is it a hit?
        boolean isAcceptable = false;// is it acceptable?

        // get input pull off input
            // takes the input and stores it as a String variable
            // char guess = guessInput.charAt(0);// gets the first character of the
            // guessInput
        do {
            System.out.println("Enter a Letter:   ");// asks user for a letter
            String guessInput = scan.nextLine();
            //char guess = guessInput.charAt(0);
            try {
                isHit = game.applyGuess(guessInput);// takes the guess and does normalization
                isAcceptable = true;
            } catch (IllegalArgumentException e) {
                System.out.printf("%s. Please try again %n", e.getMessage());
            }
        }while (!isAcceptable);

        return isHit;
    }


    public void displayProgress() {
        System.out.printf("You have %d tries left to solve:  %s%n", game.getRemainingTries(),
                game.getCurrentProgress());
    }

    public static void displayOutcome() {
        if (game.isWon()) {
            System.out.printf("Congrats! You Won with %d tries remaining. %n", game.getRemainingTries());
       }else{
            System.out.printf("Sorry you lost the answer was %s.", game.getAnswer());
       }
   }
}