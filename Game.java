class Game {
    public static final int MAX_MISSES = 8;
    private String answer;
    private String hits;
    private String misses;

    public Game(String answer) {
        this.answer = answer.toLowerCase();// this.answer refers to the instances field of answer rather than the
                                           // argument that was passed in.
        hits = "";
        misses = "";
    }

    public String getAnswer(){
        return answer;
    }

    private char normalizeGuess(char letter) throws IllegalArgumentException {
        if (! Character.isLetter(letter)) {
            throw new IllegalArgumentException("A letter is required. ");
        }
        letter = Character.toLowerCase(letter);
        if (misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1) {
            throw new IllegalArgumentException(letter + " has already been guessed");
        }
        return letter;
    }

    // method that checks to see of the guess is a match or not
    public boolean applyGuess(char letter) throws IllegalArgumentException {
        letter = normalizeGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        if (isHit) {
            hits += letter;// if guess is a hit then concatenate on to hits
        } else {
            misses += letter;// if guess is a miss then concatenate to misses
        }
        return isHit;
    }

    public boolean applyGuess(String letters) throws IllegalArgumentException {
        if (letters.length() == 0) {            
                throw new IllegalArgumentException("No letter found");
             }   
        return applyGuess(letters.charAt(0));
    }

    public String getCurrentProgress(){
        String progress = "";
        //for each letter display _ to represent a missing letter
        for(char letter : answer.toCharArray()){
            char display = '-';
            //if the user hits (guesses correctly) display the letter
            if(hits.indexOf(letter) != -1){
                display = letter;
            }
            //append progress to the display
            progress += display;
        }
        return progress;
    }

    public int getRemainingTries(){
        return MAX_MISSES - misses.length();
    }

    public boolean isWon() {
      return getCurrentProgress().indexOf('-') == -1;
       // getCurrentProgress returns a string and then the string is checked to see if the char - is located in it 
    }
}