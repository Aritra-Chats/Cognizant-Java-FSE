package factorymethodpatternexample;

import factorymethodpatternexample.factory.ExcelFactory;
import factorymethodpatternexample.factory.PDFFactory;
import factorymethodpatternexample.factory.WordFactory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        ExcelFactory excels = new ExcelFactory();
        excels.createDocument("excel", 3);
        WordFactory words = new WordFactory();
        words.createDocument("word", 5);
        PDFFactory pdfs = new PDFFactory();
        pdfs.createDocument("PDF", 10);
    }
}