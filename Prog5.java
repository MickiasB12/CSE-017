import java.util.List;
import java.util.ArrayList;

public class Prog5 {

    public static void main(String[] args) {
        Thesaurus thes = new Thesaurus("mthesaurEDIT.txt");
        PronouncingDictionary word = new PronouncingDictionary("cmudictEDIT.0.7a.txt", "cmudict.0.7a.phones.txt");
        String rootWord = "";
        String rhymeWord = "";
        int degree = 0;
        try {
            if (args.length >= 3) {
                rootWord = args[0];
                rhymeWord = args[1];
                degree = Integer.parseInt(args[2]);
                List<String> rhyme = new ArrayList<String>();
                System.out.print(rootWord + "'s synonyms are: ");
                for (String words : thes.getSynonyms(rootWord)) {
                    System.out.print(words + " ");

                }
                System.out.println();
                rhyme = word.findRhymingSynonyms(rootWord, rhymeWord, degree);
                System.out.println("Words which rhyme with " + rootWord + " are:");
                for (String rh : rhyme) {
                    System.out.print(rh + " ");
                }
            } else {
                throw new Exception("args length less than 3");
            }

        } catch (ThesaurusException excpt) {
            System.out.println(excpt.getLocalizedMessage());
            System.out.println("Exiting file");
        } catch (Exception excpt) {
            System.out.println(excpt.getMessage());
            System.out.println("Exiting file");
        }
    }
}