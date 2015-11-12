// UPDATE FROM GITHUB

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import static java.util.Objects.hash;
import java.util.Scanner;

/**
 *
 * @author M_S INFO
 */
public class Corpus {

    /**
     * Load corpus from text file
     * @param filepath
     * @return
     * @throws FileNotFoundException 
     */
    public ArrayList<String> load(String filepath) throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<>();

        try ( //----------------------
                Scanner s = new Scanner(new File(filepath))) {
            while (s.hasNext()) {
                words.add(s.next());
            }
        }

        //----------------------
        return words;
    }
    
    
    /**
     * Load vocabulary from corpus. 
     * @param words
     * @return 
     */
    public ArrayList<String> LoadVocabulary(ArrayList<String>  words){
        ArrayList<String> vocabulary = new ArrayList<>();
        
        for(String word : words){
            if(!vocabulary.contains(word)){
                vocabulary.add(word);
            }
        }
        
        return vocabulary;
    }
    
    
    public ArrayList<String> Loadbigrams(ArrayList<String>  words){
        ArrayList<String> bigrams = new ArrayList<>();
        
        for(int i = 1 ; i < words.size()-1; ++i){
           bigrams.add( words.get(i)+" "+ words.get(i+1));
        }
        
        return bigrams;
    }
    
    /**
     * 
     * @param bigrams
     * @param words
     * @return 
     */
    public Map<String, Double> ComputeBigramsProb( ArrayList<String> bigrams ,  ArrayList<String> words, int V ){
        
        Map<String, Double> BigramsProb = new HashMap<>();
                
        for(String bigram : bigrams){
            Double P = 0.0;
            String[] mots = bigram.split("\\s");
            P = ( Collections.frequency(bigrams, bigram) + 1)
                    /  ( Double.valueOf(Collections.frequency(words, mots[0]))  + V );
            BigramsProb.put(bigram, P);
        }
        
        
        return BigramsProb;        
    }
    
 public ArrayList<String> LoadTrigrams(ArrayList<String>  words){
        ArrayList<String> Trigrams = new ArrayList<>();
        
        for(int i = 1 ; i < words.size()-2; ++i){
           Trigrams.add( words.get(i)+" "+ words.get(i+1) + " " +words.get(i+2));
        }
        
        return Trigrams;
    }

 public Map<String, Double> ComputeTrigramsProb( ArrayList<String> Trigrams ,  ArrayList<String> words, int V ){
        
        Map<String, Double> TrigramsProb = new HashMap<>();
                
        for(String Trigram : Trigrams){
            Double P = 0.0;
            String[] mots = Trigram.split("\\s");
            P = ( Collections.frequency(Trigrams, Trigram) + 1)
                    /  ( Double.valueOf(Collections.frequency(words, mots[0] + " " + mots [1]))  + V );
            TrigramsProb.put(Trigram, P);
        }
        
        
        return TrigramsProb;  
}
 
}
