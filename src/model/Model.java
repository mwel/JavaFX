package model;

import java.util.HashMap;

public class Model {

    private HashMap<String, String> vocab;
    private String[] keyWords;

    public Model() {
        vocab = new HashMap<>();
        fillVocal();
        keyWords = vocab.keySet().toArray(new String[0]);
    }

    public String choose() {
        int index = (int) (Math.random() * keyWords.length);
        return keyWords[index];
    }

    public boolean check(String lang1, String lang2) {

        return lang2.equals(vocab.get(lang1));
    }

    private void fillVocal() {
        vocab.put("Hund", "dog");
        vocab.put("Katze", "cat");
        vocab.put("Sonne", "sun");
        vocab.put("Haus", "house");
        // ...
    }
}
