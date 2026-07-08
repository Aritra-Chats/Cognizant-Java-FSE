package factorymethodpatternexample.factory;

import factorymethodpatternexample.factory.I_Factory;
import factorymethodpatternexample.documents.PDFDocuments;

public class PDFFactory implements I_Factory {
    @Override
    public void createDocument(String type, int count) {
        for(int i = 1; i <= count; i++) {
            PDFDocuments pdf = new PDFDocuments();
            System.out.println(pdf.getType() + " created");
        }
        System.out.println("Created " + count + " " + type + " files.");
    }
}