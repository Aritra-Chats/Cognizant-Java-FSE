package factorymethodpatternexample.documents;

import factorymethodpatternexample.documents.I_Documents;

public class ExcelDocuments implements I_Documents {
    public ExcelDocuments() { }

    @Override
    public String getType() {
        return "Excel";
    }
}