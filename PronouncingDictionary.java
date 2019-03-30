import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class PronouncingDictionary {
    private Map<String, List<String>> wordList = new HashMap<String, List<String>>();

    private Map<String, Boolean> isVowel = new HashMap<String, Boolean>();

    public PronouncingDictionary(String wordlistFile, String phonemeFile) {

        String line = "";
        String lookupWord = "";
        String line2 = "";
        String lookupWord2 = "";

        ArrayList<String> phonemeList = new ArrayList<String>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(wordlistFile));

            while ((line = in.readLine()) != null) {
                if (!(line.contains(";;;"))) {
                    String[] wordsArray = line.split(" ");
                    lookupWord = wordsArray[0];
                    for (int i = 1; i < wordsArray.length; i++) {
                        phonemeList.add(wordsArray[i]);

                    }
                }
            }
            wordList.put(lookupWord, phonemeList);
            in.close();
        } catch (IOException excpt) {
            System.out.println("Caught IOException: " + excpt.getMessage());
        }

        try {
            BufferedReader in2 = new BufferedReader(new FileReader(phonemeFile));

            while ((line2 = in2.readLine()) != null) {
                String[] word = line2.split("");
                lookupWord2 = word[0];
                if (word[1].equals("Vowel")) {
                    isVowel.put(lookupWord2, true);
                } else {
                    isVowel.put(lookupWord2, false);
                }

            }

        } catch (IOException excpt) {
            System.out.println("Caught IOException: " + excpt.getMessage());
        }

    }

    public int rhymePhoneCount(String word1, String word2) {
        int count = 0;
        int x = wordList.get(word1).size() - 1;
        int y = wordList.get(word2).size() - 1;
        String ph1 = wordList.get(word1).get(x);
        String ph2 = wordList.get(word2).get(y);
        while (ph1.equals(ph2) && x > -1 && y > -1) {
            ph1 = wordList.get(word1).get(x - 1);
            ph2 = wordList.get(word2).get(y - 1);
            if (isVowel.get(ph1) && ph1.equals(ph2)) {
                count++;
            }
            x--;
            y--;
        }
        return count;
    }

    public List<String> findRhymingSynonyms(String rootWord, String rhymeWord, int degree) throws ThesaurusException {

        List<String> syn = new Thesaurus("mthesaurEDIT.txt").getSynonyms(rootWord);
        List<String> words = new LinkedList<String>();
        for (String sy : syn) {
            if (rhymePhoneCount(rhymeWord, sy) >= degree) {
                words.add(sy);

            }

        }
        return words;

    }

}