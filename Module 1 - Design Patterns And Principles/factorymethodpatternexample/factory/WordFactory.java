package factorymethodpatternexample.factory;

import factorymethodpatternexample.factory.I_Factory;
import factorymethodpatternexample.documents.WordDocuments;

public class WordFactory implements I_Factory {
    @Override
    public void createDocument(String type, int count) {
        for(int i = 1; i <= count; i++) {
            WordDocuments word = new WordDocuments();
            System.out.println(word.getType() + " created");
        }
        System.out.println("Created " + count + " " + type + " files.");
    }
}