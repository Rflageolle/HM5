/*
 * This sets up the methods used in the main for the wordArrayList class 
 */
package searchmethods;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;


/**
 *
 * @author FlageMac
 */
public class wordArrayList{
    ArrayList<word> words;
    
    // counstructor with string, no default constructor wanted
    wordArrayList(String local) {
        words = new ArrayList<>();
        populateList(local);
//        for (word s: words) {
//            System.out.println(s.word);
//        }
    }
    
    // modified add where a string is passed to see if it matches an existing word
    // id it doesnt then it creates a word and adds it to the ArrayList
    public void add(String n) {
        word add = new word(n);
        boolean inArray = false;
        if (this.words.size() > 0) {
            for (word w : this.words) {
                if (w.equals(add)){
                    w.count++;
                    inArray = true;
                }
            }
            if (!inArray) {
                words.add(add);
            }
        }
        else {
            words.add(add);
        }
        
    }
    
    // removes a word, not used
    public void remove(word n) {
        for (word w : words) {
            if (n.word.equals(w.word)) {
                words.remove(w);
            }
        }
    }
    
    // gets count from a single word, not used 
    public int getCount(String n) {
        int count = 0;
        for (word w : words) {
            if (n.equals(w.word)) {
                count = w.count;
            }
        }
        return count;
    }
    
    // sorts the Array based on its Lexiconagraphical position (alphabetically)
    public void sortListAlpabetically(){ 
        words.sort((word o1, word o2) -> {
            return o1.word.compareTo(o2.word);
        });
    }
    
    // sorts the Array based on the number of instances the word has
    public void sortListCount(){
        words.sort((word o1, word o2) -> {
            return o1.count - o2.count;
        });
    }
    
    // populates the Array from a files given path
    public void populateList(String local) {

        try {
            File contents = new File(local);
            BufferedReader in = new BufferedReader(new FileReader(local));
            String line;
            
            while ((line = in.readLine()) != null){
                Scanner breaker = new Scanner(line);
                
                while (breaker.hasNext()){
                    String temp = breaker.next().toLowerCase();
                    temp = parseString(temp);
                    if (!temp.equals("") ) {
                        this.add(temp);
                    }
                }
            }
            
        } catch (IOException e) {
            System.out.println("Something went wrong Ke-mo sah-bee");
        }
    }
    
    // removes unwanted characters
    public String parseString(String s) {
        Pattern check = Pattern.compile("[^a-z']");
        Matcher two = check.matcher(s);
        Matcher remove = check.matcher(s);
        return remove.replaceAll("");
    }
    
    // overridden toString method to print out all the words in the array
    @Override
    public String toString(){
        String rtn = "";
        for (word w: this.words){
            rtn += w.toString() + "\n";
        }
        return rtn;
    }
    
        
}
