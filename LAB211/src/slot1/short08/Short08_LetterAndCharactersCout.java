package slot1.short08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

public class Short08_LetterAndCharactersCout {

    public void doCountWords(String content) {
        String[] words = content.split(" ");
        Map<String, Integer> wordCounts = new HashMap<>();
        
        for (String word : words) {
            Integer count = wordCounts.getOrDefault(word, 0);
            wordCounts.put(word, count + 1);
        }
        
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            sj.add(entry.getKey() + "=" + entry.getValue());
        }
        
        System.out.println( sj.toString());
    }

    public void doCountCharacters(String content) {
        Map<Character, Integer> charCounts = new HashMap<>();
        
        for (char c : content.toCharArray()) {
            if (c != ' ') {
                Integer count = charCounts.getOrDefault(c, 0);
                charCounts.put(c, count + 1);
            }
        }
        
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            sj.add(entry.getKey() + "=" + entry.getValue());
        }
        
        System.out.println( sj.toString());
    }

    
}