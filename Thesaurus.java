import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Thesaurus {
    private Map<String, List<String>> synonyms = new HashMap<String, List<String>>();

    public Thesaurus(String fileName) {

        String line = "";
        String lookupWord = "";
        List<String> synonymList = new LinkedList<String>();
        try {

            BufferedReader in = new BufferedReader(new FileReader(fileName));

            while ((line = in.readLine()) != null) {
                String[] wordsArray = line.split(",");
                lookupWord = wordsArray[0];
                for (int i = 1; i < wordsArray.length; i++) {
                    synonymList.add(wordsArray[i]);

                }
            }

            in.close();
        } catch (IOException excpt) {
            System.out.println("Caught IOException: " + excpt.getMessage());
        }

        synonyms.put(lookupWord, synonymList);

    }

    public List<String> getSynonyms(String lookupWord) throws ThesaurusException {
        List<String> syn = new LinkedList<String>();
        if (synonyms.containsKey(lookupWord)) {
            syn.addAll(synonyms.get(lookupWord));

        }

        else if (!(synonyms.containsKey(lookupWord))) {
            throw new ThesaurusException("Word not found");

        }
        return syn;

    }

}