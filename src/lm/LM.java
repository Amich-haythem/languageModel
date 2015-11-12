/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lm;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author M_S INFO
 */
public class LM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        Corpus corpus = new Corpus();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> vocabulary = new ArrayList<>();
        ArrayList<String> Trigrams = new ArrayList<>();
        Map<String, Double> TrigramsProb = new HashMap();

        words = corpus.load("data/corpus.dat");
        vocabulary = corpus.LoadVocabulary(words);
        Trigrams = corpus.LoadTrigrams(words);
        TrigramsProb = corpus.ComputeTrigramsProb(Trigrams, words, vocabulary.size());
        

        System.out.println(TrigramsProb);

    }

}
