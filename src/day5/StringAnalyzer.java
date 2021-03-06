/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Andrea
 */
public class StringAnalyzer {

    private final String[] forbiddenPool = new String[]{"ab", "cd", "pq", "xy"};

    public boolean containsForbidden(String key) {
        for (String token : forbiddenPool) {
            if (key.contains(token)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDouble(String key) {
        Pattern p = Pattern.compile("(\\w)\\1+");
        Matcher m = p.matcher(key);
        return m.find();
    }

    public int numberOfVowels(String key) {
        int total = 0;
        int keyLength = key.length();
        String[] vowels = new String[]{"a", "o", "e", "i", "u"};
        for (String vowel : vowels) {
            int index = key.indexOf(vowel);
            while (index >= 0 && index < keyLength) {
                index = key.indexOf(vowel, index + 1);
                total++;
            }
        }
        return total;

    }

    public boolean isNice(String key) {
        return !containsForbidden(key) && containsDouble(key) && (numberOfVowels(key) > 2);
    }

    public int niceCount(String fileName) throws IOException  {
        File fin = new File(fileName);
        FileInputStream fis = new FileInputStream(fin);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        int total = 0;
        while ((line = br.readLine()) != null) {
            if(isNice(line)){
                total++;
            }
        }
        br.close();
        return total;
    }
    
    
    /**
     * Calculates the number of "nice" words using method {@link #isNiceModified(java.lang.String)} as a criteria.
     * @param fileName
     * @return
     * @throws IOException 
     */
    public int niceCountModified(String fileName) throws IOException  {
        File fin = new File(fileName);
        FileInputStream fis = new FileInputStream(fin);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        int total = 0;
        while ((line = br.readLine()) != null) {
            if(isNiceModified(line)){
                total++;
            }
        }
        br.close();
        return total;
    }
    
    public boolean containsPair(String key){
        Pattern p = Pattern.compile("([a-z]{2})[a-z]*?\\1");
        Matcher m = p.matcher(key);
        return m.find();
    }
    
    public boolean containsSandwich(String key){
        Pattern p = Pattern.compile("([a-z])[a-z]\\1");
        Matcher m = p.matcher(key);
        return m.find();
    }
    
    public boolean isNiceModified(String key){
        return containsPair(key) && containsSandwich(key);
    }

}
