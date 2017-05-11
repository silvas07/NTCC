package Test;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ImgTemplate;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Created by rdsdo on 11/05/2017.
 */
public class GeneratorPDF {

    public static void main(String[] args) {
        // criação do documento
        Document document = new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\rdsdo\\Desktop\\PDF_DevMedia.pdf"));
            document.open();

            // adicionando um parágrafo no documento
            document.add(new Paragraph("rubens dirgo santana de oliveira"));
            document.add(new Paragraph("rubens diego sabtana de oliveira"));
        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
    }

}
