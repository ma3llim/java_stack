package CollectionsPrograms;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String text = "Hello world! Hello Java, hello again world.";
        String cleanText = text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]","");
        String[] words = cleanText.split("\\s+");
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word: words){
            if (word.isEmpty()) continue;

            if (wordCounts.containsKey(word)){
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }


        System.out.println("Word Frequencies: ");
        for (Map.Entry<String, Integer> word : wordCounts.entrySet()){
            System.out.println(word.getKey() + ": " + word.getValue());
        }
    }
}