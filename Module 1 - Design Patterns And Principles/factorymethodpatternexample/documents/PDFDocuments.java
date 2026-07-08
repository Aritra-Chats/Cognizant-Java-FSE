package factorymethodpatternexample.documents;

import factorymethodpatternexample.documents.I_Documents;

public class PDFDocuments implements I_Documents {
    public PDFDocuments() { }

    @Override
    public String getType() {
        return "PDF";
    }
}