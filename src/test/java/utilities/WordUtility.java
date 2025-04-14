package utilities;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileOutputStream;

public class WordUtility {

    public static void writeToWordDoc(String content, String filePath) {
        try (XWPFDocument doc = new XWPFDocument()) {
            XWPFParagraph para = doc.createParagraph();
            para.createRun().setText(content);
            try (FileOutputStream out = new FileOutputStream(filePath)) {
                doc.write(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
