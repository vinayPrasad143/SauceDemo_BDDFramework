package utilities;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;

import static java.awt.SystemColor.text;

public class WordUtility {

    public static void writeToWordDoc(String content, String filePath) {
        try (XWPFDocument doc = new XWPFDocument()) {
            XWPFParagraph para = doc.createParagraph();
            XWPFRun run = para.createRun();
            String[] lines = content.split("\n");
            for (String line : lines) {
                run.setText(line);
                run.addBreak();
            }
            try (FileOutputStream out = new FileOutputStream(filePath)) {
                doc.write(out);
            }
            System.out.println("Word document created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
