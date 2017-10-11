/*
 * This sets up the methods used in the main by the wordLinkedList class
 */
package searchmethods;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 *
 * @author FlageMac
 */
public class wordLinkedList {
    LinkedList<word> wordsll = new LinkedList();
    
    // no default constructor just this one
    wordLinkedList(String local) {
        populateList(local);
//        for (word w : wordsll){
//            System.out.println(w.word);
//        }
    }
    
    // need to read in strings from a file to populate the linked list
    public void populateList(String local){
        try {
            File contents = new File(local);
            BufferedReader in = new BufferedReader(new FileReader(local));
            String line;
             
            while ((line = in.readLine()) != null){
                Scanner breaker = new Scanner(line);
                 
                while (breaker.hasNext()){
                    String temp = breaker.next().toLowerCase();
                    temp = parseString(temp);
                    if (!temp.equals("") || !temp.equals("[b-z?+]")) {
                        this.addSorted(temp);
                    }
                }
            }
             
        } catch (IOException e) {
            System.out.println("Something went wrong Ke-mo sah-bee");
        }
    }
    
    // for each item in the **Sorted Array** (hopefully) populate the linked list
    public void populateListFromArray(ArrayList<word> array){
        for (word w: array){
            wordsll.add(w);
        }
    }
    
    // I wanted to try sort the linked list as it was created
    public void addSorted(String n) {
        word add = new word(n);
        int position = 0;
        boolean inList = false;
        
        if (this.wordsll.isEmpty()){
            this.wordsll.add(add);
        }
        
        else {
        // i need to traverse and check if the word is present in the list
        // if not add in the correct spot in the list 
            for (word w : this.wordsll) {
                if (w.word.compareTo(n) == 0) {
                    w.count++;
                    inList = true;
                    break;
                }
                else if (w.word.compareTo(n) > 0) {
                    break;
                }
                position++;
            }
            if (!inList){
                this.wordsll.add(position, add);
            } 
        }    
    }
    
    public String parseString(String s){
        Pattern check = Pattern.compile("[^a-z']");
        Matcher two = check.matcher(s);
        Matcher remove = check.matcher(s);
        return remove.replaceAll("");
    }
}
