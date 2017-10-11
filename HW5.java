/*
 * Ryan Flageolle Computer Science 2
 * 
 * October 2, 2017  
 * 
 * This program will read in words from a given text file placing them into an array 
 * and and a LinkedList, as they are placed into an array if they already exist in
 * the array we will, instead of adding a duplicate to the list, increase an associated
 * number idetifying its existance.  
 * 
 * 
 */
package searchmethods;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author FlageMac
 */
public class HW5 {

    wordArrayList wordsAL;
    wordLinkedList wordsLL;
    
    // constructor with a string, no default constructor
    public HW5(String path){
        wordsAL = new wordArrayList(path);
        wordsLL = new wordLinkedList(path);
    }
    
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Hello please enter the the path of the file: ");
          
        long startClock = System.currentTimeMillis();
        long startCPU = System.nanoTime();
          
        String path = in.nextLine();
        File inFrom = new File(path);
          
        HW5 current = new HW5(path);
        current.wordsAL.sortListAlpabetically();
          
        current.toFile(current.wordsAL.toString());
        
        System.out.println("Filename: " + inFrom.getName());
        System.out.println("Number of words: " + current.wordsAL.words.size());
        
        long stopClock = System.currentTimeMillis();
        long stopCPU = System.nanoTime();
          
        long clockTime = stopClock - startClock;
        long timeCpu = stopCPU - startCPU;      
        
    }
    
    // creates the list of words file
    public void toFile(String data){
        File rtn = new File("HW5.txt");
        try{
            FileWriter out = new FileWriter(rtn);
            out.append(data);
        } catch (IOException e){
            System.out.print("Something went wrong Kee - moh - sah - bee");
        }
        
    }
    
        // turns the milliseconds into a more readable format... me no good at read big numbers
    public static String convert(long x) {
                
        int mins = (int)x / 60000;
        int secs = (int)(x - (mins * 60000)) / 1000;
        int millisecs = (int)(x - (mins * 60000) - (secs * 1000));
        
        String str = mins + " mins " + secs + " secondss " + millisecs + " milliseconds";
        
        return str;
    }
    
    // creates a time log file
    public void timeLogFile(long clockTime, long CPUtime){
        File rtn = new File("HW5TimeLog.txt");
        try{
            FileWriter out = new FileWriter(rtn);
            String str = String.format("Wall Clock: %s \nCPU time: %,d milliseconds", convert(clockTime), CPUtime);
            out.append(str);
        } catch (IOException e){
            System.out.print("Something went wrong Kee - moh - sah - bee");
        }
        
    }
    
}
