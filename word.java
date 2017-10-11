/*
 * This sets up my base class called word used by everyother class
 */
package searchmethods;

/**
 *
 * @author FlageMac
 */
public class word {
    String word;
    int count;
    
    // constructor with a String, no default constructor
    word(String s) {
        this.word = s;
        count = 1;
    }
    
    public boolean equals(word w){
        return (this.word.equals(w.word));
    }
    
    
    // overriden toString method for the object word to print what i want it to.
    @Override
    public String toString(){
        return String.format("Word: %-20s Count: %d", word, count);
    }
}
