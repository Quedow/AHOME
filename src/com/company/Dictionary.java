package com.company;

import java.util.ArrayList;

public class Dictionary {

    protected ArrayList<String> dic;
    private Analyse analyse;
    protected int numberOfWords;

    public Dictionary(){
        numberOfWords = 0;
        dic = new ArrayList<String>();
        analyse = new Analyse();
    }

    // Research writing word in dictionary
    public int find(String sentence) {
        int max = 0;
        int maxIndex = 0;
        int i = 0;
        int IndexError = 0;

        for (String word : dic) {
            int maxTemp = analyse.similitude(sentence, word);
            if (maxTemp > max) {
                max = maxTemp;
                maxIndex = i;
            }
            i += 1;
        }

        if (max < 50) {
            return IndexError;
        } else {
            return maxIndex;
        }
    }

    // Send the number of words
    public int getNumberOfWords() {
        return numberOfWords;
    }

    // Send the dictionary associated to the writing word
    public String correspondence(int index){
        return dic.get(index);
    }
}