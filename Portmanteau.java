
/*Portmanteau Class*/
import java.util.Map; //importing Map
import java.util.TreeMap; //importing TreeMap
import java.util.ArrayList; //importing ArrayList
import java.util.List; //importing List
import java.util.Scanner; //importing Scanner 
import java.io.BufferedReader; //importing BufferedReader
import java.io.IOException; //importing IOException
import java.util.Collections; //importing Collections

import java.io.FileReader;

public class Portmanteau { // class Portmantea

    public List<String> list; // list that holds the text file
    public List<String> beforeWord; // for all the prefixes
    public List<String> afterWord; // for all the suffixes
    public Map<String, String[]> Portmant; // for combining the words and create a new word

    public Portmanteau(String file) throws IOException { // constructor
        list = new ArrayList<String>(); // initializing it with ArrayList
        Portmant = new TreeMap<String, String[]>(); // initializing it with a Tree Map
        BufferedReader w = new BufferedReader(new FileReader(file)); // reading file with bufferedReader
        Scanner newScanner = new Scanner(w); // using Scanner object
        while (newScanner.hasNext()) { // checking if there is a word
            String ne = newScanner.nextLine();
            list.add(ne); // adding the words in the list

        }
        Collections.sort(list); // sorting the list
        w.close(); // closing the bufferedReader
    }

    public boolean check(String x, String y, String z) { // to check if there is compound word or not
        if (y.concat(z).equals(x)) {
            return false;
        } else {
            if (!(y.equals(z))) {
                if (x.equals(y)) {
                    return false;
                }
                if (x.equals(z)) {
                    return false;
                }
                return true;
            }
            return false;

        }
    }// end of check method

    public void workon() { // combination of words

        String word; // that holds the single word

        for (int i = 0; i < list.size(); i++) { //
            beforeWord = new ArrayList<String>();// initializing the prefix with arrayList
            afterWord = new ArrayList<String>(); // initializing the suffix with arrayList
            word = list.get(i); // that iterates for every element in a list
            for (int j = 0; j < word.length() - 2; j++) {
                String before = word.substring(0, j); // getting the prefix
                String after = word.substring(j, word.length()); // getting the suffix
                for (int a = 0; a < list.size(); a++) {
                    String anotherword = list.get(a); // getting another word to check
                    if (anotherword.startsWith(before)) {
                        beforeWord.add(anotherword);
                    }
                    if (anotherword.endsWith(after)) {
                        afterWord.add(anotherword);
                    }
                }

            }
            for (int j = 0; j < beforeWord.size(); j++) {
                for (int k = 0; k < afterWord.size(); k++) {
                    if (check(word, beforeWord.get(j), afterWord.get(k))) { // checks if there is a compound word
                        String[] array = new String[2]; // strings that hold the prefix and suffix
                        array[0] = beforeWord.get(j); // the first (prefix) word
                        array[1] = afterWord.get(k); // the second (suffix)
                        Portmant.put(word, array);

                    }
                }
            }
        }
        for (Map.Entry<String, String[]> x : Portmant.entrySet()) {
            String something = x.getKey(); // getting the key (which is the new word)
            String[] someone = x.getValue(); // getting the value (which are the prefix and suffix)
            System.out.println(something + " == " + someone[0] + " + " + someone[1]); // printing out the output

        }
    }// end of workon

}