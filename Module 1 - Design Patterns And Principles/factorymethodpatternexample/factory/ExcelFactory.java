package factorymethodpatternexample.factory;

import factorymethodpatternexample.factory.I_Factory;
import factorymethodpatternexample.documents.ExcelDocuments;

public class ExcelFactory implements I_Factory {
    @Override
    public void createDocument(String type, int count) {
        for(int i = 1; i <= count; i++) {
            ExcelDocuments excel = new ExcelDocuments();
            System.out.println(excel.getType() + " created");
        }
        System.out.println("Created " + count + " " + type + " files.");
    }
}