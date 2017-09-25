import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Task6 {
    //stores how many times each word includes in spam or ham messages
    private HashMap<String, Integer> spamWords;
    private HashMap<String, Integer> hamWords;

    //file where data is
    private File dataset;

    //amount of words in spam and ham messages
    private int totalWordsInSpam;
    private int totalWordsInHam;

    Task6() {
        spamWords = new HashMap<>();
        hamWords = new HashMap<>();

        dataset = new File("english_big.txt");

        totalWordsInHam = 0;
        totalWordsInSpam = 0;

        parse();
    }

    /**
     * parses dataset
     */
    private void parse() {
        Scanner sc = null;
        try {
            sc = new Scanner(dataset,"UTF-8");
        } catch (FileNotFoundException ignored) {

        }

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.endsWith("spam")) {
                s = s.substring(0, s.length() - 4);
                s = s.toLowerCase();
                parseString(s, spamWords, totalWordsInSpam);
            }
            else {
                s = s.substring(0, s.length() - 3);
                s = s.toLowerCase();
                parseString(s, hamWords, totalWordsInHam);
            }
        }
    }

    /**parses a string from dataset
     * @param s string to parse
     * @param map storage of words of such type
     * @param count amount of word in spam/ham
     */
    private void parseString(String s, HashMap<String, Integer> map, int count) {
        StringTokenizer st = new StringTokenizer(s," .,!?-'\"():");

        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            count++;
            if (map.get(word) == null)
                map.put(word, 1);
            else
                map.put(word, map.get(word) + 1);
        }
    }

    /**computes probability that a message is spam
     * @param message
     * @return
     */
    private double computeSpamProb(String message) {
        message = message.toLowerCase();

        double spamProb = 1;
        double hamProb = 1;

        StringTokenizer st = new StringTokenizer(message," .,!?-'\"():");

        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            double n = computeWordSpamProb(s);
            spamProb *= n;
            hamProb *= (1 - n);
        }

        return spamProb / (spamProb + hamProb);
    }

    /**
     * computes probability that a message is a spam given that it contains this word
     * @param word
     * @return
     */
    private double computeWordSpamProb(String word) {
        Integer spamNumber = spamWords.get(word);
        Integer hamNumber = hamWords.get(word);

        if (spamNumber == null)
            return 0;
        if (hamNumber == null)
            return 1;

        return (double)spamNumber / (double)(spamNumber + hamNumber);
    }

    void execute(String message) {
        double probability = computeSpamProb(message);
        System.out.print("This message is a spam with probability ");
        System.out.printf("%.3f", probability);
    }
}
