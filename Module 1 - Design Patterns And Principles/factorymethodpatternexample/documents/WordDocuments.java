package factorymethodpatternexample.documents;

public class WordDocuments implements I_Documents {
    public WordDocuments() { }

    @Override
    public String getType() {
        return "Word";
    }
}