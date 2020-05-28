public class Hangman {
    public static void main(String[] args) throws IllegalArgumentException {
        Game game = new Game("treehouse");
        Prompter prompt = new Prompter(game);//makes new prompter
        // while there are still tries and game is not won keep going. 
        while (game.getRemainingTries() > 0 && !game.isWon()) {
            prompt.displayProgress();
            prompt.promptForGuess();
        }

        Prompter.displayOutcome();
        /*boolean isHit = prompt.promptForGuess();//asks for a letter
       
        //checks if the variable is a hit or miss. 
        if (isHit){
            System.out.println("Its a Hit!");
        }else{
            System.out.println("Oops its a miss...");
        }
        prompt.displayProgress();*/
    }
}