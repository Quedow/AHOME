package com.company;

import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

public class Analyse {
    public String[] Full_Command;
    private Scanner input;
    protected String sentence;

    public Analyse(){
        sentence = "";
        input = new Scanner(System.in);
    }

    // Cut the sentence in word table
    public String[] extract(@NotNull String Full_Sentence){
        this.Full_Command = Full_Sentence.split(" ");
        return Full_Command;
    }

    // Ask and get sentence in the console
    public String getSentence() {
        return input.nextLine().toLowerCase();
    }

    public void endPause() {
        input.nextLine();
    }

    public String[] getAndAnalyzeSentence(){
        sentence = getSentence();
        return extract(sentence);
    }

    // Compare the longest word with the smallest
    public int similitude(String a, String b){
        a = a.toLowerCase();
        b = b.toLowerCase();
        if(a.length() > b.length()){
            return getPercentage(a,b);
        }
        else{
            return getPercentage(b,a);
        }
    }

    // Similitude percentage between writing word and dictionary's word
    public int getPercentage(String a, String b){
        int percentage = 0;
        int somme = 0;
        if(a != null){
            for(int i = 0; i < a.length(); i ++){
                try{
                    if(a.charAt(i) == b.charAt(i)){
                        somme += 1;
                    }
                }catch (Exception ignored){}
            }
            percentage = 100*somme/a.length();
        }
        return percentage;
    }
}