package sample.com;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.fail;

public class SampleTest {
    @Test
    void PDFからテキスト取得のサンプル() {
        try (InputStream is = SampleTest.class.getResourceAsStream("/sample.pdf")) {
            if (is == null) {
                System.out.println("PDF file not found!");
                fail();
            }

            PDDocument document = PDDocument.load(is);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);

            System.out.println("Extracted text from PDF v2.0.31:");
            System.out.println(text);

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
