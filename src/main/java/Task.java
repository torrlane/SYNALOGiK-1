package main.java;

import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.util.*;
import java.io.FileNotFoundException;

public class Task {

    public static int totalWords;
    public static double averageWordLength;

    public static void main(String args[] ) {

        System.out.println("Joseph Malam - SYNALOGiK Java Programming Test");

        HashMap<Integer, Integer> wordLengthCounters = new HashMap<Integer, Integer>();

        totalWords = loadFile(wordLengthCounters, args[0]);

        System.out.println("Word count = " + totalWords);

        int totalCharacters = 0;
        for (Integer i : wordLengthCounters.keySet()) {
            totalCharacters += (i * wordLengthCounters.get(i));
        }
        averageWordLength = Math.round(((double)totalCharacters / (double)totalWords) * 1000.0) / 1000.0;
        System.out.println("Average word length = " + averageWordLength);

        if (totalWords != 0){
            int mostFrequentCounter = 0;
            ArrayList<Integer> mostFrequentWordLengths = new ArrayList<Integer>();

            for (Integer i : wordLengthCounters.keySet()) {
                System.out.println("Number of words of length " + i + " is " + wordLengthCounters.get(i));
                if (wordLengthCounters.get(i) > mostFrequentCounter) {
                    mostFrequentCounter = wordLengthCounters.get(i);
                    mostFrequentWordLengths.clear();
                    mostFrequentWordLengths.add(i);
                } else if (wordLengthCounters.get(i) == mostFrequentCounter) {
                    mostFrequentWordLengths.add(i);
                }
            }

            System.out.print("The most frequently occurring word length is " + mostFrequentCounter + ", for word lengths of ");
            System.out.print(mostFrequentWordLengths.get(0));
            if (mostFrequentWordLengths.size() > 2) {
                for (int i = 1; i < mostFrequentWordLengths.size() - 2; i++) {
                    System.out.print(", " + mostFrequentWordLengths.get(i));
                }
            }
            System.out.println(" & " + mostFrequentWordLengths.get(mostFrequentWordLengths.size() - 1));
        }

    }


    public static int loadFile(HashMap<Integer, Integer> wordLengthCounters, String fileName){

        Scanner input = null;
        int totalWords = 0;

        try {
            input = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("File does not exist, program will now terminate.");
            System.exit(1);
        }

        while (input.hasNext()) {
            String word = input.next();

            if (word.contains("!")
                    || word.contains(".")
                    || word.contains("_")
                    || word.contains(",")
                    || word.contains("@")
                    || word.contains("?")) {
                String[] elements = word.split("[!._,@?]");

                for (int i = 0; i < elements.length; i++) {
                    int wordLength = elements[i].length();
                    totalWords++;
                    if (wordLengthCounters.containsKey(wordLength)) {
                        int tempCount = wordLengthCounters.get(wordLength);
                        tempCount++;
                        wordLengthCounters.replace(wordLength, tempCount);
                    } else {
                        wordLengthCounters.put(wordLength, 1);
                    }
                }
            } else {
                int wordLength = word.length();
                totalWords++;
                if (wordLengthCounters.containsKey(wordLength)) {
                    int tempCount = wordLengthCounters.get(wordLength);
                    tempCount++;
                    wordLengthCounters.replace(wordLength, tempCount);
                } else {
                    wordLengthCounters.put(wordLength, 1);
                }
            }
        }

        input.close();
        return totalWords;

    }



}





















//
